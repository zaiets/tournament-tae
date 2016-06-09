
#TODO REWRITE ALL


DROP SCHEMA IF EXISTS tournament_tae;

CREATE SCHEMA IF NOT EXISTS tournament_tae;

CREATE TABLE IF NOT EXISTS school (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(256) NOT NULL,
  UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS trainer (
  id         INT AUTO_INCREMENT PRIMARY KEY,
  surname    VARCHAR(128) NOT NULL,
  name       VARCHAR(128) NOT NULL,
  patronymic VARCHAR(128) NOT NULL,
  school_id  INT          NOT NULL,
  FOREIGN KEY (school_id) REFERENCES school (id)
    ON DELETE CASCADE,
  UNIQUE (surname, name, patronymic)
);

CREATE TABLE IF NOT EXISTS sparrer (
  id               INT AUTO_INCREMENT PRIMARY KEY,
  name             VARCHAR(128) NOT NULL,
  surname          VARCHAR(128) NOT NULL,
  trainer_id       INT          NOT NULL,
  sex              VARCHAR(48)  NOT NULL,
  age              INT          NOT NULL,
  weight           INT          NOT NULL,
  sparing          INT          NOT NULL,
  specialtechnique INT          NOT NULL,
  tul              INT          NOT NULL,
  kup_rate         INT          NOT NULL,
  FOREIGN KEY (trainer_id) REFERENCES trainer (id)
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS competitionslot (
  id           INT AUTO_INCREMENT PRIMARY KEY,
  sparrer_1_id INT,
  sparrer_2_id INT,
  winner_id    INT,
  FOREIGN KEY (sparrer_1_id) REFERENCES sparrer (id),
  FOREIGN KEY (sparrer_2_id) REFERENCES sparrer (id),
  FOREIGN KEY (winner_id) REFERENCES sparrer (id)
);