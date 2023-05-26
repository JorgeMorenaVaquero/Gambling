CREATE DATABASE IF NOT EXISTS gambling;

USE gambling;

CREATE TABLE jugador (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  dni CHAR(10) NOT NULL UNIQUE,
  dinero DECIMAL(16, 2) NOT NULL DEFAULT 0,
  correo_electronico VARCHAR(255) NOT NULL,
  contrasenna CHAR(64) NOT NULL,
  telefono VARCHAR(15) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE sorteo (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  fecha_apertura DATE NOT NULL,
  fecha_cierre DATE NOT NULL,
  fecha_hora_ DATETIME NOT NULL,
  resultado JSON,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE apuesta (
  id_jugador BIGINT UNSIGNED NOT NULL,
  id_sorteo BIGINT UNSIGNED NOT NULL,
  fecha_apuesta DATE NOT NULL DEFAULT NOW(),
  premio BOOLEAN,
  apuesta JSON,
  PRIMARY KEY (id_jugador, id_sorteo),
  FOREIGN KEY (id_jugador) REFERENCES jugador (id),
  FOREIGN KEY (id_sorteo) REFERENCES sorteo (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
