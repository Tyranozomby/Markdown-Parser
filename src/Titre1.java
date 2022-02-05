/**
 * Cette classe implémente le style <b>Markdown</b> : <u>Titre1</u>
 *
 * @author TODO
 * @version Hiver 2022
 */
public class Titre1 extends StyleMD {

    /**
     * Ce constructeur initialise un <u>Titre1</u> dont la <i>disposition</i> est de type <i>BLOC</i>.
     */
    public Titre1() {
        super(StyleMD.BLOC);
    }

    /**
     * Cette méthode retourne le format <b>Markdown</b> du texte donné en paramètre,
     * dans le style <u>Titre1</u>.
     * <p>
     * Au format <b>Markdown</b>, le style <u>Titre1</u> peut être
     * spécifié en soulignant le texte avec une ligne formée de caractères '='.
     *
     * @param texte Le texte à formater dans le style <u>Titre1</u>.
     * @return Le texte formaté dans le style <u>Titre1</u>.
     */
    @Override
    public String formater(String texte) {
        String retour;

        if (texte == null) texte = "null";

        retour = texte.trim();
        int longueur = retour.length();
        retour = retour + "\n";

        for (int i = 0; i < longueur; i++) {
            retour = retour + "=";
        }
        return appliquerDisposition(retour);
    }
}
