/*
Autores: 
Lopez Castillo, Cesar
Farfan Altuna, Paul
Ramos Mendoza, Walter
*/


--SCRIPT DE LA BASE DE DATOS. CORRE TODO

create table NivelEducacion(
id int primary key not null,
nombreCorto varchar(3) not null,
nombreLargo varchar(45) not null,
estado char(1) default '1'  null 
);

create table Seccion(
id int primary key not null,
descripcion varchar(45) not null,
estado char(1) default '1'  null 
);

create table Grado(
id int primary key not null,
idnivelEducacion int not null,
foreign key(idnivelEducacion) references NivelEducacion(id),
idSeccion int not null,
foreign key(idSeccion) references Seccion(id),
numeroGrado varchar(40)not null,
estado char(1) default '1'  null 
);

create table Curso(
id int primary key not null,
nombreCorto varchar(6) not null,
nombreLargo varchar(45) not null,
horasTecnicas int not null,
horasPracticas int,
descripcion varchar(45),
estado char(1) default '1'  null 
);

create table CursoPorGrado(
id int primary key not null,
idGrado int not null,
foreign key(idGrado) references Grado(id),
idCurso int not null,
foreign key(idCurso) references Curso(id),
descripcion varchar(45),
estado char(1) default '1'  null 
);


create table Especialidad(
id int primary key not null,
descripcion varchar(40),
estado char(1) default '1'  null 
);


create table TipoEvaluacion(
id int primary key not null,
descripcion varchar(30) not null,
peso numeric(3,2) not null,
observacion varchar(50),
estado char(1) default '1'  null 
);

create table Periodo(
id int primary key not null,
descripcion varchar(20) not null,
observacion varchar(50),
estado char(1) default '1'  null 
);

create table Apoderado(
id int primary key not null,
nombre varchar(40) not null,
apellidoPaterno varchar(40)not null,
apellidoMaterno varchar(40)not null,
DNI varchar(12)not null,
telefono varchar(20),
movil varchar(20),
fechaNacimiento date,
email varchar(40),
estado char(1) default '1'  null,
CONSTRAINT unique_apo UNIQUE(DNI)
);

create table Usuario(
id int primary key not null,
usuario varchar(20)not null,
clave varchar(20) not null,
estado varchar(1) default '1'  null,
tipo varchar(1) null
);

--FALTA CREAR EL HISTORIAL DE ACCESO
create table HistoricoAcceso(
id int primary key not null,
idUsuario varchar(45),
inicioSession DATE,
finSession TIMESTAMP,
tiempoSession TIMESTAMP,
lugar varchar(45)
);


create table Alumno(
id int primary key not null,
nombre varchar(40) not null,
apellidoPaterno varchar(15)not null,
apellidoMaterno varchar(15)not null,
DNI varchar(10) not null,
telefono varchar(15),
movil varchar(15),
fechadenacimiento date,
email varchar(45),
estado char(1) default '1'  null ,
CONSTRAINT unique_alu UNIQUE(DNI),
idUsuario int not null,
foreign key(idUsuario) references Usuario(id)
);


create table Parentesco(
id int primary key not null,
parentesco varchar(20)not null,
observacion varchar(40),
idAlumno int not null,
foreign key(idAlumno) references Alumno(id),
idApoderado int not null,
foreign key(idApoderado) references Apoderado(id)
);


create table Docente(
id int primary key not null,
idEspecialidad int not null,
foreign key(idEspecialidad) references Especialidad(id),
nombre varchar(40)not null,
apellidoPaterno varchar(40)not null,
apellidoMaterno varchar(40)not null,
DNI varchar(15)not null,
telefono varchar(20),
movil varchar(20),
fechadenacimiento date,
email varchar(40),
estado char(1) default '1'  null ,
idUsuario int not null,
CONSTRAINT unique_doc UNIQUE(DNI),
foreign key(idUsuario) references Usuario(id)
);

