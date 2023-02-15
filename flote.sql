-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 15 fév. 2023 à 14:33
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `flote`
--

-- --------------------------------------------------------

--
-- Structure de la table `affectation`
--

CREATE TABLE `affectation` (
  `id` bigint(20) NOT NULL,
  `agent` bigint(20) DEFAULT NULL,
  `vehicule` bigint(20) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libele` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `depense`
--

CREATE TABLE `depense` (
  `id` bigint(20) NOT NULL,
  `date_depense` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `type_depense` varchar(255) DEFAULT NULL,
  `kilometrage` double NOT NULL,
  `agent_id` bigint(20) DEFAULT NULL,
  `vehicule_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(6);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` bigint(20) NOT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `poste` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `matricule` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `age`, `email`, `nom`, `prenom`, `role`, `sexe`, `password`, `address`, `poste`, `telephone`, `etat`, `adresse`, `matricule`, `ville`) VALUES
(1, 0, 'admin@gmail.com', NULL, NULL, 'Admin', 'MASCULIN', '$2a$10$uo84dsEM4YFdWhKO9.taFuVFVKUX3VnKWKHwXpPiZ.aO1jvWux9Tm', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 0, 'chahid@gmail.com', 'charifa', 'chahid', 'Agent', 'FEMININ', '$2a$10$PMap/jUOWSnzYmneuSUeaePPRIEWxFfbtF.xV6blMH01T476H.kCS', 'yaounde', 'agent', '670721353', 'Inactive', NULL, NULL, NULL),
(3, 0, 'hassan@gmail.com', 'fouapon', 'hassan', 'Agent', 'MASCULIN', '$2a$10$521fBdXmu48lv7fhPE0Z9eehDRGI76qvR0.SpZHcN0JXA4fGyHY9.', 'yaounde', 'informaticien', '698227743', NULL, NULL, NULL, NULL),
(4, 0, 'charifa@gmail.com', 'Riape', 'Charifa', 'Agent', 'FEMININ', '$2a$10$0ilU1hWlgdcD9Vlqux4XhuknPeG.3ncxyfVhnY.h0JZDKNfOpl5B6', 'yaounde', 'agent', '698227743', 'Inactive', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `id` bigint(20) NOT NULL,
  `date_acquisition` datetime DEFAULT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `immatriculation` varchar(255) DEFAULT NULL,
  `kilometrage` double NOT NULL,
  `categorieid` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `energie` varchar(255) DEFAULT NULL,
  `marque` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `affectation`
--
ALTER TABLE `affectation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrkn3d8tcykpdpc4g3crvs546y` (`agent`),
  ADD KEY `FKpbr8xpewt0ttlqruo010962yk` (`vehicule`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `depense`
--
ALTER TABLE `depense`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmdu1fsox80n2l7n89qlc883cm` (`agent_id`),
  ADD KEY `FK90uey7yi36a1nqr59q9vxlb94` (`vehicule_id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK84joksnx2jhuyb4ab9mn8q0w5` (`categorieid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
