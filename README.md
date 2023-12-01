# Objetivo do Projeto
Desenvolver um portal do aluno que permita o cadastro das notas dos estudantes e ofereça aos alunos a possibilidade de visualizar suas notas por disciplina de forma simples e acessível. Este projeto visa melhorar a comunicação entre professores e alunos, proporcionando uma plataforma centralizada para o registro e acompanhamento das notas, contribuindo assim para o sucesso acadêmico dos estudantes.

# Escopo
1. Cadastro de Usuários:
   * Desenvolvimento de um sistema de autenticação para os usuários.
   * Roles de acesso ( ADMINISTRADOR, PROFESSOR, ALUNO ).
2. Cadastro Disciplinas:
   * Implementação de funcionalidades para que os professores possam criar disciplinas.
3. Vincular Alunos a Disciplinas:
   * Implementação de funcionalidade para que os professores consigam vincular os alunos a disciplinas que eles ministrarão.
4. Cadastro de Notas:
   * Criação de um painel de administração para professores inserirem as notas dos alunos em cada disciplina.
   * Permitir a adição de alunos a disciplina específicas.
5. Visualização de Notas:
   * Criação de um painel do aluno onde os estudantes podem visualizar suas notas.
   * Apresentação das notas por disciplina, com média parcial e final.
6. Segurança e Privacidade:
   * Garantir a segurança dos dados dos alunos, implementando medidas de criptografia e autenticação segura.
7. Testes e Validação:
   * Realizar testes unitários e de integração no sistema para garantir seu funcionamento adequado.

