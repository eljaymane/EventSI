# Microservices pour la gestion d'évenements
Le projet est composé de :
- Un service d'authentification : (BDD: db-auth)
- Un service gérant les données de l'application (BDD: db-events)
- un client web [Angular]

Les services de discovery et gateway sont désactivés.

## Dépendences
- Le serveur de la base de données est MYSQL

## Authentification :

- L'authentification à l'API se fait en appellant localhost:10002/authenticate 
-> Body : {'username','password'}

- L'enregistrement à l'api se fait en appellant localhost:10002/register 
-> Body : {'username','password'}

L'ajout des roles : ROLE_USER,ROLE_ADMIN,ROLE_SYSTEM et d'un compte (username: system, password: system, ROLE: SYSTEM) est nécessaires au fonctionnement des services

