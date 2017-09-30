-- phpMyAdmin SQL Dump
-- version 4.4.15.10
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 24, 2017 at 08:43 PM
-- Server version: 5.7.18
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `cscie57`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `isbn` varchar(10) COLLATE utf8_bin NOT NULL,
  `title` varchar(500) COLLATE utf8_bin NOT NULL,
  `price` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
ADD PRIMARY KEY (`id`),
ADD UNIQUE KEY `book_isbn_UQ` (`isbn`) USING BTREE COMMENT 'Book ISBNs are expected to be unique.',
ADD KEY `category_id` (`category_id`) USING BTREE COMMENT 'The foreign key reference to this books parent category.';

--
-- Indexes for table `category`
--
ALTER TABLE `category`
ADD PRIMARY KEY (`id`),
ADD UNIQUE KEY `category_name_UQ` (`name`) USING BTREE COMMENT 'Category names must be unique.';

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
ADD CONSTRAINT `category_category_id__book_category_id_FK` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
