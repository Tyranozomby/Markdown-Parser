/**
 * Cette classe implémente le style <b>Markdown</b> : <u>Titre3</u>
 *
 * @author TODO
 * Code permanent : TODO
 * Courriel : TODO
 * Cours : INF2120-H22
 * @version 2022-02-05
 */
public class Titre3 extends StyleMD {

    /**
     * Ce constructeur initialise un <u>Titre3</u> dont la <i>disposition</i> est de type <i>BLOC</i>.
     */
    public Titre3() {
        super(StyleMD.BLOC);
    }

    /**
     * Cette méthode retourne le format <b>Markdown</b> du texte donné en paramètre,
     * dans le style <u>Titre3</u>.
     * <p>
     * Au format <b>Markdown</b>, le style <u>Titre3</u> peut être spécifié en ajoutant '### '
     * au début du texte.
     *
     * @param texte Le texte à formater dans le style <u>Titre3</u>.
     * @return Le texte formaté dans le style <u>Titre3</u>.
     */
    @Override
    public String formater(String texte) {
        String retour;

        if (texte == null) texte = "null";

        retour = "### " + texte.trim();
        return appliquerDisposition(retour);
    }
}
