



-- datos iniciales que necesitamos

insert into usuario (id, usuario, clave, estado, tipo) 
values (sq_usuario.nextval, 'admin', 'admin', '1','0');

insert into usuario (id, usuario, clave, estado, tipo) 
values (sq_usuario.nextval, '3000', 'coord', '1','0');




-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- DATA DE CURSO

Insert into SYSTEM.CURSO (ID,NOMBRECORTO,NOMBRELARGO,HORASTECNICAS,HORASPRACTICAS,DESCRIPCION,ESTADO) 
values (sq_curso.NEXTVAL,'CIAM','Ciencia y Ambiente','2','2','para primaria','1');

Insert into SYSTEM.CURSO (ID,NOMBRECORTO,NOMBRELARGO,HORASTECNICAS,HORASPRACTICAS,DESCRIPCION,ESTADO) 
values (sq_curso.NEXTVAL,'MATBAS','Matematica Basica','4','0','para primaria','1');

Insert into SYSTEM.CURSO (ID,NOMBRECORTO,NOMBRELARGO,HORASTECNICAS,HORASPRACTICAS,DESCRIPCION,ESTADO) 
values (sq_curso.NEXTVAL,'COMU','Comunicacion Integral','4','0','para primaria','1');

Insert into SYSTEM.CURSO (ID,NOMBRECORTO,NOMBRELARGO,HORASTECNICAS,HORASPRACTICAS,DESCRIPCION,ESTADO) 
values (sq_curso.NEXTVAL,'REL','Religion','2','0','para primaria','1');

Insert into SYSTEM.CURSO (ID,NOMBRECORTO,NOMBRELARGO,HORASTECNICAS,HORASPRACTICAS,DESCRIPCION,ESTADO) 
values (sq_curso.NEXTVAL,'HISPE','Historia del Peru','2','0','para primaria','1');

Insert into SYSTEM.CURSO (ID,NOMBRECORTO,NOMBRELARGO,HORASTECNICAS,HORASPRACTICAS,DESCRIPCION,ESTADO) 
values (sq_curso.NEXTVAL,'QUIEL','Quimica Elemental','2','2','para secundaria','1');

Insert into SYSTEM.CURSO (ID,NOMBRECORTO,NOMBRELARGO,HORASTECNICAS,HORASPRACTICAS,DESCRIPCION,ESTADO) 
values (sq_curso.NEXTVAL,'FISEL','Fisica Elemental','2','2','para secundaria','1');

Insert into SYSTEM.CURSO (ID,NOMBRECORTO,NOMBRELARGO,HORASTECNICAS,HORASPRACTICAS,DESCRIPCION,ESTADO) 
values (sq_curso.NEXTVAL,'TRIGO','Geometria y Trigonometria','4','0','para secundaria','1');

Insert into SYSTEM.CURSO (ID,NOMBRECORTO,NOMBRELARGO,HORASTECNICAS,HORASPRACTICAS,DESCRIPCION,ESTADO) 
values (sq_curso.NEXTVAL,'ECOCIE','Economia y Ciencias Politicas','2','0','para secundaria','1');

Insert into SYSTEM.CURSO (ID,NOMBRECORTO,NOMBRELARGO,HORASTECNICAS,HORASPRACTICAS,DESCRIPCION,ESTADO) 
values (sq_curso.NEXTVAL,'PERFAM','Persona Familia y Relaciones Humanas','2','0','para secundaria','1');






-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- DATA DE ESPECIALIDAD
Insert into SYSTEM.ESPECIALIDAD (ID,DESCRIPCION,ESTADO) values (sq_especialidad.NEXTVAL,'idiomas','1');
Insert into SYSTEM.ESPECIALIDAD (ID,DESCRIPCION,ESTADO) values (sq_especialidad.NEXTVAL,'educacion inicial','1');
Insert into SYSTEM.ESPECIALIDAD (ID,DESCRIPCION,ESTADO) values (sq_especialidad.NEXTVAL,'fisica','1');
Insert into SYSTEM.ESPECIALIDAD (ID,DESCRIPCION,ESTADO) values (sq_especialidad.NEXTVAL,'matematica pura','1');
Insert into SYSTEM.ESPECIALIDAD (ID,DESCRIPCION,ESTADO) values (sq_especialidad.NEXTVAL,'quimica','1');
Insert into SYSTEM.ESPECIALIDAD (ID,DESCRIPCION,ESTADO) values (sq_especialidad.NEXTVAL,'comunicaciones','1');
Insert into SYSTEM.ESPECIALIDAD (ID,DESCRIPCION,ESTADO) values (sq_especialidad.NEXTVAL,'psicologia','1');
Insert into SYSTEM.ESPECIALIDAD (ID,DESCRIPCION,ESTADO) values (sq_especialidad.NEXTVAL,'economia','1');
Insert into SYSTEM.ESPECIALIDAD (ID,DESCRIPCION,ESTADO) values (sq_especialidad.NEXTVAL,'informatica','1');




