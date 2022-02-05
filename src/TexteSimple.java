/**
 * Cette classe implémente le style <b>Markdown</b> : <u>TexteSimple</u>
 *
 * @author TODO
 * Code permanent : TODO
 * Courriel : TODO
 * Cours : INF2120-H22
 * @version 2022-02-05
 */
public class TexteSimple extends StyleMD {

    /**
     * Un <u>TexteSimple</u> peut être de <i>disposition</i> <i>BLOC</i> ou <i>LIGNE</i>.
     * <p>
     * Ce constructeur initialise donc l'attribut d'instance <i>disposition</i> avec la valeur passée en paramètre.
     * <p>
     * Si le paramètre <i>disposition</i> est invalide (n'est pas égal à <i>LIGNE</i> ou <i>BLOC</i>),
     * on ignore le paramètre, et l'on initialise l'attribut <i>disposition</i> à <i>BLOC</i>.
     *
     * @param disposition La <i>disposition</i> pour ce <u>TexteSimple</u>. Doit être <i>LIGNE</i> ou <i>BLOC</i>.
     */
    public TexteSimple(int disposition) {
        super(disposition);
    }

    /**
     * Cette méthode retourne le format <b>Markdown</b> du texte donné en paramètre, dans le style <u>TexteSimple</u>.
     *
     * @param texte Le texte à formater dans le style <u>TexteSimple</u>.
     * @return Le texte où l'on a remplacé tous les sauts de lignes '\n' par un saut de ligne HTML (<br/>).
     */
    @Override
    public String formater(String texte) {
        String retour;

        if (texte == null) texte = "null";

        retour = texte.trim().replace("\n", "<br/>");

        return appliquerDisposition(retour);
    }
}
