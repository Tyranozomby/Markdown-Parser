/**
 * Cette classe implémente le style <b>Markdown</b> : <u>Emphase</u>
 *
 * @author TODO
 * @version Hiver 2022
 */
public class Emphase extends StyleMD {

    /**
     * Ce constructeur construit un objet <u>Emphase</u>
     * dont la <i>disposition</i> est (toujours) de type <i>LIGNE</i>.
     */
    public Emphase() {
        super(StyleMD.LIGNE);
    }

    /**
     * Cette méthode retourne le format <b>Markdown</b> du texte donné en paramètre,
     * dans le style <u>Emphase</u>.
     * <p>
     * Au format <b>Markdown</b>, le style <u>Emphase</u> consiste à mettre l'emphase sur un texte donné (le mettre en gras),
     * et peut être spécifié en ajoutant la chaine "**" avant et après le texte donné.
     *
     * @param texte Le texte sur lequel mettre l'emphase.
     * @return Le texte formaté en <b>Markdown</b>.
     */
    @Override
    public String formater(String texte) {
        if (texte == null) texte = "null";

        String retour = "**" + texte.trim() + "**";

        return appliquerDisposition(retour);
    }
}
