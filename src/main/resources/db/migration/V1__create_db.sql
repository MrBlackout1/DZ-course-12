CREATE TABLE client
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) BETWEEN 3 AND 200)
);

CREATE TABLE planet
(
    id   VARCHAR(255) PRIMARY KEY CHECK (id REGEXP '^[A-Z0-9]+$'),
    name VARCHAR(500) NOT NULL
);

CREATE TABLE ticket
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id      BIGINT,
    from_planet_id VARCHAR(255),
    to_planet_id   VARCHAR(255),
    FOREIGN KEY (client_id) REFERENCES client (id),
    FOREIGN KEY (from_planet_id) REFERENCES planet (id),
    FOREIGN KEY (to_planet_id) REFERENCES planet (id)
);