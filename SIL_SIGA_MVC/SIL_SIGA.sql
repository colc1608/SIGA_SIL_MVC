CREATE DATABASE  IF NOT EXISTS `sil-siga` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sil-siga`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: sil-siga
-- ------------------------------------------------------
-- Server version	5.6.25-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `apellidoPaterno` varchar(15) NOT NULL,
  `apellidoMaterno` varchar(15) NOT NULL,
  `DNI` varchar(10) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `movil` varchar(15) DEFAULT NULL,
  `fechadenacimiento` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_alu` (`DNI`),
  KEY `alumno_ibfk_1` (`idUsuario`),
  CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'cesar','lopez','castillo','70777740','323068','123123123','1990-05-19','cesar.1608@','1',3),(2,'juan','perez','carmon','12121212','111111','111111111','1989-03-22','juanperez@hotmail','1',4),(4,'sandra','lala','lalaleeeeeee','22222222','225222','223322322','1986-09-17','sandra@','1',6);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apoderado`
--

DROP TABLE IF EXISTS `apoderado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apoderado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `apellidoPaterno` varchar(40) NOT NULL,
  `apellidoMaterno` varchar(40) NOT NULL,
  `DNI` varchar(12) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `movil` varchar(20) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_apo` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apoderado`
--

LOCK TABLES `apoderado` WRITE;
/*!40000 ALTER TABLE `apoderado` DISABLE KEYS */;
/*!40000 ALTER TABLE `apoderado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clase`
--

DROP TABLE IF EXISTS `clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCursoPorGrado` int(11) NOT NULL,
  `idDocente` int(11) NOT NULL,
  `cantidadAlumnos` int(11) NOT NULL,
  `observacion` varchar(45) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idCursoPorGrado` (`idCursoPorGrado`),
  KEY `idDocente` (`idDocente`),
  CONSTRAINT `clase_ibfk_1` FOREIGN KEY (`idCursoPorGrado`) REFERENCES `cursoporgrado` (`id`),
  CONSTRAINT `clase_ibfk_2` FOREIGN KEY (`idDocente`) REFERENCES `docente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clase`
--

LOCK TABLES `clase` WRITE;
/*!40000 ALTER TABLE `clase` DISABLE KEYS */;
/*!40000 ALTER TABLE `clase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCorto` varchar(6) NOT NULL,
  `nombreLargo` varchar(45) NOT NULL,
  `horasTecnicas` int(11) NOT NULL,
  `horasPracticas` int(11) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'CIAM','Ciencia y Ambiente',2,2,'para primaria','1'),(2,'MATBAS','Matematica Basica',4,0,'para primaria','1'),(3,'COMU','Comunicacion Integral',4,0,'para primaria','1'),(4,'REL','Religion',2,0,'para primaria','1'),(5,'HISPE','Historia del Peru',2,0,'para primaria','1'),(6,'QUIEL','Quimica Elemental',2,2,'para secundaria','1'),(7,'FISEL','Fisica Elemental',2,2,'para secundaria','1'),(8,'TRIGO','Geometria y Trigonometria',4,0,'para secundaria','1'),(9,'ECOCIE','Economia y Ciencias Politicas',2,0,'para secundaria','1'),(10,'PERFAM','Persona Familia y Relaciones Humanas',2,0,'para secundaria','1');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursoporgrado`
--

DROP TABLE IF EXISTS `cursoporgrado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursoporgrado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idGrado` int(11) NOT NULL,
  `idCurso` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idGrado` (`idGrado`),
  KEY `idCurso` (`idCurso`),
  CONSTRAINT `cursoporgrado_ibfk_1` FOREIGN KEY (`idGrado`) REFERENCES `grado` (`id`),
  CONSTRAINT `cursoporgrado_ibfk_2` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursoporgrado`
--

LOCK TABLES `cursoporgrado` WRITE;
/*!40000 ALTER TABLE `cursoporgrado` DISABLE KEYS */;
/*!40000 ALTER TABLE `cursoporgrado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallematricula`
--

DROP TABLE IF EXISTS `detallematricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallematricula` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idMatricula` int(11) NOT NULL,
  `idClase` int(11) NOT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idMatricula` (`idMatricula`),
  KEY `idClase` (`idClase`),
  CONSTRAINT `detallematricula_ibfk_1` FOREIGN KEY (`idMatricula`) REFERENCES `matricula` (`id`),
  CONSTRAINT `detallematricula_ibfk_2` FOREIGN KEY (`idClase`) REFERENCES `clase` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallematricula`
--

LOCK TABLES `detallematricula` WRITE;
/*!40000 ALTER TABLE `detallematricula` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallematricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idEspecialidad` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellidoPaterno` varchar(40) NOT NULL,
  `apellidoMaterno` varchar(40) NOT NULL,
  `DNI` varchar(15) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `movil` varchar(20) DEFAULT NULL,
  `fechadenacimiento` date DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_doc` (`DNI`),
  KEY `idEspecialidad` (`idEspecialidad`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `docente_ibfk_1` FOREIGN KEY (`idEspecialidad`) REFERENCES `especialidad` (`id`),
  CONSTRAINT `docente_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(40) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidad`
--

LOCK TABLES `especialidad` WRITE;
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
INSERT INTO `especialidad` VALUES (1,'idiomas','1'),(2,'educacion inicial','1'),(3,'fisica','1'),(4,'matematica pura','1'),(5,'quimica','1'),(6,'comunicaciones','1'),(7,'psicologia','1'),(8,'economia','1'),(9,'informatica','1');
/*!40000 ALTER TABLE `especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grado`
--

DROP TABLE IF EXISTS `grado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idnivelEducacion` int(11) NOT NULL,
  `idSeccion` int(11) NOT NULL,
  `numeroGrado` varchar(40) NOT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idnivelEducacion` (`idnivelEducacion`),
  KEY `idSeccion` (`idSeccion`),
  CONSTRAINT `grado_ibfk_1` FOREIGN KEY (`idnivelEducacion`) REFERENCES `niveleducacion` (`id`),
  CONSTRAINT `grado_ibfk_2` FOREIGN KEY (`idSeccion`) REFERENCES `seccion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grado`
--

LOCK TABLES `grado` WRITE;
/*!40000 ALTER TABLE `grado` DISABLE KEYS */;
INSERT INTO `grado` VALUES (1,1,3,'1','1'),(2,2,1,'6','1'),(3,2,1,'1','1'),(4,2,2,'1','1');
/*!40000 ALTER TABLE `grado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matricula` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAlumno` int(11) NOT NULL,
  `idGrado` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `montoPension` decimal(3,2) DEFAULT NULL,
  `observacion` varchar(100) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idAlumno` (`idAlumno`),
  KEY `idGrado` (`idGrado`),
  CONSTRAINT `matricula_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`id`),
  CONSTRAINT `matricula_ibfk_2` FOREIGN KEY (`idGrado`) REFERENCES `grado` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `niveleducacion`
--

DROP TABLE IF EXISTS `niveleducacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `niveleducacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCorto` varchar(45) DEFAULT NULL,
  `nombreLargo` varchar(45) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `niveleducacion`
--

LOCK TABLES `niveleducacion` WRITE;
/*!40000 ALTER TABLE `niveleducacion` DISABLE KEYS */;
INSERT INTO `niveleducacion` VALUES (1,'PRI','PRIMARIA','1'),(2,'SEC','SECUNDARIA','1');
/*!40000 ALTER TABLE `niveleducacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idClase` int(11) NOT NULL,
  `idTipoEvaluacion` int(11) NOT NULL,
  `idPeriodo` int(11) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `nota` int(11) DEFAULT '0',
  `peso` decimal(4,2) DEFAULT NULL,
  `observacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idClase` (`idClase`),
  KEY `idTipoEvaluacion` (`idTipoEvaluacion`),
  KEY `idPeriodo` (`idPeriodo`),
  KEY `idAlumno` (`idAlumno`),
  CONSTRAINT `nota_ibfk_1` FOREIGN KEY (`idClase`) REFERENCES `clase` (`id`),
  CONSTRAINT `nota_ibfk_2` FOREIGN KEY (`idTipoEvaluacion`) REFERENCES `tipoevaluacion` (`id`),
  CONSTRAINT `nota_ibfk_3` FOREIGN KEY (`idPeriodo`) REFERENCES `periodo` (`id`),
  CONSTRAINT `nota_ibfk_4` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parentesco`
--

DROP TABLE IF EXISTS `parentesco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parentesco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentesco` varchar(20) NOT NULL,
  `observacion` varchar(40) DEFAULT NULL,
  `idAlumno` int(11) NOT NULL,
  `idApoderado` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idAlumno` (`idAlumno`),
  KEY `idApoderado` (`idApoderado`),
  CONSTRAINT `parentesco_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`id`),
  CONSTRAINT `parentesco_ibfk_2` FOREIGN KEY (`idApoderado`) REFERENCES `apoderado` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parentesco`
--

LOCK TABLES `parentesco` WRITE;
/*!40000 ALTER TABLE `parentesco` DISABLE KEYS */;
/*!40000 ALTER TABLE `parentesco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `periodo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) NOT NULL,
  `observacion` varchar(50) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo`
--

LOCK TABLES `periodo` WRITE;
/*!40000 ALTER TABLE `periodo` DISABLE KEYS */;
INSERT INTO `periodo` VALUES (1,'iii','Tercer Bimestre','1'),(2,'iv','Cuarto Bimestre','1'),(3,'i','Primer Bimestre','1'),(4,'ii','Segundo Bimestre','1');
/*!40000 ALTER TABLE `periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seccion`
--

DROP TABLE IF EXISTS `seccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seccion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seccion`
--

LOCK TABLES `seccion` WRITE;
/*!40000 ALTER TABLE `seccion` DISABLE KEYS */;
INSERT INTO `seccion` VALUES (1,'C','1'),(2,'A','1'),(3,'B','1');
/*!40000 ALTER TABLE `seccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoevaluacion`
--

DROP TABLE IF EXISTS `tipoevaluacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoevaluacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) NOT NULL,
  `peso` double NOT NULL,
  `observacion` varchar(50) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoevaluacion`
--

LOCK TABLES `tipoevaluacion` WRITE;
/*!40000 ALTER TABLE `tipoevaluacion` DISABLE KEYS */;
INSERT INTO `tipoevaluacion` VALUES (1,'P2',0.1,'segunda practica','1'),(2,'P3',0.2,'tercera P','1'),(3,'P4',0.2,'cuarta P','1'),(4,'EP',0.2,'examen parcial','1'),(5,'EF',0.2,'examen final','1'),(6,'P1',0.1,'primera practica','1');
/*!40000 ALTER TABLE `tipoevaluacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(20) NOT NULL,
  `clave` varchar(20) NOT NULL,
  `estado` varchar(1) DEFAULT '1',
  `tipo` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','admin','1','1'),(2,'3000','1234','1','1'),(3,'3001','bb2831db','1','3'),(4,'3002','d6751a9e','1','3'),(5,'3003','708100db','1','3'),(6,'3004','50b18d5b','1','3');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sil-siga'
--

--
-- Dumping routines for database 'sil-siga'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_addAlumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_addAlumno`(nom  varchar(45), apater varchar(45), 
amater varchar(45), dni varchar(45), telefono varchar(45), movil varchar(45), email varchar(45),
fecha date)
BEGIN

DECLARE var1 INT DEFAULT 0; #variables enteras 
select user+1 from usuario where id = (select max(id) from usuario)  into var1;


insert into usuario ( user, clave , tipo)
values ( var1, (SELECT SUBSTRING(MD5(RAND()) FROM 1 FOR 8) ),'3');


insert into ALUMNO (nombre, APELLIDOPATERNO, APELLIDOMATERNO, dni, idusuario, telefono, movil, email, fechadenacimiento)
values (nom,apater,amater,dni, (select max(id) from usuario) , telefono, movil, email, fecha);


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_addDocente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_addDocente`(espec int, nom varchar(45), apater varchar(45), 
amater varchar(45), dni varchar(45), fec DATE)
BEGIN

DECLARE var1 INT DEFAULT 0; #variables enteras 
select user+1 from usuario where id = (select max(id) from usuario)  into var1;


insert into usuario ( user, clave , tipo)
values ( var1, (SELECT SUBSTRING(MD5(RAND()) FROM 1 FOR 8) ),'2');
 
 
insert into docente ( idespecialidad, nombre, APELLIDOPATERNO, APELLIDOMATERNO, dni, idusuario, FECHADENACIMIENTO)
values (espec,nom,apater,amater,dni,(select max(id) from usuario), fec);


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-02  7:53:17
