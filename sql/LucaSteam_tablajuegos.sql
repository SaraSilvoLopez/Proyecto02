-- DROP DATABASE IF EXISTS `lucasteam`;
CREATE DATABASE IF NOT EXISTS `lucasteam`;
USE `lucasteam`;
-- DROP TABLE IF EXISTS `lucasteam`.`juegos` ;
CREATE TABLE `juegos` (
  `juego_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(90) NOT NULL,
  `fecha` year (4) NOT NULL,
  `editor` varchar(45) NULL,
  `genero` varchar(45) NULL,
  `plataforma` varchar(45) NULL,
  `ventas` decimal (4,2) NULL,
  PRIMARY KEY (`juego_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1

