# Projet PLUGINS. 

## Développeurs : **geothere**.

                 
## How To : 
        * Récupérer le dépôt
        * Générer le projet : mvn package
                * Lire la JavaDoc : > COO/plugins/target/docs
        * Exécuter le jar : java -jar target/plugins-1.0-SNAPSHOT.jar

        --- Afin d'assurer le bon fonctionnement de projet et des tests, merci de suivre la démarche suivante  ---
        * Ajouter le classpath REPOSITORY suivant: ./repository/
        * Sous eclipse >
                - RUN CONFIGURATIONS
                - Main (Java Application) ou (JUnit)
                - Cliquer sur l'onglet CLASSPATH
                - Selectionner USER ENTRIES
                - Cliquer sur ADVANCED puis ADD EXTERNAL FOLDER
                - à partir de plugins, il se trouve dans: plugins/repository/


### Quelques tests avec l'exercice 5
        * Lancer le Main dans le dossier src/main/java/plugin.
        * La fenêtre JFrame devrait s'ouvrir. De base, il y a 2 plugins fonctionnels dans le repertoire repository, ils sont présent dans le menu plugin de la fenetre JFrame.
        * Comme test, vous pouvez aller dans le dossier repository/plugins et :
                - supprimer un .class et regarder la modification dans le JFrame
                - ajouter un .class qui n'a pas la bonne signature (ne fait rien)
                - Ouvrir un fichier txt dans le JFrame
                - Lancer CesarCode.class pour tester le plugin


## Éléments de conception : 
        * Utilisation du design pattern OBSERVER
   
## Difficultés : 
        * Je n'ai pas reussi à réaliser le test pour montrer que le scanner de dossier fonctionne. Mon problème était le suivant: sans while, la fonction ne s'execute pas et donc, pour les tests, c'est indésirable. Le while bloque les tests, je l'ai donc mis en commentaire pour que les suivants soient réalisés.

