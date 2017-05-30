-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-05-2017 a las 18:36:09
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `regufinal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE IF NOT EXISTS `alumno` (
  `id_matricula` varchar(10) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `pass` varchar(15) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id_matricula`, `nombre`, `pass`, `estado`) VALUES
('1', 'Alfonso', '1', 'Hecho'),
('12011266', 'Uriel Oropeza Hernandez', '12011266', NULL),
('2', 'Carlos', '2', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docente`
--

CREATE TABLE IF NOT EXISTS `docente` (
  `id_docente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_docente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `docente`
--

INSERT INTO `docente` (`id_docente`, `nombre`) VALUES
(1, 'Aline');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evalua`
--

CREATE TABLE IF NOT EXISTS `evalua` (
  `id_evaluacion` int(11) NOT NULL AUTO_INCREMENT,
  `evaluacion` int(3) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `id_fk_matricula` varchar(10) DEFAULT NULL,
  `id_fk_docente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_evaluacion`),
  KEY `id_fk_matricula` (`id_fk_matricula`),
  KEY `id_fk_docente` (`id_fk_docente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `evalua`
--

INSERT INTO `evalua` (`id_evaluacion`, `evaluacion`, `fecha`, `id_fk_matricula`, `id_fk_docente`) VALUES
(2, 90, '2017-05-28', '1', 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `evalua`
--
ALTER TABLE `evalua`
  ADD CONSTRAINT `evalua_ibfk_1` FOREIGN KEY (`id_fk_matricula`) REFERENCES `alumno` (`id_matricula`),
  ADD CONSTRAINT `evalua_ibfk_2` FOREIGN KEY (`id_fk_docente`) REFERENCES `docente` (`id_docente`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
