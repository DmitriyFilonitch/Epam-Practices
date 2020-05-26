 DROP DATABASE practice10;
 CREATE DATABASE practice10;
 USE practice10;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE roles(
  id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(32)
);

CREATE TABLE users(
  login VARCHAR(32) UNIQUE NOT NULL,
  password VARCHAR(32),
  role_id INTEGER,
  FOREIGN KEY (role_id) REFERENCES roles(id)
);



INSERT INTO roles VALUES  (DEFAULT, 'admin'),
                          (DEFAULT, 'client');

INSERT INTO users VALUES  ('ivanov', 'password', 2),
                          ('admin', 'wordpass', 1);