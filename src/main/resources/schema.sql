CREATE TABLE IF NOT EXISTS TBL_PLAYERS (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    email VARCHAR(250) DEFAULT NULL
    );
--
--
-- CREATE TABLE IF NOT EXISTS TBL_APIKEYS (
--     id INT AUTO_INCREMENT  PRIMARY KEY,
--     apikey VARCHAR(250) NOT NULL,
--     last_call_time VARCHAR(250) NOT NULL,
--     call_count INT DEFAULT 0,
--     real_api VARCHAR(250) NOT NULL
--     );


-- CREATE TABLE IF NOT EXISTS APIKEY (
--     id INT AUTO_INCREMENT  PRIMARY KEY,
--     apikey VARCHAR(250) NOT NULL,
--     last_call_time VARCHAR(250) NOT NULL,
--     call_count INT DEFAULT 0,
--     real_api VARCHAR(250) NOT NULL
--     );