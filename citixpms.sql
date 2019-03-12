-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 02, 2018 at 08:56 PM
-- Server version: 5.6.34-log
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `citixpms`
--
CREATE DATABASE IF NOT EXISTS `citixpms` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `citixpms`;

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `user_ID` smallint(6) NOT NULL,
  `admin_FName` varchar(50) NOT NULL,
  `admin_LName` varchar(50) NOT NULL,
  `admin_DoB` date NOT NULL,
  `admin_Address` varchar(50) DEFAULT NULL,
  `admin_Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`user_ID`, `admin_FName`, `admin_LName`, `admin_DoB`, `admin_Address`, `admin_Email`) VALUES
(1, 'Katleho', 'Mofokeng', '2008-10-08', '53942 Turflaagte 2 Bloemfontein 9373', '3879462@myuwc.ac.za');

-- --------------------------------------------------------

--
-- Table structure for table `document`
--

CREATE TABLE `document` (
  `doc_ID` smallint(6) NOT NULL,
  `doc_Name` varchar(50) NOT NULL,
  `doc_Type` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document`
--

INSERT INTO `document` (`doc_ID`, `doc_Name`, `doc_Type`) VALUES
(1, 'CiTix Programme Management System UML Diagram', 'jpg'),
(2, 'CiTix PMS Database ERD', 'png'),
(3, 'PGDip-Swd-2018_ProSpec_Matjele_3879462', 'pdf');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `user_ID` smallint(6) NOT NULL,
  `user_Name` varchar(50) NOT NULL,
  `user_Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`user_ID`, `user_Name`, `user_Password`) VALUES
(1, 'matjele7', 'matjele7@gmail.com'),
(2, '3879462', '3879462@myuwc.ac.za'),
(2, 'kgmofokeng', 'kgmofokeng@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `programme`
--

CREATE TABLE `programme` (
  `prog_ID` varchar(20) NOT NULL,
  `prog_Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `programme`
--

INSERT INTO `programme` (`prog_ID`, `prog_Name`) VALUES
('ICT', 'Information and Communication Technology'),
('PGDip_SWD', 'Postgraduate Diploma in Software Development');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `user_ID` smallint(6) NOT NULL,
  `prog_ID` varchar(20) NOT NULL,
  `std_FName` varchar(50) NOT NULL,
  `std_LName` varchar(50) NOT NULL,
  `std_DoB` date NOT NULL,
  `std_Email` varchar(50) NOT NULL,
  `std_Adrress` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`user_ID`, `prog_ID`, `std_FName`, `std_LName`, `std_DoB`, `std_Email`, `std_Adrress`) VALUES
(2, 'PGDip_SWD', 'Teboho Alfred', 'Matjele', '1988-08-22', 'matjele7@gmail.com', '48 Edison Drive Belhar Ex 23 Cape Town');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_ID` smallint(6) NOT NULL,
  `user_Type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_ID`, `user_Type`) VALUES
(1, 'Administartor'),
(2, 'Student');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`user_ID`);

--
-- Indexes for table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`doc_ID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD KEY `user_ID` (`user_ID`);

--
-- Indexes for table `programme`
--
ALTER TABLE `programme`
  ADD PRIMARY KEY (`prog_ID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`user_ID`),
  ADD KEY `prog_ID` (`prog_ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `document`
--
ALTER TABLE `document`
  MODIFY `doc_ID` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_ID` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`user_ID`) REFERENCES `user` (`user_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`user_ID`) REFERENCES `user` (`user_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`user_ID`) REFERENCES `user` (`user_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`prog_ID`) REFERENCES `programme` (`prog_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
