# CONSULTA FILMES

Este projeto tem como objetivo integrar a API da OMDB para pesquisar filmes e salvar informações relevantes em um arquivo `.json` chamado `Filmes.json`. As informações coletadas incluem o nome do filme, ano de lançamento e duração em minutos.

## Como Usar

1. **Inicie o programa**:  
   - Execute o programa no terminal.

2. **Pesquisar um filme**:  
   - Insira o nome do filme quando solicitado. Caso o filme não seja encontrado, tente escrever o nome em inglês.

3. **Sair do programa**:  
   - Para encerrar o programa, digite `Sair` no terminal.

4. **Verifique o arquivo `Filmes.json`**:  
   - Após realizar a pesquisa, você pode conferir as informações dos filmes no arquivo `Filmes.json`.

## Recursos

- **Interface via Terminal simples**: O programa permite a pesquisa de filmes diretamente no terminal.  
- **Uso de Maven e Gson**: Integração com o Maven para gerenciar dependências, incluindo o uso da biblioteca Gson para manipulação de dados JSON.  
- **Tratamento de exceções e erros**: O programa foi projetado para evitar falhas de execução, como erros ao buscar filmes na API.

## Instalação

1. Clone o repositório:  
   ```bash
   git clone https://github.com/Bielfy/api-filmes-omdb.git
   ```

2. Navegue até o diretório do projeto:  
   ```bash
   cd api-filmes-omdb
   ```

3. Compile o projeto usando Maven:  
   ```bash
   mvn clean install
   ```

4. Execute o programa:  
   ```bash
   mvn exec:java
   ```

## Estrutura do Projeto

- **`src/`**: Contém o código-fonte do projeto.  
- **`Filmes.json`**: Arquivo gerado com as informações dos filmes pesquisados.  
- **`pom.xml`**: Arquivo de configuração do Maven, que gerencia as dependências do projeto.

## Contribuições

Sinta-se à vontade para fazer melhorias no código ou sugerir novas funcionalidades. Se você encontrar algum problema, crie uma issue ou envie um pull request.

---

Este projeto foi criado por **Gabriel T**.
