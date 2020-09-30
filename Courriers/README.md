# Projet Courrier

## Développeur : **geothere**

                 
## How To : 
        * Récupérer le dépôt
        
        --- Commandes à effectuer dans le dossier COO/Courriers : ---
        * Générer la JavaDoc : > mvn javadoc:javadoc
        * Générer le projet : mvn package
    
        * Lire la JavaDoc : > COO/Courriers/target/docs
        * Exécuter le jar : java -jar target/Courriers-1.0-SNAPSHOT.jar

## Éléments de conception : 
        * Utilisation de la généricité pour le développement et les tests (Letters, resource et schedulers). 
        * Utilisation du design pattern DECORATEUR pour certains types de lettres (Urgent, Register..).
        * Création de types de Context pour les différents types de lettres (Money, Text, listes d'habitants)

## Améliorations à pourvoir : 
        * Modifier les tests de FoolLetter (et/ou l'ajouter dans le LetterTest). Il est actuellement détaché de LetterTest.
        

## Tests: 
        * Deux simulations se trouvent dans le main. La première (firstSimulation) permet de tester les différents types de 
        lettres (sauf les FoolLetters). La deuxième teste uniquement le système de lettres "chaîne de naifs" avec les fool letters

## Remarques : 
        * Nous avons volontairement omis les tests sur les méthodes get et set.
        * [FOOL LETTERS] Afin de vous permettre de tester plus rapidement, nous avons modifier le pourcentage de chance du recepteur. 
        En effect, il a ~40% de chance de répondre au lieu de 10%
        
## Diagramme UML : 

![Diagramme UML Courriers](https://i.imgur.com/9on214L.png)