-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- DATA DE SECCION
Insert into SYSTEM.SECCION (ID,DESCRIPCION,ESTADO) values (sq_seccion.NEXTVAL,'C','1');
Insert into SYSTEM.SECCION (ID,DESCRIPCION,ESTADO) values (sq_seccion.NEXTVAL,'A','1');
Insert into SYSTEM.SECCION (ID,DESCRIPCION,ESTADO) values (sq_seccion.NEXTVAL,'B','1');

-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- DATA DE NIVEL
Insert into SYSTEM.NIVELEDUCACION (ID,NOMBRECORTO,NOMBRELARGO,ESTADO) values (sq_niveleducacion.NEXTVAL,'PRI','PRIMARIA','1');
Insert into SYSTEM.NIVELEDUCACION (ID,NOMBRECORTO,NOMBRELARGO,ESTADO) values (sq_niveleducacion.NEXTVAL,'SEC','SECUNDARIA','1');



-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- DATA DE GRADO

Insert into SYSTEM.GRADO (ID,IDNIVELEDUCACION,IDSECCION,NUMEROGRADO,ESTADO) values (sq_grado.NEXTVAL,'1','3','1','1');
Insert into SYSTEM.GRADO (ID,IDNIVELEDUCACION,IDSECCION,NUMEROGRADO,ESTADO) values (sq_grado.NEXTVAL,'2','1','6','1');
Insert into SYSTEM.GRADO (ID,IDNIVELEDUCACION,IDSECCION,NUMEROGRADO,ESTADO) values (sq_grado.NEXTVAL,'2','1','1','1');
Insert into SYSTEM.GRADO (ID,IDNIVELEDUCACION,IDSECCION,NUMEROGRADO,ESTADO) values (sq_grado.NEXTVAL,'2','2','1','1');


-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- DATA DE PERIODO

Insert into SYSTEM.PERIODO (ID,DESCRIPCION,OBSERVACION,ESTADO) values (sq_periodo.NEXTVAL,'iii','Tercer Bimestre','1');
Insert into SYSTEM.PERIODO (ID,DESCRIPCION,OBSERVACION,ESTADO) values (sq_periodo.NEXTVAL,'iv','Cuarto Bimestre','1');
Insert into SYSTEM.PERIODO (ID,DESCRIPCION,OBSERVACION,ESTADO) values (sq_periodo.NEXTVAL,'i','Primer Bimestre','1');
Insert into SYSTEM.PERIODO (ID,DESCRIPCION,OBSERVACION,ESTADO) values (sq_periodo.NEXTVAL,'ii','Segundo Bimestre','1');

-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- DATA DE TIPO NOTA
Insert into SYSTEM.TIPOEVALUACION (ID,DESCRIPCION,PESO,OBSERVACION,ESTADO) values (sq_tipoevaluacion.NEXTVAL,'P2','0,1','segunda practica','1');
Insert into SYSTEM.TIPOEVALUACION (ID,DESCRIPCION,PESO,OBSERVACION,ESTADO) values (sq_tipoevaluacion.NEXTVAL,'P3','0,2','tercera P','1');
Insert into SYSTEM.TIPOEVALUACION (ID,DESCRIPCION,PESO,OBSERVACION,ESTADO) values (sq_tipoevaluacion.NEXTVAL,'P4','0,2','cuarta P','1');
Insert into SYSTEM.TIPOEVALUACION (ID,DESCRIPCION,PESO,OBSERVACION,ESTADO) values (sq_tipoevaluacion.NEXTVAL,'EP','0,2','examen parcial','1');
Insert into SYSTEM.TIPOEVALUACION (ID,DESCRIPCION,PESO,OBSERVACION,ESTADO) values (sq_tipoevaluacion.NEXTVAL,'EF','0,2','examen final','1');
Insert into SYSTEM.TIPOEVALUACION (ID,DESCRIPCION,PESO,OBSERVACION,ESTADO) values (sq_tipoevaluacion.NEXTVAL,'P1','0,1','primera practica','1');



-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
--DATA DE ALUMNO ( en caso EXTREMO, recuerda que se debe generar un USUARIO con el STORE PROCEDURE !!!!!!!!!!!!!!!! )
CALL sp_addAlumno('juanito','quispe','plasencia','30303030',null,null,null);
CALL sp_addAlumno('jaimito','baca','orbegoso','40404040',null,null,null);
CALL sp_addAlumno('lucho','perez','gutierrez','50505050',null,null,null);
CALL sp_addAlumno('pepe','lopez','vega','10101010',null,null,null);
CALL sp_addAlumno('lulu','iquique','horna','20202020',null,null,null);



-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- DATA DE DOCENTE ( en caso EXTREMO, recuerda que se debe generar un USUARIO con el STORE PROCEDURE !!!!!!!!!!!!!!!! )
CALL sp_addDocente(8,'walter','ramos','mendoza','33333333','23/06/91');
CALL sp_addDocente(7,'cesar','lopez','castillo','22222222','23/06/90');
CALL sp_addDocente(6,'paul','farfan','altuna','11111111','23/06/89');
CALL sp_addDocente(5,'maria','lazaro','asuncion','44444444','23/06/88');
CALL sp_addDocente(1,'gabriela','vasquez','leon','55555555','23/06/87');

