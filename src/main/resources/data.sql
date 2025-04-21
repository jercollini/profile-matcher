-- Create PLAYERS table
CREATE TABLE IF NOT EXISTS PLAYERS (
    player_id CHAR(36) PRIMARY KEY,
    country VARCHAR(2) NOT NULL,
    birthdate TIMESTAMP NOT NULL,
    created TIMESTAMP NOT NULL,
    modified TIMESTAMP NOT NULL,
    language VARCHAR(10) NOT NULL,
    gender VARCHAR(10) NOT NULL
);
-- Create CLANS table
CREATE TABLE IF NOT EXISTS CLANS (
    clan_id CHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    creation_date TIMESTAMP NOT NULL
);

-- Create PLAYER_PROFILES table
CREATE TABLE IF NOT EXISTS PLAYER_PROFILES (
    profile_id CHAR(36) PRIMARY KEY,
    player_id CHAR(36) NOT NULL,
    level INT NOT NULL,
    xp INT NOT NULL,
    total_playtime INT NOT NULL,
    active_campaigns VARCHAR(1000) NULL,
    clan_id CHAR(36) NULL,
    FOREIGN KEY (player_id) REFERENCES PLAYERS(player_id),
    FOREIGN KEY (clan_id) REFERENCES CLANS(clan_id)
);

-- Create PLAYER_SESSION table
CREATE TABLE IF NOT EXISTS PLAYER_SESSION (
    session_id CHAR(36) PRIMARY KEY,
    player_id CHAR(36) NOT NULL,
    credential VARCHAR(255) NOT NULL,
    last_session TIMESTAMP NOT NULL,
    FOREIGN KEY (player_id) REFERENCES PLAYERS(player_id)
);

-- Create PLAYER_INVENTORY table
CREATE TABLE IF NOT EXISTS PLAYER_INVENTORY (
    inventory_id CHAR(36) PRIMARY KEY,
    player_id CHAR(36) NOT NULL,
    cash INT NOT NULL,
    coins INT NOT NULL,
    FOREIGN KEY (player_id) REFERENCES PLAYERS(player_id)
);

