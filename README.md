# Exemple d'utilisation de l'héritage multiple d'interfaces et de la généricité au sein de Spring Boot

## Mise en place d'un package prêt à l'emploi afin d'effectuer des opérations de recherche REST sur la propriété connue d'une entité inconnue dans Spring Boot

Les fichiers présents dans ce dépôt sont un exemple de la façon dont on peut implémenter un `contrôleur`, un `service` et un `repository` afin d'effectuer des opérations prêtes à l'emploi sur une entité dont on ne connait pas le type mais qui possèderait une propriété `name`.

## Le contrôleur

L'interface `HasNameEntityController` possède des méthodes génériques liées à la  route principale du contrôleur qui implémentera cette interface sur la méthode `GET`, appellant les méthodes de `HasNameService` du même nom et retournant un jeu de données en fonction des paramètres de requête fournis.

Les paramètres de requête sont les variables ajoutées à la fin d'une url. Ex: `http://localhost?[variable]=[valeur]`

## Le service

Le service `HasNameService` possède des méthodes génériques aux même noms des méthodes de son repository `hasNameRepository` qui fait le lien entre l'entité et ses instances en base de données.

## Le repository

`HasNameRepository` est annoté `@NoRepositoryBean`, il n'est donc pas `Autowired`. Les Repositories qui l'implémentent sont enrichies des opérations de ce dernier. 

Jpa dispose d'un système d'instanciation des méthodes d'une interface annotée `@Repository` et étendant JpaRepository qui respectent une syntaxe en camelCase de type `[operation]By[Propriété](Type valeur)` etc. 

Ici par exemple la méthode `findByNameStartingWith` enrichit le repository l'étendant d'une recherche des entitées qui ont un nom commençant par la valeur fournie dans un interval produit par un objet `Pageable`.

Une interface peut étendre un nombre illimité d'interface, contrairement à une classe qui ne peut étendre qu'une classe.

De ce fait, un repository étant une interface, il peut être enrichi par héritage d'un nombre illimité d'opérations CRUD via d'autre interfaces disposant de méthodes de repository ;)

Il est donc possible d'écrire un jeu de nombreux repositories disposant de méthodes CRUD et de les faire hériter par les repositories de votre application Spring Boot (opérations sur un age, une taille, un poids...)

## Pagination

Pageable est une classe qui permet de paginer les recherches dans une méthode findBy d'un repository. Une instance de cette classe est ajoutée en dernier argument des méthodes de repository.

`PageRequest.of(page,size)` produit une instance de `Pageable` ou `page` est le numéro de la page dans laquelle on récupère un jeu de données et `size` est le nombre de données dans cette page. Ainsi si l'on cherche les 25 premières entitées de la première page on écrite `PageRequest.of(0,25)`, les 12 entités de la page 2 : `PageRequest.of(1,12)`.

## Généricité

La généricité permet de dire à une classe ou une méthode qu'elle va accueillir ou traiter une classe dont on ne connait pas encore le type. `ArrayList` ou encore ici `ResponseEntity` sont des classe génériques qui acceptent n'importe quelle classe entre leurs chevrons `<>`. 

Grace à la généricité, il est possible de réutiliser plus facilement sont code. 

`ArrayList` stocke des données de type inconnu et `ResponseEntity` dans Spring Boot renvoie des données sérialisées en json sur le modèle de l'entité qu'on lui donne grace à `Jackson` par exemple :)

Dans notre cas, Les interfaces de ce projet disposent de méthodes génériques. Il n'y a donc pas à s'inquiéter de définir le type de l'entité sur laquelle on travaille, il est deviné à l'éxécution de la méthode.  

## H2

Une base de donnée h2 est produite et un jeu de données est produit au lancement du projet dans le fichier de configuration `PostConstructionActions`.

Le fichier `applications.properties` est le suivant:

```bash 
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
```

h2-console est activé.

## Exemple de recherche REST

Cet exemple permet de faire des recherches sur les animaux dont le nom commence, termine, contient ou ne contient pas un texte.

La liste des noms est :

snoopy, tina, sam, sally, ulysse, chipie, rocky, roxane, max, princesse, lady, oscar, ugo, tequila, simba, ramses, teddy, titus, maya, tania, samy, filou, tomy, lucky, junior, socrate, vanille, gribouille, choupette, nina, sandy, saphir, tara, lola, romeo, roxy, stella, prince, belle, tom, tyson, pacha, reglisse, scotty, rusty, caramel, roxanne, benji, milou, paco, sacha, tommy, caline, oliver, sultan, theo, rex, scott, nougat, roucky, samba, tess, théo, luna, nicky, praline, titeuf, topaze, enzo, kenzo, noisette, ruby, saxo, oceane, sweety, tessy, titan, voyou, charly, leo, spike, stan, suzy, tango, léo, perle, prisca, sissi, whisky, dolly, popeye, rita, taz, titi, fanny, felix, nala, roméo, toby, twist.

Lancez le serveur via votre ide ou le shell avec maven.

### Commence par:

http://localhost:8080/animal?name_starts_with=r&page=0&size=25

### Termine par:

http://localhost:8080/animal?name_ends_with=na&page=0&size=25

### Contient:

http://localhost:8080/animal?name_contains=a&page=0&size=25

### Ne contient pas:

http://localhost:8080/animal?name_contains_not=y&page=0&size=25


## Conclusion

La généricité et l'héritage multiple d'interfaces permettent de réutiliser facilement du code et enrichir facilement et rapidement les composant d'une application Spring Boot. 

C'est un gain de temps non négligeable lors du développement d'une application.

N'hésitez pas à ajouter des données dans la base ou produire votre propre paquet réutilisable sur une autre propriété d'entité ;)
