INSERT INTO user (id, first_name, last_name, email, password, phone, location, authorities, enabled, deleted) VALUES (999999997, 'John', 'Doe', 'john@miu.com', '$2a$10$KoxHNdhOe6OY88Ybq6T2d.SGp6lVfj5ynY/QwaO5SRk998TgnYayi', '641890987', '1000 N 4th street, Fairfield, Iowa 52557', 'ROLE_ADMIN', true, false);
INSERT INTO user (id, first_name, last_name, email, password, phone, location, authorities, enabled, deleted) VALUES (999999998, 'Michael', 'Dan', 'michael@miu.com', '$2a$10$KoxHNdhOe6OY88Ybq6T2d.SGp6lVfj5ynY/QwaO5SRk998TgnYayi', '641890987', '1000 N 4th street, Fairfield, Iowa 52557', 'ROLE_MANAGER', true, false);
INSERT INTO user (id, first_name, last_name, email, password, phone, location, authorities, enabled, deleted) VALUES (999999999, 'Thomas', 'Brown', 'thomas@miu.com', '$2a$10$KoxHNdhOe6OY88Ybq6T2d.SGp6lVfj5ynY/QwaO5SRk998TgnYayi', '641890987', '1000 N 4th street, Fairfield, Iowa 52557', 'ROLE_INSPECTOR', true, false);
INSERT INTO user (id, first_name, last_name, email, password, phone, location, authorities, enabled, deleted) VALUES (9999999991, 'Hozifa', 'Hose', 'edison@miu.com', '123456', '641890987', '1000 N 4th street, Fairfield, Iowa 52557', 'ROLE_INSPECTOR', true, false);
insert into HIRED_INSPECTORS (manager_id, inspector_id) values (999999998, 999999999);

-- INSERT INTO form(id, name) values (9999991, 'Restaurant');
-- INSERT INTO form(id, name) values (9999992, 'Hotel');

-- INSERT INTO form(id, name) values (9999992, 'Testing');
-- INSERT INTO hotel_form(id, number_of_room) values (9999992,100);