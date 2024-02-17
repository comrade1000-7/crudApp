CREATE TABLE IF NOT EXISTS disciplines
(
    id serial PRIMARY KEY,
    nominative_name VARCHAR(128),
    genitive_name VARCHAR(128),
    alias_name VARCHAR(128),
    tests_ids INT
    );

CREATE TABLE IF NOT EXISTS test
(
    id serial PRIMARY KEY,
    nominative_name VARCHAR(128),
    genitive_name VARCHAR(128),
    alias_name VARCHAR(128)
    );

CREATE TABLE IF NOT EXISTS t_users
(
    id serial PRIMARY KEY,
    c_username varchar not null
);

CREATE TABLE IF NOT EXISTS users
(
    username VARCHAR(128) PRIMARY KEY,
    firstname VARCHAR(128),
    lastname VARCHAR(128),
    birth_date DATE,
    age INT
);
