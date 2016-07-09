-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 09, 2016 at 03:24 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `samridhi`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `A_id` bigint(20) NOT NULL,
  `a_date` date NOT NULL,
  `present` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`A_id`, `a_date`, `present`) VALUES
(1, '2016-07-10', 1),
(2, '0000-00-00', 0),
(2, '2016-07-11', 1),
(3, '2016-07-12', 1),
(4, '2016-07-12', 0),
(5, '2016-07-11', 1);

-- --------------------------------------------------------

--
-- Table structure for table `bridge`
--

CREATE TABLE `bridge` (
  `Bid` bigint(20) NOT NULL,
  `Maths` int(11) NOT NULL,
  `Science` int(11) NOT NULL,
  `English` int(11) NOT NULL,
  `Social` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bridge`
--

INSERT INTO `bridge` (`Bid`, `Maths`, `Science`, `English`, `Social`) VALUES
(1, 90, 75, 80, 85),
(2, 95, 90, 96, 98),
(3, 100, 95, 80, 85);

-- --------------------------------------------------------

--
-- Table structure for table `mainstream`
--

CREATE TABLE `mainstream` (
  `M_id` bigint(20) NOT NULL,
  `School` varchar(40) NOT NULL,
  `Class` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mainstream`
--

INSERT INTO `mainstream` (`M_id`, `School`, `Class`) VALUES
(4, 'St. marys', 5),
(5, 'New angels english school', 8);

-- --------------------------------------------------------

--
-- Table structure for table `relocation`
--

CREATE TABLE `relocation` (
  `reloc_id` bigint(20) NOT NULL,
  `studying` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `relocation`
--

INSERT INTO `relocation` (`reloc_id`, `studying`) VALUES
(1, 5),
(5, 4);

-- --------------------------------------------------------

--
-- Table structure for table `siblings`
--

CREATE TABLE `siblings` (
  `sib_id` bigint(20) NOT NULL,
  `sib_name` varchar(40) NOT NULL,
  `sib_age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siblings`
--

INSERT INTO `siblings` (`sib_id`, `sib_name`, `sib_age`) VALUES
(1, 'teju', 4),
(3, 'harsha', 5),
(5, 'varun', 9);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `stud_id` bigint(20) NOT NULL,
  `stud_name` varchar(50) NOT NULL,
  `stud_age` int(11) NOT NULL,
  `gender` varchar(15) NOT NULL,
  `Parents_name` varchar(50) NOT NULL,
  `Phone` bigint(20) NOT NULL,
  `Siblings` tinyint(1) NOT NULL,
  `Language` varchar(20) NOT NULL,
  `Been_to_school` tinyint(1) NOT NULL,
  `Location` varchar(40) NOT NULL,
  `Native` varchar(40) NOT NULL,
  `Photo` varchar(250) NOT NULL,
  `Par_Occupation` varchar(30) NOT NULL,
  `Par_Income` bigint(20) NOT NULL,
  `Relocation` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`stud_id`, `stud_name`, `stud_age`, `gender`, `Parents_name`, `Phone`, `Siblings`, `Language`, `Been_to_school`, `Location`, `Native`, `Photo`, `Par_Occupation`, `Par_Income`, `Relocation`) VALUES
(1, 'abc', 7, 'male', 'cba', 9523641245, 1, 'tamil', 0, 'bengaluru', 'bengaluru', '', 'carpenter', 10000, 1),
(2, 'def', 9, 'female', 'fed', 9541236587, 0, 'telugu', 1, 'vijaywada', 'vijaywada', '', 'craftsman', 15000, 0),
(3, 'ghi', 11, 'male', 'ihg', 9545241245, 1, 'urdu', 1, 'delhi', 'bengaluru', '', 'farmer', 11000, 0),
(4, 'SAITEJ', 16, 'male', 'HAJI', 9632587456, 0, 'KANNADA', 0, 'MUMBAI', 'mysore', '', 'farmer', 10000, 0),
(5, 'saipriya', 15, 'female', 'gangadhar', 9523641277, 1, 'telugu', 1, 'hyderabad', 'malakpet', '', 'farmer', 1000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(8) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`stud_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `stud_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
