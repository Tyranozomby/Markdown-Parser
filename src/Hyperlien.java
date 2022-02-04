/**
 * Cette classe implémente le style Markdown : Hyperlien
 *
 * @author TODO
 * @version Hiver 2022
 */
public class Hyperlien extends StyleMD {

    public static final String URL_DEFAUT = "http://localhost";
    /**
     * L'URL de la ressource ciblée par cet hyperlien.
     */
    private final String url;

    /**
     * Ce constructeur construit un Hyperlien en initialisant ses attributs url et disposition avec les valeurs données
     * en paramètres. Cependant, si le paramètre disposition est invalide (n'est pas égal à LIGNE ou BLOC), on ignore le
     * paramètre, et l'on initialise l'attribut disposition à BLOC. Si le paramètre url est null ou si url.trim() est
     * vide, on ignore le paramètre, et l'on assigne la valeur "http://localhost" à l'attribut url.
     *
     * @param url         L'URL de la ressource ciblée par cet Hyperlien.
     * @param disposition La disposition pour cet Hyperlien. Doit être LIGNE ou BLOC.
     */
    public Hyperlien(String url, int disposition) {
        super(disposition);

        if (url == null || url.trim().equals("")) {
            this.url = URL_DEFAUT;
        } else {
            this.url = url.trim();
        }
    }

    /**
     * Cette méthode retourne le format Markdown du texte donné en paramètre, dans le style Hyperlien.
     *
     * @param texte Le texte du lien entre crochet.
     * @return Le texte du lien entre crochets, suivi de l'URL entre parenthèses.
     */
    @Override
    public String formater(String texte) {
        return "[" + texte + "] (" + url + ")";
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
     * Deux objets de type Hyperlien sont considérés comme égaux si tous leurs attributs (disposition et url) sont égaux.
     *
     * @param autreHyperlien L'autre Hyperlien avec lequel comparer celui-ci.
     * @return Un booléen correspondant à l'égalité des deux Hyperliens.
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
