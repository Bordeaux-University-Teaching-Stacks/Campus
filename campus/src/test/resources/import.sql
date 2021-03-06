-- SQL QUERIES TO SETUP HSQLDB FOR EMBEDDED DAO TESTS

-- Crée un campus
INSERT INTO campus(name) VALUES ('Grenoble');
INSERT INTO campus(name) VALUES ('Bordeaux');

-- Crée des utilisateurs pour les tests CRUD
INSERT INTO user(id_campus, email, password, birth, name, surname, photo, sex, legals, newsletter) VALUES (1, 'select@campus.fr', 'ngLzopB+RVaKg+Lx5Uuu3w==', DATE '1988-11-11' , 'SelectName', 'SelectSurname', NULL, 'M', true, true);
INSERT INTO user(id_campus, email, password, birth, name, surname, photo, sex, legals, newsletter) VALUES (1, 'update@campus.fr', 'Update13', DATE '1988-11-11' , 'UpdateName', 'UpdateSurname', NULL, 'M', true, true);
INSERT INTO user(id_campus, email, password, birth, name, surname, photo, sex, legals, newsletter) VALUES (1, 'delete@campus.fr', 'Delete13', DATE '1988-11-11' , 'DeleteName', 'DeleteSurname', NULL, 'M', true, true);
