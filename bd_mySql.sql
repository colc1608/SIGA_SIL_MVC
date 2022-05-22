-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbsilsiga
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `apellidoPaterno` varchar(15) NOT NULL,
  `apellidoMaterno` varchar(15) NOT NULL,
  `DNI` varchar(10) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `movil` varchar(15) DEFAULT NULL,
  `fechadenacimiento` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  `idUsuario` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_alu` (`DNI`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `apoderado`
--

DROP TABLE IF EXISTS `apoderado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apoderado` (
  `id` int NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `clase`
--

DROP TABLE IF EXISTS `clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idCursoPorGrado` int NOT NULL,
  `idDocente` int NOT NULL,
  `cantidadAlumnos` int NOT NULL,
  `observacion` varchar(45) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idCursoPorGrado` (`idCursoPorGrado`),
  KEY `idDocente` (`idDocente`),
  CONSTRAINT `clase_ibfk_1` FOREIGN KEY (`idCursoPorGrado`) REFERENCES `cursoporgrado` (`id`),
  CONSTRAINT `clase_ibfk_2` FOREIGN KEY (`idDocente`) REFERENCES `docente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombreCorto` varchar(6) NOT NULL,
  `nombreLargo` varchar(45) NOT NULL,
  `horasTecnicas` int NOT NULL,
  `horasPracticas` int DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cursoporgrado`
--

DROP TABLE IF EXISTS `cursoporgrado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursoporgrado` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idGrado` int NOT NULL,
  `idCurso` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  `CANTIDADALUMNOS` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idGrado` (`idGrado`),
  KEY `idCurso` (`idCurso`),
  CONSTRAINT `cursoporgrado_ibfk_1` FOREIGN KEY (`idGrado`) REFERENCES `grado` (`id`),
  CONSTRAINT `cursoporgrado_ibfk_2` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detallematricula`
--

DROP TABLE IF EXISTS `detallematricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallematricula` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idMatricula` int NOT NULL,
  `idClase` int NOT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idMatricula` (`idMatricula`),
  KEY `idClase` (`idClase`),
  CONSTRAINT `detallematricula_ibfk_1` FOREIGN KEY (`idMatricula`) REFERENCES `matricula` (`id`),
  CONSTRAINT `detallematricula_ibfk_2` FOREIGN KEY (`idClase`) REFERENCES `clase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idEspecialidad` int NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellidoPaterno` varchar(40) NOT NULL,
  `apellidoMaterno` varchar(40) NOT NULL,
  `DNI` varchar(15) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `movil` varchar(20) DEFAULT NULL,
  `fechadenacimiento` date DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  `idUsuario` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_doc` (`DNI`),
  KEY `idEspecialidad` (`idEspecialidad`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `docente_ibfk_1` FOREIGN KEY (`idEspecialidad`) REFERENCES `especialidad` (`id`),
  CONSTRAINT `docente_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(40) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grado`
--

DROP TABLE IF EXISTS `grado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grado` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idnivelEducacion` int NOT NULL,
  `idSeccion` int NOT NULL,
  `numeroGrado` varchar(40) NOT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idnivelEducacion` (`idnivelEducacion`),
  KEY `idSeccion` (`idSeccion`),
  CONSTRAINT `grado_ibfk_1` FOREIGN KEY (`idnivelEducacion`) REFERENCES `niveleducacion` (`id`),
  CONSTRAINT `grado_ibfk_2` FOREIGN KEY (`idSeccion`) REFERENCES `seccion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `historicoacceso`
--

DROP TABLE IF EXISTS `historicoacceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historicoacceso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idUsuario` varchar(45) DEFAULT NULL,
  `inicioSession` date DEFAULT NULL,
  `finSession` timestamp NULL DEFAULT NULL,
  `tiempoSession` timestamp NULL DEFAULT NULL,
  `lugar` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matricula` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idAlumno` int NOT NULL,
  `idGrado` int NOT NULL,
  `fecha` date DEFAULT NULL,
  `montoPension` decimal(3,2) DEFAULT NULL,
  `observacion` varchar(100) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idAlumno` (`idAlumno`),
  KEY `idGrado` (`idGrado`),
  CONSTRAINT `matricula_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`id`),
  CONSTRAINT `matricula_ibfk_2` FOREIGN KEY (`idGrado`) REFERENCES `grado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `niveleducacion`
--

DROP TABLE IF EXISTS `niveleducacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `niveleducacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombreCorto` varchar(3) NOT NULL,
  `nombreLargo` varchar(45) NOT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nota` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idClase` int NOT NULL,
  `idTipoEvaluacion` int NOT NULL,
  `idPeriodo` int NOT NULL,
  `idAlumno` int NOT NULL,
  `nota` int DEFAULT '0',
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `parentesco`
--

DROP TABLE IF EXISTS `parentesco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parentesco` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parentesco` varchar(20) NOT NULL,
  `observacion` varchar(40) DEFAULT NULL,
  `idAlumno` int NOT NULL,
  `idApoderado` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idAlumno` (`idAlumno`),
  KEY `idApoderado` (`idApoderado`),
  CONSTRAINT `parentesco_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`id`),
  CONSTRAINT `parentesco_ibfk_2` FOREIGN KEY (`idApoderado`) REFERENCES `apoderado` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) NOT NULL,
  `observacion` varchar(50) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `seccion`
