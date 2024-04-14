-- TABLE WASTE MANAGER ADDRESS --
INSERT INTO waste_manager_address (direccion, is_enabled, version, created_date, last_modified_date)
VALUES ('Address 1', TRUE, 1, '2024-01-01', '2024-01-15');

INSERT INTO waste_manager_address (direccion, is_enabled, version, created_date, last_modified_date)
VALUES ('Address 2', TRUE, 1, '2024-01-16', '2024-01-31');

INSERT INTO waste_manager_address (direccion, is_enabled, version, created_date, last_modified_date)
VALUES ('Address 3', TRUE, 1, '2024-02-01', '2024-02-15');

INSERT INTO waste_manager_address (direccion, is_enabled, version, created_date, last_modified_date)
VALUES ('Address 4', TRUE, 1, '2024-02-16', '2024-02-28');

INSERT INTO waste_manager_address (direccion, is_enabled, version, created_date, last_modified_date)
VALUES ('Address 5', TRUE, 1, '2024-03-01', '2024-03-15');

-- TABLE WASTE MANAGER --
INSERT INTO waste_manager (nombre, nif, is_enabled, version, created_date, last_modified_date, waste_manager_address_id)
    VALUES ('Name 1', 'NIF 1', TRUE, 1, '2024-01-01', '2024-01-15', 1L);

INSERT INTO waste_manager (nombre, nif, is_enabled, version, created_date, last_modified_date, waste_manager_address_id)
VALUES ('Name 2', 'NIF 2', TRUE, 1, '2024-01-01', '2024-01-15', 2L);

-- TABLE WASTE CENTER AUTHORIZATION --
INSERT INTO waste_center_authorization (authorization_number, waste_manager_id)
    VALUES ('Authorization 1', 1);

INSERT INTO waste_center_authorization (authorization_number, waste_manager_id)
    VALUES ('Authorization 1', 2);