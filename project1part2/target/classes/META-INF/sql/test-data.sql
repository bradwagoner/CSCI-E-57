-- phpMyAdmin SQL Dump
-- version 4.4.15.10
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 24, 2017 at 08:45 PM
-- Server version: 5.7.18
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `cscie57`
--

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(2, 'Drama'),
(1, 'Romance');

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `category_id`, `isbn`, `title`, `price`) VALUES
(1, 1, 'R111111111', 'Romance 1', '11.11'),
(2, 1, 'R222222222', 'Romance 2', '2.22'),
(3, 1, 'R333333333', 'Romance 3', '3.33'),
(4, 1, 'R444444444', 'Romance 4', '44.44'),
(5, 2, 'D111111111', 'Drama 1', '1.11');