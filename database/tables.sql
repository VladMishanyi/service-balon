DROP DATABASE IF EXISTS db_balon;
CREATE DATABASE IF NOT EXISTS db_balon CHARSET = utf8 COLLATE = utf8_general_ci;
USE db_balon;

/*----------------------------------------------------------------------------------*/
DROP TABLE IF EXISTS trm202;
CREATE TABLE trm202 (
  id     int UNSIGNED NOT NULL AUTO_INCREMENT,
  date   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  holdingRegister0 FLOAT        NOT NULL DEFAULT 0,
  holdingRegister1 FLOAT        NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;