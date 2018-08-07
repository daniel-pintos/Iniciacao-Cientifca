drop database Iniciacaojava;
create database IniciacaoJava;
use IniciacaoJava;

create table Cliente(
  idCliente int auto_increment,
  nomeCliente varchar(255),
  constraint pkCliente primary key (idCliente)
);

insert into Cliente(nomeCliente) values ('Daniel');
insert into Cliente(nomeCliente) values ('Joao');
insert into Cliente(nomeCliente) values ('Luciene');
insert into Cliente(nomeCliente) values ('Igor');
insert into Cliente(nomeCliente) values ('Gabriele');

create table Produto(
  idProduto int auto_increment,
  nomeProduto varchar(255),
  constraint pkProduto primary key (idProduto)
);

insert into Produto(nomeProduto) values ('carro');
insert into Produto(nomeProduto) values ('carro2');
insert into Produto(nomeProduto) values ('carro3');
insert into Produto(nomeProduto) values ('carro4');
insert into Produto(nomeProduto) values ('carro5');

create table Nota(
  idNota int auto_increment,
  idCliente int,
  idProduto int,
  notaProduto int,
  constraint fkProduto foreign key (idProduto) references Produto(idProduto),
  constraint fkCliente foreign key (idCliente) references Cliente(idCliente),
  constraint pkNota primary key (idNota)
);

insert into Nota(idProduto, idCliente, notaProduto) values (1,1,5);
insert into Nota(idProduto, idCliente, notaProduto) values (1,2,5);
insert into Nota(idProduto, idCliente, notaProduto) values (1,3,5);
insert into Nota(idProduto, idCliente, notaProduto) values (1,4,5);
insert into Nota(idProduto, idCliente, notaProduto) values (1,5,5);
insert into Nota(idProduto, idCliente, notaProduto) values (2,1,4);
insert into Nota(idProduto, idCliente, notaProduto) values (2,2,4);
insert into Nota(idProduto, idCliente, notaProduto) values (2,3,4);
insert into Nota(idProduto, idCliente, notaProduto) values (2,4,4);
insert into Nota(idProduto, idCliente, notaProduto) values (2,5,4);
insert into Nota(idProduto, idCliente, notaProduto) values (3,1,2);
insert into Nota(idProduto, idCliente, notaProduto) values (3,2,2);
insert into Nota(idProduto, idCliente, notaProduto) values (3,3,2);
insert into Nota(idProduto, idCliente, notaProduto) values (3,4,2);
insert into Nota(idProduto, idCliente, notaProduto) values (3,5,2);
insert into Nota(idProduto, idCliente, notaProduto) values (4,1,3);
insert into Nota(idProduto, idCliente, notaProduto) values (4,2,3);
insert into Nota(idProduto, idCliente, notaProduto) values (4,3,3);
insert into Nota(idProduto, idCliente, notaProduto) values (4,4,3);
insert into Nota(idProduto, idCliente, notaProduto) values (4,5,3);
insert into Nota(idProduto, idCliente, notaProduto) values (5,1,4);
insert into Nota(idProduto, idCliente, notaProduto) values (5,2,4);
insert into Nota(idProduto, idCliente, notaProduto) values (5,3,4);
insert into Nota(idProduto, idCliente, notaProduto) values (5,4,4);
insert into Nota(idProduto, idCliente, notaProduto) values (5,5,4);

select cl.nomeCliente, n.notaProduto, p.nomeProduto from cliente cl, nota n, produto p where n.idProduto = p.idProduto and cl.idCliente = n.idCliente and cl.idCliente = 2;



/*CRUD NOTA*/
select * from nota;
insert into nota(idNota, idCliente, idProduto, notaProduto) values (1,2,3,4);
UPDATE nota SET idNota = ?, idCliente = ? , idProduto = ? , notaProduto = ? WHERE idNota = ?;
delete from nota where idNota = ?;
select * from nota where id;

/*CRUD CLIENTE*/
select * from cliente;
insert into cliente(nomeCliente) values ('mateus');
update cliente set idCliente = ?, nomeCliente = ? where idCliente = ?;
delete from cliente where idCliente=?;


/*CRUD PRODUTO*/
select * from produto;
insert into produto(nomeProduto) values ('mateus');
update produto set idProduto = ?, nomeProduto = ? where idProduto = ?;
delete from produto where idProduto=?;

/*        *                   *     *                *
  [Cliente] -- <possuem>---- [ Nota ] ---< tem > --- [ Produto ]
  - idClient                   nota                  idProduto
  - nomeCliente                                      nomeProduto
*/
