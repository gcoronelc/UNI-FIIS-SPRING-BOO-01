package pe.edu.uni.eureka.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.uni.eureka.model.Cuenta;
import pe.edu.uni.eureka.model.Sucursal;
import pe.edu.uni.eureka.repository.CuentaRepository;
import pe.edu.uni.eureka.repository.SucursalRepository;

@Service
public class CuentaService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SucursalRepository sucursalRepository;

	@Autowired
	private CuentaRepository cuentaRepository;

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public String crearCuenta(String cliente, String moneda, double importe, String clave, String empleado) {
		// Variables
		String query = null, codSucursal, codCuenta;
		int cont, contCuentas;
		Sucursal sucursal;
		// Validar el cliente
		query = "select count(1) from cliente where chr_cliecodigo=?";
		cont = jdbcTemplate.queryForObject(query, Integer.class, cliente);
		if (cont != 1) {
			throw new RuntimeException("Cliente no existe.");
		}
		// Obtener la sucursal
		query = "select count(1) from asignado a where a.chr_emplcodigo=? " + "and dtt_asigfechabaja is null";
		cont = jdbcTemplate.queryForObject(query, Integer.class, empleado);
		if (cont != 1) {
			throw new RuntimeException("Empleado no existe.");
		}
		// Obtener la sucursal
		query = "select chr_sucucodigo from asignado a where a.chr_emplcodigo=? " + "and dtt_asigfechabaja is null";
		codSucursal = jdbcTemplate.queryForObject(query, String.class, empleado);
		// Trabajando con la sucursal
		sucursal = sucursalRepository.findById(codSucursal).get();
		contCuentas = sucursal.getContador() + 1;
		sucursal.setContador(contCuentas);
		sucursalRepository.save(sucursal);
		// Trabajando con la cuenta
		codCuenta = codSucursal + String.format("%05d", contCuentas);
		System.out.println("Cuenta=> " + codCuenta);
		Cuenta cuenta = new Cuenta();
		cuenta.setCuenta(codCuenta);
		cuenta.setMoneda(moneda);
		cuenta.setCliente(cliente);
		cuenta.setSucursal(codSucursal);
		cuenta.setSaldo(importe);
		cuenta.setClave(clave);
		cuenta.setEmpleado(empleado);
		cuenta.setFecha(LocalDateTime.now());
		cuenta.setEstado("ACTIVO");
		cuenta.setContador(1);
		cuenta.setNuevo(true);
		cuentaRepository.save(cuenta);
		// Movimiento
		query = "insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,"
				+ "chr_emplcodigo,chr_tipocodigo,dec_moviimporte) values(?,?,?,?,?,?)";
		Object[] args = {codCuenta,1,LocalDateTime.now(),empleado,"001",importe};
		jdbcTemplate.update(query, args);
		// Reporte
		return codCuenta;
	}
	
	public List<Map<String,Object>> consultarMovimientos(String fecha1, String fecha2){
		String query = "select cuencodigo cuenta, convert(varchar(20), movifecha, 103) fecha, "
				+ "tiponombre tipo, tipoaccion accion, moviimporte importe "
				+ "from dbo.v_movimiento "
				+ "where movifecha>=convert(datetime,?,103) "
				+ "and movifecha<(convert(datetime,?,103)+1) ";
		Object[] args = {fecha1, fecha2};
		List<Map<String,Object>> lista = jdbcTemplate.queryForList(query, args);
		return lista;
	}
}
