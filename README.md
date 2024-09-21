# SafeWallet

# Projeto de Carteira Digital

* Este projeto é uma API de carteira digital desenvolvida com o objetivo de fornecer uma solução segura e escalável para gerenciamento de saldo e transações financeiras. A API permite que os usuários se cadastrem, autentiquem, gerenciem seus saldos e realizem transações de forma eficiente e segura.

## Funcionalidades
       Cadastro de Usuário: Permite que novos usuários se cadastrem na plataforma.
       Autenticação e Autorização: Implementa login seguro e controle de acesso utilizando JWT.
       Gerenciamento de Saldo: Consultar, adicionar e subtrair saldo da carteira.
       Transações: Registrar e listar transações (depósitos, retiradas, transferências).
       Notificações: Enviar notificações para os usuários sobre transações e saldo.
       Histórico de Transações: Adicionar filtros como data, tipo de transação e paginação para otimizar consultas.
       Requisitos Não Funcionais
       Segurança: Utiliza criptografia para dados sensíveis e autenticação.
       Escalabilidade: Estrutura a API para suportar um grande número de usuários, utilizando Redis para cache.
       Desempenho: Garante tempos de resposta rápidos.
       Confiabilidade: Implementa testes e monitoramento contínuos com Spring Boot Actuator e Logback.
       Estrutura de Dados

       Usuário
       id: Identificador único do usuário.
       nome: Nome completo do usuário.
       email: Email do usuário.
       senha: Senha (armazenada de forma segura).
       dataCriacao: Data de criação da conta.

       Carteira
       id: Identificador único da carteira.
       usuarioId: Identificador do usuário dono da carteira.
       saldo: Saldo atual da carteira.
       dataCriacao: Data de criação da carteira.

       Transação
       id:Identificador único da transação.
       carteiraId: Identificador da carteira associada.
       tipo: Tipo de transação (depósito, retirada, transferência).
       valor: Valor da transação.
       dataTransacao: Data e hora da transação.

       Endpoints da API
       POST /usuarios: Criar um novo usuário.
       POST /login: Autenticar um usuário.
       GET /carteiras/{id}: Obter detalhes de uma carteira.
       POST /carteiras/{id}/deposito: Adicionar saldo à carteira.
       POST /carteiras/{id}/retirada: Retirar saldo da carteira.
       GET /carteiras/{id}/transacoes: Listar transações de uma carteira com filtros por data, tipo de transação e paginação.

       Tecnologias e Bibliotecas
       Spring Boot: Para criar a API.
       Spring Security: Para autenticação e autorização.
       Hibernate: Para mapeamento objeto-relacional (ORM).
       JWT: Para tokens de autenticação.
       PostgreSQL/MySQL: Como banco de dados.
       Redis: Para cache.
       Spring Boot Actuator: Para monitoramento.
       Logback: Para logs estruturados.