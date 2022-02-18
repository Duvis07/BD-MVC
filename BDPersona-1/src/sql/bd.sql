
/**
 * Author:  
 * Created: 25-may-2021
 */

create database empresa;

use empresa;

create table usuarios(
    documento varchar(50) not null,
    seguridad_social int not null,
    nombre varchar(100) not null,
    apellido varchar(100) not null,
    primary key(documento)
);

-- JDBC