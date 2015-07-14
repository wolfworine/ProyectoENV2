DROP DATABASE IF EXISTS bd_proyPE;
CREATE DATABASE IF NOT EXISTS bd_proyPE;
USE bd_proyPE;

create table nivel(
nivelid varchar(1) primary key,
niveldes varchar(30)
);

-- select * from nivel;
insert into nivel(nivelid, niveldes) values("1","Administrador");
insert into nivel(nivelid, niveldes) values("2","Empleado");
insert into nivel(nivelid, niveldes) values("3","Usuario");

create table usuario(
usernom varchar(10) primary key,
userpwd varchar(10),
nombre varchar(100),
correo varchar(100),
nivel varchar(1), 
CONSTRAINT `fk_nivelid` FOREIGN KEY (`nivel`)
REFERENCES `nivel` (`nivelid`)
);


-- drop table usuario;

-- select * from usuario;
insert into usuario(usernom, userpwd, nombre, correo, nivel) values("admin", "admin", "manuel","madmin@gmail.com","1");
insert into usuario(usernom, userpwd, nombre, correo, nivel) values("adminemp", "admin", "Jahir","K9999_jair@hotmail.com","2");
insert into usuario(usernom, userpwd, nombre, correo, nivel) values("adminusu", "admin", "Carlos","carlos123@gmail.com","3");




/*CREATE TABLE tb_administrador(
adm_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
adm_nombre VARCHAR(50) NOT NULL,
adm_apellido VARCHAR(50) NOT NULL,
adm_telefono INT NOT NULL,
adm_correo VARCHAR(20) NOT NULL,
adm_contraseña VARCHAR(20) NOT NULL );

INSERT INTO tb_administrador(adm_nombre, adm_apellido, adm_telefono, adm_correo, adm_contraseña)
	values ('Jair', 'Cancharis', '921861422', 'jairc612@gmail.com', '12345');*/
    
    

/*
CREATE TABLE tb_usuarios(
usu_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
usu_nombre VARCHAR(50) NOT NULL,
usu_apellido VARCHAR(50) NOT NULL,
usu_telefono INT NOT NULL,
usu_correo VARCHAR(50) NOT NULL,
usu_contraseña VARCHAR(20) NOT NULL );

INSERT INTO tb_usuarios(usu_nombre, usu_apellido, usu_telefono, usu_correo, usu_contraseña)
	values ('Alexander', 'Sanvodal', '977863782', 'K9999_jair@hotmail.com', '12345'),
    ('Carlos', 'Barboza', '966521352', 'carlos123@gmail.com', '12345'),
    ('Juan', 'Urbina', '988546325', 'jurbina@gmail.com', '12345');*/
    
CREATE TABLE tb_categorias(
cat_id VARCHAR(10) NOT NULL PRIMARY KEY AUTO_INCREMENT, 
cat_descripcion VARCHAR(250) NOT NULL );

INSERT INTO tb_categorias(cat_descripcion)
	values ('Accion'),
    ('Aventura'),
    ('Lucha');

CREATE TABLE tb_ofertas(
of_id VARCHAR(10) not null primary key auto_increment,
of_descripcion varchar(250) not null,
of_fechaini date not null,
of_fechafin date not null );

INSERT INTO tb_ofertas(of_descripcion, of_fechaini, of_fechafin)
	values ('10% de nuestro catalogo.', '2015-06-01', '2015-06-30'),
    ('20% de nuestro catalogo.', '2015-06-15', '2015-06-30'),
    ('30% de nuestro catalogo.', '2015-07-01', '2015-07-31');
    
CREATE TABLE tb_videojuegos(
vj_id VARCHAR(10) NOT NULL PRIMARY KEY AUTO_INCREMENT, 
vj_titulo VARCHAR(50) NOT NULL,
vj_descripcion VARCHAR(250) NOT NULL,
vj_stock int not null,
vj_precio double(4,2) NOT NULL,
vj_precio_descuento double(4,2),
cat_id int,
of_id int,
FOREIGN KEY(cat_id) REFERENCES tb_categorias(cat_id),
FOREIGN KEY(of_id) REFERENCES tb_ofertas(of_id));

INSERT INTO tb_videojuegos(vj_titulo, vj_descripcion, vj_stock, vj_precio, vj_precio_descuento, cat_id, of_id)
	values ('Left 4 Dead 2', 'Sobrevive de una horda de zombies en este juego accion coperativo.', 20, 49.99,  44.99,1, 1),
    ('Ultra Street Fighter IV', 'El mejor juego de lucha ahora en su edicion ULTRA.', 20, 69.99, 55.99,3, 2),
    ('Batman Arkham Knight', 'Juega el ultimo capitulo de la saga hecho por Rocksteady Studios.', 20, 89.99, 62.99, 2, 3);
 
 /*
CREATE TABLE tb_compras(
com_id int not null primary key auto_increment,
usu_id int not null,
vj_id int not null,
FOREIGN KEY(usu_id) REFERENCES tb_usuarios(usu_id),
FOREIGN KEY(vj_id) REFERENCES tb_videojuegos(vj_id) );

CREATE TABLE tb_servicios(
se_id int not null primary key auto_increment,
se_nombre varchar(30) not null,
se_descripcion VARCHAR(250) not null,
se_costo double(2,2) not null );
*/
