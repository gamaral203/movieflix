🎬 MovieFlix

Sistema web para listagem e avaliação de filmes, onde usuários podem explorar títulos, visualizar detalhes e deixar avaliações.

📌 Sobre o projeto

O MovieFlix é uma aplicação back-end desenvolvida durante estudos/prática, que simula uma plataforma de filmes com autenticação de usuários e sistema de avaliações.

O sistema permite:

Listar filmes com paginação
Filtrar por gênero
Visualizar detalhes completos
Registrar avaliações (usuários autenticados)

Usuários podem ser:

👤 VISITOR → apenas visualiza
⭐ MEMBER → pode avaliar filmes

🚀 Funcionalidades
🔐 Autenticação com login (OAuth2 / JWT)
🎞️ Listagem de filmes paginada
🎯 Filtro por gênero
📄 Página de detalhes do filme
✍️ Cadastro de avaliações
👥 Controle de acesso por tipo de usuário

🛠️ Tecnologias utilizadas
🔙 Back-end
-Java 17+
-Spring Boot
-Spring Security
-OAuth2 / JWT
-JPA / Hibernate
-Maven

🗄️ Banco de dados
-PostgreSQL

📂 Estrutura do projeto

movieflix/
│
├── backend/        # API Spring Boot
├── front-web/      # Aplicação React
│
├── README.md
└── LICENSE

⚙️ Como executar o projeto
🔙 Back-end
Pré-requisitos:

-Java 17+
-Maven

# clonar repositório
git clone https://github.com/gamaral203/movieflix.git

# entrar no backend
cd movieflix/backend

# rodar o projeto
./mvnw spring-boot:run


🌐 API (exemplo)
GET /movies → lista filmes
GET /movies/{id} → detalhes
POST /criar → criar filmes


👨‍💻 Autor

Desenvolvido por Gabriel Amaral
