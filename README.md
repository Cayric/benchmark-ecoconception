
# benchmark-ecoconception

Ce projet a pour but de comparer la consommation en ressource de différents services réalisant la même tâche métier et écrit dans différents langages. Les framework utilisés pour chaque service sont massivement utilisés en entreprises et c’est pourquoi ils ont été choisis.


## Service

Le service expose une API pouvant créer une bibliothèque simplifiée. Le but étant d’avoir plusieurs relations et des objets métier lourds (les livres auront un résumé et une image)
## Les différents langages

**Java:** Java 17, Spring Boot

**JavaScript:** Node, Express

**Python:** ??

**PHP:** ??

Pour chaque langage, les services existeront sous différentes forme :
* Avec ORM
* Sans ORM
* Avec pagination
* Sans pagination

## La base de données

Le système de gestion de bases de données relationnelles utilisé est MySQL.

La base de données existera sous deux formes :
* Sans index
* Avec index

## Les scénarios

Les scénarios seront lancés depuis JMeter

Le premier scénario créera unitairement des bibliothèque, des auteurs et des livres.

Le deuxième scénario créera en masse les bibliothèques, les auteurs et les livres.

## API Reference

#### Obtenir toutes les bibliothèques

```http
  GET /library
```


#### Obtenir tous les auteurs

```http
  GET /author
```

#### Obtenir tous les livres

```http
  GET /book
```
