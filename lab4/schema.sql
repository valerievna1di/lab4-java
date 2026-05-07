CREATE TABLE clothes (

    id SERIAL PRIMARY KEY,

    type VARCHAR(50) NOT NULL,

    name VARCHAR(100) NOT NULL,

    season_type VARCHAR(50) NOT NULL,

    price DOUBLE PRECISION NOT NULL,

    size VARCHAR(20) NOT NULL,

    material VARCHAR(100),

    long_sleeve BOOLEAN,

    hood BOOLEAN,

    sole_type VARCHAR(100)
);