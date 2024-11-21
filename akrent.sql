-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2024 at 04:41 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `akrent`
--

-- --------------------------------------------------------

--
-- Table structure for table `jaminan`
--

CREATE TABLE `jaminan` (
  `id_jaminan` int(4) NOT NULL,
  `jenis_jaminan` varchar(50) NOT NULL,
  `unit` int(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jaminan`
--

INSERT INTO `jaminan` (`id_jaminan`, `jenis_jaminan`, `unit`) VALUES
(1, 'KTP', 1),
(2, 'Cash', 1500000),
(3, 'Motor', 1),
(5, 'Motor', 3);

-- --------------------------------------------------------

--
-- Table structure for table `mobil`
--

CREATE TABLE `mobil` (
  `id_mobil` int(4) NOT NULL,
  `jenis_mobil` varchar(50) NOT NULL,
  `no_polisi` varchar(50) NOT NULL,
  `tahun` int(4) NOT NULL,
  `warna` varchar(50) NOT NULL,
  `harga` int(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mobil`
--

INSERT INTO `mobil` (`id_mobil`, `jenis_mobil`, `no_polisi`, `tahun`, `warna`, `harga`) VALUES
(1, 'Avanza', 'DD 2302 XY', 2017, 'Abu Abu', 220000),
(2, 'Honda', 'DD 2313 WQ', 2019, 'Silver', 330000),
(3, 'Xpander', 'DD 9326 QA', 2020, 'Silver', 340000),
(4, 'Panther', 'DD 4574 PQ', 2012, 'Coklat', 120000),
(5, 'Kijang', 'DD 3201 SA', 2010, 'Hitam', 120000),
(6, 'Avanza Veloz', 'DD 4821 QA', 2020, 'Silver', 350000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jaminan`
--
ALTER TABLE `jaminan`
  ADD PRIMARY KEY (`id_jaminan`);

--
-- Indexes for table `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`id_mobil`),
  ADD UNIQUE KEY `no_polisi` (`no_polisi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jaminan`
--
ALTER TABLE `jaminan`
  MODIFY `id_jaminan` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `mobil`
--
ALTER TABLE `mobil`
  MODIFY `id_mobil` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
