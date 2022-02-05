/**
 * Cette classe abstraite implémente différents styles <b>Markdown</b>
 *
 * @author TODO
 * @version Hiver 2022
 */
public abstract class StyleMD {
    /**
     * Un entier initialisé à 0. Cette constante désigne une <i>disposition</i> de type <i>BLOC</i>
     * pour un élément formaté en <b>Markdown</b>.
     */
    public static final int BLOC = 0;

    /**
     * Un entier initialisé à 1. Cette constante désigne une <i>disposition</i> de type <i>LIGNE</i>
     * pour un élément formaté en <b>Markdown</b>.
     */
    public static final int LIGNE = 1;

    /**
     * Un entier qui indique la <i>disposition</i> de ce StyleMD. Doit être <i>LIGNE</i> ou <i>BLOC</i>.
     * Une <i>disposition</i> de type <i>LIGNE</i> pour un élément de texte formaté en <b>Markdown</b>
     * signifie qu'on veut enchaîner cet élément à l'élément précédent
     * (sans commencer de nouveau paragraphe). Une <i>disposition</i> de type <i>BLOC</i>
     * signifie qu'on veut commencer un nouveau paragraphe.
     */
    private final int disposition;

    /**
     * Ce constructeur initialise l'attribut d'instance <i>disposition</i>
     * avec la valeur passée en paramètre. Si le paramètre <i>disposition</i>
     * est invalide (n'est pas égal à <i>LIGNE</i> ou <i>BLOC</i>), on ignore le paramètre,
     * et l'on initialise l'attribut <i>disposition</i> à <i>BLOC</i>.
     *
     * @param disposition Indique la <i>disposition</i> de ce StyleMD. Doit être <i>LIGNE</i> ou <i>BLOC</i>.
     */
    public StyleMD(int disposition) {
        if ((disposition == LIGNE) || (disposition == BLOC)) {
            this.disposition = disposition;
        } else {
            this.disposition = BLOC;
        }
    }

    /**
     * Le texte à formater dans un style <b>Markdown</b>. La redéfinition de cette méthode
     * (dans chaque sous-classe) retourne le format <b>Markdown</b> du texte donné en
     * paramètre (dans le style représenté par la sous-classe).
     *
     * @param texte Le texte à formater dans un style <b>Markdown</b>.
     * @return Le texte formaté.
     */
    public abstract String formater(String texte);

    /**
     * Ce getter retourne simplement la valeur de l'attribut <i>disposition</i>.
     *
     * @return disposition La <i>disposition</i>.
     */
    public int getDisposition() {
        return disposition;
    }

    /**
     * Deux objets de type StyleMD sont considérés comme égaux s'ils ont la même <i>disposition</i>
     *
     * @param autreStyle L'autre style avec lequel comparer ce style.
     * @return Un booléen correspondant à l'égalité des deux styles.
     */
    @Override
    public boolean equals(Object autreStyle) {
        StyleMD autre;

        if (!(autreStyle instanceof StyleMD) || this.getClass() != autreStyle.getClass()) return false;

        autre = (StyleMD) autreStyle;
        return this.disposition == autre.disposition;
    }

    /**
     * Applique la <i>disposition</i> du type <i>BLOC</i> ou <i>LIGNE</i> du style.
     *
     * @param texte Le texte à formater.
     * @return Le texte formaté en fonction de sa <i>disposition</i>.
     */
    public String appliquerDisposition(String texte) {
        if (disposition == StyleMD.BLOC) return "\n" + texte + "\n";
        else //if (disposition == StyleMD.LIGNE)
            return texte + "\n";
    }
}
