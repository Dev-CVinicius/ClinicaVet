📄 Sistema de Gerenciamento para Petshop / Clínica Veterinária

1. Apresentação
O sistema de gerenciamento para petshop é um software desktop desenvolvido em Java com o objetivo de auxiliar no controle dos atendimentos realizados em pets, além de organizar cadastros de tutores, pets, profissionais e serviços oferecidos pelo estabelecimento.
O sistema será desenvolvido utilizando o NetBeans IDE e banco de dados MySQL, funcionando como uma aplicação interna para facilitar a gestão e o registro das informações do petshop.


2. Descrição do Projeto
O sistema permitirá o gerenciamento completo das operações básicas de um petshop, incluindo:
Cadastro de tutores
Cadastro de pets
Cadastro de profissionais (veterinários e funcionários)
Registro de atendimentos (banho, tosa, consultas, etc.)
Consulta de histórico de serviços
Gerenciamento de estoque de produtos
Controle e organização das informações do estabelecimento
Os dados serão armazenados em banco de dados MySQL, garantindo organização, persistência e facilidade na consulta das informações.


3. Descrição dos Usuários
Os principais usuários do sistema serão:
Recepcionistas / Funcionários: responsáveis por realizar cadastros, agendamentos e registros de atendimentos.
Profissionais (Veterinários): podem visualizar seus atendimentos e consultar informações dos pets atendidos.
Administrador / Gerente: responsável pelo controle geral do sistema, incluindo histórico de atendimentos, gestão de profissionais e controle de estoque.


4. Necessidades Observadas e Regras de Negócio

Necessidades
Organizar os dados de pets, tutores e profissionais
Facilitar o registro e consulta de atendimentos
Evitar perda de informações
Melhorar o controle dos serviços prestados
Garantir histórico completo dos atendimentos

Regras de Negócio
Um tutor pode possuir vários pets
Cada pet deve estar vinculado a um único tutor
Um atendimento deve estar associado a um pet e a um profissional
Um profissional pode realizar diferentes tipos de serviços
Não é permitido cadastrar pets sem tutor
Os atendimentos devem conter data, pet, tutor e profissional
Profissionais e atendimentos não podem ser duplicados no mesmo horário
O sistema deve manter histórico completo dos atendimentos


5. Requisitos Funcionais
RF01 – Cadastrar tutores
RF02 – Cadastrar pets
RF03 – Cadastrar profissionais
RF04 – Registrar atendimentos
RF05 – Consultar histórico de atendimentos
RF06 – Listar pets cadastrados
RF07 – Alterar informações cadastrais
RF08 – Gerenciar estoque de produtos


6. Requisitos Não Funcionais
RNF01 – O sistema deverá ser desenvolvido em Java
RNF02 – O banco de dados utilizado será MySQL
RNF03 – O sistema deverá possuir interface simples e intuitiva
RNF04 – O sistema deverá funcionar em computadores com Windows
RNF05 – O sistema deverá ser responsivo e acessível para diferentes perfis de usuário, incluindo idosos
RNF06 – O sistema deverá garantir armazenamento seguro dos dados
RNF07 – O sistema deve suportar pelo menos 1000 registros de atendimentos sem perda significativa de desempenho


7. Modelagem do Sistema
Entidades do Banco de Dados
Tutor
id
nome
telefone
endereço

Pet
id
nome
espécie
idade
tutor (FK)

Profissional
id
nome
especialidade

Atendimento
id
data
descrição
pet (FK)
profissional (FK)


8. Relações (UML)
Tutor 1 → N Pet
Pet 1 → N Atendimento
Profissional 1 → N Atendimento


9. Funcionalidades / Telas do Sistema
Tela de cadastro de tutor
Tela de cadastro de pet
Tela de cadastro de profissional
Tela de registro de atendimento
Tela de consulta / histórico de atendimentos

