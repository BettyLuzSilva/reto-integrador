create table favorito(IdFavorito int identity(1,1) primary key, TipoFavorito varchar(5), NombreFavorito varchar(100), CodServicio varchar(3), IdCliente varchar(50) )

insert into [dbo].[favorito](TipoFavorito, NombreFavorito, CodServicio, IdCliente)
values(A', 'Telf casa', '010','08000401')