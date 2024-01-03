-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2023 at 04:43 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `textile`
--

-- --------------------------------------------------------

--
-- Table structure for table `addressmaster`
--

CREATE TABLE `addressmaster` (
  `addId` int(100) NOT NULL,
  `user_email` varchar(250) NOT NULL,
  `address` varchar(250) NOT NULL,
  `contact_no` varchar(250) NOT NULL,
  `alt_address` varchar(250) NOT NULL,
  `city` varchar(250) NOT NULL,
  `state` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cartId` int(100) NOT NULL,
  `useremail` varchar(250) NOT NULL,
  `prodId` int(100) NOT NULL,
  `meters` int(100) NOT NULL,
  `amount` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`cartId`, `useremail`, `prodId`, `meters`, `amount`) VALUES
(2, 'bhuwan@gmail.com', 5, 78, 29640);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `catId` int(100) NOT NULL,
  `name` varchar(250) NOT NULL,
  `type` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`catId`, `name`, `type`) VALUES
(1, 'Knitted Fabrics', 'Plain'),
(2, 'Natural Fibers', 'Floral Prints'),
(3, 'Synthetic Fibers', 'Plain'),
(4, 'Blended Fibers', 'Small Print'),
(5, 'Specialty Fabrics', 'Plain'),
(6, 'Woven Fabrics', 'Plain');

-- --------------------------------------------------------

--
-- Table structure for table `getintouch`
--

CREATE TABLE `getintouch` (
  `Id` int(100) NOT NULL,
  `user_email` varchar(250) NOT NULL,
  `name` varchar(250) NOT NULL,
  `message` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `getintouch`
--

INSERT INTO `getintouch` (`Id`, `user_email`, `name`, `message`) VALUES
(2, 'bhagyashree@gmail.com', 'Bhagyashree', 'hi');

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

CREATE TABLE `orderdetails` (
  `odId` int(100) NOT NULL,
  `useremail` varchar(250) NOT NULL,
  `prodId` int(100) NOT NULL,
  `ordermasterId` int(100) NOT NULL,
  `ProdPrice` int(100) NOT NULL,
  `ProdName` varchar(250) NOT NULL,
  `tax` int(100) NOT NULL,
  `meter` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ordermaster`
--

CREATE TABLE `ordermaster` (
  `omId` int(100) NOT NULL,
  `user_email` varchar(250) NOT NULL,
  `order_date` date NOT NULL,
  `order_status` varchar(250) DEFAULT 'Pending',
  `meter` int(100) DEFAULT 50,
  `total_Amt` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ordermaster`
--

INSERT INTO `ordermaster` (`omId`, `user_email`, `order_date`, `order_status`, `meter`, `total_Amt`) VALUES
(1, 'bhagyashree@gmail.com', '2023-12-07', 'Pending', 89, 3009980),
(2, 'rupesh@gmail.com', '2023-12-07', 'Pending', 90, 495000),
(3, 'jainul@gmail.com', '2023-12-07', 'Pending', 670, 134000),
(4, 'bhagyashree@gmail.com', '2023-12-07', 'Pending', 450, 130500),
(5, 'kinal@gmail.com', '2023-12-07', 'Pending', 670, 288100),
(6, 'bhuwan@gmail.com', '2023-12-07', 'Pending', 900, 495000),
(7, 'bhagyashree@gmail.com', '2023-12-07', 'Pending', 789, 299820),
(8, 'dhara@gmail.com', '2023-12-07', 'Pending', 120, 28080),
(9, 'bhagyashree@gmail.com', '2023-12-08', 'Pending', 890, 208260);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payId` int(100) NOT NULL,
  `orderdId` int(100) NOT NULL,
  `useremail` varchar(250) NOT NULL,
  `mode` varchar(250) DEFAULT 'Cash',
  `upiId` int(100) DEFAULT NULL,
  `amount` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `productmaster`
--

CREATE TABLE `productmaster` (
  `prodId` int(100) NOT NULL,
  `name` varchar(250) NOT NULL,
  `catId` int(100) NOT NULL,
  `description` varchar(250) NOT NULL,
  `image` varchar(250) NOT NULL,
  `tax` int(100) NOT NULL DEFAULT 10,
  `colors` varchar(250) NOT NULL,
  `meters` int(100) NOT NULL,
  `price` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `productmaster`
--

INSERT INTO `productmaster` (`prodId`, `name`, `catId`, `description`, `image`, `tax`, `colors`, `meters`, `price`) VALUES
(1, 'Cotton', 2, 'It is commonly used in apparel (t-shirts, dresses), home textiles (bedding, towels), denim, medical textiles, interior furnishings, and industrial applications (tents, canvas).', 'Cotton.jpg', 10, 'White', 1790, 234),
(2, 'Linen-Cotton Blend', 4, 'A fusion of linen\'s natural luster and cotton\'s softness. Ideal for breathable and comfortable apparel like shirts and dresses, as well as home textiles such as curtains and bedding. ', 'Linen-Cotton Blend.png', 12, 'Brown', 2300, 250),
(3, 'Jersey', 1, 'Jersey is a soft, stretchy, and comfortable fabric known for its smooth texture.', 'Jersey.webp', 12, 'Yellow', 4500, 320),
(4, 'Polyester', 3, 'Polyester is a synthetic fabric valued for its durability, wrinkle resistance, and quick-drying properties. Widely used in activewear, outerwear, and home textiles, it offers a versatile and low-maintenance option.', 'Polyester.jpg', 12, 'Green', 3000, 220),
(5, 'Organza', 5, 'Organza is a sheer and lightweight fabric known for its crisp texture and elegant appearance. Often used in formal wear, bridal gowns, and decorative accents, it adds a touch of sophistication and delicacy to various fashion and décor applications.', 'Organza.jpg', 12, 'MultiColor', 2000, 380),
(6, 'Rayon', 3, 'Rayon is a semi-synthetic fabric with a soft, breathable feel resembling natural fibers. Commonly used in clothing, it offers versatility for both casual and formal wear, combining comfort with a smooth drape.', 'Rayon.jpg', 12, 'Lavender', 4560, 190),
(7, 'Chiffon', 5, 'Chiffon is a lightweight, sheer fabric with a delicate drape and subtle texture. Often chosen for elegant eveningwear, dresses, and scarves, it adds a touch of ethereal grace to garments, making it a popular choice for special occasions.', 'Chiffon.jpg', 12, 'OffWhite', 3200, 290),
(8, 'Rib Knit', 1, 'Rib knit is a fabric characterized by vertical textured lines, created by alternating raised and lowered rows of stitches. Commonly used in the creation of stretchy and form-fitting garments like t-shirts, sweaters, and cuffs, rib knit provides flexi', 'RibKnit.jpg', 12, 'Pink', 1900, 550),
(9, 'Wool-Silk Blend', 4, 'A Wool-Silk blend combines the warmth of wool with the luxurious softness and sheen of silk. Ideal for sophisticated and comfortable clothing, this blend is often used in suits, scarves, and other garments, offering a balance of insulation and a touc', 'wool silk blend.jpg', 12, 'Black', 4560, 200),
(10, 'Hemp', 2, 'Hemp is a versatile natural fiber known for its durability, breathability, and eco-friendly properties. Commonly used in textiles, it produces fabrics for clothing, accessories, and home goods, offering a sustainable alternative with a rugged yet com', 'Hemp.jpg', 12, 'light', 3490, 260),
(11, 'Nylon', 3, 'Nylon is a synthetic polymer known for its strength, durability, and resilience. Widely used in the production of activewear, hosiery, and various accessories, nylon offers a lightweight and flexible material with excellent resistance to wear and tea', 'Nylon.jpg', 12, 'Black Crush', 300, 290),
(12, 'Mesh', 1, 'Mesh is a breathable fabric characterized by an open, porous structure. Frequently used in sportswear, activewear, and accessories like bags, it provides ventilation and a lightweight feel, making it ideal for applications where airflow is crucial.', 'Mesh.jpg', 12, 'OffWhite', 4560, 430),
(15, 'asfds', 2, 'dasfsasadfs', 'images', 0, 'red', 332, 242),
(16, 'dg', 5, 'fghjklk fghjk', '1.jpg', 0, 'rgvg', 456, 567),
(19, 'xyz', 2, 'asdfsdfdsa', 'sfdsf', 12, 'pink', 2344, 345),
(20, 'Lord Of the Ring', 4, 'Lord Of the Ring Lord Of the Ring', 'Screenshot (7).png', 12, 'Blue', 8990, 890);

-- --------------------------------------------------------

--
-- Table structure for table `rolemaster`
--

CREATE TABLE `rolemaster` (
  `roleId` int(100) NOT NULL,
  `role` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rolemaster`
--

INSERT INTO `rolemaster` (`roleId`, `role`) VALUES
(1, 'User'),
(2, 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `testimonials`
--

CREATE TABLE `testimonials` (
  `tstId` int(100) NOT NULL,
  `user_email` varchar(250) NOT NULL,
  `name` varchar(250) NOT NULL,
  `ratting` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usermaster`
--

CREATE TABLE `usermaster` (
  `name` varchar(250) NOT NULL,
  `user_email` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `contact_no` varchar(250) NOT NULL,
  `gender` varchar(250) NOT NULL,
  `roleId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usermaster`
--

INSERT INTO `usermaster` (`name`, `user_email`, `password`, `contact_no`, `gender`, `roleId`) VALUES
('Admin', 'admin@gmail.com', 'PBKDF2WithHmacSHA256:2048:/tX1DJEMZHyBtYs71uILQh/GfkuRo30Q01Z9pFnWJaI=:wYlfuPFkvvLFzOeCnd2fV7cCwZvK9mYcXw0RSCXc3bY=', '45987645678', 'female', 2),
('Bhagyashree', 'bhagyashree@gmail.com', 'PBKDF2WithHmacSHA256:2048:QYZm23hb+580gnK3gU/neJxJXHKUlxeLlW8VIhRiS/s=:013A/VrOpKX9k9yvMOAU37iXO5ZJ2ND1QU0kqsj+7eY=', '5964309876', 'Female', 1),
('Bhuwan', 'bhuwan@gmail.com', 'PBKDF2WithHmacSHA256:2048:q4ExnKM1qm2vsPGU4JMVugNwW8RHjt2mEMf+kTgIdBk=:YnkTkjbVmcwHeBMqr2DgKpWcWOMlGB4uhyHY18L85z8=', '8978678990', 'Male', 1),
('Dhara', 'dhara@gmail.com', 'PBKDF2WithHmacSHA256:2048:alfUelSSoIXPK6mdbml4Zu+PJzXQnBMnANki+rmpzy8=:jE4x5W54/CBtQk5cEfqGs5x2fRZ9xjQudASBFIVC+Lw=', '3457906543', 'Female', 1),
('Jainul', 'jainul@gmail.com', 'PBKDF2WithHmacSHA256:2048:Zk1BezTAHlA7GU8kKcPl3qZBfnjIaTvDBgKsqPf6KuU=:ITdFs9WBqd/0pmY0EvXLIJDK+sLP4UKRvQUW8QFPBoA=', '7898767892', 'Male', 1),
('Kinal', 'kinal@gmail.com', 'PBKDF2WithHmacSHA256:2048:tD7xAHEmvUZAfPw8mYtN2Gdtbgz7bTLY+jMd7KaRNbM=:t9McC7mHEeIlMpIQUYUpnIDaz7Xoum/Pr+XshmdErAU=', '976434689987', 'Female', 1),
('Rupesh', 'rupesh@gmail.com', 'PBKDF2WithHmacSHA256:2048:DQypH1whxRNYqowPkeWu9eAExMUfDrtVzA552umE7Zg=:btCCgufBMXi4b5mG07ciGrSxPueRH/MjRHxXkZmCP0w=', '7878987879', 'Male', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `addressmaster`
--
ALTER TABLE `addressmaster`
  ADD PRIMARY KEY (`addId`),
  ADD KEY `user_email` (`user_email`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cartId`),
  ADD KEY `product_id` (`prodId`),
  ADD KEY `useremail` (`useremail`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`catId`);

--
-- Indexes for table `getintouch`
--
ALTER TABLE `getintouch`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `user_email` (`user_email`);

--
-- Indexes for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`odId`),
  ADD KEY `product_id` (`useremail`),
  ADD KEY `ordermasterId` (`ordermasterId`),
  ADD KEY `prodId` (`prodId`);

--
-- Indexes for table `ordermaster`
--
ALTER TABLE `ordermaster`
  ADD PRIMARY KEY (`omId`),
  ADD KEY `user_email` (`user_email`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payId`),
  ADD KEY `orderdId` (`orderdId`),
  ADD KEY `useremail` (`useremail`);

--
-- Indexes for table `productmaster`
--
ALTER TABLE `productmaster`
  ADD PRIMARY KEY (`prodId`),
  ADD KEY `cat_id` (`catId`);

--
-- Indexes for table `rolemaster`
--
ALTER TABLE `rolemaster`
  ADD PRIMARY KEY (`roleId`);

--
-- Indexes for table `testimonials`
--
ALTER TABLE `testimonials`
  ADD PRIMARY KEY (`tstId`),
  ADD KEY `user_email` (`user_email`);

--
-- Indexes for table `usermaster`
--
ALTER TABLE `usermaster`
  ADD PRIMARY KEY (`user_email`),
  ADD KEY `role_id` (`roleId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `addressmaster`
--
ALTER TABLE `addressmaster`
  MODIFY `addId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `cartId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `catId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `getintouch`
--
ALTER TABLE `getintouch`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `orderdetails`
--
ALTER TABLE `orderdetails`
  MODIFY `odId` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ordermaster`
--
ALTER TABLE `ordermaster`
  MODIFY `omId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payId` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `productmaster`
--
ALTER TABLE `productmaster`
  MODIFY `prodId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `rolemaster`
--
ALTER TABLE `rolemaster`
  MODIFY `roleId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `testimonials`
--
ALTER TABLE `testimonials`
  MODIFY `tstId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `addressmaster`
--
ALTER TABLE `addressmaster`
  ADD CONSTRAINT `addressmaster_ibfk_1` FOREIGN KEY (`user_email`) REFERENCES `usermaster` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`prodId`) REFERENCES `productmaster` (`prodId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cart_ibfk_3` FOREIGN KEY (`useremail`) REFERENCES `usermaster` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `getintouch`
--
ALTER TABLE `getintouch`
  ADD CONSTRAINT `getintouch_ibfk_1` FOREIGN KEY (`user_email`) REFERENCES `usermaster` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD CONSTRAINT `orderdetails_ibfk_2` FOREIGN KEY (`ordermasterId`) REFERENCES `ordermaster` (`omId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orderdetails_ibfk_3` FOREIGN KEY (`useremail`) REFERENCES `usermaster` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orderdetails_ibfk_4` FOREIGN KEY (`prodId`) REFERENCES `productmaster` (`prodId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ordermaster`
--
ALTER TABLE `ordermaster`
  ADD CONSTRAINT `ordermaster_ibfk_1` FOREIGN KEY (`user_email`) REFERENCES `usermaster` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`orderdId`) REFERENCES `orderdetails` (`odId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`useremail`) REFERENCES `usermaster` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `productmaster`
--
ALTER TABLE `productmaster`
  ADD CONSTRAINT `productmaster_ibfk_1` FOREIGN KEY (`catId`) REFERENCES `category` (`catId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `testimonials`
--
ALTER TABLE `testimonials`
  ADD CONSTRAINT `testimonials_ibfk_1` FOREIGN KEY (`user_email`) REFERENCES `usermaster` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `usermaster`
--
ALTER TABLE `usermaster`
  ADD CONSTRAINT `usermaster_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `rolemaster` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
