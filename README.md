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
