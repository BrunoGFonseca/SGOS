# SGOS (Sistema de Gerenciamento de Ordens de Serviço)

Esse repositório está armazenando o SGOS, um sistema para controle de ordens de serviço para pequenas empresas. Esse sistema está sendo desenvolvido como trabalho de conclusão de curso (TCC) do graduando Bruno Gabriel Fonseca, orientado pelo Prof. Dr. Rodrigo de Oliveira Plotze (http://lattes.cnpq.br/4956606071703925).

## Configurações do projeto:
### BackEnd
- SpringTools STS 4.9.0
- Gerenciador de dependências = MAVEN
- Java Version 11
- SpringBoot version 2.4.5
- Pacotes instalados SpringWEB

## Histórico de commits:

- **Projeto Criado**: Criação dos arquivos de base para o correto funcionamento do projeto.
- **Testando o REST**: Criação da pasta de resources junto com os arquivos CategoriaProdutoResource e CategoriaServicoResource e testando o metodo get de ambos arquivos.
- **Testando duas primeiras classes de dominio**: Ajuste nas classes CategoriaProdutoResource e CategoriaServicoResource, mocando categorias para testes. 
- **Banco de dados H2 e criação automatica da base de dados**: Configuração do H2 e a criação automatica da base de dados a partir das classes de dominio.
- **Criando Repository e Service para CategoriaProduto e CategoriaServico**: Criando classes de Repository e de Service para os produtos e para os serviços da aplicação.
- **Criando operação de instanciacao**: Criado as operações para instanciar categorias de servico e categorias de produtos.
- **Produto e serviço com associacao muitos para muitos**: Associacao muitos para muitos para os produtos e servicos criado. 
- **Ajuste nos EndPoins /categoria_produtos{id} e /categoria_servicos{id}**: Adicionando tratativa de erro, para caso seja passado um ID nao cadastrado. 
- **Estado e Cidade adicionados**: Categoria Estado e categoria Cidade adicionados ao projeto. 