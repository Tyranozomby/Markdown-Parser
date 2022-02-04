/**
 * Cette classe implémente le style Markdown : Emphase
 *
 * @author TODO
 * @version Hiver 2022
 */
public class Emphase extends StyleMD {

    /**
     * Ce constructeur construit un objet Emphase
     * dont la disposition est (toujours) de type LIGNE.
     */
    public Emphase() {
        super(StyleMD.LIGNE);
    }

    /**
     * Cette méthode retourne le format Markdown du texte donné en paramètre,
     * dans le style Emphase.
     * <p>
     * Au format Markdown, le style Emphase consiste à mettre l'emphase sur un texte donné (le mettre en gras),
     * et peut être spécifié en ajoutant la chaine "**" avant et après le texte donné.
     *
     * @param texte Le texte sur lequel mettre l'emphase.
     * @return Le texte formaté en Markdown.
     */
    @Override
    public String formater(String texte) {
        if (texte == null)
            return "null";

        String retour = "**" + texte.trim() + "**";

        return appliquerDisposition(retour);
    }
}
