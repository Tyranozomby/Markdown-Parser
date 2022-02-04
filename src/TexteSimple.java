/**
 * Cette classe implémente le style Markdown : TexteSimple
 *
 * @author TODO
 * @version Hiver 2022
 */
public class TexteSimple extends StyleMD {

    /**
     * Un TexteSimple peut être de disposition BLOC ou LIGNE.
     * <p>
     * Ce constructeur initialise donc l'attribut d'instance disposition avec la valeur passée en paramètre.
     * <p>
     * Si le paramètre disposition est invalide (n'est pas égal à LIGNE ou BLOC),
     * on ignore le paramètre, et l'on initialise l'attribut disposition à BLOC.
     *
     * @param disposition La disposition pour ce TexteSimple. Doit être LIGNE ou BLOC.
     */
    public TexteSimple(int disposition) {
        super(disposition);
    }

    /**
     * Cette méthode retourne le format Markdown du texte donné en paramètre, dans le style TexteSimple.
     *
     * @param texte Le texte à formater dans le style TexteSimple.
     * @return Le texte où l'on a remplacé tous les sauts de lignes '\n' par un saut de ligne HTML (<br/>).
     */
    @Override
    public String formater(String texte) {
        if (texte == null)
            texte = "null";

        String retour = texte.trim().replace("\n", "<br/>");

        return appliquerDisposition(retour);
    }
}
