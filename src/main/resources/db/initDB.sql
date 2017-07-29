DROP TABLE IF EXISTS drink;
DROP TABLE IF EXISTS cafe;
DROP TABLE IF EXISTS director;

CREATE TABLE director (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  first_name   VARCHAR(255) NOT NULL,
  last_name    VARCHAR(255) NOT NULL,
  phone_number VARCHAR(20)  NOT NULL,
  email        VARCHAR(255) NOT NULL
);
CREATE TABLE cafe (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  address     VARCHAR(255) NOT NULL,
  name        VARCHAR(30)  NOT NULL,
  director_id INT          NOT NULL,
  rating      INT          NOT NULL,
  FOREIGN KEY (director_id) REFERENCES director (id)
);

CREATE TABLE drink (
  id       INT PRIMARY KEY  AUTO_INCREMENT,
  name     VARCHAR(255) NOT NULL,
  price    INT          NOT NULL,
  capacity INT          NOT NULL,
  cafe_id  INT          NOT NULL,
  FOREIGN KEY (cafe_id) REFERENCES cafe (id)
);

