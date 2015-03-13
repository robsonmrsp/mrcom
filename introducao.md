# GisApp #

GisApp é uma tentativa de produzir uma aplicação/arquitetura simples que combine as sequintes tecnologias/frameworks:
  1. **GWT** par a camada de visão.
  1. **Spring** para fazer a injeção de dependencia e  segurança da aplicação.
  1. **Hibernate** para fazer a camada de persistencia
  1. **PostgreSql** é o Banco de dados utilizado
  1. **PostGis** é a extensão espacial do postgresql .
  1. **Maven** para fazer o controle de dependencia
  1. **Ant** para gerar os _Builds_ automáticos da aplicação.
  1. 
> Cada passo do desenvolvimento( que pudesse ser esquecido) foi descrito de forma grosseira em um arquivo chamado **Tentativa de criar um projeto.txt** de modo que na sequencia possamos fazer uma pagina Wiki em forma de tutorial.

# Details #

A aplicação consistirá em criar um objeto geométrico com a ajuda da api de mapas do GWT e persisti-lo no postgreSql/postgis com ajuda do Hibernate e Spring: