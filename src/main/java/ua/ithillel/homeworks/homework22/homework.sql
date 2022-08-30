CREATE TABLE car_rent.roles
(
    id   integer,
    role character varying NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE car_rent.manager
(
    id       integer,
    name     character varying NOT NULL,
    login    character varying,
    password character varying,
    email    character varying,
    role     integer,
    PRIMARY KEY (id),
    CONSTRAINT "car_ rent.role(id)" FOREIGN KEY (role)
        REFERENCES car_rent.roles (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE car_rent.cars
    ADD available BOOLEAN;


ALTER TABLE car_rent.orders
    ADD FOREIGN KEY (manager) REFERENCES car_rent.manager (id);


INSERT INTO car_rent.managers(id, "name", login, "password", email, "role")
VALUES (1, 'Kyle', 'admin', 1111, 'kyle@mail.com', 1),
       (2, 'Alex', 'alex', 2222, 'alex@mail.com', 2),
       (3, 'Paul', 'paul', 222322, 'paul@mail.com', 2),
       (4, 'Boris', 'britva', 333, 'boris@mail.com', 2);
    (5, 'Nick', 'petrov','nick3000', 'petrov@mail.com', 1);


INSERT INTO car_rent.cars (id, manufacturer, model, "year", price)
VALUES (5, 'BMV', 'X3', 2014, 330),
       (6, 'Audi', 'A6', 2017, 300),
       (7, 'Audi', 'A8', 2014, 210),
       (8, 'Audi', 'Q7', 2009, 120),
       (9, 'Audi', 'A4', 2013, 290),
       (10, 'BMV', 'X5', 2011, 250);


INSERT INTO car_rent.clients (id, "name", surname, phone)
VALUES (1, 'Liza', 'Sokolova', '0984563221'),
       (2, 'Ivan', 'Li', '0978654325'),
       (3, 'Anastasia', 'Cat', '09376223344'),
       (4, 'Bod', 'Black', '5678819594'),
       (5, 'Nick', 'Ivanov', '23567890');



INSERT INTO car_rent.orders(id, date, car_id, client_id, manager_id)
VALUES (2, '20.10.2021', 1, 1, 4),
       (1, '01.02.2022', 2, 4, 2),
       (3, '25.06.2022', 3, 2, 1),
       (4, '13.11.2021', 7, 5, 3),
       (5, '08.04.2022', 9, 3, 2);

-- / task 1/ --
SELECT managers
FROM car_rent.managers
WHERE role = 1;

-- / task 2/ --
SELECT *
FROM car_rent.orders
WHERE date >'2022-01-28';

-- / task 3/ --
SELECT *
FROM car_rent.cars
WHERE price IN (SELECT MAX(price) FROM car_rent.cars)


SELECT id, manufacturer, model, "year", price
FROM car_rent.cars
WHERE price IS MAX(price);

-- / task 4/ --
SELECT COUNT('Manager')
FROM car_rent.roles;

-- / task 5/ --
SELECT manufacturer, model
FROM car_rent.cars
         JOIN car_rent.orders ON orders.car_id = cars.id;

-- / task 6/ --
SELECT count(*), manufacturer as COUNT
FROM car_rent.cars
GROUP BY manufacturer;

-- / task 7/ --
BEGIN;
INSERT INTO car_rent.orders
VALUES (6, '20.08.2022', 10, 3, 2),
       (7, '13.06.2022', 6, 5, 4);
UPDATE car_rent.cars
SET available = 'false'
WHERE id = 6
  AND id = 10;
COMMIT;