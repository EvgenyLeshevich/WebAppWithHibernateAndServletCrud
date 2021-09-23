USE registration_user;

DROP TABLE IF EXISTS country;

CREATE TABLE country
(
    country_id SERIAL,
    country_name  varchar(100),
    PRIMARY KEY (country_id)
);