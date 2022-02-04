/**
 * Cette classe implémente le style Markdown : Titre3
 *
 * @author TODO
 * @version Hiver 2022
 */
public class Titre3 extends StyleMD {

    /**
     * Ce constructeur initialise un Titre3 dont la disposition est de type BLOC.
     */
    public Titre3() {
        super(StyleMD.BLOC);
    }

    /**
     * Cette méthode retourne le format Markdown du texte donné en paramètre,
     * dans le style Titre3.
     * <p>
     * Au format Markdown, le style Titre3 peut être spécifié en ajoutant '### '
     * au début du texte.
     *
     * @param texte Le texte à formater dans le style Titre3.
     * @return Le texte formaté dans le style Titre3.
     */
    @Override
    public String formater(String texte) {
        if (texte == null)
            texte = "null";

        String retour = "### " + texte.trim();
        return appliquerDisposition(retour);
    }
}
