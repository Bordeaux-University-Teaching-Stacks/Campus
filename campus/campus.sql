-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Sam 12 Juillet 2014 à 13:49
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `campus`
--
CREATE DATABASE IF NOT EXISTS `campus` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `campus`;

-- --------------------------------------------------------

--
-- Structure de la table `campus`
--

CREATE TABLE IF NOT EXISTS `campus` (
  `id_campus` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  PRIMARY KEY (`id_campus`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=39 ;

--
-- Contenu de la table `campus`
--

INSERT INTO `campus` (`id_campus`, `name`) VALUES
(5, 'Bordeaux'),
(6, 'Lyon'),
(7, 'Grenoble'),
(8, 'Aix-Marseille'),
(9, 'Amiens'),
(10, 'Antilles-Guyane'),
(11, 'Besançon'),
(12, 'Bordeaux'),
(13, 'Caen'),
(14, 'Clermont-Ferrand'),
(15, 'Corse'),
(16, 'Créteil'),
(17, 'Dijon'),
(18, 'Grenoble'),
(19, 'Lille'),
(20, 'Limoges'),
(21, 'Lyon'),
(22, 'Mayotte'),
(23, 'Montpellier'),
(24, 'Nancy-Metz'),
(25, 'Nantes'),
(26, 'Nice'),
(27, 'Nouvelle-Calédonie'),
(28, 'Orléans-Tours'),
(29, 'Paris'),
(30, 'Poitiers'),
(31, 'Polynésie Française'),
(32, 'Reims'),
(33, 'Rennes'),
(34, 'La Réunion'),
(35, 'Rouen'),
(36, 'Strasbourg'),
(37, 'Toulouse'),
(38, 'Versailles');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `id_campus` int(11) NOT NULL,
  `email` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `birth` date NOT NULL,
  `name` varchar(250) NOT NULL,
  `surname` varchar(250) NOT NULL,
  `sex` char(1) CHARACTER SET latin1 NOT NULL,
  `photo` varchar(250) DEFAULT NULL,
  `legals` tinyint(1) NOT NULL,
  `newsletter` tinyint(1) NOT NULL,
  `date_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_user`),
  KEY `id_campus` (`id_campus`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=19 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id_user`, `id_campus`, `email`, `password`, `birth`, `name`, `surname`, `sex`, `photo`, `legals`, `newsletter`, `date_update`, `date_create`) VALUES
(1, 5, 'meidi.airouche@gmail.com', 'Hn93KT8Pe8lCH+K3KaLgag==', '1988-11-13', 'Airouche', 'Meidi', 'M', 'profile.png', 1, 1, '2014-07-06 20:30:45', '2014-07-02 00:00:00'),
(7, 6, 'clovis.borowy@hotmail.fr', '3yQmSw7ULmWBUXuCmLOzDw==', '1992-04-17', 'Borowy', 'Clovis', 'M', 'profile.png', 1, 1, '2014-07-06 20:31:37', '2014-07-06 00:00:00');

--
-- Déclencheurs `user`
--
DROP TRIGGER IF EXISTS `TRG_USER_DATECREATE`;
DELIMITER //
CREATE TRIGGER `TRG_USER_DATECREATE` BEFORE INSERT ON `user`
 FOR EACH ROW SET NEW.date_create = NOW()
//
DELIMITER ;
DROP TRIGGER IF EXISTS `TRG_USER_DATEUPDATE`;
DELIMITER //
CREATE TRIGGER `TRG_USER_DATEUPDATE` BEFORE UPDATE ON `user`
 FOR EACH ROW SET NEW.date_update = NOW()
//
DELIMITER ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_campus`) REFERENCES `campus` (`id_campus`) ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
