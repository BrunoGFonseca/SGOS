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
- **Deletando Categorias com método DELETE**: Criação do método DELETE para a categoria_produtos e categoria_servicos. <br /><br />
- **Listando todas categorias usando DTO**: Criação dos DTOs da categorias e usando eles para exibir apenas as categorias sem os produtos relacioandos. <br /><br />
- **Paginação com parametros opcionais**: É possível paginar as categorias. <br /><br />
- **Validação sintática usando o BEAN VALIDATION**: Adicionando validações sem aceso a dados nos nomes das categorias. <br /><br />
- **Retorno da validação personalizado**: Criando um padrão para o retorno dos erros. <br /><br />
- **Criando método PUT, DELETE, GET para classe cliente**: Desenvolvendo CRUD para classe de clientes. <br /><br />
- **Ajustes**: Ajuste nas CategoriaService e no construtor do pagamento <br /><br />
- **Inserindo um cliente com o método POST**: Criação do metodo POST para a classe clientes <br /><br />
- **Ajuste na deleção de clientes**: Fazendo com que os endeços e veiculos de um cliente sejam deletados caso o cliente for excluido e não possuir pedidos <br /><br />
- **Validação customizada para CPF e CNPJ**: Foi criado uma validação customizada para os campos de CNPJ e CPF na inclusão do cliente <br /><br />
- **Validação customizada para CPF e CNPJ já existente**: Foi criado uma validação customizada para impedir que um cpf ou cnpj já cadastrado seja inserido <br /><br />
- **Ajuste ClienteService**: Adicionado a anotação @Transactional na classe ClienteService <br /><br />
- **Validação customizada: cpf ou cnpj repetido na atualização do cliente**: Foi criado uma validação customizada para impedir que um cpf ou cnpj já cadastrado seja inserido na atualização de um cliente <br /><br />
- **Busca de ordens por nome e categoria**: Criada a busca de ordem por nome e categoria <br /><br />
- **Adicionado valores totais de servicos, produtos e da ordem**: Adicionado as funções para calculo dos valores. <br /><br />
- **Inserindo um pedidos**: Ajustando sistema para receber pedidos. <br /><br />
- **Profile de TESTE criado**: Divisao dos profiles da aplicacao (TESTE). <br /><br />
- **Profile de DEV criado**: Divisao dos profiles da aplicacao (DEV). <br /><br />
- **Profile de PROD criado**: Divisao dos profiles da aplicacao (PROD) e criacao do arquivo procfile. <br /><br />
- **Adicionado System.properties**: System.properties criado. <br /><br />
- **criadno metodo toString da ordem de servico**: metodo toString das ordens de servico criado para converter a ordem para enviar via e-mail. <br /><br />
- **MockEmailService com Logger. Padroes Strategy e Template Method**: MockEmailService criado para simular o envio das ordens via email.<br /><br />
- **Implementando SmtpEmailService com servidor do Google**: SmtpEmailService criado para efetuar o envio das ordens via email.<br /><br />
- **Email em HTML**: Criando corpo do do email em HTML.<br /><br />
- **Correção do corpo HTML do e-mail**: Correção no corpo HTML dos e-mails para que os serviços fossem enviados junto aos produtos.<br /><br />
- **Configuração dos arquivos base para o funcionamento do Spring Security**: Criação da configuração inicial para utilização do Spring Security<br /><br />
- **Adicionando o campo de senha para o cliente**: Criação da senha para a classe cliente<br /><br />
- **Adicionando niveis de perfis ao projeto**: Criação dos perfis de Administrador e de clientes<br /><br />