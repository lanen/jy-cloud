CREATE SCHEMA IF NOT EXISTS eventuate;
USE eventuate;

drop table if exists message;

CREATE TABLE message (
  ID VARCHAR(64) PRIMARY KEY,
  DESTINATION VARCHAR(1000) NOT NULL,
  HEADERS VARCHAR(1000) NOT NULL,
  PAYLOAD VARCHAR(1000) NOT NULL,
  CREATION_TIME bigint(11)  DEFAULT '0'
);

drop table if exists received_messages;

CREATE TABLE received_messages (
  CONSUMER_ID VARCHAR(64),
  MESSAGE_ID VARCHAR(64),
  CREATION_TIME bigint(11)  DEFAULT '0',
  PRIMARY KEY(CONSUMER_ID, MESSAGE_ID)
);

drop table if exists offset_store;

CREATE TABLE offset_store (
  client_name VARCHAR(255) NOT NULL PRIMARY KEY,
  serialized_offset VARCHAR(255)
);