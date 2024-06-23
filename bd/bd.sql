create database bdt2castillo;

CREATE TABLE Autor
(
 IdAutor 		INT NOT NULL AUTO_INCREMENT,
 NomAutor		VARCHAR(50) NOT NULL,
 ApeAutor 		VARCHAR(50) NOT NULL,
 FechNacAutor	DATE NOT NULL,
 PRIMARY KEY (IdAutor)
);

CREATE TABLE Publicacion
(
 IdPublicacion 		INT NOT NULL AUTO_INCREMENT,
 Titulo 			VARCHAR(250) NOT NULL,
 Resumen 			VARCHAR(250) NOT NULL,
 FechPublicacion	DATE NOT NULL,
 IdAutor 			INT NOT NULL,
 PRIMARY KEY (IdPublicacion),
 FOREIGN KEY (IdAutor) REFERENCES Autor(IdAutor)
 );