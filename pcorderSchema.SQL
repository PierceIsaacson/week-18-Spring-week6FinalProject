DROP TABLE IF EXISTS cpu;
DROP TABLE IF EXISTS gpu;
DROP TABLE IF EXISTS memory;
DROP TABLE IF EXISTS order;
DROP TABLE IF EXISTS customer;

CREATE TABLE memory (
	option int NOT NULL AUTO_INCREMENT,
	spec varchar(255),
	PRIMARY KEY (option)

CREATE TABLE gpu (
	option int NOT NULL AUTO_INCREMENT,
	spec varchar(255),
	PRIMARY KEY (option)

CREATE TABLE cpu (
	option int NOT NULL AUTO_INCREMENT,
	spec varchar(255),
	PRIMARY KEY (option)
)
 
CREATE TABLE order (
	order_id int NOT NULL AUTO_INCREMENT,
	cpu varchar(255),
	gpu varchar(255),
	memory varchar(255),
	PRIMARY KEY (order_id)
);

CREATE TABLE customer (
	customer_id int NOT NULL AUTO_INCREMENT,
	first_name varchar(255),
	last_name varchar(255),
	order_id int NOT NULL,
	phone_number varchar(255),
	PRIMARY KEY (customer_id),
	FOREIGN KEY (order_id) REFERENCES order (order_id)
);

