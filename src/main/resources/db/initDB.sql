DROP TABLE IF EXISTS drink;
DROP TABLE IF EXISTS cafe;
DROP TABLE IF EXISTS director;

CREATE TABLE director
(
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    phone_number VARCHAR(20)
);

CREATE TABLE cafe
(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  address VARCHAR(100),
  name VARCHAR(100),
  dir_id INT(11),
  rating FLOAT,
  CONSTRAINT dir_id FOREIGN KEY (dir_id) REFERENCES director (id) ON DELETE SET NULL ON UPDATE SET NULL
);
CREATE INDEX dir_id_idx ON cafe (dir_id);

CREATE TABLE drink
(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  price FLOAT,
  capacity INT(11),
  cafe_id INT(11) NOT NULL,
  CONSTRAINT cafe_id FOREIGN KEY (cafe_id) REFERENCES cafe (id)
);
CREATE INDEX cafe_id_idx ON drink (cafe_id);

