# Projet Donjon. 

## Développeurs : **geothere**

## Introduction : 
        * Donjon possédant des personnages joueurs et des monstres.
        * Donjon possédant différentes salles qui possèdent elles-mêmes différents objets/monstres.
        * Donjon possédant une sortie.
        * Donjon permettant les actions d'un personnage l'utilisation de certains objets.
                 
## How To : 
        * Récupérer le dépôt
        
        --- Commandes à effectuer dans le dossier COO/Donjon : ---
        * Générer la JavaDoc : > mvn javadoc:javadoc
        * Générer le projet : mvn package

        * Lire la JavaDoc : > COO/Donjon/target/docs
        * Exécuter le jar : java -jar target/Donjon-1.0-SNAPSHOT.jar

## Éléments de conception : 
        * J'ai décidé de concentrer nos efforts sur la mise en place d'un code simple mais fonctionnel.
        De ce fait, j'ai essayé de mettre à niveau nos méthodes notamment au niveau des constructeurs pour éviter tout
        doublon qui pourrait venir perturber l'équilibre du programme.
        Par exemple, dans la création d'une "Room" nous générons directement les Objets et Monstres liés à celle-ci afin d'éviter
        de devoir faire de plus amples manipulations pouvant rapidement générer des erreurs si celles-ci ne sont pas effectuées
        dans le bon ordre.
        * Utilisation de la classe Mock pour tester des objets génériques. 
        * Création d'une liste d'objets génériques afin de pouvoir générer ceux-ci aléatoirement quel que soit leur type.
        * Nous avons crée une classe principale permettant de gérer plus facilement le donjon : AdventureGame. Cet AdventureGame possède une énumération qui se nomme "WAY" nous permettant
        de définir clairement et simplement les directions à chaque salle. Cela est d'autant plus important pour le choix d'avancée dans le donjon
        
## Améliorations à pourvoir : 
        * Créer un donjon aléatoire permettant d'avoir un donjon différent à chaque nouvelle partie. Ce système a pour avantage de créer de la diversité mais peut-être compliqué à mettre
        en place dès lors qu'il faut relier les salles entre elles et crée une certaine logique au donjon (c'est à dire ne pas avoir 20 salles qui vont vers le NORTH pour aucune sortie)
        * Créer un marchand permettant la dépense d'argent.
        * Créer des niveaux augmentant les différentes statistiques (HP, Strength) du personnage. Cela demande aussi de modifier la façon dont nous déclarons les limites.
        * Créer une continuité dans le jeu en créant un système de "planque" permettant l'achat d'objet, de changer d'équipements...
        * Un fichier JSON avec différents monstres et statistiques.
        * Créer une map du donjon permettant de visualiser la construction de celui-ci.
        
## Difficultés : 
        * La difficulté majeure a été la mise en place des Tests qui s'est avérée plus difficile que prévu. En effet, nous n'avons pas opté pour une programmation
        de type "Test Driven Development" et nous avons été confronté à certains problèmes quand nous avons voulu mettre en place les tests APRÈS l'écriture de méthodes.
        De ce fait, nous penserons la prochaine fois à essayer une approche TDD afin de ressentir la différence et si cette option nous convient ou non.
        * La navigation entre les salles fut au début laborieuse bien que simple d'apparence et nous avons éprouvé quelques difficultés à mettre en place un système qui nous
        convenait totalement. Nous avons ainsi opté pour une énumération des directions permettant de se réperer plus facilement.
        
        
## Remarques : 
        * Pendant la phase de développement des tests nous avons eu des doutes quant à l'utilité de certains tests, 
        nous pensions directement faire des tests sur les classes "Action" par exemple mais nous nous sommes rapidement rendu compte que ces tests étaient établis 
        sur une méthode qui utilisait elle-même un enchaînement de méthodes déjà testées au préalable. De ce fait, nous avons décidé d'éviter de faire ce "doublon" 
        en nous basant uniquement sur des tests de méthodes faisant des actions concrètes.
        
## Diagramme UML : 

![Diagramme UML Donjon](https://i.imgur.com/Z5BdNQ6.png)
        
        