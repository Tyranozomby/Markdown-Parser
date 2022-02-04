/**
 * Cette classe implémente le style Markdown : Titre1
 *
 * @author TODO
 * @version Hiver 2022
 */
public class Titre1 extends StyleMD {

    /**
     * Ce constructeur initialise un Titre1 dont la disposition est de type BLOC.
     */
    public Titre1() {
        super(StyleMD.BLOC);
    }

    /**
     * Cette méthode retourne le format Markdown du texte donné en paramètre,
     * dans le style Titre1.
     * <p>
     * Au format Markdown, le style Titre1 peut être
     * spécifié en soulignant le texte avec une ligne formée de caractères '='.
     *
     * @param texte Le texte à formater dans le style Titre1.
     * @return Le texte formaté dans le style Titre1.
     */
    @Override
    public String formater(String texte) {
        if (texte == null)
            texte = "null";

        String retour = texte.trim();
        int longueur = retour.length();
        retour = retour + "\n";

        for (int i = 0; i < longueur; i++) {
            retour = retour + "=";
        }
        return appliquerDisposition(retour);
    }
}
