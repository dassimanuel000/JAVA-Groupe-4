-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 27 mai 2019 à 20:46
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `id14306609_map`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `boucle`$$
/*CREATE DEFINER=`id14306609_root`@`localhost` PROCEDURE `boucle` ()  NO SQL*/
CREATE /*DEFINER = root@localhost*/ PROCEDURE `boucle` ()  NO SQL
BEGIN
DECLARE param VARCHAR(50);
DECLARE colonne VARCHAR(50);
DECLARE nom VARCHAR(50);
DECLARE cmd VARCHAR(500);
SET @param = 1;
SET @colonne = "line ";  
boucle_loop: LOOP
SET @nom = CONCAT('`',@colonne, @param, '`');
SET @cmd = CONCAT('INSERT INTO `map1.1` (line1) SELECT ',@nom,' FROM `level 1`');
PREPARE stmt1 FROM @cmd; 
EXECUTE stmt1; 
SET @param = @param + 1;
IF (@param = 23) THEN
LEAVE boucle_loop;
END IF;
END LOOP;
END$$

DROP PROCEDURE IF EXISTS `getLineMap1`$$
/*CREATE DEFINER=`id14306609_root`@`localhost` PROCEDURE `getLineMap1` (IN `nbLine` VARCHAR(50))  NO SQL*/
CREATE /*DEFINER=`id14306609_root`@`localhost`*/ PROCEDURE `getLineMap1` (IN `nbLine` VARCHAR(50))  NO SQL
SELECT * FROM `map1.1` WHERE ID = nbLine$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `level 1`
--

