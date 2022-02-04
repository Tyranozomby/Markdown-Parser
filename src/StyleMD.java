/**
 * Cette classe abstraite implémente différents styles Markdown
 *
 * @author TODO
 * @version Hiver 2022
 */
public abstract class StyleMD {
    /**
     * Un entier initialisé à 0. Cette constante désigne une disposition de type BLOC
     * pour un élément formaté en Markdown.
     */
    public static final int BLOC = 0;

    /**
     * Un entier initialisé à 1. Cette constante désigne une disposition de type LIGNE
     * pour un élément formaté en Markdown.
     */
    public static final int LIGNE = 1;

    /**
     * Un entier qui indique la disposition de ce StyleMD. Doit être LIGNE ou BLOC.
     * Une disposition de type LIGNE pour un élément de texte formaté en Markdown
     * signifie qu'on veut enchaîner cet élément à l'élément précédent
     * (sans commencer de nouveau paragraphe). Une disposition de type BLOC
     * signifie qu'on veut commencer un nouveau paragraphe.
     */
    private final int disposition;

    /**
     * Ce constructeur initialise l'attribut d'instance disposition
     * avec la valeur passée en paramètre. Si le paramètre disposition
     * est invalide (n'est pas égal à LIGNE ou BLOC), on ignore le paramètre,
     * et l'on initialise l'attribut disposition à BLOC.
     *
     * @param disposition Indique la disposition de ce StyleMD. Doit être LIGNE ou BLOC.
     */
    public StyleMD(int disposition) {
        if ((disposition == LIGNE) || (disposition == BLOC)) {
            this.disposition = disposition;
        } else {
            this.disposition = BLOC;
        }
    }

    /**
     * Le texte à formater dans un style Markdown. La redéfinition de cette méthode
     * (dans chaque sous-classe) retourne le format Markdown du texte donné en
     * paramètre (dans le style représenté par la sous-classe).
     *
     * @param texte Le texte à formater dans un style Markdown.
     * @return Le texte formaté.
     */
    public abstract String formater(String texte);

    /**
     * Ce getter retourne simplement la valeur de l'attribut disposition.
     *
     * @return La disposition.
     */
    public int getDisposition() {
        return disposition;
    }

    /**
     * Deux objets de type StyleMD sont considérés comme égaux s'ils ont la même disposition
     *
     * @param autreStyle L'autre style avec lequel comparer ce style.
     * @return Un booléen correspondant à l'égalité des deux styles.
     */
    @Override
    public boolean equals(Object autreStyle) {
        if (!(autreStyle instanceof StyleMD) || this.getClass()!=autreStyle.getClass())
            return false;

        StyleMD autre = (StyleMD) autreStyle;
        return this.disposition == autre.disposition;
    }

    /**
     * Applique la disposition du type BLOC ou LIGNE du style.
     *
     * @param texte Le texte à formater.
     * @return Le texte formaté en fonction de sa disposition.
     */
    public String appliquerDisposition(String texte) {
        if (disposition == StyleMD.BLOC)
            return "\n" + texte + "\n";
        else //if (disposition == StyleMD.LIGNE)
            return texte + "\n";
    }
}
