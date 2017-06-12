
CREATE TABLE product (
    id     integer,
    name   VARCHAR(40),
    code varchar(40),
    releaseDate   TIMESTAMP DEFAULT current_timestamp,
    description   TEXT,
    price   REAL,
    starRating REAL,
    imageUrl TEXT
);