--

DROP TABLE IF EXISTS `seccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seccion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipoevaluacion`
--

DROP TABLE IF EXISTS `tipoevaluacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoevaluacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) NOT NULL,
  `peso` decimal(3,2) NOT NULL,
  `observacion` varchar(50) DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) NOT NULL,
  `clave` varchar(20) NOT NULL,
  `estado` varchar(1) DEFAULT '1',
  `tipo` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'dbsilsiga'
--

--
-- Dumping routines for database 'dbsilsiga'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_addAlumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_addAlumno`( 
in nom  varchar(100), 
in apater varchar(100), 
IN amater varchar(100), 
IN dni varchar(100), 
in telefono varchar(100), 
in movil varchar(100), 
IN email varchar(100) ,
IN nacimiento date)
begin

insert into usuario (  usuario, clave, tipo)
values ( 
		(select u.usuario+1  from usuario U where u.id = (select max(A.id) from usuario A)  ), 
		( SELECT LEFT(UUID(), 8) ),
		'2'
        );
      

insert into ALUMNO ( nombre, APELLIDOPATERNO, APELLIDOMATERNO, dni, idusuario, telefono, movil, email, fechadenacimiento)
values (nom,apater,amater,dni,(select max(id) from usuario), telefono, movil, email, nacimiento);

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
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_addDocente`(
in espec int, 
in  nom varchar(40), 
in  apater varchar(40), 
in amater varchar(40), 
in dni varchar(15), 
in  fec DATE,
in telefono varchar(20), 
in email varchar(40), 
in movil varchar(20)
)
begin 

insert into usuario ( usuario, clave, tipo)
values ( 
		(select UU.usuario+1  from usuario UU where UU.id = (select max(AA.id) from usuario AA)), 
		( SELECT LEFT(UUID(), 8) ),
		'1'
);

insert into docente 
( idespecialidad, nombre, APELLIDOPATERNO, APELLIDOMATERNO, dni, idusuario, FECHADENACIMIENTO, telefono, email, movil)
values 
( espec,nom,apater,amater,dni,(select max(id) from usuario), fec, telefono, email, movil);


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_ADDPARENTESCO` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ADDPARENTESCO`(in par Varchar(100), in  obs varchar(100))
BEGIN
   
    INSERT INTO PARENTESCO(PARENTESCO, OBSERVACION,IDALUMNO,IDAPODERADO)
    VALUES(par,obs,(select max(id) from ALUMNO),(select max(id) from APODERADO));


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

-- Dump completed on 2022-05-22 18:31:14
