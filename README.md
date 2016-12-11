# Projet IFI 2016 : Spring MVC blog

*Durand Jean-Frédéric & Frolkova Vasilina*

## Pré-requis

* une base de donnée mySQL
* maven

## Lancement du projet

* Via l'IDE Intellij il suffit de cliquer sur "run"
* les réglages sont à configurer dans le dossier src/main/resources/application.properties

Réglages correspondant à la base de données :

```
spring.datasource.driver-class-name = com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost/blog_db?characterEncoding=utf8&autoReconnect=true&useSSL=false
spring.datasource.username = blog
spring.datasource.password = blog
```

Si à chaque lancement, la base doit être nettoyer alors il faut décommenter cette ligne :

```
# spring.jpa.properties.hibernate.hbm2ddl.auto = create
```

# Fonctionnalités implémentées

* S'enregistrer, Se connecter, Se déconnecter
* Voir la liste de tous les posts
* Créer des posts
* Consulter le profil des utilisateurs
* Consulter les posts des utilisateurs
* la page d'accueil affiche uniquement les 5 posts les plus récents.

# Bref descriptions des fichiers

* Dans le dossier data est fournie une implémentation des tables users et posts qui peut être importé directement dans la nouvelle base. Cela correspond à des fixtures.
* src/main/java/blog contient les différentes fonctionnalités implémentés sur le projet à savoir :
  * les controlleurs (controllers)
  * les formulaires (forms) : ajouter un nouveau post, se connecter et s'enregistrer
  * les modèles (models) : User et Post
  * les repositories (repositories)
  * les services et leurs implémenntations (services)
* src/main/resources/templates contients les différents templates utilisés pour les différentes pages de l'application.
* src/main/resources/templates/layout contients les layouts génériques pour l'ensemble des pages.
* pom.xml 
