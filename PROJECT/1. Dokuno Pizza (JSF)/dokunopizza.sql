-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 14, 2019 at 02:46 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dokunopizza`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `id_admin` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`id_admin`, `username`, `password`) VALUES
(1, 'muhamaddanisetiawan', 'azura042');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_product`
--

CREATE TABLE `tbl_product` (
  `id_pizza` int(20) NOT NULL,
  `pizza_name` varchar(200) NOT NULL,
  `stock` int(200) NOT NULL,
  `price` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_product`
--

INSERT INTO `tbl_product` (`id_pizza`, `pizza_name`, `stock`, `price`) VALUES
(1, 'Veggie Lovers', 619, 20000),
(2, 'Cheese Mania', 500, 10000),
(3, 'Extravaganza', 500, 30000),
(4, 'Meatzza', 500, 60000);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_subcriber`
--

CREATE TABLE `tbl_subcriber` (
  `id_subcriber` int(11) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone_number` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_subcriber`
--

INSERT INTO `tbl_subcriber` (`id_subcriber`, `email`, `phone_number`) VALUES
(1, 'muhamaddanisetiawan@gmail.com', '086676655'),
(2, 'danikeceabis@gmaisda.com', '898989898'),
(3, 'hanasoke@gmail.com', '0865876654'),
(4, 'danisetiawan@gmail.com', '0865876654'),
(5, 'hanas2@gmail.com', '28728372'),
(6, 'hanasdani@gmail.com', '99898988');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transaction`
--

CREATE TABLE `tbl_transaction` (
  `id_transaction` int(10) NOT NULL,
  `id_user` int(8) NOT NULL,
  `id_pizza_product` int(8) NOT NULL,
  `name` varchar(200) NOT NULL,
  `pizza_name` varchar(200) NOT NULL,
  `price` int(200) NOT NULL,
  `qty` int(50) NOT NULL,
  `total_price` int(200) NOT NULL,
  `address` varchar(200) NOT NULL,
  `date_of_purchase` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_transaction`
--

INSERT INTO `tbl_transaction` (`id_transaction`, `id_user`, `id_pizza_product`, `name`, `pizza_name`, `price`, `qty`, `total_price`, `address`, `date_of_purchase`) VALUES
(15, 21321, 6, 'asdasd', 'asdasd', 2, 10, 2323, 'sadasd', '2020-19-10'),
(16, 10, 6, 'asd', 'asdas', 0, 0, 0, 'asdasd', '2020-10-10'),
(17, 10, 6, 'asd', 'asdas', 0, 0, 0, 'asdasd', '2020-10-10'),
(18, 6, 6, 'da', 'asdas', 22, 2, 2222, 'asdsad', '222'),
(19, 655, 1, 'Muhamad Dani Setiawan', 'Veggie Lover\'s', 20000, 2, 40000, 'hvhvgh', '2020/10/10'),
(20, 655, 1, 'Muhamad Dani Setiawan', 'Veggie Lover\'s', 20000, 2, 40000, 'hvhvgh', '2020/10/10'),
(21, 655, 1, 'Muhamad Dani Setiawan', 'Veggie Lover\'s', 20000, 2, 40000, 'hvhvgh', '2020/10/10'),
(22, 655, 1, 'Muhamad Dani Setiawan', 'Veggie Lover\'s', 20000, 2, 40000, 'hvhvgh', '2020/10/10'),
(23, 655, 1, 'Muhamad Dani Setiawan', 'Veggie Lover\'s', 20000, 2, 40000, 'hvhvgh', '2020/10/10'),
(24, 655, 1, 'Muhamad Dani Setiawan', 'Veggie Lovers', 20000, 2, 40000, 'hvhvgh', '2020/10/10'),
(25, 655, 1, 'Muhamad Dani Setiawan', 'Veggie Lovers', 20000, 2, 40000, 'hvhvgh', '2020/10/10'),
(26, 655, 1, 'Muhamad Dani Setiawan', 'Veggie Lovers', 20000, 2, 40000, 'hvhvgh', '2020/10/10'),
(27, 655, 1, 'Muhamad Dani Setiawan', 'Veggie Lovers', 20000, 2, 40000, 'hvhvgh', '2020/10/10'),
(28, 655, 1, 'MuhamadDan Setiawan', 'Veggie Lovers', 20000, 2, 40000, 'hvhvgh', '2020/10/10'),
(29, 655, 1, 'MuhamadDan Setiawan', 'Veggie Lovers', 20000, 2, 40000, 'hvhvgh', '2020/10/10'),
(30, 655, 1, 'MuhamadDan Setiawan', 'Veggie Lovers', 20000, 2, 40000, 'hvhvgh', '2020/10/10'),
(31, 655, 1, 'MuhamadDan Setiawan', 'Veggie Lovers', 20000, 2, 40000, 'hvhvgh', '2020/10/10'),
(32, 123, 1, 'Dani', 'Veggie Lovers', 0, 0, 0, 'depok', '2020/10/10'),
(33, 123, 1, 'Hanas', 'Veggie Lovers', 20000, 5, 100000, 'ssadsa', '10/10/2019'),
(34, 123, 1, 'Hanas', 'Veggie Lovers', 20000, 5, 100000, 'depok', '10/10/2019'),
(35, 5, 1, 'Hanas', 'Veggie Lovers', 20000, 10, 200000, 'depok', '10/10/2019'),
(36, 0, 1, 'MuhamadDani', 'Veggie Lover', 20000, 5, 100000, 'depok', '8/10/2019'),
(37, 0, 1, 'MuhamadDani', 'Veggie Lover', 20000, 10, 200000, 'depok', '8/10/2019'),
(38, 0, 1, 'MuhamadDani', 'Veggie Lover', 20000, 10, 200000, 'depok', '8/10/2019'),
(39, 0, 1, 'hanasdani', 'Veggie Lover', 20000, 10, 200000, 'depok', '8/10/2019');

--
-- Triggers `tbl_transaction`
--
DELIMITER $$
CREATE TRIGGER `pizza_transaction` AFTER INSERT ON `tbl_transaction` FOR EACH ROW BEGIN
UPDATE tbl_product SET stock=stock-NEW.qty
WHERE id_pizza = NEW.id_pizza_product;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id_user` int(10) NOT NULL,
  `firstname` varchar(200) NOT NULL,
  `lastname` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone_number` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id_user`, `firstname`, `lastname`, `email`, `password`, `address`, `phone_number`) VALUES
(5, 'Dani', 'Setiawan', 'muhamaddanisetiawan@gmail.com', 'azura042', 'Bogor', '085693553084'),
(7, 'hanas', 'dani', 'hanasdani@gmail.com', '123456', 'depok', '08877655477'),
(8, 'dani', 'setiawan', 'danisetiawan@gmail.com', 'azura042', 'depok', '08877655477'),
(10, 'hanas', 'dani', 'hanasdani@gmail.com', 'azura042', 'depok', '98989898'),
(11, 'hanas', 'dani', 'hanasdani@gmail.com', 'azura042', 'depok', '98989898'),
(12, 'muhamaddanisetiawan', 'dani', 'danisetiawanid@gmail.com', '123456', 'depok', '898989898'),
(13, 'dani', 'hanas', 'danihanas@gmail.com', '123456', 'depok', '989889'),
(14, 'dani', 'hanas', 'danihanas@gmail.com', 'azura042', 'depok', '08877655477');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `tbl_product`
--
ALTER TABLE `tbl_product`
  ADD PRIMARY KEY (`id_pizza`);

--
-- Indexes for table `tbl_subcriber`
--
ALTER TABLE `tbl_subcriber`
  ADD PRIMARY KEY (`id_subcriber`);

--
-- Indexes for table `tbl_transaction`
--
ALTER TABLE `tbl_transaction`
  ADD PRIMARY KEY (`id_transaction`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_product`
--
ALTER TABLE `tbl_product`
  MODIFY `id_pizza` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tbl_subcriber`
--
ALTER TABLE `tbl_subcriber`
  MODIFY `id_subcriber` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_transaction`
--
ALTER TABLE `tbl_transaction`
  MODIFY `id_transaction` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
