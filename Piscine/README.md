# Projet Pisicine. 

## Développeurs : **geothere**

                 
## How To : 
        * Récupérer le dépôt
        --- Commandes à effectuer dans le dossier COO/Piscine : ---
        * Générer la JavaDoc : > mvn javadoc:javadoc
        * Générer le projet : mvn package

        * Lire la JavaDoc : > COO/Piscine/target/docs
        * Exécuter le jar : java -jar target/Piscine-1.0-SNAPSHOT.jar

## Éléments de conception : 
        * Utilisation de la généricité pour le développement et les tests (actions, resource et schedulers). 
        * Création d'une liste de resource génériques afin de pouvoir les utiliser quel que soit leur type (ResourcePool)

## Améliorations à pourvoir : 
        * Modifier SwimmingPool afin de pouvoir enregistrer des nageur dans une piscine
        * Creer des sous-types de Action afin de pouvoir optimiser l'affichage (DressingAction / UnDressingAction / SwimmingAction plutôt que ForeseableAction("undress"))
        
## Difficultés : 
        * Nous avons rencontré des problèmes de MERGE github lors de nos différents push. Nous avons compris le fonctionnement et nous sommes désormais capable de traiter ce problème sans perdre de code.
        
        
## Remarques : 
        * Nous avons volontairement omis les tests sur les méthodes get, status des actions.
        
## Diagramme UML : 

![Diagramme UML Piscine](https://i.imgur.com/pj7ULxn.jpg)
