/**
 * Cette classe implémente le style <b>Markdown</b> : <u>Hyperlien</u>
 *
 * @author TODO
 * @version Hiver 2022
 */
public class Hyperlien extends StyleMD {

    /**
     * L'URL par défaut utilisé.
     */
    public static final String URL_DEFAUT = "http://localhost";

    /**
     * L'URL de la ressource ciblée par cet hyperlien.
     */
    private final String url;

    /**
     * Ce constructeur construit un <u>Hyperlien</u> en initialisant ses attributs url
     * et <i>disposition</i> avec les valeurs données en paramètres.
     * <p>
     * Cependant, si le paramètre <i>disposition</i> est invalide (n'est pas égal à <i>LIGNE</i> ou <i>BLOC</i>),
     * on ignore le paramètre, et l'on initialise l'attribut <i>disposition</i> à <i>BLOC</i>.
     * <p>
     * Si le paramètre url est null ou si url.trim() est vide,
     * on ignore le paramètre, et l'on assigne la valeur "http://localhost" à l'attribut url.
     *
     * @param url         L'URL de la ressource ciblée par cet <u>Hyperlien</u>.
     * @param disposition La <i>disposition</i> pour cet <u>Hyperlien</u>. Doit être <i>LIGNE</i> ou <i>BLOC</i>.
     */
    public Hyperlien(String url, int disposition) {
        super(disposition);

        if (url == null || url.trim().isEmpty()) {
            this.url = URL_DEFAUT;
        } else {
            this.url = url.trim();
        }
    }

    /**
     * Cette méthode retourne le format <b>Markdown</b> du texte donné en paramètre,
     * dans le style <u>Hyperlien</u>.
     *
     * @param texte Le texte du lien entre crochet.
     * @return Le texte du lien entre crochets, suivi de l'URL entre parenthèses.
     */
    @Override
    public String formater(String texte) {
        if (texte == null) texte = "null";

        String retour = "[" + texte.trim() + "](" + url + ")";

        return appliquerDisposition(retour);
    }

    /**
     * Cette méthode retourne simplement la valeur de l'attribut url.
     *
     * @return la valeur de l'attribut url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Cette méthode est la redéfinition de la méthode equals (de la classe StyleMD)
     * Deux objets de type <u>Hyperlien</u> sont considérés comme égaux si tous leurs
     * attributs (<i>disposition</i> et url) sont égaux.
     *
     * @param autreHyperlien L'autre <u>Hyperlien</u> avec lequel comparer celui-ci.
     * @return Un booléen correspondant à l'égalité des deux <u>Hyperliens</u>.
     */
    @Override
    public boolean equals(Object autreHyperlien) {
        if (super.equals(autreHyperlien)) {
            if (!(autreHyperlien instanceof Hyperlien)) return false;

            Hyperlien autre = (Hyperlien) autreHyperlien;
            return this.url.equals(autre.url);
        } else {
            return false;
        }
    }

}