DROP TABLE IF EXISTS `level 1`;
CREATE TABLE IF NOT EXISTS `level 1` (
  `line 1` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 2` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 3` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 4` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 5` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 6` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 7` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 8` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 9` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 10` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 11` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 12` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 13` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 14` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 15` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 16` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 17` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 18` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 19` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 20` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 21` varchar(50) COLLATE utf8_bin NOT NULL,
  `line 22` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `level 1`
--

INSERT INTO `level 1` (`line 1`, `line 2`, `line 3`, `line 4`, `line 5`, `line 6`, `line 7`, `line 8`, `line 9`, `line 10`, `line 11`, `line 12`, `line 13`, `line 14`, `line 15`, `line 16`, `line 17`, `line 18`, `line 19`, `line 20`, `line 21`, `line 22`) VALUES
('MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM', 'MTTDTTTTTTTTTTTTTTTTTTTDTTCTTTTTTTTTTTTM', 'MTTTTTTTDTTTTTTTTTTTTTTCTTCTTTTTTTTTDTTM', 'MTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMTTTTM', 'MTTTTTTTTTTCTTTTTTTTTTTTTTTTTTTTTTTTTCCM', 'MTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTM', 'MTTDTTTTTTCTCTTTTTTTTDTTTTTTTTTTTTDTTTTM', 'MTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTM', 'MTTTTMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM', 'MTTTCCTTTTTTTTTTCCCTTTCTTTTTTTTCCCTCTTTM', 'MTTTTCTTTTTTTTTTTTTTTTTCTCTTTTTTTTTCTTTM', 'MDTTTCTTCTTTDTTTTTTTTTTTTTTTTTTTTTTDTTTM', 'MTTTTTTTTTTTTTTTTTTTTTTTTTTTDTTTTTTTTTTM', 'MTTCTTTTTTTTTTTTDTTTTTTTTTTTTTTTTTTTTTTM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMTTM', 'MCTCTTTTCCTTCTTTTCCCTTTTTTTTTCDCTTTCTTTM', 'MTTCTTTTTCTTDTTTTTTTTTTTTTTTTCCCTTTTCTTM', 'METTTTTTTTTTTTTTTTTTTTTTTTTCTCTTTTTTTTTM', 'MTTTTTTTTTTTTTTTTTCTCTTTTTTCCCTTTTTDTTTM', 'MTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM');

-- --------------------------------------------------------

--
-- Structure de la table `map1.1`
--

DROP TABLE IF EXISTS `map1.1`;
CREATE TABLE IF NOT EXISTS `map1.1` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `line1` varchar(500) COLLATE utf8_bin NOT NULL,
  `line2` varchar(500) COLLATE utf8_bin NOT NULL,
  `line3` varchar(500) COLLATE utf8_bin NOT NULL,
  `line4` varchar(500) COLLATE utf8_bin NOT NULL,
  `line5` varchar(500) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `map1.1`
--

INSERT INTO `map1.1` (`ID`, `line1`, `line2`, `line3`, `line4`, `line5`) VALUES
(1, 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM'),
(2, 'MPTDTTTTTTTTTTTTTTTTTTTDTTCTTTTTTTTTTTTM', 'MPTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTCCTTTTM', 'MPTTTTTTTTCTTTACATTTTTTTTTTTCTTATTTTTTTM', 'MPMTTTTTTTTTMTTTMTTTTTTTTTTTTTTTTTTTCCCM', 'MPTTTTTTTTTTTTTTMTTTTTTTMTTTTTTMTTTTMTTM'),
(3, 'MTTTTTTTDTTTTTTTTTTTTTTCTTCTTTTTTTTTDTTM', 'MTTTTTTTTCTTTTTCTTTTTTTTTTATTTTTTTTTTTTM', 'MTTTTTTTTTDTTTCCATTTTTTTTCTTDTTTTCTATCTM', 'MTMTTTMDTTTTMTDDMCCCTTTTTTTTTTTTTTTTTTTM', 'MTTTTTTTTTTTTTTTMTTTTTTTMTTTTTTMTTCTMTTM'),
(4, 'MTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTM', 'MTTTTTTTTTATTTTCTTTTTTTTTTTAATTTTTTTTTTM', 'MTTTTCTTTTTTTTCCTTTTTTCTTTTTTTTTTTTTTTTM', 'MTMTTTMTTTCTMTTTMTTTTCCTTTTTTTTTTTTTTTTM', 'MTTTTTTTTTTTTTTTMTTTMTTTMTTTTCTMCTCTMTTM'),
(5, 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMTTTTM', 'MTAATTTTTTATTTTTTTTTCTTTTTTTTTTTTTCTTTTM', 'MTCTTCTTTTTTTTCCTTTCTTTTTTTTTTCTTTTTTTTM', 'MTMTTTMTTTTTMTTTMTTTTTTTTTTTTTTTTTTTTTTM', 'MMMMMMMMMMMMMTTCMTTTMTDTMTDTMTTMTTTTMCTM'),
(6, 'MTTTTTTTTTTCTTTTTTTTTTTTTTTTTTTTTTTTTCCM', 'MTTATTTTTATTTTTTTTTCCTTTTTTTTTTTTACTTAAM', 'MTTTTTCTTTTTTTCCTTTDTTTTTCTTCTTTATTTATTM', 'MTMTTTMTTTTCMTTTMTTTTTTTTTTTTTTTTTTTTTTM', 'MTTTTTTTTTTTTTTTMTTTMTTTMTTTMTTMTTMTMTTM'),
(7, 'MTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTM', 'MPTTTTTTTTTTTTTTTTTTCTTTTTTTTTTTTTTTTAAM', 'MTTTTTTTTTTTTTCCTTTTTCTTTTTTTTTTTTTCTTTM', 'MTMCCCMTTTTTMTTTMTDTTMMMMMMMMMMMMMMMTTTM', 'MTTTCTTTTTTTTTTTMTCTMTTTMTTTMDTMTTMTMTTM'),
(8, 'MTTDTTTTTTCTCTTTTTTTTDTTTTTTTTTTTTDTTTTM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMTTTAAM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMTTTTDM', 'MTMTTTMTTCCTMTTTMTTTTMTTTTTTTTTTTTTTTDTM', 'MDTTDTCCTTTTDTTTMTTTMCCTMTTTMTTMTTMTMTTM'),
(9, 'MTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMTTTAAM', 'MTTTTTTTTDDTTTTTTTTTTTTTTTTTTTTTTTTTATTM', 'MTMTDTMTTTTTMTMMMTTTTMTTTTTTTTTTTTTTTTTM', 'MTTTTTTTTTTTTTTTMTTTMTTTMTCTMTTMTDMTMTTM'),
(10, 'MTTTTMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM', 'MTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTM', 'MTTTTTTTTDDTTTTTTTTTTTTTTTTTTTTTTTTTATTM', 'MTMTTTMTTAATMTTTMATDTMTTTTTAATTTTTTTTTTM', 'MTTTTTTTTDTTTTTTMTDTMTTTMTTTMTTMTTMTMDTM'),
(11, 'MTTTCCTTTTTTTTTTCCCTTTCTTTTTTTTCCCTCTTTM', 'MTTTTCCTTTTCTTTTTTTCCTTTTTTTCTTTTTTTTTTM', 'MCDCTTTTTTTTTTCTATTTATTTTTTATTTTTTATCTTM', 'MTMTTTMMMMMTMTTTMTTTTMDCTTTCCTTTTTTTCCTM', 'MTTTTTTTTTTTTTTTMTTTMTTTMTTTMTTMTTMTMTTM'),
(12, 'MTTTTCTTTTTTTTTTTTTTTTTCTCTTTTTTTTTCTTTM', 'MTCTTTTTCTTTTTTTTTTCCTTTTTTTTTTTTTATTTTM', 'MCCCTTTTATTTTTTTTTTTTTTTTTTTTTDTTTTTTTCM', 'MTMTTTMTTTTTMTTTMTTTTMTCCTTTTTTTTTTTTTTM', 'MTDTMMMMMMMMMMMMMTTTMTTTMTTTMTTMTTMTMTTM'),
(13, 'MDTTTCTTCTTTDTTTTTTTTTTTTTTTTTTTTTTDTTTM', 'MTTTTTTTTTTTTTTTTTTCCTTTCTTTTTTTTTCTTTTM', 'MTTTATTTTTTTTTTTTTTDTTTCTTTCTTTTTCTTTTTM', 'MTMTTTMTTTTTMTTTMTTDTMTTTTTTTTTTTTTTTTDM', 'MTTTTTTTTTTTTCTTMTCTMTDTMTTTMTTMTTMTMTTM'),
(14, 'MTTTTTTTTTTTTTTTTTTTTTTTTTTTDTTTTTTTTTTM', 'MTTTCTTTTTTTTTTTTTTTTTTTTTTTTTTTTTCTTATM', 'MTTTTTTTTTTTATTTTTTTTTATTTTTTTATTTTCTTTM', 'MTMTTTMTTTTTMTTTMTTTTMTTTTMMMMMMMMMMMMMM', 'MTTTTTTTTTTTTCTTMTTTMTTTMTTTMCTMTTMTMTTM'),
(15, 'MTTCTTTTTTTTTTTTDTTTTTTTTTTTTTTTTTTTTTTM', 'MTTTCTMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM', 'MTTTTTMMMMMMMMMMMMMMMMMMMMMMMCMMMMMMMMMM', 'MTMTTTMTMMMMMTTTMTCTTMTTTTTTTTTTTTTTTTTM', 'MTTTTTTTTCTCTCTTMTTTMTTTMTTTMTTMTTMTMTTM'),
(16, 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMTTM', 'MTCTTTTTTTTTCTTTTTTTTTTTATTTCCTTTTTTTTEM', 'MTATTTTTTTTTTTTTTTCCTTTTTCTTTCDDTTTTTATM', 'MTMDTTMTTTTTMTDTMCTCTMTTTTTTTTTDTTTTTTTM', 'MDTTTDTTTTTTTCTTMCCTMTTTMTTTMTTMTTMTMTTM'),
(17, 'MCTCTTTTCCTTCTTTTCCCTTTTTTTTTCDCTTTCTTTM', 'MTTTTTTTTTTTTTTTCTTTTTTTCTTTTTTTTTTCTTTM', 'MTTTTTTTTTTCTTTTTTCDTTTTTTTTTCCDCTATCATM', 'MTMTTTMTTTTTMTTTTTTTTMTTTTTTTTTTTTTTTTTM', 'MTTTTTTTTTTTTTCTMTTTMTTTMTTTMTTMTTMTTTTM'),
(18, 'MTTCTTTTTCTTDTTTTTTTTTTTTTTTTCCCTTTTCTTM', 'MTTTTTTTTCTTATTATTTTTCTTCTTTTTTTTTTTCTTM', 'MTTTCCTTATCDTTTCTTTTTTTTTTTTTCCCCTTTATTM', 'MTMTTTMTTTTTMTTTTTTTTMTTTTTTTTTTTTTTTTTM', 'MMMMMMMMMMMMMMMTMTTTMTTTMTTTMTTTTTMTTTTM'),
(19, 'METTTTTTTTTTTTTTTTTTTTTTTTTCTCTTTTTTTTTM', 'MTTTTAATTTTTATTTTCTTTTTTCTTTTTTCTCCATTTM', 'MATTCDCTTTTTTTTTTTTTTTTTTTTTTCTTTTTAATEM', 'MTMTTTMTTTTTMTTTTTTTTMTTTTTTTTTTTTTDTTTM', 'MTTTTTTTTTTTTTTDMTTTMTTTTTTTMTTTTTMTTTTM'),
(20, 'MTTTTTTTTTTTTTTTTTCTCTTTTTTCCCTTTTTDTTTM', 'MTTTTAATTTTTATTTTTTTTCTTCTTTTTTTTTTTTTTM', 'MTTTCCCTTTTTCTTTCTTTTCTCCTTTTCTTTTCTATTM', 'MCTTTTMTTTTTMTTTTTTTTMTTTTTTTTTTTTTTTTTM', 'MTTTTTTTTTTTTTTTMTTTMTTTTTTTMTTTTTMTTTTM'),
(21, 'MTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTM', 'MTTTTTTTCTTTTTTTTTTTTTTTCTTTTTTTTCATTTTM', 'MTTTCCTTTTTTTTTTTTTTTTTCDTTTTTTTATTTATTM', 'MDTTTTMTTTTTTTTTTTTTTMTTTTTTTTTTTTTTTTEM', 'MTTTTTTTTTTTTTTTTTTTMTTTTTTTMTTTTTMTTTEM'),
(22, 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM', 'MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
