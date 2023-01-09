-- Insert de pessoas


insert into pessoa (nome,nascimento) values('Julio Lopez','1986-12-06');
insert into pessoa (nome,nascimento) values('Vanessa Alves','1975-02-16');
insert into pessoa (nome,nascimento) values('Lucca Mello','2000-01-28');
insert into pessoa (nome,nascimento) values('Alicia Motta','1994-10-13');
insert into pessoa (nome,nascimento) values('Ellyson Monarc','2003-07-07');
insert into pessoa (nome,nascimento) values('Herbert Fagundes','1966-08-23');
insert into pessoa (nome,nascimento) values('Carolina Vasquez','1993-11-30');


-- Insert de enderecos

insert into endereco (logradouro,cep,numero,cidade,principal,pessoa_id) values('Rua Projetada F','87307-022','311','Campo Mourão',false,1);
insert into endereco (logradouro,cep,numero,cidade,principal,pessoa_id) values('Rua Quarenta e Quatro-1','49044-469','340','Aracaju',true,1);
insert into endereco (logradouro,cep,numero,cidade,principal,pessoa_id) values('Rua Esperança','23065-069','140','Recife',false,1);