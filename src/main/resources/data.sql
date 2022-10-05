INSERT INTO users (id, email, firstname, lastname, password) VALUES (1, 'admin@gmail.com', 'Admin', 'Admin', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO role (id, role) VALUES (1, 'ADMIN');
INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1);
