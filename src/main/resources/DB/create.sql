SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS restaurants (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 address VARCHAR,
 zipCode VARCHAR,
 phone VARCHAR,
 website VARCHAR,
 email VARCHAR
);

CREATE TABLE IF NOT EXISTS foodTypes (
 id int PRIMARY KEY auto_increment,
 name VARCHAR
);

CREATE TABLE IF NOT EXISTS reviews (
 id int PRIMARY KEY auto_increment,
 writtenby VARCHAR,
 content VARCHAR,
 rating VARCHAR,
 restaurantid INTEGER
);