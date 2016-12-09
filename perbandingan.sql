-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 08 Des 2016 pada 10.38
-- Versi Server: 10.1.10-MariaDB
-- PHP Version: 7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perbandingan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `file`
--

CREATE TABLE `file` (
  `id_file` int(11) NOT NULL,
  `nama_file1` varchar(50) NOT NULL,
  `nama_file2` varchar(50) NOT NULL,
  `k_gram` int(11) NOT NULL,
  `bil_prima` int(11) NOT NULL,
  `window` int(11) NOT NULL,
  `waktu1` double NOT NULL,
  `waktu2` double NOT NULL,
  `similarity1` double NOT NULL,
  `similarity2` double NOT NULL,
  `tgl_submit` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `file`
--

INSERT INTO `file` (`id_file`, `nama_file1`, `nama_file2`, `k_gram`, `bil_prima`, `window`, `waktu1`, `waktu2`, `similarity1`, `similarity2`, `tgl_submit`) VALUES
(2, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 7, 2, 4, 613687137, 515112047, 40.54054054054054, 75, '2016-11-24'),
(3, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 4, 5, 4, 1947544017, 1802659050, 37.5, 20, '2016-11-24'),
(4, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 5, 3, 4, 1114709635, 967846827, 34.375, 66.66666666666666, '2016-11-24'),
(5, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 5, 5, 4, 557068022, 491861296, 33.33333333333333, 20, '2016-11-24'),
(6, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 8, 2, 4, 2333964668, 2093274186, 38.88888888888889, 75, '2016-11-24');

-- --------------------------------------------------------

--
-- Struktur dari tabel `hasil`
--

CREATE TABLE `hasil` (
  `id_file` int(11) NOT NULL,
  `nama_file1` varchar(50) NOT NULL,
  `nama_file2` varchar(50) NOT NULL,
  `k_gram` int(11) NOT NULL,
  `bil_prima` int(11) NOT NULL,
  `window` int(11) NOT NULL,
  `algoritma` varchar(50) NOT NULL,
  `similarity` double NOT NULL,
  `waktu` double NOT NULL,
  `tgl_tes` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `hasil`
--

INSERT INTO `hasil` (`id_file`, `nama_file1`, `nama_file2`, `k_gram`, `bil_prima`, `window`, `algoritma`, `similarity`, `waktu`, `tgl_tes`) VALUES
(1, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 4, 3, 4, 'Winnowing', 41.38, 0.16, '2016-12-05'),
(2, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 4, 3, 4, 'Winnowing', 41.38, 0.42, '2016-12-05'),
(3, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 4, 3, 4, 'Winnowing', 41.38, 0.33, '2016-12-05'),
(4, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 4, 3, 4, 'Winnowing', 41.38, 0.15, '2016-12-05'),
(5, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 4, 3, 4, 'Winnowing', 41.38, 0.31, '2016-12-05'),
(6, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 4, 3, 4, 'Winnowing', 41.38, 0.27, '2016-12-05'),
(7, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 0, 3, 4, 'Biword Winnowing', 66.67, 0.21, '2016-12-05'),
(8, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 0, 3, 4, 'Biword Winnowing', 66.67, 0.09, '2016-12-05'),
(9, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 0, 3, 4, 'Biword Winnowing', 66.67, 0.24, '2016-12-05'),
(10, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 0, 3, 4, 'Biword Winnowing', 66.67, 0.24, '2016-12-05'),
(11, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 0, 3, 4, 'Biword Winnowing', 66.67, 0.23, '2016-12-05'),
(12, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 0, 3, 4, 'Biword Winnowing', 66.67, 0.04, '2016-12-05'),
(13, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 0, 3, 4, 'Biword Winnowing', 66.67, 0.06, '2016-12-05'),
(14, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 0, 3, 4, 'Biword Winnowing', 66.67, 0.18, '2016-12-05'),
(15, 'C:\\Users\\Idrus\\Documents\\data_uji1.pdf', 'C:\\Users\\Idrus\\Documents\\data_uji2.pdf', 0, 3, 4, 'Biword Winnowing', 66.67, 0.24, '2016-12-05');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `file`
--
ALTER TABLE `file`
  ADD PRIMARY KEY (`id_file`);

--
-- Indexes for table `hasil`
--
ALTER TABLE `hasil`
  ADD PRIMARY KEY (`id_file`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `file`
--
ALTER TABLE `file`
  MODIFY `id_file` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `hasil`
--
ALTER TABLE `hasil`
  MODIFY `id_file` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
