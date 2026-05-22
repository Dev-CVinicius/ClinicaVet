✅ PROJETO DEFINIDO (ETAPA 1)
Sistema: Petshop / Clínica Veterinária

Esse foi o projeto que estruturamos como ideia principal do PI.

📄 1. APRESENTAÇÃO

Sistema desktop desenvolvido em Java para gerenciamento de um petshop/veterinária, com foco em organizar cadastros de pets, tutores, profissionais e atendimentos.

📄 2. DESCRIÇÃO DO PROJETO

Sistema permite:

cadastro de tutores
cadastro de pets
cadastro de veterinários/profissionais
registro de consultas/atendimentos
emissão de receitas
consulta de histórico

📄 3. USUÁRIOS DO SISTEMA

Definimos 3 perfis:

👨‍💼 Administrador
acesso total ao sistema
🩺 Veterinário
consultas
receitas
histórico clínico
🧑‍💻 Atendente
cadastro de tutor
cadastro de pet
agendamentos

📄 4. NECESSIDADES E REGRAS DE NEGÓCIO

Necessidades
organizar atendimentos
evitar perda de dados
controlar histórico de pets
facilitar cadastro de clientes
Regras de negócio
um tutor pode ter vários pets
um pet pertence a apenas um tutor
uma consulta pertence a um pet e um veterinário
apenas administrador tem acesso completo
receitas são geradas após consultas

📄 5. REQUISITOS FUNCIONAIS

RF01 – cadastrar tutor
RF02 – cadastrar pet
RF03 – cadastrar veterinário
RF04 – registrar consulta
RF05 – emitir receita
RF06 – listar histórico
RF07 – login por perfil

📄 6. REQUISITOS NÃO FUNCIONAIS

sistema em Java
interface desktop (Swing)
banco de dados MySQL (futuro – Etapa 4)
sistema intuitivo
acessibilidade básica
validação de dados

RNF01 – O sistema deverá ser desenvolvido em Java
RNF02 – O banco de dados utilizado será MySQL
RNF03 – O sistema deverá possuir interface simples e intuitiva
RNF04 – O sistema deverá funcionar em computadores com Windows
RNF05 – O sistema deverá ser responsivo e acessível para diferentes perfis de usuário, incluindo idosos
RNF06 – O sistema deverá garantir armazenamento seguro dos dados
RNF07 – O sistema deve suportar pelo menos 1000 registros de atendimentos sem perda significativa de desempenho

📄7. Modelagem do Sistema
   
Entidades do Banco de Dados

(Tutor)

id
nome
telefone
endereço

(Pet)

id
nome
espécie
idade
tutor (FK)

(Profissional)
id
nome
especialidade

(Atendimento)

id
data
descrição
pet (FK)
profissional (FK)

📄8. Relações (UML)

Tutor 1 → N Pet
Pet 1 → N Atendimento
Profissional 1 → N Atendimento
11. Funcionalidades / Telas do Sistema
Tela de cadastro de tutor
Tela de cadastro de pet
Tela de cadastro de profissional
Tela de registro de atendimento
Tela de consulta / histórico de atendimentos


🧱 UML DEFINIDO

Classes:

Tutor
Pet
Veterinario
Consulta
Receita
Usuario (Login)
Relações:
Tutor 1 → muitos Pets
Pet 1 → muitas Consultas
Veterinario 1 → muitas Consultas
Consulta → Receita (1:1 ou 1:0..1)

