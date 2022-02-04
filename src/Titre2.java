/**
 * Cette classe implémente le style Markdown : Titre2
 *
 * @author TODO
 * @version Hiver 2022
 */
public class Titre2 extends StyleMD {

    /**
     * Ce constructeur initialise un Titre2 dont la disposition est de type BLOC.
     */
    public Titre2() {
        super(StyleMD.BLOC);
    }

    /**
     * Cette méthode retourne le format Markdown du texte donné en paramètre,
     * dans le style Titre2.
     * <p>
     * Au format Markdown, le style Titre2 peut être
     * spécifié en soulignant le texte avec une ligne formée de caractères '-'.
     *
     * @param texte Le texte à formater dans le style Titre2.
     * @return Le texte formaté dans le style Titre2.
     */
    @Override
    public String formater(String texte) {
        if (texte == null)
            texte = "null";

        String retour = texte.trim();
        int longueur = retour.length();
        retour = retour + "\n";

        for (int i = 0; i < longueur; i++) {
            retour = retour + "-";
        }
        return appliquerDisposition(retour);
    }
}