create table Clase(
id int primary key not null,
idCursoPorGrado int not null,
foreign key(idCursoPorGrado) references CursoPorGrado(id),
idDocente int not null,
foreign key(idDocente) references Docente(id),
cantidadAlumnos int not null,
observacion varchar(45),
estado char(1) default '1'  null 
);

create table Nota(
id int primary key not null,
idClase int not null,
foreign key(idClase) references Clase(id),
idTipoEvaluacion int not null,
foreign key(idTipoEvaluacion) references TipoEvaluacion(id),
idPeriodo int not null,
foreign key(idPeriodo) references Periodo(id),
idAlumno int not null,
foreign key(idAlumno) references Alumno(id),
nota int default '0' ,
peso numeric(4,2),
observacion varchar(45)
);

create table Matricula(
id int primary key not null,
idAlumno int not null,
foreign key(idAlumno) references Alumno(id),
idGrado int not null,
foreign key(idGrado) references Grado(id),
fecha date,
montoPension numeric(3,2),
observacion varchar(100),
estado char(1) default '1'  null
);


create table DetalleMatricula(
id int primary key not null,
idMatricula int not null,
foreign key(idMatricula) references Matricula(id),
idClase int not null,
foreign key(idClase) references Clase(id),
estado char(1) default '1'  null

);



--SECUENCIAS 
create sequence sq_docente
start with 1
increment by 1;

create sequence sq_usuario
start with 1
increment by 1;

create sequence sq_especialidad
start with 1
increment by 1;

create sequence sq_niveleducacion
start with 1
increment by  1;

create sequence sq_seccion
start with 1
increment by 1;

create sequence sq_grado
start with 1
increment by 1;

create sequence sq_curso
start with 1
increment by 1;

create sequence sq_cursoporgrado
start with 1
increment by 1;

create sequence sq_tipoevaluacion
start with 1
increment by 1;

create sequence sq_periodo
start with 1
increment by 1;

create sequence sq_apoderado
start with 1
increment by 1;

create sequence sq_alumno
start with 1
increment by 1;

create sequence sq_parentesco
start with 1
increment by 1;

create sequence sq_clase
start with 1
increment by 1;

create sequence sq_nota
start with 1
increment by 1;

create sequence sq_historicoacceso
start with 1
increment by 1;

create sequence sq_matricula
start with 1
increment by 1;

create sequence sq_detalleMatricula
start with 1
increment by 1;



-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
---------------------GENERAR UNA NUEVA DATA LIMPIA-----------------------------
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------


-- eliminando secuencias
drop SEQUENCE sq_alumno;
drop SEQUENCE sq_clase;
drop SEQUENCE sq_cursoporgrado;
drop SEQUENCE sq_grado;
drop SEQUENCE sq_parentesco;
drop SEQUENCE sq_docente;
drop SEQUENCE sq_usuario;
drop SEQUENCE sq_nota;
drop SEQUENCE sq_matricula;
drop SEQUENCE sq_detalleMatricula;
drop SEQUENCE sq_apoderado;
drop SEQUENCE sq_curso;
drop SEQUENCE sq_niveleducacion;
drop SEQUENCE sq_seccion;
drop SEQUENCE sq_especialidad;
drop SEQUENCE sq_tipoevaluacion;
drop SEQUENCE sq_periodo;
drop SEQUENCE sq_historicoacceso;



--borrando data ( EN ESE MISMO ORDEN !!!!!!! )

delete from Nota;
delete from DetalleMatricula;
delete from Matricula;
delete from Clase;
delete from CursoPorGrado;
delete from Grado;
delete from Seccion;
delete from NivelEducacion;
delete from Curso;
delete from Parentesco;
delete from Alumno;
delete from Docente;
delete from Usuario;
delete from Apoderado;
delete from Especialidad;
delete from TipoEvaluacion;
delete from Periodo;



/*
    OEEEEEEEEEEEEEEEEE AHORA DEBES VOLVER A CREAR LAS SECUENCIAS -.- 
*/









