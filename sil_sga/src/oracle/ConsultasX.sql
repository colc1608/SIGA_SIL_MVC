

--seleccionar el ULTIMO id
select max(id) from ESPECIALIDAD;


--CONSULTA PARA GENERAR CLAVES ALEATORIAS
SELECT dbms_random.string('p', 8) as clave
FROM   dual;


--CONSULTA PARA DEVOLVER ULTIMOS REGISTROS
select max(usuario)+1 from usuario;


---MOSTRAR LOS CURSOS POR ID de docente
select c.NOMBRELARGO from curso c, clase cl, docente d
where c.ID = cl.IDCURSO and
cl.IDDOCENTE =1
group by c.NOMBRELARGO;