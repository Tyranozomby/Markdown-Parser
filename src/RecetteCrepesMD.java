
/**
 * TP1 INF2120 Hiver 2022
 * Tests PARTIELS des classes ElementTextuelMD et DocumentMD.
 * 
 * ATTENTION : Cette classe ne contient absolument pas tous les cas de tests 
 *             requis pour bien tester les deux classes. Vous devrez faire vos
 *             propres tests plus complets.
 * 
 * L'execution de la methode main de cette classe devrait afficher exactement 
 * ce qui est montre en commentaires au bas de cette classe : un document markdown 
 * d'une recette de crêpes savoureuse suivi de quelques autres tests.
 * 
 * Si ca vous interesse de voir ce que ca donne en HTML, vous pouvez convertir
 * le Markdown (affiche a la console) en HTML avec dingus : 
 * https://daringfireball.net/projects/markdown/dingus
 * 
 * @author Melanie Lord
 * @version Hiver 2022
 */
public class RecetteCrepesMD {
   
   public static void main(String[] args) {
      
      DocumentMD recette = new DocumentMD();
      
      try {
         recette.ajouterElementTextuel(  
            new ElementTextuelMD("CRÊPES AU BABEURRE", new Titre1()));

         recette.ajouterElementTextuel(
            new ElementTextuelMD("Recette de crêpes au babeurre tirée "
               + "de la chaine YouTube", new TexteSimple(StyleMD.BLOC)));

         recette.ajouterElementTextuel(
            new ElementTextuelMD("Tasty", new Emphase()));

         recette.ajouterElementTextuel(
            new ElementTextuelMD(".", new TexteSimple(StyleMD.LIGNE)));

         recette.ajouterElementTextuel(
            new ElementTextuelMD("Ingrédients", new Titre2()));
         
         
         recette.ajouterElementTextuel(
            new ElementTextuelMD("2 1/2 T. farine\n" +
                                 "3 c. à table sucre",
                                 new Liste(false)));
         
         recette.ajouterElementTextuel(
            new ElementTextuelMD("Préparation", new Titre2()));
         
         recette.ajouterElementTextuel(
            new ElementTextuelMD("Babeurre", new Titre3()));
         
         recette.ajouterElementTextuel(
            new ElementTextuelMD("Mélanger 2 - 3 c. à table de jus "
               + "de citron ou vinaigre avec 2 1/2 T. de lait entier.", 
               new TexteSimple(StyleMD.BLOC)));

         recette.ajouterElementTextuel(
            new ElementTextuelMD("Crêpes", new Titre3()));
         
         recette.ajouterElementTextuel(
            new ElementTextuelMD("Combiner les ingrédients secs en brassant " +
               "avec un fouet.\n" +
               "Mélanger les ingrédients liquides (sauf les blancs d'oeufs).\n" +
               "Ajouter le liquide  dans le solide et mélanger avec une spatule. \n" +
               "Incorporer les blancs d'oeufs au mélange.\n" +
               "Laisser reposer le mélange environ 15 - 30 minutes.\n" +
               "Dans une poêle, faire fondre du beurre à feu moyen.\n" +
               "Une fois le beurre fondu, baisser le feu à 3.\n" +
               "Placer 1/3 T. du mélange dans la poêle.\n" +
               "Tourner la crêpe lorsque des bulles apparaissent à la surface, "
                  + "et cuire environ 2 minutes de l'autre côté.", 
            new Liste(true)));
         
         recette.ajouterElementTextuel(4, 
            new ElementTextuelMD("https://www.youtube.com/watch?v=BPl7D20F2mE&"
               + "feature=em-uploademail", 
               new TexteSimple(StyleMD.BLOC)));


         recette.remplacerElementTextuel(6, 
            new ElementTextuelMD("2 1/2 T. farine\n" +
                                 "3 c. à table sucre\n" +
                                 "2 c. à thé sel\n" +
                                 "1 c. à thé poudre à pâte\n" +
                                 "1 c. à thé bicarbonate de soude\n" +
                                 "2 1/2 T. babeurre (voir préparation "
                                    + "ci-dessous)\n" +
                                 "1 bâton de beurre non salé fondu\n" +
                                 "2 jaunes d'oeufs\n" +
                                 "2 blancs d'oeufs", new Liste(false)));
         
         recette.ajouterElementTextuel(  //13 elts
            new ElementTextuelMD("A EFFACER", new Titre1()));
         
         recette.modifierStyle(4, 
            new Hyperlien(
               "https://www.youtube.com/watch?v=BPl7D20F2mE&feature=em-uploademail", 
               StyleMD.BLOC));
         
         recette.supprimerElementTextuel(12);  //devient 12 elts
         
         recette.modifierTexte(4, 
            "Cliquer ici pour visionner la recette sur YouTube");

         //Afficher le document MD
         System.out.println(recette);

         
         //------------------------------------   
         
         System.out.println("\nAUTRES TESTS\n");
         
         System.out.println(recette.taille());  //12
         
         System.out.println(recette.obtenirElementTextuel(4));
         
         System.out.println(recette.obtenirMarkdown(0));
         
      } catch (Exception e) {
         System.err.println("ERREUR : " + e.getClass());
      }
   }
   
}

/*

CRÊPES AU BABEURRE
==================

Recette de crêpes au babeurre tirée de la chaine YouTube
**Tasty**
.

[Cliquer ici pour visionner la recette sur YouTube](https://www.youtube.com/watch?v=BPl7D20F2mE&feature=em-uploademail)

Ingrédients
-----------

* 2 1/2 T. farine
* 3 c. à table sucre
* 2 c. à thé sel
* 1 c. à thé poudre à pâte
* 1 c. à thé bicarbonate de soude
* 2 1/2 T. babeurre (voir préparation ci-dessous)
* 1 bâton de beurre non salé fondu
* 2 jaunes d'oeufs
* 2 blancs d'oeufs

Préparation
-----------

### Babeurre

Mélanger 2 - 3 c. à table de jus de citron ou vinaigre avec 2 1/2 T. de lait entier.

### Crêpes

1. Combiner les ingrédients secs en brassant avec un fouet.
2. Mélanger les ingrédients liquides (sauf les blancs d'oeufs).
3. Ajouter le liquide  dans le solide et mélanger avec une spatule. 
4. Incorporer les blancs d'oeufs au mélange.
5. Laisser reposer le mélange environ 15 - 30 minutes.
6. Dans une poêle, faire fondre du beurre à feu moyen.
7. Une fois le beurre fondu, baisser le feu à 3.
8. Placer 1/3 T. du mélange dans la poêle.
9. Tourner la crêpe lorsque des bulles apparaissent à la surface, et cuire environ 2 minutes de l'autre côté.


AUTRES TESTS

12

[Cliquer ici pour visionner la recette sur YouTube](https://www.youtube.com/watch?v=BPl7D20F2mE&feature=em-uploademail)


CRÊPES AU BABEURRE
==================

*/