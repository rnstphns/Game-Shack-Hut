INSERT INTO users (user_id, email, name, password)
VALUES (1, 'test@gmail.com', 'test', '$2a$10$Ofo56eKDCEgZNDNlmZZQxe6acECPojGdeWNifug7HPC2cCcJQb/9a'); --password:test123
INSERT INTO users (user_id, email, name, password)
VALUES (2, 'sai@gmail.com', 'sai', '$2a$10$Ofo56eKDCEgZNDNlmZZQxe6acECPojGdeWNifug7HPC2cCcJQb/9a'); --password:test123

INSERT INTO role (role_id, role_name,user_id)
VALUES (1, 'ADMIN',1);
INSERT INTO role (role_id, role_name,user_id)
VALUES (2, 'STAFF',2);