-- Create GAME_ITEMS table
CREATE TABLE IF NOT EXISTS GAME_ITEMS (
    id BIGINT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    rarity VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- Create INVENTORY_ITEMS table
CREATE TABLE IF NOT EXISTS INVENTORY_ITEMS (
    item_id BIGINT NOT NULL,
    inventory_id CHAR(36) NOT NULL,      
    quantity INT NOT NULL,
    PRIMARY KEY (item_id, inventory_id),
    FOREIGN KEY (inventory_id) REFERENCES PLAYER_INVENTORY(inventory_id),
    FOREIGN KEY (item_id) REFERENCES GAME_ITEMS(id)
);

-- Create PLAYER_STORES table
CREATE TABLE IF NOT EXISTS PLAYER_STORES (
    store_id CHAR(36) PRIMARY KEY,
    player_id CHAR(36) NOT NULL,
    spent_money DECIMAL(10, 2) NOT NULL,
    refund_transactions INT NOT NULL,
    last_purchase TIMESTAMP NOT NULL,
    total_transactions INT NOT NULL, -- TODO: Add table PLAYER_TRANSACTIONS
    FOREIGN KEY (player_id) REFERENCES PLAYERS(player_id)
);

-- Create DEVICES table
CREATE TABLE IF NOT EXISTS DEVICES (
    id INT PRIMARY KEY,
    model VARCHAR(255) NOT NULL
);

-- Create FIRMWARES table
CREATE TABLE IF NOT EXISTS FIRMWARES (
    id INT PRIMARY KEY,
    firmware_version VARCHAR(50) NOT NULL,
    device_id INT NOT NULL,
    FOREIGN KEY (device_id) REFERENCES DEVICES(id)
);

-- Create CARRIERS table
CREATE TABLE IF NOT EXISTS CARRIERS (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create PLAYER_DEVICES table
CREATE TABLE IF NOT EXISTS PLAYER_DEVICES (
    player_device_id CHAR(36) PRIMARY KEY,
    player_id CHAR(36) NOT NULL,
    device_id INT NOT NULL,
    firmware_id INT NOT NULL,
    carrier_id INT NOT NULL,
    FOREIGN KEY (player_id) REFERENCES PLAYERS(player_id),
    FOREIGN KEY (device_id) REFERENCES DEVICES(id),
    FOREIGN KEY (firmware_id) REFERENCES FIRMWARES(id),
    FOREIGN KEY (carrier_id) REFERENCES CARRIERS(id)
);

-- Insert data into PLAYERS
INSERT INTO PLAYERS (player_id, country, birthdate, created, modified, language, gender)
VALUES 
('97983be2-98b7-11e7-90cf-082e5f28d836', 'CA', '2000-01-10 13:37:17', '2021-01-10 13:37:17','2021-01-23 13:37:17', 'fr', 'male');

INSERT INTO PLAYERS (player_id, country, birthdate, created, modified, language, gender)
VALUES (RANDOM_UUID(), 'US', '1990-01-01 00:00:00', '2022-01-01 00:00:00','2022-01-01 00:00:00', 'en', 'female');
INSERT INTO PLAYERS (player_id, country, birthdate, created, modified, language, gender)
VALUES (RANDOM_UUID(), 'PT', '1999-12-01 00:00:00', '2024-01-01 00:00:00','2024-01-01 00:00:00', 'pt', 'male');

-- Insert data into CLANS
INSERT INTO CLANS (clan_id, name, creation_date)
VALUES 
('123456', 'Hello world clan', '2021-01-01 00:00:00');

-- Insert data into PLAYER_PROFILES
INSERT INTO PLAYER_PROFILES (profile_id, player_id, level, xp, total_playtime, clan_id)
VALUES 
('1a2b3c4d-5e6f-7g8h-9i0j-1k2l3m4n5o6p', '97983be2-98b7-11e7-90cf-082e5f28d836', 3, 1000, 144,'123456');

-- Insert data into PLAYER_SESSION
INSERT INTO PLAYER_SESSION (session_id, player_id, credential, last_session)
VALUES 
('2b3c4d5e-6f7g-8h9i-0j1k-2l3m4n5o6p7q', '97983be2-98b7-11e7-90cf-082e5f28d836', 'apple_credential', '2021-01-23 13:37:17');

-- Insert data into PLAYER_INVENTORY
INSERT INTO PLAYER_INVENTORY (inventory_id, player_id, cash, coins)
VALUES 
('3c4d5e6f-7g8h-9i0j-1k2l-3m4n5o6p7q8r', '97983be2-98b7-11e7-90cf-082e5f28d836', 123, 123);

-- Insert data into GAME_ITEMS
INSERT INTO GAME_ITEMS (id, description, rarity, price)
VALUES 
(1, 'item_1', 'Rare', 100.00),
(34, 'item_34', 'Common', 50.00),
(55, 'item_55', 'Uncommon', 25.00);

-- Insert data into INVENTORY_ITEMS
INSERT INTO INVENTORY_ITEMS (item_id, inventory_id, quantity)
VALUES 
(1, '3c4d5e6f-7g8h-9i0j-1k2l-3m4n5o6p7q8r', 1),
(34, '3c4d5e6f-7g8h-9i0j-1k2l-3m4n5o6p7q8r', 3),
(55, '3c4d5e6f-7g8h-9i0j-1k2l-3m4n5o6p7q8r', 2);

-- Insert data into PLAYER_STORES
INSERT INTO PLAYER_STORES (store_id, player_id, spent_money, refund_transactions, last_purchase, total_transactions)
VALUES 
('4d5e6f7g-8h9i-0j1k-2l3m-4n5o6p7q8r9s', '97983be2-98b7-11e7-90cf-082e5f28d836', 400.00, 0, '2021-01-22 13:37:17', 5);

-- Insert data into DEVICES
INSERT INTO DEVICES (id, model)
VALUES 
(1, 'apple iphone 11');

-- Insert data into FIRMWARES
INSERT INTO FIRMWARES (id, firmware_version, device_id)
VALUES 
(123, '123', 1);

-- Insert data into CARRIERS
INSERT INTO CARRIERS (id, name)
VALUES 
(1, 'vodafone');

-- Insert data into PLAYER_DEVICES
INSERT INTO PLAYER_DEVICES (player_device_id, player_id, device_id, firmware_id, carrier_id)
VALUES 
('5e6f7g8h-9i0j-1k2l-3m4n-5o6p7q8r9s0t', '97983be2-98b7-11e7-90cf-082e5f28d836', 1, 123, 1);