DROP DATABASE IF EXISTS db_balon;
CREATE DATABASE IF NOT EXISTS db_balon CHARSET = utf8 COLLATE = utf8_general_ci;
USE db_balon;

/*----------------------------------------------------------------------------------*/
DROP TABLE IF EXISTS trm202;
CREATE TABLE trm202 (
  id                int UNSIGNED NOT NULL AUTO_INCREMENT,
  date              TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  holdingRegister0  FLOAT        NOT NULL DEFAULT 0,
  holdingRegister1  FLOAT        NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*----------------------------------------------------------------------------------*/
DROP TABLE IF EXISTS trm138;
CREATE TABLE trm138 (
                        id              int UNSIGNED NOT NULL AUTO_INCREMENT,
                        date            TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        inputRegister0  FLOAT        NOT NULL DEFAULT 0,
                        inputRegister1  FLOAT        NOT NULL DEFAULT 0,
                        inputRegister2  FLOAT        NOT NULL DEFAULT 0,
                        inputRegister3  FLOAT        NOT NULL DEFAULT 0,
                        inputRegister4  FLOAT        NOT NULL DEFAULT 0,
                        PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

SELECT * FROM trm202 ORDER BY date DESC LIMIT 1