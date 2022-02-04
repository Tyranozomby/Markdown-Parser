
import java.util.Locale;

/**
 * TP1 INF2120 H22. 
 * Classe de tests pour les methodes de la hierarchie de classes StyleMD.
 * @author Melanie Lord
 * @version Hiver 2022
 */
public class TestsStyleMD {

   private static double totalPoints = 0;
   private static final int TOTAL = 58;
   private static final int NOTE_MAX = 25;
   
   private static StyleMD style;
   private static StyleMD s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12;
   
   //---------------------------------
   //METHODES UTILITAIRES
   //---------------------------------
   
   /**
    * Affiche le titre donne en majuscule et entre deux lignes de tirets de 
    * meme longueur.
    * @param titre le titre a afficher.
    */
   public static void titre (String titre) {
      String s = "\n";
      for (int i = 0 ; i < titre.length() ; i++) {
         s = s + "-";
      }
      s = s + "\n" + titre.toUpperCase() + "\n";
      for (int i = 0 ; i < titre.length() ; i++) {
         s = s + "-";
      }
      System.out.println(s);
   }
   
   /**
    * Affiche un message d'erreur
    * @param msg le message d'erreur a afficher.
    */
   private static void err(String msg) {
      System.out.println(msg + "\n");
   }
   
   /**
    * Affiche un message de confirmation pour un test reussi.
    * @param points le nombre de points alloues pour ce test.
    * @return le nombre de points alloues pour ce test.
    */
   private static int ok(int points) {
      System.out.println("OK");
      return points;
   }
   
   /**
    * Affiche un message d'erreur pour une exception inattendue levee dans une
    * methode.
    * @param e l'exception levee.
    */
   public static void exceptionInattendue(Exception e) {
      System.out.println("ERREUR - " + e.getClass().getSimpleName() 
              + " inattendue.");
   }

   /**
    * Affiche le score pour une section de tests.
    * @param points nombre de points accumules pour cette section
    * @param total maximum de points pour cette section
    */
   private static void scoreInter(double points, double total) {
      totalPoints = totalPoints + points;
      System.out.println("\nPoints : " + points + " / " + total);
      System.out.println();
   }
   
   /**
    * Affiche le score final et la note finale ponderee.
    */
   private static void afficherScore () {
      double note = (totalPoints * NOTE_MAX) / (double)TOTAL;
      double pointsTotal = totalPoints;
      double total = TOTAL;
      double noteMax = NOTE_MAX;
      
      System.out.printf (Locale.ENGLISH, "\nSCORE FINAL : %3.1f / %3.1f", 
         pointsTotal, total);
      System.out.println();
      System.out.printf (Locale.ENGLISH, "\nNOTE FINALE : %3.1f / %3.1f", 
         note, noteMax);
      System.out.println("\n");
   }
   
   /**
    * Encadre le texte donne avec un caractere '<' avant et un caractere '>' 
    * après.
    * @param texte, le texte a encadrer
    * @return le texte encadre
    */
   public static String encadrer(String texte) {
      return "<\n" + texte + "\n>";
   }
   
   /**
    * Initialise dix styles pour les tests.
    */
   public static void initTests() {
      System.out.println("Preparation des tests => creation de differents styles : ");
      System.out.println(
            "  s1 = new Titre1();\n" +
            "  s2 = new Titre2();\n" +
            "  s3 = new Titre3();\n" +
            "  s4 = new Liste(true);\n" +
            "  s5 = new Liste(false);\n" +
            "  s6 = new TexteSimple(StyleMD.BLOC);\n" +
            "  s7 = new TexteSimple(StyleMD.LIGNE);\n" +
            "  s8 = new Emphase();\n" +
            "  s9 = new Hyperlien(\"http://uqam.ca\", StyleMD.BLOC);\n" +
            "  s10 = new Hyperlien(\"https://www.google.com\", StyleMD.LIGNE);");
      
      s1 = new Titre1();
      s2 = new Titre2();
      s3 = new Titre3();
      s4 = new Liste(true);
      s5 = new Liste(false);
      s6 = new TexteSimple(StyleMD.BLOC);
      s7 = new TexteSimple(StyleMD.LIGNE);
      s8 = new Emphase();
      s9 = new Hyperlien("http://uqam.ca", StyleMD.BLOC);
      s10 = new Hyperlien("https://www.google.com", StyleMD.LIGNE);
   }
   
