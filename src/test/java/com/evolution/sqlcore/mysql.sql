CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone_number VARCHAR(15),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE Products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    category_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE Orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'Pending',
    address_id INT,
    payment_id INT
);
CREATE TABLE OrderDetails (
    order_detail_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);
CREATE TABLE Addresses (
    address_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    street_address VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100),
    postal_code VARCHAR(20) NOT NULL,
    country VARCHAR(100) NOT NULL
);
CREATE TABLE Payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    payment_method VARCHAR(50) NOT NULL,
    transaction_id VARCHAR(100) NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE Categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT
);
CREATE TABLE UserInfo (
    user_info_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(50) NOT NULL,
    user_email VARCHAR(100) NOT NULL UNIQUE,
    user_password_hash VARCHAR(255) NOT NULL,
    user_first_name VARCHAR(50),
    user_last_name VARCHAR(50),
    user_phone_number VARCHAR(15),
    user_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO Users (username, email, password_hash, first_name, last_name, phone_number) VALUES
('alice', 'alice@example.com', 'password123', 'Alice', 'Smith', '1234567890'),
('bob', 'bob@example.com', 'password456', 'Bob', 'Johnson', '0987654321'),
('charlie', 'charlie@example.com', 'password789', 'Charlie', 'Brown', '1112223333'),
('david', 'david@example.com', 'password101', 'David', 'Wilson', '4445556666'),
('eve', 'eve@example.com', 'password111', 'Eve', 'Davis', '7778889999'),
('frank', 'frank@example.com', 'password222', 'Frank', 'Lee', '3334445555'),
('grace', 'grace@example.com', 'password333', 'Grace', 'Miller', '6667778888'),
('hector', 'hector@example.com', 'password444', 'Hector', 'Taylor', '2223334444'),
('irene', 'irene@example.com', 'password555', 'Irene', 'White', '5556667777'),
('james', 'james@example.com', 'password666', 'James', 'Black', '8889990000'),
('karen', 'karen@example.com', 'password777', 'Karen', 'Green', '1112223333'),
('lisa', 'lisa@example.com', 'password888', 'Lisa', 'Brown', '4445556666'),
('mike', 'mike@example.com', 'password999', 'Mike', 'Davis', '7778889999'),
('nancy', 'nancy@example.com', 'password111', 'Nancy', 'Lee', '3334445555'),
('oliver', 'oliver@example.com', 'password222', 'Oliver', 'Miller', '6667778888'),
('peter', 'peter@example.com', 'password333', 'Peter', 'Taylor', '2223334444'),
('quinn', 'quinn@example.com', 'password444', 'Quinn', 'White', '5556667777'),
('robert', 'robert@example.com', 'password555', 'Robert', 'Black', '8889990000'),
('susan', 'susan@example.com', 'password666', 'Susan', 'Green', '1112223333'),
('tom', 'tom@example.com', 'password777', 'Tom', 'Brown', '4445556666');

INSERT INTO UserInfo (user_name, user_email, user_password_hash, user_first_name, user_last_name, user_phone_number) VALUES
('alice2', 'alice2@example.com', 'password123', 'Alice2', 'Smith2', '1234567890'),
('bob2', 'bob2@example.com', 'password456', 'Bob2', 'Johnson2', '0987654321'),
('charlie2', 'charlie2@example.com', 'password789', 'Charlie2', 'Brown2', '1112223333'),
('david2', 'david2@example.com', 'password101', 'David2', 'Wilson2', '4445556666'),
('eve2', 'eve2@example.com', 'password111', 'Eve2', 'Davis2', '7778889999'),
('frank2', 'frank2@example.com', 'password222', 'Frank2', 'Lee2', '3334445555'),
('grace2', 'grace2@example.com', 'password333', 'Grace2', 'Miller2', '6667778888'),
('hector2', 'hector2@example.com', 'password444', 'Hector2', 'Taylor2', '2223334444'),
('irene2', 'irene2@example.com', 'password555', 'Irene2', 'White2', '5556667777'),
('james2', 'james2@example.com', 'password666', 'James2', 'Black2', '8889990000'),
('karen2', 'karen2@example.com', 'password777', 'Karen2', 'Green2', '1112223333'),
('lisa2', 'lisa2@example.com', 'password888', 'Lisa2', 'Brown2', '4445556666'),
('mike2', 'mike2@example.com', 'password999', 'Mike2', 'Davis2', '7778889999'),
('nancy2', 'nancy2@example.com', 'password111', 'Nancy2', 'Lee2', '3334445555'),
('oliver2', 'oliver2@example.com', 'password222', 'Oliver2', 'Miller2', '6667778888'),
('peter2', 'peter2@example.com', 'password333', 'Peter2', 'Taylor2', '2223334444'),
('quinn2', 'quinn2@example.com', 'password444', 'Quinn2', 'White2', '5556667777'),
('robert2', 'robert2@example.com', 'password555', 'Robert2', 'Black2', '8889990000'),
('susan2', 'susan2@example.com', 'password666', 'Susan2', 'Green2', '1112223333'),
('tom2', 'tom2@example.com', 'password777', 'Tom2', 'Brown2', '4445556666');
INSERT INTO Orders (user_id, total_amount, status, address_id, payment_id) VALUES
(1, 1200.00, 'Completed', 1, 1),
(2, 800.00, 'Pending', 2, 2),
(3, 1500.00, 'Shipped', 3, 3),
(4, 950.00, 'Completed', 4, 4),
(5, 700.00, 'Pending', 5, 5),
(6, 1100.00, 'Shipped', 6, 6),
(7, 1300.00, 'Completed', 7, 7),
(8, 600.00, 'Pending', 8, 8),
(9, 1400.00, 'Shipped', 9, 9),
(10, 1000.00, 'Completed', 10, 10),
(11, 1600.00, 'Pending', 11, 11),
(12, 1800.00, 'Shipped', 12, 12),
(13, 1900.00, 'Completed', 13, 13),
(14, 1700.00, 'Pending', 14, 14),
(15, 1250.00, 'Shipped', 15, 15),
(16, 1150.00, 'Completed', 16, 16),
(17, 1050.00, 'Pending', 17, 17),
(18, 1350.00, 'Shipped', 18, 18),
(19, 1450.00, 'Completed', 19, 19),
(20, 1550.00, 'Pending', 20, 20);
INSERT INTO Products (name, description, price, stock, category_id) VALUES
('Laptop', 'High-performance laptop for professionals', 1200.00, 50, 1),
('Smartphone', 'Latest model smartphone with advanced features', 800.00, 100, 2);

INSERT INTO OrderDetails (order_id, product_id, quantity, price) VALUES
(1, 1, 1, 1200.00),
(2, 2, 1, 800.00);
INSERT INTO Addresses (user_id, street_address, city, state, postal_code, country) VALUES
(1, '123 Main St', 'Springfield', 'IL', '62704', 'USA'),
(2, '456 Elm St', 'Shelbyville', 'IL', '62705', 'USA');
INSERT INTO Payments (user_id, amount, payment_method, transaction_id) VALUES
(1, 1200.00, 'Credit Card', 'TX1234567890'),
(2, 800.00, 'PayPal', 'TX0987654321');
INSERT INTO Categories (name, description) VALUES
('Electronics', 'Electrical and electronic devices'),
('Mobile Devices', 'Smartphones, tablets, and other mobile gadgets');

