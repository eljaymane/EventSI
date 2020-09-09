# Microservices pour la gestion d'un musée
Le projet est composé de :
- Un service d'authentification : (BDD: bootdb)
- Un service gérant les données du musée (BDD: db-musee)
- Un client admin [JavaFX]
- un client web [Angular]

Les services de discovery et gateway sont désactivés.

## Dépendences

- Le client admin nécessite l'ajout des librairies dans les libraries global du projet (disponible dans le dossier 'libs')
- Le serveur de la base de données est MYSQL

## Authentification :

- L'authentification à l'API se fait en appellant localhost:10002/authenticate 
-> Body : {'username','password'}

- L'enregistrement à l'api se fait en appellant localhost:10002/register 
-> Body : {'username','password'}

L'ajout des roles : ROLE_USER,ROLE_ADMIN,ROLE_SYSTEM et d'un compte (username: system, password system, ROLE: SYSTEM) est nécessaires au fonctionnement des services

LHOUSSAINE OUSTANI  :

 -Client web angular + api muséé + model

 Aymane El Jahrani  : 

 - Client admin JFX + api auth + api musée + gateway/discovery (désactivé)