[Diagrama de Classe.](https://github.com/joaoeffs/portal-aluno-java/blob/main/docs/diagrama-de-classe/V1.diagrama-de-classe.png)
</br>
[Diagrama de Sequência.](https://github.com/joaoeffs/portal-aluno-java/tree/main/docs/diagrama-de-sequencia)
     
# Stack e Arquitetura do Projeto
## Backend
  * Java 17
  * Spring boot
  * Maven

Será utilizado como arquitetura o modelo CQRS (Command Query Responsibility Segregation) é uma abordagem que separa a parte de leitura (queries) da parte de escrita (commands) em um sistema.
### Como vai funcionar:
  1. Comandos
     * Classes de comando para representar as operações que alteram o estado do sistema.
  2. Consultas
     * Classes de consulta para representar as operações de leitura.
  3. Modelo do Domínio
     * Classes Java que representam entidades e agregados.
     * Lógica de negócios dentro dessas classes.

A modelagem da arquitetura do projeto você pode encontrar aqui, acessando o [link.](https://github.com/joaoeffs/portal-aluno-java/blob/main/docs/arquitetura/V1.arquitetura-CQRS.png)

## Frontend
  * Angular 13
  * Node

  * Esse projeto tem repositório separados para Front e Back. Passa acessar o repositório do Front-End acessa esse https://github.com/joaoeffs/portal-aluno-angular

# Requisitos do Projeto
**Requisitos Funcionais:**

**1. Login de Usuários:**
   * **Descrição**: O sistema deve permitir que os usuários façam login de forma segura, atribuindo-lhes funções de ADMIN, PROFESSOR ou ALUNO.
   * **Funcionalidades**:
     * Autenticação segura.
     * Gerenciamento de perfis de usuário (ADMIN, PROFESSOR, ALUNO) durante o acesso.
       
**2. Cadastro de Disciplinas:**
   * **Descrição**: O sistema deve possibilitar que PROFESSOR crie disciplinas.
   * **Funcionalidades**:
     * Criação, alteração e gerenciamento de disciplinas.
       
**3. Vincular Alunos a Disciplinas:**
   * **Descrição**: O sistema deve possibilitar que PROFESSOR vincule alunos a disciplinas.
   * **Funcionalidades**:
     * Associação de alunos às disciplinas.
       
**4. Registro de Notas:**
   * **Descrição**: O sistema deve fornecer uma ferramenta para PROFESSOR insera notas dos alunos em cada disciplina.
   * **Funcionalidades**:
     * Painel de administração de notas para professores registrarem as notas dos alunos.
     * Funcionalidade de adicionar notas por disciplina.
       
**5. Visualização de Notas:**
   * **Descrição**: O sistema deve permitir que ALUNOS visualizem suas notas por disciplina, incluindo média parcial e final.
   * **Funcionalidades**:
     * Painel do aluno para visualização de notas.
     * Apresentação das notas por disciplina, incluindo médias parciais e finais.
   
**Requisitos Não Funcionais:**

**1. Segurança:**
   * **Descrição:** Implementação de criptografia e autenticação segura para proteger os dados dos usuários.
     
**2. Testes e Validação:**
   * **Descrição:** Realização de testes unitários e de integração para garantir a funcionalidade e confiabilidade do sistema.

**3. Desempenho e Escalabilidade:**
   * **Descrição:** O sistema deve ser capaz de lidar com um grande número de usuários e dados sem comprometer o desempenho.
     
**4. Usabilidade:**
   * **Descrição:** Interface de usuário intuitiva e fácil de navegar para todos os tipos de usuários (ADMIN, PROFESSOR e ALUNOS).

**5. Manutenção e Suporte:**
   * **Descrição:** O sistema deve ser fácil de manter e atualizar.

# Metodologia de Organização de Tarefas
Neste projeto, adotamos a abordagem do FDD (Feature Driven Development) para gerenciar o desenvolvimento de software. O FDD é uma metodologia que se concentra na entrega incremental e iterativa de funcionalidades específicas, o que nos permite atender de forma eficaz às necessidades do cliente e manter o controle do progresso do projeto.

## Pacotes de Entrega
### Pacote 1: Arquitetura e Infraestrutura do Projeto
  1. Comunicação entre Backend e Frontend
  2. Organização do Código
  3. Documentação do Código
  4. Pipeline
  5. Monitoramento de Qualidade

### Pacote 2: Disciplinas, Vínculos de alunos e Notas
  1. Registrar disciplinas
  2. Listar disciplinas
  3. Alterar disciplina
  4. Deletar disciplina
  5. Vincular aluno a disciplina
  6. Listagem de alunos vinculados a disciplina
  7. Registrar notas
  8. Listar notas
  9. Alterar notas
      
### Pacote 3: Autenticação e Registro dos Usuários
  1. Registrar usuário
  2. Segurança e autenticação

Para mais informações das tarefas e visualizar o andamento delas, entre no [Board.](https://joao-effting.atlassian.net/jira/software/projects/PA/boards/1)

# Infraestrutura

* AWS
  * EC2 (Back-End)
  * S3 (Front-End)
  * RDS (Database)

* Github Actions
  * CI/CD

# Monitoramento

### Monitoramento EC2
![Monitoramento EC2](https://github.com/joaoeffs/portal-aluno-java/assets/70415298/b901ae4c-3725-4863-bdc6-0e8f2cdef82a)

### Monitoramento RDS
![Monitoramento RDS](https://github.com/joaoeffs/portal-aluno-java/assets/70415298/65c98006-74b6-4711-9f3b-780180d3d3b4)

### Cobertura de Código
![SonarCloud](https://github.com/joaoeffs/portal-aluno-java/assets/70415298/2bbc139b-09bd-46c3-8964-b43f02604f0e)

Acesso para o [SonarCloud](https://sonarcloud.io/summary/overall?id=joaoeffs_portal-aluno-java).

# Acesso para a Aplicação em Produção
http://portalalunoapp.s3-website-sa-east-1.amazonaws.com/login

Para realizar o login como PROFESSOR, informar: </br>
E-mail -> admin@admin.com </br>
Senha  -> admin </br>

Para realizar o login como ALUNO, informar: </br>
E-mail -> joaoeffting@gmail.com </br>
Senha  -> 1234 </br>

# Contribuir com o Projeto

Caso você queria baixar o projeto na sua máquina local e subir o mesmo, afim de contribuir para melhorias ou para estudos academicos. Siga esses passos descritos abaixo. </br>
**Obs.:** Caso for contribuir, lembre de abrir um Pull Request para que a gente possa discutir as novas implementações.

### Java / Spring Boot
1. O primeiro passo é clonar o repositório, digite o comando: **git clone https://github.com/joaoeffs/portal-aluno-java**
2. Instale o Java JDK 17. Você pode baixá-lo acessando esse **https://www.oracle.com/java/technologies/downloads/#java17**
3. Define a variável de ambiente **JAVA_HOME** para o caminho onde o JDK está instalado.
4. Baixe algum Ambiente de Desenvolvimento Integrado (IDE) de sua preferência, que pode ser o IntelliJ IDEA, Eclipse ou Spring Tool Suite.
5. Adicione essa configuração nas suas Environment variables: **-spring.profiles.active=dev**
6. Execute o projeto, procure a classe principal do Spring Boot, com **@SpringBootApplication**
7. Após subir o projeto, o mesmo estará disponível na URL -> **http://localhost:8080**

### Banco de Dados
1. Baixe o banco de Dados PostgreSQL ou algum de sua preferência.
2. Crie um novo Banco de Dados
3. Configure a conexão no projeto no arquivo **application-dev.yml.**
