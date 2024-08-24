INSERT INTO client (name)
VALUES ('John Smith'),
       ('Jane Doe'),
       ('Robert Brown'),
       ('Emily Wilson'),
       ('Michael Davis'),
       ('Jennifer Thomas'),
       ('David Garcia'),
       ('Linda Rodriguez'),
       ('Christopher Williams'),
       ('Angela Jones');

INSERT INTO planet (id, name)
VALUES ('EARTH', 'Earth'),
       ('MARS', 'Mars'),
       ('VEN', 'Venus'),
       ('JUP', 'Jupiter'),
       ('SAT', 'Saturn');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id)
VALUES (1, 'EARTH', 'MARS'),
       (2, 'MARS', 'VEN'),
       (3, 'VEN', 'EARTH'),
       (4, 'JUP', 'SAT'),
       (5, 'SAT', 'JUP'),
       (6, 'EARTH', 'VEN'),
       (7, 'MARS', 'JUP'),
       (8, 'VEN', 'SAT'),
       (9, 'JUP', 'EARTH'),
       (10, 'SAT', 'MARS');