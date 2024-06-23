create database bdt2castillo;

CREATE TABLE Autor
(
 IdAutor 		INT NOT NULL AUTO_INCREMENT,
 NomAutor		VARCHAR(50) NOT NULL,
 ApeAutor 		VARCHAR(50) NOT NULL,
 FechNacAutor	DATE NOT NULL,
 PRIMARY KEY (IdAutor)
);
insert into autor values(null,"Alfredo","Castillo","25-02-15");
insert into autor values(null,"Karla","Castillo","25-02-16");
insert into autor values(null,"Key","Barzola","20-05-10");
insert into autor values(null,"Akiles","Castillo","25-02-17");
insert into autor values(null,"Briyi","Mendosa","27-02-13");

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
 insert into publicacion values(null,"Guerra Fria","matansa entre paises","2015-10-12",1);
 insert into publicacion values(null,"Perdedor","Quien gane es el mejor","2015-10-10",2);
 insert into publicacion values(null,"Huaco Derrumba todo","Feneomeno del niño","2015-10-14",3);
 insert into publicacion values(null,"Guerra Friañ","matansa entre paises","2015-11-17",4);
 insert into publicacion values(null,"Guerra Friam","matansa entre paises","2015-11-16",5);
  insert into publicacion values(null,"Guer","matansa  paises","2014-1-16",5);
 select *from publicacion;