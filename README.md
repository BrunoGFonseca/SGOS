# SGOS (Sistema de Gerenciamento de Ordens de Serviço)

Esse repositório está armazenando o SGOS, um sistema para controle de ordens de serviço para pequenas empresas. Esse sistema está sendo desenvolvido como trabalho de conclusão de curso (TCC) do graduando Bruno Gabriel Fonseca, orientado pelo Prof. Dr. Rodrigo de Oliveira Plotze (http://lattes.cnpq.br/4956606071703925).

## Configurações do projeto:
### BackEnd
- SpringTools STS 4.9.0
- Gerenciador de dependências MAVEN
- Java Version 11
- SpringBoot version 2.4.5
- Pacotes instalados SpringWEB

## Histórico de Commits:
Para um melhor desenvolvimento, eu decidi que iria montar o BackEnd da aplicação em duas partes. A primeira parte é composta pelas classes, relacionamentos e base de teste.

### Primeira Parte
- **Projeto Criado**: Criação dos arquivos de base para o correto funcionamento do projeto.<br /><br />
- **Testando o REST**: Criação da pasta de resources junto com os arquivos CategoriaProdutoResource e CategoriaServicoResource e testando o metodo get de ambos arquivos.<br /><br />
- **Testando duas primeiras classes de dominio**: Ajuste nas classes CategoriaProdutoResource e CategoriaServicoResource, mocando categorias para testes. <br /><br />
- **Banco de dados H2 e criação automatica da base de dados**: Configuração do H2 e a criação automatica da base de dados a partir das classes de dominio.<br /><br />
- **Criando Repository e Service para CategoriaProduto e CategoriaServico**: Criando classes de Repository e de Service para os produtos e para os serviços da aplicação.<br /><br />
- **Criando operação de instanciacao**: Criado as operações para instanciar categorias de servico e categorias de produtos.<br /><br />
- **Produto e serviço com associacao muitos para muitos**: Associacao muitos para muitos para os produtos e servicos criado. <br /><br />
- **Ajuste nos EndPoins /categoria_produtos{id} e /categoria_servicos{id}**: Adicionando tratativa de erro, para caso seja passado um ID nao cadastrado. <br /><br />
- **Estado e Cidade adicionados**: Categoria Estado e categoria Cidade adicionados ao projeto. <br /><br />
- **Cliente, TipoCliente, Telefone e Endereço - parte 1**: Nesse commit, foram adicionados as classes de cliente, TipoCliente (ENUM), Telefone(Entidade fraca, alocado dentro do cliente) e o Endereço. <br /><br />
- **Cliente, TipoCliente, Telefone e Endereço - parte 2**: Nesse commit, foram criados um cliente com seus respectivos endereços e telefones para testes <br /><br />
- **EndPoint /clientes/{id} criado**: Criação do acesso para os clientes via endpoint. <br /><br />
- **Veiculo adicionado**: Categoria Veiculo adicionada ao projeto. <br /><br />
- **Ordem de servico, EstadoPagamento e Pagamento**: Nesse commit as classes OrdemServiço, EstadoPagamento e Pagamento foram criadas. <br /><br />
- **ItemOrdem, ItemOrdemPk e ServicoOrdem, ServicoOrdemPK**: Nesse commit foi feito a relação entre os itens e serviços com as ordens. <br /><br />
- **EndPoint /ordens/{id} criado**: Criação do acesso para as ordens de servico via endpoint. <br /><br />
- **Atualizando para usar somente o JsonIgnore**: Ajuste nas classes de dominio. <br /><br />
- **Inserindo novas Categorias com método POST**: Criação do método POST para a categoria_produtos e categoria_servicos. <br /><br />
- **Atualizando Categorias com método PUT**: Criação do método PUT para a categoria_produtos e categoria_servicos. <br /><br />