
select * from sucursal where chr_sucucodigo='001';
select * from cuenta where chr_sucucodigo='001';
select * from cuenta where chr_cuencodigo='00200004';
select * from movimiento where chr_cuencodigo='00200004';
go

-- Consulta para saber la sucursal de un empleado
select chr_sucucodigo 
from asignado a
where a.chr_emplcodigo='0004' and dtt_asigfechabaja is null;
go

insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
chr_emplcodigo,chr_tipocodigo,dec_moviimporte)
values(?,?,?,?,?,?)

SP_HELP MOVIMIENTO
GO

select 


