

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


--probando implementar el CURSO POR GRADO
select cpg.id as idcpg, g.ID as idGrado, c.ID as idCurso, 
n.NOMBRELARGO, s.DESCRIPCION, g.NUMEROGRADO, c.NOMBRELARGO as nombreCurso
from niveleducacion n, seccion s, grado g, curso c, cursoporgrado cpg where
g.IDNIVELEDUCACION = n.ID and
g.IDSECCION = s.ID and
g. ID = cpg.IDGRADO and
cpg.IDCURSO = c.ID;

select * from cursoPorGrado;

insert into cursoporgrado(id,idgrado,idcurso,descripcion) values(sq_cursoporgrado.nextval, 21, 3, 'aa');

update cursoporgrado set idgrado=21, idcurso = 3 , descripcion = 'ee' where id = 1;




--probando algo
select g.NUMEROGRADO, s.DESCRIPCION as seccion, n.NOMBRELARGO as nivel, c.NOMBRELARGO as nombreCurso,
g.ID as idGrado, cpg.ID as idCPG, c.ID as idCurso
from grado g, NIVELEDUCACION n, SECCION s, CURSOPORGRADO cpg, curso c where
g.IDSECCION = s.ID and
g.IDNIVELEDUCACION = n.ID and
g.ID = cpg.IDGRADO and 
cpg.IDCURSO = c.ID;



--probando otra cosa xD
select g.NUMEROGRADO, s.DESCRIPCION as seccion, n.NOMBRELARGO as nivel, c.NOMBRELARGO as nombreCurso, d.NOMBRE, d.APELLIDOPATERNO, cla.CANTIDADALUMNOS, cla.OBSERVACION, 
g.ID as idGrado, cpg.ID as idCPG, c.ID as idCurso, cla.ID as idClase, d.ID as idDocente
from grado g, NIVELEDUCACION n, SECCION s, CURSOPORGRADO cpg, curso c , clase cla, docente d where
g.IDSECCION = s.ID and
g.IDNIVELEDUCACION = n.ID and
g.ID = cpg.IDGRADO and 
cpg.IDCURSO = c.ID and 
cpg.ID = cla.IDCURSOPORGRADO and
cla.IDDOCENTE = d.ID and
cla.ESTADO = '1';
               
--