/**
 * Cette classe implémente le style <b>Markdown</b> : <u>Titre2</u>
 *
 * @author TODO
 * @version Hiver 2022
 */
public class Titre2 extends StyleMD {

    /**
     * Ce constructeur initialise un <u>Titre2</u> dont la <i>disposition</i> est de type <i>BLOC</i>.
     */
    public Titre2() {
        super(StyleMD.BLOC);
    }

    /**
     * Cette méthode retourne le format <b>Markdown</b> du texte donné en paramètre,
     * dans le style <u>Titre2</u>.
     * <p>
     * Au format <b>Markdown</b>, le style <u>Titre2</u> peut être
     * spécifié en soulignant le texte avec une ligne formée de caractères '-'.
     *
     * @param texte Le texte à formater dans le style <u>Titre2</u>.
     * @return Le texte formaté dans le style <u>Titre2</u>.
     */
    @Override
    public String formater(String texte) {
        if (texte == null) texte = "null";

        String retour = texte.trim();
        int longueur = retour.length();
        retour = retour + "\n";

        for (int i = 0; i < longueur; i++) {
            retour = retour + "-";
        }
        return appliquerDisposition(retour);
    }
}
