CREATE DATABASE IF NOT EXISTS db_jdbclaba4;
USE db_jdbclaba4;


DROP TABLE IF EXISTS electricity_price;
DROP TABLE IF EXISTS battary_charge;
DROP TABLE IF EXISTS sold_energy;
DROP TABLE IF EXISTS instalation_date;
DROP TABLE IF EXISTS panel_angels;
DROP TABLE IF EXISTS panel;
DROP TABLE IF EXISTS amount_of_station;
DROP TABLE IF EXISTS owner_s;
DROP TABLE IF EXISTS solar_station;

CREATE TABLE solar_station (
                               id INT NOT NULL AUTO_INCREMENT,
                               country VARCHAR(45) NOT NULL,
                               type_station VARCHAR(45) NOT NULL,
                               capacity INT NOT NULL,
                               CONSTRAINT solar_station_pk PRIMARY KEY (id)
)ENGINE = InnoDB;

CREATE TABLE electricity_price (
                                   id INT NOT NULL AUTO_INCREMENT,
                                   price INT NOT NULL,
                                   solar_station_id INT NOT NULL,
                                   CONSTRAINT electricity_price_pk PRIMARY KEY (id),
                                   FOREIGN KEY (solar_station_id) REFERENCES solar_station (id)
)ENGINE = InnoDB;

CREATE TABLE battary_charge (
                                id INT NOT NULL AUTO_INCREMENT,
                                type_of_charge VARCHAR(45) NOT NULL,
                                solar_station_id INT NOT NULL,
                                CONSTRAINT battary_charge_pk PRIMARY KEY (id),
                                FOREIGN KEY (solar_station_id) REFERENCES solar_station (id)
)ENGINE = InnoDB;

CREATE TABLE owner_s (
                         id INT NOT NULL AUTO_INCREMENT,
                         name VARCHAR(45) NOT NULL,
                         surname VARCHAR(45) NOT NULL,
                         CONSTRAINT owner_s_pk PRIMARY KEY (id)
)ENGINE = InnoDB;

CREATE TABLE amount_of_station (
                                   id INT NOT NULL AUTO_INCREMENT,
                                   amount INT NOT NULL,
                                   owner_s_id INT NOT NULL,
                                   CONSTRAINT amount_of_station_pk PRIMARY KEY (id),
                                   FOREIGN KEY (owner_s_id) REFERENCES owner_s (id)
)ENGINE = InnoDB;

CREATE TABLE sold_energy (
                             id INT NOT NULL AUTO_INCREMENT,
                             amount_of_sold_energy DECIMAL(8, 2) NOT NULL,
                             solar_station_id INT NOT NULL,
                             CONSTRAINT sold_energy_pk PRIMARY KEY (id),
                             FOREIGN KEY (solar_station_id) REFERENCES solar_station (id)
)ENGINE = InnoDB;

CREATE TABLE instalation_date (
                                  id INT NOT NULL AUTO_INCREMENT,
                                  ins_date DATE NOT NULL,
                                  solar_station_id INT NOT NULL,
                                  CONSTRAINT instalation_date_pk PRIMARY KEY (id),
                                  FOREIGN KEY (solar_station_id) REFERENCES solar_station (id)
)ENGINE = InnoDB;

CREATE TABLE panel (
                       id INT NOT NULL AUTO_INCREMENT,
                       amount_of_panel INT NOT NULL,
                       solar_station_id INT NOT NULL,
                       CONSTRAINT panel_pk PRIMARY KEY (id),
                       FOREIGN KEY (solar_station_id) REFERENCES solar_station (id)
)ENGINE = InnoDB;

CREATE TABLE panel_angels (
                              id INT NOT NULL AUTO_INCREMENT,
                              tilt INT NOT NULL,
                              panel_id INT NOT NULL,
                              CONSTRAINT panel_angels_pk PRIMARY KEY (id),
                              FOREIGN KEY (panel_id) REFERENCES panel (id)
)ENGINE = InnoDB;

INSERT INTO solar_station(country,type_station,capacity) VALUES
                                                             ('UA','multi',100),
                                                             ('UK','solar',87),
                                                             ('DE','biggest',69),
                                                             ('AUS','multi',23),
                                                             ('USA','solar',67),
                                                             ('UK','solar',33),
                                                             ('DE','biggest',12),
                                                             ('AUS','multi',99),
                                                             ('UK','solar',11),
                                                             ('KA','biggest',78);

INSERT INTO electricity_price(id,price,solar_station_id) VALUES
                                                             (1, 1000, 1),
                                                             (2, 39933, 2),
                                                             (3, 32322, 7),
                                                             (4, 9999, 3),
                                                             (5, 9222, 8),
                                                             (6, 1111, 9),
                                                             (7, 2233, 10),
                                                             (8, 1111, 6),
                                                             (9, 7843, 4),
                                                             (10, 9113, 5);

INSERT INTO battary_charge(id,type_of_charge,solar_station_id) VALUES
                                                                   (1, 'USB-C', 1),
                                                                   (2, 'LIGHTNING', 2),
                                                                   (3, 'MICRO-USB', 2),
                                                                   (4, 'LIGHTNING', 3),
                                                                   (5, 'USB-C', 1),
                                                                   (6, 'MICRO-USB', 3),
                                                                   (7, 'LIGHTNING-Ka', 5),
                                                                   (8, 'HDMI', 2),
                                                                   (9, 'MICRO-USB', 4),
                                                                   (10, 'LIGHTNING', 5);

INSERT INTO owner_s(id,name,surname) VALUES
                                         (1,'harry','potter'),
                                         (2,'charly','jeremy'),
                                         (3,'marsel','pillow'),
                                         (4,'memet','DZIGAEV'),
                                         (5,'witsel','axel');

INSERT INTO amount_of_station(amount,owner_s_id) VALUES
                                                     (2,3),(3,5),(1,4),(3,1),(1,2);

INSERT INTO sold_energy(amount_of_sold_energy,solar_station_id) VALUES
                                                                    (1211,10),
                                                                    (8902, 1),
                                                                    (99191,8),
                                                                    (1111,2),
                                                                    (4242,7),
                                                                    (2123,3),
                                                                    (8909,6),
                                                                    (3211,4),
                                                                    (3910,9),
                                                                    (8932,5);

INSERT INTO instalation_date(ins_date,solar_station_id) VALUES
                                                            ('2007-08-20',2),
                                                            ('2009-10-01',1),
                                                            ('2001-04-15',10),
                                                            ('2021-08-11',9),
                                                            ('1999-12-30',3),
                                                            ('2003-12-30',7),
                                                            ('2004-01-21',6),
                                                            ('2005-02-22',8),
                                                            ('2006-03-23',5),
                                                            ('2007-04-24',4);

INSERT INTO panel(amount_of_panel,solar_station_id) VALUES
                                                        (123,10),
                                                        (98, 1),
                                                        (432,8),
                                                        (233,2),
                                                        (783,7),
                                                        (142,3),
                                                        (98,6),
                                                        (89,4),
                                                        (422,9),
                                                        (152,5);

INSERT INTO panel_angels(id,tilt,panel_id) VALUES
                                               (1, 180, 1),
                                               (2, 89, 2),
                                               (3, 13, 7),
                                               (4, 78, 3),
                                               (5, 11, 8),
                                               (6, 99, 9),
                                               (7, 43, 10),
                                               (8, 56, 6),
                                               (9, 71, 4),
                                               (10, 140, 5);

CREATE UNIQUE INDEX idx_pname
    ON owner_s (name, surname);

CREATE UNIQUE INDEX idx_tilt
    ON panel_angels (tilt);

