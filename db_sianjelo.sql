-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 18, 2023 at 06:56 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_sianjelo`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_detail_transaksi`
--

CREATE TABLE `tb_detail_transaksi` (
                                       `id_detail` int(11) NOT NULL,
                                       `id_paket` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_detail_transaksi`
--

INSERT INTO `tb_detail_transaksi` (`id_detail`, `id_paket`) VALUES
                                                                (1, 1),
                                                                (1, 28),
                                                                (2, 4),
                                                                (3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tb_member`
--

CREATE TABLE `tb_member` (
                             `id` int(11) NOT NULL,
                             `nama_member` varchar(100) NOT NULL,
                             `alamat_member` text NOT NULL,
                             `no_telp` varchar(15) NOT NULL,
                             `point` int(11) NOT NULL DEFAULT 0,
                             `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_member`
--

INSERT INTO `tb_member` (`id`, `nama_member`, `alamat_member`, `no_telp`, `point`, `created_at`) VALUES
                                                                                                     (1, 'Lintang Intan Handayani S.Pt', 'Gg. Pattimura No. 484, Magelang 11615, BaBel', '082223127698', 1001, '2023-01-18 11:59:54'),
                                                                                                     (2, 'Jasmani Nugroho', 'Dk. Sutoyo No. 10, Binjai 75064, KepR', '082256349900', 2, '2023-01-18 12:00:43'),
                                                                                                     (3, 'Daniswara Uda Wasita S.H.', 'Ds. Wahid No. 364, Serang 44951, Papua', '082223127698', 1, '2023-01-18 12:01:46'),
                                                                                                     (4, 'Wani Prastuti', 'Dk. Casablanca No. 982, Banjarbaru 92972, KepR', '082223127698', 1, '2023-01-18 12:02:07'),
                                                                                                     (5, 'Risfan Herlaya', 'jalan sana sini', '082256349900', 1001, '2023-01-18 12:06:14'),
                                                                                                     (6, 'Airlangga', 'san', '085742676176', 1001, '2023-01-18 12:12:37');

-- --------------------------------------------------------

--
-- Table structure for table `tb_paket`
--

CREATE TABLE `tb_paket` (
                            `id_paket` int(11) NOT NULL,
                            `nama_paket` text NOT NULL,
                            `jenis_paket` text NOT NULL,
                            `harga_paket` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_paket`
--

INSERT INTO `tb_paket` (`id_paket`, `nama_paket`, `jenis_paket`, `harga_paket`) VALUES
                                                                                    (1, 'Cuci Komplit Reguler', 'Kiloan', 6000),
                                                                                    (2, 'Cuci Komplit Express', 'Kiloan', 10000),
                                                                                    (3, 'Cuci + Kering', 'Kiloan', 7000),
                                                                                    (4, 'Setrika Reguler', 'Kiloan', 7000),
                                                                                    (5, 'Setrika Express', 'Kiloan', 10000),
                                                                                    (6, 'Cuci + Setrika Reguler', 'Kiloan', 7500),
                                                                                    (7, 'Cuci + Setrika Express', 'Kiloan', 14000),
                                                                                    (8, 'Cuci + Setrika Full Express', 'Kiloan', 20000),
                                                                                    (9, 'Jas Kecil', 'Satuan', 20000),
                                                                                    (10, 'Jas Biasa', 'Satuan', 15000),
                                                                                    (11, 'Gaun', 'Satuan', 50000),
                                                                                    (12, 'Kemeja', 'Satuan', 24000),
                                                                                    (13, 'Sepatu', 'Satuan', 30000),
                                                                                    (14, 'Jeans', 'Satuan', 32000),
                                                                                    (15, 'Jaket', 'Satuan', 21000),
                                                                                    (16, 'Sweater', 'Satuan', 15000),
                                                                                    (17, 'Piyama', 'Satuan', 12000),
                                                                                    (18, 'Sprei Kecil', 'Satuan', 12000),
                                                                                    (19, 'Sprei Sedang', 'Satuan', 16000),
                                                                                    (20, 'Sprei Besar', 'Satuan', 30000),
                                                                                    (21, 'Gordyn', 'Satuan', 15000),
                                                                                    (22, 'Karpet Kecil', 'Satuan', 17000),
                                                                                    (23, 'Karpet Besar', 'Satuan', 250000),
                                                                                    (24, 'Selimut Kecil', 'Satuan', 21000),
                                                                                    (25, 'Selimut Sedang', 'Satuan', 27000),
                                                                                    (26, 'Selimut Besar', 'Satuan', 32000),
                                                                                    (27, 'Bantal', 'Satuan', 12000),
                                                                                    (28, 'Handuk', 'Satuan', 10000),
                                                                                    (29, 'Jubah', 'Satuan', 12000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_setting`
--

CREATE TABLE `tb_setting` (
                              `id` int(11) NOT NULL,
                              `active_send_whatsapp` tinyint(1) NOT NULL,
                              `api_endpoint` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_setting`
--

INSERT INTO `tb_setting` (`id`, `active_send_whatsapp`, `api_endpoint`) VALUES
    (1, 1, 'http://localhost:5000/api/send');

-- --------------------------------------------------------

--
-- Table structure for table `tb_transaksi`
--

CREATE TABLE `tb_transaksi` (
                                `id` int(11) NOT NULL,
                                `id_member` int(11) NOT NULL,
                                `id_user` int(11) NOT NULL,
                                `tgl_transaksi` datetime NOT NULL DEFAULT current_timestamp(),
                                `status_proses` enum('Selesai','Pengerjaan','Antar','Jemput') NOT NULL,
                                `status_transaksi` enum('Dibayar','Belum Bayar') NOT NULL,
                                `total_pembayaran` int(11) NOT NULL,
                                `jumlah_pembayaran` int(11) NOT NULL,
                                `kembalian` int(11) NOT NULL,
                                `id_detail` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_transaksi`
--

INSERT INTO `tb_transaksi` (`id`, `id_member`, `id_user`, `tgl_transaksi`, `status_proses`, `status_transaksi`, `total_pembayaran`, `jumlah_pembayaran`, `kembalian`, `id_detail`) VALUES
                                                                                                                                                                                       (1, 1, 1, '2023-01-18 12:02:58', 'Selesai', 'Belum Bayar', 32000, 32000, 0, 1),
                                                                                                                                                                                       (2, 5, 1, '2023-01-18 12:06:34', 'Selesai', 'Belum Bayar', 21000, 22000, 1000, 2),
                                                                                                                                                                                       (3, 6, 1, '2023-01-18 12:12:53', 'Pengerjaan', 'Belum Bayar', 14000, 15000, 1000, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
                           `id` int(11) NOT NULL,
                           `username` varchar(60) NOT NULL,
                           `password` varchar(60) NOT NULL,
                           `full_name` varchar(100) NOT NULL,
                           `role` enum('admin','karyawan','kurir','') NOT NULL,
                           `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id`, `username`, `password`, `full_name`, `role`, `created_at`) VALUES
                                                                                            (1, 'sandroputraa', 'sandro123abc', 'Martinus Krisandro Perdana Putra', 'admin', '2023-01-18 11:40:44'),
                                                                                            (2, 'angga', 'angga', 'Airlangga Maulana Anwar', 'karyawan', '2023-01-18 12:48:28');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_detail_transaksi`
--
ALTER TABLE `tb_detail_transaksi`
    ADD KEY `id_detail` (`id_detail`),
  ADD KEY `id_paket` (`id_paket`);

--
-- Indexes for table `tb_member`
--
ALTER TABLE `tb_member`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_paket`
--
ALTER TABLE `tb_paket`
    ADD PRIMARY KEY (`id_paket`);

--
-- Indexes for table `tb_setting`
--
ALTER TABLE `tb_setting`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
    ADD PRIMARY KEY (`id`),
  ADD KEY `id_member` (`id_member`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `tb_transaksi_ibfk_4` (`id_detail`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_member`
--
ALTER TABLE `tb_member`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tb_paket`
--
ALTER TABLE `tb_paket`
    MODIFY `id_paket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `tb_setting`
--
ALTER TABLE `tb_setting`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_detail_transaksi`
--
ALTER TABLE `tb_detail_transaksi`
    ADD CONSTRAINT `tb_detail_transaksi_ibfk_1` FOREIGN KEY (`id_detail`) REFERENCES `tb_transaksi` (`id_detail`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_detail_transaksi_ibfk_2` FOREIGN KEY (`id_paket`) REFERENCES `tb_paket` (`id_paket`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
    ADD CONSTRAINT `tb_transaksi_ibfk_1` FOREIGN KEY (`id_member`) REFERENCES `tb_member` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tb_transaksi_ibfk_3` FOREIGN KEY (`id_user`) REFERENCES `tb_user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
