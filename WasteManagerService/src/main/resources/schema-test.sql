DROP TABLE IF EXISTS waste_manager;

CREATE TABLE waste_manager (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    nif VARCHAR(50),
    is_enabled BIT,
    version INT,
    created_date DATE,
    last_modified_date DATE,
    waste_manager_address_id INT
);

DROP TABLE IF EXISTS waste_center_authorization;

CREATE TABLE waste_center_authorization (
   id INT AUTO_INCREMENT PRIMARY KEY,
   authorizationNumber VARCHAR(50),
   waste_manager_id INT
);
