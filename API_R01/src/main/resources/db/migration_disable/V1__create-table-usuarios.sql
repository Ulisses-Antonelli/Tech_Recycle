create table usuarios(

    id bigint not null AUTO_INCREMENT,
    ativo tinyint NOT NULL, 
    nome varchar(100) not null,
    cpf varchar(10) not null unique,
    telefone varchar(20)NOT NULL,
    privilegio varchar(50) not null,
    email varchar(100) not null unique,
    password varchar(255)NOT NULL,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,

    primary key(id)
);