CREATE TABLE car_rent.cars
(
    id integer,
    manufacturer character varying(100),
    model character varying(50),
    year integer,
    price integer,
    PRIMARY KEY (id)
);

CREATE TABLE car_rent.clients
(
    id integer,
    name character varying(50) NOT NULL,
    surname character varying(50),
    phone character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE car_rent.orders
(
    id integer,
    date timestamp without time zone NOT NULL,
    car_id integer,
    client_id integer,
    PRIMARY KEY (id),
    CONSTRAINT orders_cars_id_fk FOREIGN KEY (car_id)
        REFERENCES car_rent.cars (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT orders_clients_id_fk FOREIGN KEY (client_id)
        REFERENCES car_rent.clients (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

/* INSERTS */
INSERT INTO car_rent.cars (id,manufacturer, model,"year", price) VALUES (2,'Honda','Civic', 2012, 130);
INSERT INTO car_rent.cars (id,manufacturer, model,"year", price) VALUES (3,'BMW','X5', 2007, 180);
INSERT INTO car_rent.cars (id,manufacturer, model,"year", price) VALUES (4,'Opel','Astra', 2017, 110);

INSERT INTO car_rent.clients (id, "name", surname, phone) VALUES (1, 'Jack', 'Black', '55519594');
INSERT INTO car_rent.clients (id, "name", surname, phone) VALUES (2, 'Ivan', 'Ivanov', '23419594');
INSERT INTO car_rent.clients (id, "name", surname, phone) VALUES (3, 'Oleg', 'Popov', '12341294');

/* SELECT */
SELECT * FROM car_rent.clients;
SELECT id,manufacturer,model FROM car_rent.cars;
SELECT id,manufacturer,model FROM car_rent.cars WHERE year > 2015;

/* UPDATE */
UPDATE car_rent.cars SET year = 2015 WHERE id = 5;

/* DELETE */
DELETE FROM car_rent.cars WHERE id = 5;




