--cesar lopez

--seleccionar el ULTIMO id
select max(id) from ESPECIALIDAD;

/*

'a' o 'A': Genera una cadena aleatoria con sólo letras íncluyendo mayúsculas y minúsculas.
'l' o 'L': Genera una cadena aleatoria con sólo letras minúsculas.
'p' o 'P': Genera una cadena aleatoria con cualquier tipo de carácter imprimible.
'u' o 'U': Genera una cadena aleatoria con sólo letras mayúsculas.
'x' o 'X': Genera una cadena aleatoria con caracteres alfa numéricos en mayúsculas.

*/
--CONSULTA PARA GENERAR CLAVES ALEATORIAS
SELECT dbms_random.string('x', 8) as clave
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





--mostrar las NOTAS de los alumnos por CLASE con tipoNota y Periodo
--(PROBLEMA DE QUE SE DEBE INGRESAR DESDE ANTES)

select a.id, a.NOMBRE, a.APELLIDOPATERNO, a.APELLIDOMATERNO, n.NOTA
from alumno a, matricula m, detalleMatricula dm, clase c, nota n, TIPOEVALUACION te, PERIODO p 
where
a.ID = m.IDALUMNO and
m.id = dm.IDMATRICULA and
dm.IDCLASE = c.ID and
c.id = 1 and
te.id = 2 and
p.ID = 1;



--consulta para listar alumnos por clase
select a.id, c.id from alumno a, matricula m, detalleMatricula dm, clase c where
a.id = m.idalumno and
m.id = dm.idmatricula and
dm.idclase = c.id and
c.id = 1;



--consulta para listar alumnos por una clase, tipo nota y periodo

select a.NOMBRE, a.APELLIDOPATERNO, a.APELLIDOMATERNO, n.NOTA, 
n.id, n.IDALUMNO, n.IDCLASE, n.IDPERIODO, n.IDTIPOEVALUACION
from nota n, periodo p, TIPOEVALUACION te, alumno a , clase c where
n.IDPERIODO = p.id and
n.IDTIPOEVALUACION = te.id and
n.IDALUMNO = a.id and
n.IDCLASE = c.id and
n.IDCLASE = 1 and
n.IDPERIODO = 1 and
n.IDTIPOEVALUACION = 1;


--actualizar notas
update nota set NOTA = 10 where
IDCLASE = 1 and
IDALUMNO = 1 and
IDTIPOEVALUACION = 2 and
IDPERIODO = 1 and 
id = 182 ;



-- CONSULTA QUE DEVUELVE LAS CLASES DE UN ALUMNO 
SELECT c.id, cu.NOMBRELARGO ,a.NOMBRE 
from alumno a, detalleMatricula dm, matricula m, clase c, cursoPorGrado cpg , curso cu
where
a.id = m.IDALUMNO and
m.id = dm.IDMATRICULA and 
dm.IDCLASE = c.ID and 
c.IDCURSOPORGRADO = cpg.ID and
cpg.IDCURSO = cu.id and 
a.id = 21;




-- MOSTRAR LAS NOTAS DE UN ALUMNO POR CLASE 
SELECT cu.NOMBRELARGO, c.id AS idClase  ,a.NOMBRE , n.NOTA, te.DESCRIPCION, p.DESCRIPCION
from alumno a, detalleMatricula dm, matricula m, clase c, cursoPorGrado cpg , curso cu,
nota n, TIPOEVALUACION te, periodo p
where
a.id = m.IDALUMNO and
m.id = dm.IDMATRICULA and 
dm.IDCLASE = c.ID and 
c.IDCURSOPORGRADO = cpg.ID and
cpg.IDCURSO = cu.id and 
c.id = n.IDCLASE and
n.IDTIPOEVALUACION = te.id and
n.IDPERIODO = p.id and
n.IDPERIODO = 1 and
--n.IDCLASE = 21 and
--n.IDTIPOEVALUACION = 1 and
--p.id = 1 and
a.id = 22 order by cu.NOMBRELARGO;





--- REPORTE
--CONSULTA ESTATICA

select a.NOMBRE, a.APELLIDOMATERNO, a.APELLIDOPATERNO, a.DNI, g.NUMEROGRADO, s.DESCRIPCION ,n.NOMBRELARGO 
from alumno a, matricula m, grado g, NIVELEDUCACION n, seccion s where
a.ID = m.IDALUMNO and
m.IDGRADO = g.id and
g.IDSECCION = s.ID and
g.IDNIVELEDUCACION = n.ID
order by (n.NOMBRELARGO)




