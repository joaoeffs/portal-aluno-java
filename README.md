# Objetivo do Projeto
Desenvolver um portal do aluno que permita o cadastro das notas dos estudantes e ofereça aos alunos a possibilidade de visualizar suas notas por disciplina de forma simples e acessível. Este projeto visa melhorar a comunicação entre professores e alunos, proporcionando uma plataforma centralizada para o registro e acompanhamento das notas, contribuindo assim para o sucesso acadêmico dos estudantes.

# Escopo
1. Cadastro de Usuários:
   * Desenvolvimento de um sistema de autenticação para os usuários.
   * Roles de acesso ( ADMINISTRADOR, PROFESSOR, ALUNO ).
2. Cadastro Disciplinas:
   * Implementação de funcionalidades para que os professores possam criar disciplinas e associnar alunos a elas.
   * Permitir a adição de alunos a disciplina específicas.
3. Cadastro de Notas:
   * Criação de um painel de administração para professores inserirem as notas dos alunos em cada disciplina.
4. Visualização de Notas:
   * Criação de um painel do aluno onde os estudantes podem visualizar suas notas.
   * Apresentação das notas por disciplina, com média parcial e final.
5. Segurança e Privacidade:
   * Garantir a segurança dos dados dos alunos, implementando medidas de criptografia e autenticação segura.
   * Cumprimento de regulamentações de privacidade de dados, como a Lei Geral de Proteção de Dados (LGPD).
6. Testes e Validação:
   * Realizar testes unitários e de integração no sistema para garantir seu funcionamento adequado.
     
# Arquitetura do Projeto
* O frontend é desenvolvido em Angular 13, com componentes e serviços para a interface do usuário e comunicação com o backend.
* O backend usa Spring Boot e é dividido em controladores separados para comandos (alterações de dados) e consultas (leitura de dados).
* Há uma camada de comando para lidar com operações de modificação de dados e uma camada de consulta para responder às solicitações de leitura.
* A comunicação entre o frontend e o backend ocorre via HTTP/HTTPS, com autenticação JWT e validação de dados.
* Essa arquitetura permite uma separação eficiente de responsabilidades entre operações de leitura e escrita, visando melhor desempenho e escalabilidade.

# Requisitos do Projeto
**Requisitos Funcionais:**

**1. Cadastro de Usuários**:
   * **Descrição**: O sistema deve permitir que os usuários se cadastrem e façam login de forma segura, atribuindo-lhes funções de ADMINISTRADOR, PROFESSOR ou ALUNO.
   * **Funcionalidades**:
     * Registro de usuário.
     * Autenticação segura.
     * Atribuição de funções (ADMINISTRADOR, PROFESSOR, ALUNO) durante o registro.
       
**2. Cadastro de Disciplinas:**
   * **Descrição**: O sistema deve possibilitar que professores criem disciplinas e adicionem alunosa elas.
   * **Funcionalidades**:
     * Criação e alteração de disciplinas.
     * Adição de alunos a disciplinas específicas.
       
**3. Registro de Notas:**
   * **Descrição**: O sistema deve fornecer uma ferramenta para professores inserirem notas dos alunos em cada disciplina.
   * **Funcionalidades**:
     * Painel de administração de notas.
     * Inserção de notas por disciplina.
       
**4. Visualização de Notas:**
   * **Descrição**: O sistema deve permitir que estudantes visualizem suas notas por disciplina, incluindo média parcial e final.
   * **Funcionalidades**:
     * Painel do aluno para visualização de notas.
   
**Requisitos Não Funcionais:**

**1. Segurança e Privacidade:**
   * **Descrição:** O sistema deve garantir a segurança dos dados dos alunos e cumprir regulamentações de privacidade de dados, como a Lei Geral de Proteção de Dados (LGPD).
     
**2. Testes e Validação:**
   * **Descrição:** O sistema deve ter testes unitários e de integração para garantir seu funcionamento adequado.

# Modelagem do Projeto
