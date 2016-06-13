CREATE TABLE IF NOT EXISTS users (
  id         INT AUTO_INCREMENT PRIMARY KEY,
  login      VARCHAR(128) NOT NULL,
  surname    VARCHAR(128),
  name       VARCHAR(128),
  patronymic VARCHAR(128),
  password   VARCHAR(256) NOT NULL,
  UNIQUE (login)
);

CREATE TABLE IF NOT EXISTS tournaments (
  id         INT AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(256) NOT NULL,
  start_date DATETIME     NOT NULL,
  UNIQUE (name, start_date)
);

CREATE TABLE IF NOT EXISTS schools (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(256) NOT NULL,
  UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS disciplines (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(48) NOT NULL,
  UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS weight_categories (
  id            INT AUTO_INCREMENT PRIMARY KEY,
  sex           CHAR        NOT NULL,
  min_age       INT         NOT NULL,
  max_age       INT         NOT NULL,
  min_weight    INT         NOT NULL,
  max_weight    INT         NOT NULL,
  name          VARCHAR(48) NOT NULL,
  weight_factor VARCHAR(24) NOT NULL,
  UNIQUE (name, weight_factor)
);

CREATE TABLE IF NOT EXISTS trainers (
  id         INT AUTO_INCREMENT PRIMARY KEY,
  surname    VARCHAR(128) NOT NULL,
  name       VARCHAR(128) NOT NULL,
  patronymic VARCHAR(128) NOT NULL,
  school_id  INT,
  FOREIGN KEY (school_id) REFERENCES schools (id)
    ON DELETE CASCADE,
  UNIQUE (surname, name, patronymic)
);

CREATE TABLE IF NOT EXISTS dojangs (
  id            INT AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(128) NOT NULL,
  tournament_id INT          NOT NULL,
  FOREIGN KEY (tournament_id) REFERENCES tournaments (id)
    ON DELETE CASCADE,
  UNIQUE (name, tournament_id)
);

CREATE TABLE IF NOT EXISTS sparrers (
  id                 INT AUTO_INCREMENT PRIMARY KEY,
  name               VARCHAR(128) NOT NULL,
  surname            VARCHAR(128) NOT NULL,
  trainer_id         INT          NOT NULL,
  first_trainer_id   INT          NOT NULL,
  kup                VARCHAR(24)  NOT NULL,
  sex                VARCHAR(24)  NOT NULL,
  birthday           DATE         NOT NULL,
  weight             INT          NOT NULL,
  tournament_id      INT          NOT NULL,
  weight_category_id INT          NOT NULL,
  FOREIGN KEY (trainer_id) REFERENCES trainers (id)
    ON DELETE CASCADE,
  FOREIGN KEY (first_trainer_id) REFERENCES trainers (id)
    ON DELETE CASCADE,
  FOREIGN KEY (tournament_id) REFERENCES tournaments (id)
    ON DELETE CASCADE,
  FOREIGN KEY (weight_category_id) REFERENCES weight_categories (id)
    ON DELETE CASCADE,
  UNIQUE (surname, name, birthday)
);

CREATE TABLE IF NOT EXISTS sparrers_disciplines (
  tournament_id INT NOT NULL,
  sparrer_id    INT NOT NULL,
  discipline_id INT NOT NULL,
  FOREIGN KEY (sparrer_id) REFERENCES sparrers (id)
    ON DELETE CASCADE,
  FOREIGN KEY (discipline_id) REFERENCES disciplines (id)
    ON DELETE CASCADE,
  FOREIGN KEY (tournament_id) REFERENCES tournaments (id)
    ON DELETE CASCADE,
  UNIQUE (tournament_id, sparrer_id, discipline_id)
);

CREATE TABLE IF NOT EXISTS sparrers_events (
  tournament_id INT NOT NULL,
  sparrer_id    INT NOT NULL,
  event_id      INT NOT NULL,
  FOREIGN KEY (sparrer_id) REFERENCES sparrers (id)
    ON DELETE CASCADE,
  FOREIGN KEY (event_id) REFERENCES events (id)
    ON DELETE CASCADE,
  FOREIGN KEY (tournament_id) REFERENCES tournaments (id)
    ON DELETE CASCADE,
  UNIQUE (tournament_id, sparrer_id, event_id)
);

CREATE TABLE IF NOT EXISTS events (
  id            INT AUTO_INCREMENT PRIMARY KEY,
  time          DATETIME,
  dojang_id     INT,
  tournament_id INT NOT NULL,
  discipline_id INT NOT NULL,
  winner_id     INT,
  phase         INT,
  FOREIGN KEY (dojang_id) REFERENCES dojangs (id)
    ON DELETE CASCADE,
  FOREIGN KEY (tournament_id) REFERENCES tournaments (id)
    ON DELETE CASCADE,
  FOREIGN KEY (discipline_id) REFERENCES disciplines (id)
    ON DELETE CASCADE
);

