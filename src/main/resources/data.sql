DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id      INT auto_increment primary key,
    name    VARCHAR(25)  NOT NULL,
    age     INT(3)       NOT NULL,
    gender  VARCHAR(10)  NOT NULL,
    address VARCHAR(255) NOT NULL
);

INSERT INTO users (name, age, gender, address)
VALUES ('Oleg', 33, 'male', 'Dnipro'),
       ('Max', 20, 'male', 'Kyiv'),
       ('Olena', 23, 'female', 'Odessa');