   //---------------------
   // METHODES DE TESTS
   //---------------------
   
   /**
    * Tests qui verifient le style Titre1.
    */
   public static void testsStyleMDTitre1() {
      double points = 0;
      double total = 4;

      int nbrAttendu;
      int nbrTrouve;
      String sTrouvee;
      String sAttendue;
         
      titre ("tests style Titre1");
      
      try {

         try {
            System.out.println("style = new Titre1()");
            style = new Titre1();
            
            try {
               System.out.print("- style.getDisposition()... ");

               nbrAttendu = StyleMD.BLOC;
               nbrTrouve = style.getDisposition();

               if (nbrAttendu == nbrTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + nbrAttendu 
                     + "\n\n*** Trouve *** :\n" + nbrTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(null)... ");
               sAttendue = "\n" + null + "\n====\n";
               sTrouvee = style.formater(null);
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"Ceci est un titre 1\")... ");
               sAttendue = "\n" + "Ceci est un titre 1" + "\n===================\n";
               sTrouvee = style.formater("Ceci est un titre 1");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"\\n\\n    Ceci est un "
                  + "titre 1   \\n \\n\\t\")... ");
               sAttendue = "\n" + "Ceci est un titre 1" + "\n===================\n";
               sTrouvee = style.formater("\n\n    Ceci est un titre 1   \n \n\t");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }

         } catch (Exception e) {
            exceptionInattendue(e);
         }

      } catch (Exception e) {
         exceptionInattendue(e);
      }   
      scoreInter(points, total);
   }
   
   
   /**
    * Tests qui verifient le style Titre2.
    */
   public static void testsStyleMDTitre2() {
      double points = 0;
      double total = 4;

      int nbrAttendu;
      int nbrTrouve;
      String sTrouvee;
      String sAttendue;
         
      titre ("tests style Titre2");
      
      try {

         try {
            System.out.println("style = new Titre2()");
            style = new Titre2();
            
            try {
               System.out.print("- style.getDisposition()... ");

               nbrAttendu = StyleMD.BLOC;
               nbrTrouve = style.getDisposition();

               if (nbrAttendu == nbrTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + nbrAttendu 
                     + "\n\n*** Trouve *** :\n" + nbrTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(null)... ");
               sAttendue = "\n" + null + "\n----\n";
               sTrouvee = style.formater(null);
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"Ceci est un titre 2\")... ");
               sAttendue = "\n" + "Ceci est un titre 2" + "\n-------------------\n";
               sTrouvee = style.formater("Ceci est un titre 2");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"\\n\\n    Ceci est un "
                  + "titre 2   \\n \\n\\t\")... ");
               sAttendue = "\n" + "Ceci est un titre 2" + "\n-------------------\n";
               sTrouvee = style.formater("\n\n    Ceci est un titre 2   \n \n\t");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
         } catch (Exception e) {
            exceptionInattendue(e);
         }

      } catch (Exception e) {
         exceptionInattendue(e);
      }   
      scoreInter(points, total);
   }
   
   
   /**
    * Tests qui verifient le style Titre3.
    */
   public static void testsStyleMDTitre3() {
      double points = 0;
      double total = 4;

      int nbrAttendu;
      int nbrTrouve;
      String sTrouvee;
      String sAttendue;
         
      titre ("tests style Titre3");
      
      try {

         try {
            System.out.println("style = new Titre3()");
            style = new Titre3();
            
            try {
               System.out.print("- style.getDisposition()... ");

               nbrAttendu = StyleMD.BLOC;
               nbrTrouve = style.getDisposition();

               if (nbrAttendu == nbrTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + nbrAttendu 
                     + "\n\n*** Trouve *** :\n" + nbrTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(null)... ");
               sAttendue = "\n### " + null + "\n";
               sTrouvee = style.formater(null);
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"Ceci est un titre 3\")... ");
               sAttendue = "\n### " + "Ceci est un titre 3\n";
               sTrouvee = style.formater("Ceci est un titre 3");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"    \\n   Ceci est un "
                  + "titre 3\\n\\n\\n  \")... ");
               sAttendue = "\n### " + "Ceci est un titre 3\n";
               sTrouvee = style.formater("    \n   Ceci est un titre 3\n\n\n  ");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
         } catch (Exception e) {
            exceptionInattendue(e);
         }

      } catch (Exception e) {
         exceptionInattendue(e);
      }   
      scoreInter(points, total);
   }

   
   /**
    * Tests qui verifient le style Liste.
    */
   public static void testsStyleMDListe() {
      double points = 0;
      double total = 10;

      int nbrAttendu;
      int nbrTrouve;
      boolean bAttendu;
      boolean bTrouve;
      String sTrouvee;
      String sAttendue;
         
      titre ("tests style Liste");
      
      try {

         try {
            System.out.println("style = new Liste(true)");
            style = new Liste(true);
            
            try {
               System.out.print("- style.getDisposition()... ");

               nbrAttendu = StyleMD.BLOC;
               nbrTrouve = style.getDisposition();

               if (nbrAttendu == nbrTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + nbrAttendu 
                     + "\n\n*** Trouve *** :\n" + nbrTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- ((Liste)style).isNumerotee()... ");
               bAttendu = true;
               bTrouve = ((Liste)style).isListeNumerotee();
               
               if (bAttendu == bTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(null)... ");
               sAttendue = "\n1. null\n";
               sTrouvee = style.formater(null);
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            
            try {
               System.out.print("- style.formater("
                  + "\"Etape 1\\nEtape 2\\nEtape 3\")... ");
               sAttendue = "\n1. Etape 1\n2. Etape 2\n3. Etape 3\n";
               sTrouvee = style.formater("Etape 1\nEtape 2\nEtape 3");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            
            try {
               System.out.print("- style.formater(\"\\n\\n  Etape 1\\nEtape "
                  + "2\\nEtape 3\\n \\n\")... ");
               sAttendue = "\n1. Etape 1\n2. Etape 2\n3. Etape 3\n";
               sTrouvee = style.formater("\n\n  Etape 1\nEtape 2\nEtape 3\n \n");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }

         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         //------------------------------------------------------------------
         
         
         try {
            System.out.println("\nstyle = new Liste(false)");
            style = new Liste(false);
            
            try {
               System.out.print("- style.getDisposition()... ");

               nbrAttendu = StyleMD.BLOC;
               nbrTrouve = style.getDisposition();

               if (nbrAttendu == nbrTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + nbrAttendu 
                     + "\n\n*** Trouve *** :\n" + nbrTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- ((Liste)style).isNumerotee()... ");
               bAttendu = false;
               bTrouve = ((Liste)style).isListeNumerotee();
               
               if (bAttendu == bTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(null)... ");
               sAttendue = "\n* null\n";
               sTrouvee = style.formater(null);
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            
            try {
               System.out.print("- style.formater(\"Pomme\\nPoire\\n"
                  + "Banane\\nOrange\")... ");
               sAttendue = "\n* Pomme\n* Poire\n* Banane\n* Orange\n";
               sTrouvee = style.formater("Pomme\nPoire\nBanane\nOrange");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            
           try {
               System.out.print("- style.formater(\"    \\n\\nPomme\\nPoire\\n"
                  + "Banane\\nOrange\\n   \\n\")... ");
               sAttendue = "\n* Pomme\n* Poire\n* Banane\n* Orange\n";
               sTrouvee = style.formater("    \n\nPomme\nPoire\nBanane\n"
                  + "Orange\n   \n");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
         } catch (Exception e) {
            exceptionInattendue(e);
         }


      } catch (Exception e) {
         exceptionInattendue(e);
      }   
      scoreInter(points, total);
   }
   
   
   /**
    * Tests qui verifient le style TexteSimple.
    */
   public static void testsStyleMDTexteSimple() {
      double points = 0;
      double total = 11;

      int nbrAttendu;
      int nbrTrouve;
      String sTrouvee;
      String sAttendue;
         
      titre ("tests style texte simple");
      
      try {
         
         try {
            System.out.println("style = new TexteSimple(-1)");
            style = new TexteSimple(-1);
            
            try {
               System.out.print("- style.getDisposition()... ");

               nbrAttendu = StyleMD.BLOC;
               nbrTrouve = style.getDisposition();

               if (nbrAttendu == nbrTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + nbrAttendu 
                     + "\n\n*** Trouve *** :\n" + nbrTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         //------------------

         try {
            System.out.println("\nstyle = new TexteSimple(StyleMD.BLOC)");
            style = new TexteSimple(StyleMD.BLOC);
            
            try {
               System.out.print("- style.getDisposition()... ");

               nbrAttendu = StyleMD.BLOC;
               nbrTrouve = style.getDisposition();

               if (nbrAttendu == nbrTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + nbrAttendu 
                     + "\n\n*** Trouve *** :\n" + nbrTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(null)... ");
               sAttendue = "\n" + null + "\n";
               sTrouvee = style.formater(null);
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"Ceci est une phrase.\")... ");
               sAttendue = "\nCeci est une phrase.\n";
               sTrouvee = style.formater("Ceci est une phrase.");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"Ceci est une phrase.\\nCeci "
                  + "est un enonce et\\nun autre enonce.\")... ");
               sAttendue = "\nCeci est une phrase.<br/>"
                  + "Ceci est un enonce et<br/>un autre enonce.\n";
               sTrouvee = style.formater("Ceci est une phrase.\nCeci est "
                  + "un enonce et\nun autre enonce.");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"\\n\\n  Ceci est une phrase."
                  + "\\nCeci est un enonce et\\nun autre enonce.\\n\\n\\n\")... ");
               sAttendue = "\nCeci est une phrase.<br/>"
                  + "Ceci est un enonce et<br/>un autre enonce.\n";
               sTrouvee = style.formater("\n\n  Ceci est une phrase.\nCeci est "
                  + "un enonce et\nun autre enonce.\n\n\n");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }

            
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         //--------------------------
         
         
         try {
            System.out.println("\nstyle = new TexteSimple(StyleMD.LIGNE)");
            style = new TexteSimple(StyleMD.LIGNE);
            
            try {
               System.out.print("- style.getDisposition()... ");

               nbrAttendu = StyleMD.LIGNE;
               nbrTrouve = style.getDisposition();

               if (nbrAttendu == nbrTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + nbrAttendu 
                     + "\n\n*** Trouve *** :\n" + nbrTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(null)... ");
               sAttendue = null + "\n";
               sTrouvee = style.formater(null);
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            

            try {
               System.out.print("- style.formater(\"Ceci est une phrase.\")... ");
               sAttendue = "Ceci est une phrase.\n";
               sTrouvee = style.formater("Ceci est une phrase.");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"Ceci est une phrase.\\nCeci "
                  + "est un enonce et\\nun autre enonce.\")... ");
               sAttendue = "Ceci est une phrase.<br/>"
                  + "Ceci est un enonce et<br/>un autre enonce.\n";
               sTrouvee = style.formater("Ceci est une phrase.\nCeci est "
                  + "un enonce et\nun autre enonce.");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"\\n\\n  Ceci est une phrase."
                  + "\\nCeci est un enonce et\\nun autre enonce.\\n\\n\\n\")... ");
               sAttendue = "Ceci est une phrase.<br/>"
                  + "Ceci est un enonce et<br/>un autre enonce.\n";
               sTrouvee = style.formater("\n\n  Ceci est une phrase.\nCeci est "
                  + "un enonce et\nun autre enonce.\n\n\n");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
         } catch (Exception e) {
            exceptionInattendue(e);
         }

      } catch (Exception e) {
         exceptionInattendue(e);
      }   
      scoreInter(points, total);
   }
   
   /**
    * Tests qui verifient le style Emphase
    */
   public static void testsStyleMDEmphase() {
      double points = 0;
      double total = 4;

      int nbrAttendu;
      int nbrTrouve;
      String sTrouvee;
      String sAttendue;
         
      titre ("tests style Emphase");
      
      try {

         try {
            System.out.println("style = new Emphase()");
            style = new Emphase();
            
            try {
               System.out.print("- style.getDisposition()... ");
               nbrAttendu = StyleMD.LIGNE;
               nbrTrouve = style.getDisposition();

               if (nbrAttendu == nbrTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + nbrAttendu 
                     + "\n\n*** Trouve *** :\n" + nbrTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(null)... ");
               sAttendue = "**null**\n";
               sTrouvee = style.formater(null);
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"texte important !\")... ");
               sAttendue = "**texte important !**\n";
               sTrouvee = style.formater("texte important !");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"\\n    "
                  + "texte important !    \\n\\t\")... ");
               sAttendue = "**texte important !**\n";
               sTrouvee = style.formater("\n    texte important !    \n\t");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
         } catch (Exception e) {
            exceptionInattendue(e);
         }

      } catch (Exception e) {
         exceptionInattendue(e);
      }   
      scoreInter(points, total);
   }
   
   /**
    * Tests qui verifient le style Hyperlien.
    */
   public static void testsStyleMDHyperlien() {
      double points = 0;
      double total = 11;

      int nbrAttendu;
      int nbrTrouve;
      String sTrouvee;
      String sAttendue;
         
      titre ("tests style hyperlien");
      
      try {

         try {
            System.out.println("style = new Hyperlien(\"http://uqam.ca\", 3)");
            style = new Hyperlien("http://uqam.ca", 3);
            
            try {
               System.out.print("- style.getDisposition()... ");

               nbrAttendu = StyleMD.BLOC;
               nbrTrouve = style.getDisposition();

               if (nbrAttendu == nbrTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + nbrAttendu 
                     + "\n\n*** Trouve *** :\n" + nbrTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         //------------------
         
         try {
            System.out.println("\nstyle = new Hyperlien(null, StyleMD.BLOC)");
            style = new Hyperlien(null, StyleMD.BLOC);
            
            try {
               System.out.print("- ((Hyperlien)style).getUrl()... ");

               sAttendue = Hyperlien.URL_DEFAUT;
               sTrouvee = ((Hyperlien)style).getUrl();

               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + sAttendue 
                     + "\n\n*** Trouve *** :\n" + sTrouvee);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         //------------------
         
         try {
            System.out.println("\nstyle = new Hyperlien(\"\", StyleMD.BLOC)");
            style = new Hyperlien("", StyleMD.BLOC);
            
            try {
               System.out.print("- ((Hyperlien)style).getUrl()... ");
               sAttendue = Hyperlien.URL_DEFAUT;
               sTrouvee = ((Hyperlien)style).getUrl();

               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + sAttendue 
                     + "\n\n*** Trouve *** :\n" + sTrouvee);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         //------------------
         
         try {
            System.out.println("\nstyle = new Hyperlien(\"http://uqam.ca\", "
               + "StyleMD.BLOC)");
            style = new Hyperlien("http://uqam.ca", StyleMD.BLOC);
            
            try {
               System.out.print("- style.getDisposition()... ");

               nbrAttendu = StyleMD.BLOC;
               nbrTrouve = style.getDisposition();

               if (nbrAttendu == nbrTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + nbrAttendu 
                     + "\n\n*** Trouve *** :\n" + nbrTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(null)... ");
               sAttendue = "\n[null](http://uqam.ca)\n";
               sTrouvee = style.formater(null);
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"lien\")... ");
               sAttendue = "\n[lien](http://uqam.ca)\n";
               sTrouvee = style.formater("lien");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"  \\n \\n\\n"
                  + "lien     \\n\\n\")... ");
               sAttendue = "\n[lien](http://uqam.ca)\n";
               sTrouvee = style.formater("  \n \n\nlien     \n\n");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }

         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         
         //--------------------------
         
         try {
            System.out.println("\nstyle = new Hyperlien(\"http://uqam.ca\", "
               + "StyleMD.LIGNE)");
            style = new Hyperlien("http://uqam.ca", StyleMD.LIGNE);
            
            try {
               System.out.print("- style.getDisposition()... ");

               nbrAttendu = StyleMD.LIGNE;
               nbrTrouve = style.getDisposition();

               if (nbrAttendu == nbrTrouve) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + nbrAttendu 
                     + "\n\n*** Trouve *** :\n" + nbrTrouve);
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(null)... ");
               sAttendue = "[null](http://uqam.ca)\n";
               sTrouvee = style.formater(null);
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"lien\")... ");
               sAttendue = "[lien](http://uqam.ca)\n";
               sTrouvee = style.formater("lien");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }
            
            try {
               System.out.print("- style.formater(\"  \\n \\n\\n"
                  + "lien     \\n\\n\")... ");
               sAttendue = "[lien](http://uqam.ca)\n";
               sTrouvee = style.formater("  \n \n\nlien     \n\n");
               
               if (sAttendue.equals(sTrouvee)) {
                  points = points + ok(1);
               } else {
                  err("ERREUR :\n\n" + "*** Attendu *** :\n" + encadrer(sAttendue) 
                  + "\n\n*** Trouve *** :\n" + encadrer(sTrouvee));
               }
            } catch (Exception e) {
               exceptionInattendue(e);
            }

         } catch (Exception e) {
            exceptionInattendue(e);
         }

      } catch (Exception e) {
         exceptionInattendue(e);
      }   
      scoreInter(points, total);
   }
   
   
   /**
    * Tests qui verifient les methodes equals de tous les styles
    */
   public static void testsStyleMDMethodesEquals() {
      double points = 0;
      double total = 10;

      boolean bAttendu;
      boolean bTrouve;
         
      titre ("tests methodes equals");
      
      try {

         initTests();
         
         //Titre 1
         
         try {
            System.out.print("\ns1.equals(null)... ");
            bAttendu = false;
            bTrouve = s1.equals(null);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }   
         
         try {
            System.out.print("s1.equals(s2)... ");
            bAttendu = false;
            bTrouve = s1.equals(s2);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s1.equals(\"Titre1\")... ");
            bAttendu = false;
            bTrouve = s1.equals("Titre1");

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s1.equals(new Titre1())... ");
            bAttendu = true;
            bTrouve = s1.equals(new Titre1());

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
            
         
         //Titre2
         
         try {
            System.out.print("\ns2.equals(null)... ");
            bAttendu = false;
            bTrouve = s2.equals(null);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }   
         
         try {
            System.out.print("s2.equals(s3)... ");
            bAttendu = false;
            bTrouve = s2.equals(s3);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s2.equals(\"Titre2\")... ");
            bAttendu = false;
            bTrouve = s2.equals("Titre2");

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s2.equals(new Titre2())... ");
            bAttendu = true;
            bTrouve = s2.equals(new Titre2());

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         //Titre3
         
         try {
            System.out.print("\ns3.equals(null)... ");
            bAttendu = false;
            bTrouve = s3.equals(null);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }   
         
         try {
            System.out.print("s3.equals(s4)... ");
            bAttendu = false;
            bTrouve = s3.equals(s4);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s3.equals(\"Titre3\")... ");
            bAttendu = false;
            bTrouve = s3.equals("Titre3");

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s3.equals(new Titre3())... ");
            bAttendu = true;
            bTrouve = s3.equals(new Titre3());

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         //Liste numerotee
         
         try {
            System.out.print("\ns4.equals(null)... ");
            bAttendu = false;
            bTrouve = s4.equals(null);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }   
         
         try {
            System.out.print("s4.equals(s5)... ");
            bAttendu = false;
            bTrouve = s4.equals(s5);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s4.equals(s2)... ");
            bAttendu = false;
            bTrouve = s4.equals(s2);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s4.equals(new Liste(true))... ");
            bAttendu = true;
            bTrouve = s4.equals(new Liste(true));

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         
         //Liste a puces
         
        
         try {
            System.out.print("\ns5.equals(null)... ");
            bAttendu = false;
            bTrouve = s5.equals(null);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }  
         
         try {
            System.out.print("s5.equals(s4)... ");
            bAttendu = false;
            bTrouve = s5.equals(s4);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }

         
         try {
            System.out.print("s5.equals(s6)... ");
            bAttendu = false;
            bTrouve = s5.equals(s6);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s5.equals(new Liste(false))... ");
            bAttendu = true;
            bTrouve = s5.equals(new Liste(false));

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         //texte simple (BLOC)
         
         try {
            System.out.print("\ns6.equals(null)... ");
            bAttendu = false;
            bTrouve = s6.equals(null);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }   
         
         try {
            System.out.print("s6.equals(s7)... ");
            bAttendu = false;
            bTrouve = s6.equals(s7);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s6.equals(s3)... ");
            bAttendu = false;
            bTrouve = s6.equals(s3);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s6.equals(new TexteSimple(StyleMD.BLOC))... ");
            bAttendu = true;
            bTrouve = s6.equals(new TexteSimple(StyleMD.BLOC));

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         
         //texte simple (LIGNE)
         
         try {
            System.out.print("\ns7.equals(null)... ");
            bAttendu = false;
            bTrouve = s7.equals(null);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }   
         
         try {
            System.out.print("s7.equals(s6)... ");
            bAttendu = false;
            bTrouve = s7.equals(s6);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s7.equals(s1)... ");
            bAttendu = false;
            bTrouve = s7.equals(s1);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s7.equals(new TexteSimple(StyleMD.LIGNE))... ");
            bAttendu = true;
            bTrouve = s7.equals(new TexteSimple(StyleMD.LIGNE));

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         
         //Emphase
         
         try {
            System.out.print("\ns8.equals(null)... ");
            bAttendu = false;
            bTrouve = s8.equals(null);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }   
         
         try {
            System.out.print("s8.equals(s5)... ");
            bAttendu = false;
            bTrouve = s8.equals(s5);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s8.equals(\"Emphase\")... ");
            bAttendu = false;
            bTrouve = s8.equals("Emphase");

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s8.equals(new Emphase())... ");
            bAttendu = true;
            bTrouve = s8.equals(new Emphase());

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         
         //Hyperlien (BLOC)
         
         try {
            System.out.print("\ns9.equals(null)... ");
            bAttendu = false;
            bTrouve = s9.equals(null);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }   
         
         try {
            System.out.print("s9.equals(s1)... ");
            bAttendu = false;
            bTrouve = s9.equals(s1);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s9.equals(s10)... ");
            bAttendu = false;
            bTrouve = s9.equals(s10);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         try {
            System.out.print("s9.equals(new Hyperlien(\"http://uqam.ca\", StyleMD.BLOC))... ");
            bAttendu = true;
            bTrouve = s9.equals(new Hyperlien("http://uqam.ca", StyleMD.BLOC));

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }

         try {
            System.out.print("s9.equals(new Hyperlien(\"https://google.com\", StyleMD.BLOC))... ");
            bAttendu = false;
            bTrouve = s9.equals(new Hyperlien("https://google.com", StyleMD.BLOC));

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         //Hyperlien (LIGNE)
         
         try {
            System.out.print("\ns10.equals(s6)... ");
            bAttendu = false;
            bTrouve = s10.equals(s6);

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }
         
         
         try {
            System.out.print("s10.equals(new Hyperlien("
               + "\"https://www.google.com\", StyleMD.LIGNE))... ");
            bAttendu = true;
            bTrouve = s10.equals(new Hyperlien("https://www.google.com", 
               StyleMD.LIGNE));

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }

         try {
            System.out.print("s10.equals(new Hyperlien("
               + "\"https://www.google.com\", StyleMD.BLOC))... ");
            bAttendu = false;
            bTrouve = s10.equals(new Hyperlien("https://www.google.com", 
               StyleMD.BLOC));

            if (bAttendu == bTrouve) {
               points = points + ok(1);
            } else {
               err("ERREUR :\n\n" + "*** Attendu *** :\n" + bAttendu 
                  + "\n\n*** Trouve *** :\n" + bTrouve);
            }
         } catch (Exception e) {
            exceptionInattendue(e);
         }

      } catch (Exception e) {
         exceptionInattendue(e);
      }   
      scoreInter(points / 4, total);
   }
   
   
   
   /**
    * Executer la methode main pour executer les tests.
    * Vous pouvez tester a mesure que vous implementez les styles MD, en 
    * mettant en commentaires les tests des styles non encore implementes.
    */
   public static void main (String [] args) {
      
      //tests
      testsStyleMDTitre1();
      
      testsStyleMDTitre2();
      
      testsStyleMDTitre3();
      
      testsStyleMDListe();
      
      testsStyleMDTexteSimple();
      
      testsStyleMDEmphase();
      
      testsStyleMDHyperlien();
      
      testsStyleMDMethodesEquals();
      
      
      
      //score final
      afficherScore();
   }
   
}
