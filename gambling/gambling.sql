CREATE DATABASE IF NOT EXISTS gambling;

USE gambling;

CREATE TABLE jugador (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  dni CHAR(10) UNIQUE NOT NULL,
  dinero DECIMAL(16, 2) NOT NULL DEFAULT 0,
  correo_electronico VARCHAR(255) UNIQUE NOT NULL,
  contrasenna CHAR(64) NOT NULL,
  telefono VARCHAR(15) UNIQUE NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE sorteo (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  fecha_apertura DATE NOT NULL,
  fecha_cierre DATE NOT NULL,
  fecha_hora DATETIME NOT NULL,
  tipo ENUM('LOTERIA_NACIONAL', 'QUINIELA', 'EUROMILLONES', 'PRIMITIVA', 'GORDO') NOT NULL,
  resultado JSON,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE apuesta (
  id_jugador BIGINT UNSIGNED NOT NULL,
  id_sorteo BIGINT UNSIGNED NOT NULL,
  fecha_apuesta DATE NOT NULL DEFAULT (CURRENT_DATE),
  estado ENUM('PENDIENTE', 'GANADA', 'PERDIDA') NOT NULL DEFAULT 'PENDIENTE',
  premio DECIMAL(10, 2),
  apuesta JSON,
  PRIMARY KEY (id_jugador, id_sorteo),
  FOREIGN KEY (id_jugador) REFERENCES jugador (id),
  FOREIGN KEY (id_sorteo) REFERENCES sorteo (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE INDEX index_jugador_fecha_apuesta ON apuesta (id_jugador, fecha_apuesta DESC);
