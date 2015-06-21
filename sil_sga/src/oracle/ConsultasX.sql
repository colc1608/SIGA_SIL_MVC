

--seleccionar el ULTIMO id
select max(id) from ESPECIALIDAD;


--CONSULTA PARA GENERAR CLAVES ALEATORIAS
SELECT dbms_random.string('p', 8) as clave
FROM   dual;


--CONSULTA PARA DEVOLVER ULTIMOS REGISTROS
select max(usuario)+1 from usuario;
select usuario from usuario where id = (select max(id) from usuario);



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
--
--listar cursos por un grado en especifico.
select c.NOMBRELARGO from CURSOPORGRADO cpg, curso c where
cpg.IDCURSO = c.ID and
cpg.IDGRADO = 1;


--obtener las clases de un grado para Matricula
select  cla.id as idClase
from CURSOPORGRADO cpg, curso c, clase cla where
cpg.IDCURSO = c.ID and
cpg.ID = cla.ID and
cpg.IDGRADO = 1;


--obtener las clases de un grado para Matricula
select  cla.id as idClase, c.NOMBRELARGO, d.NOMBRE
from CURSOPORGRADO cpg, curso c, clase cla, docente d where
cpg.IDCURSO = c.ID and
cpg.ID = cla.ID and
cla.IDDOCENTE = d.ID and
cpg.IDGRADO = 1;


--mostrar los cursos por docente
select c.NOMBRELARGO from docente d, clase cla, curso c, CURSOPORGRADO cpg where
c.ID = cpg.IDCURSO and
cpg.id = cla.IDCURSOPORGRADO and
cla.IDDOCENTE = d.ID and
d.id = 6;





--mostrar los cursos por docente
select c.NOMBRELARGO, g.NUMEROGRADO, s.DESCRIPCION, n.NOMBRELARGO as nivel
from docente d, clase cla, curso c, CURSOPORGRADO cpg, grado g, seccion s, NIVELEDUCACION n where
c.ID = cpg.IDCURSO and
cpg.id = cla.IDCURSOPORGRADO and
cla.IDDOCENTE = d.ID and
cpg.IDGRADO = g.ID and
g.IDSECCION = s.ID and
g.IDNIVELEDUCACION = n.ID and
d.id = 6;

--algo
select c.NOMBRELARGO from docente d, clase cla, curso c, CURSOPORGRADO cpg where
c.ID = cpg.IDCURSO and
cpg.id = cla.IDCURSOPORGRADO and
cla.IDDOCENTE = d.ID and
d.id = 6;


--consulta que dado un USUARIO te devuelve los datos del docente
select u.id as idUsuario, d.ID, d.NOMBRE, d.APELLIDOPATERNO, d.APELLIDOMATERNO, d.DNI
from docente d, usuario u where
u.ID = d.IDUSUARIO and
u.id = 4;