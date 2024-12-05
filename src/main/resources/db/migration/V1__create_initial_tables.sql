CREATE TABLE planet_resource (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    rarity CHAR(1) NOT NULL
);

CREATE TABLE planet (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    planet_resource_id BIGINT,
    distance_from_earth DOUBLE PRECISION,
    quanityty_of_resource DOUBLE PRECISION,
    fuel_price DOUBLE PRECISION,
    CONSTRAINT fk_planet_resource FOREIGN KEY (planet_resource_id) REFERENCES planet_resource(id)
);

CREATE TABLE space_ship (
    id BIGSERIAL PRIMARY KEY,
    ship_name VARCHAR(255) NOT NULL,
    ship_capacity DOUBLE PRECISION NOT NULL,
    current_space_ship_resource_id BIGINT,
    current_ship_fuel DOUBLE PRECISION,
    space_ship_gold_amount DOUBLE PRECISION,
    current_planet_id BIGINT,
    space_ship_fuel_tank DOUBLE PRECISION,
    CONSTRAINT fk_space_ship_resource FOREIGN KEY (current_space_ship_resource_id) REFERENCES planet_resource(id),
    CONSTRAINT fk_space_ship_planet FOREIGN KEY (current_planet_id) REFERENCES planet(id)
);
