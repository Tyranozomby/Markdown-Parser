/**
 * Cette classe implémente le style Markdown : Liste
 *
 * @author TODO
 * @version Hiver 2022
 */
public class Liste extends StyleMD {
    /**
     * Cet attribut est true si c'est une liste numérotée, false
     * si c'est une liste à puces.
     */
    private final boolean listeNumerotee;

    /**
     * Ce constructeur construit une Liste dont la disposition est (toujours)
     * de type BLOC, l'attribut listeNumerotee de cette Liste est initialisé
     * avec la valeur du paramètre.
     *
     * @param listeNumerotee Le type de liste (numérotée (true) ou à puces (false)) pour cette Liste.
     */
    public Liste(boolean listeNumerotee) {
        super(StyleMD.BLOC);
        this.listeNumerotee = listeNumerotee;
    }

    /**
     * Cette méthode retourne le format Markdown du texte donné en paramètre,
     * dans le style Liste.
     * <p>
     * Si c'est une liste à puces :
     * Au format Markdown, on peut indiquer une liste (à puces) d'éléments en insérant une étoile (*),
     * suivi d'un espace, au début de chaque élément de la liste.
     * <p>
     * Si c'est une liste numérotée :
     * Au format Markdown, on peut indiquer une liste (numérotée) d'éléments en insérant un nombre nbr, suivi d'un point, suivi d'un
     * espace, au début de chaque élément de la liste.
     *
     * @param texte Le texte à formater dans le style Liste.
     * @return Le texte formaté dans le style Liste.
     */
    @Override
    public String formater(String texte) {
        if (texte == null)
            texte = "null";

        if (!listeNumerotee) { //liste à puces
            texte = "* " + texte.trim();
            texte = texte.replaceAll("\n", "\n* ");
        } else { //liste numérotée
            String[] lignes = texte.trim().split("\n");
            texte = "";
            for (int i = 0; i < lignes.length; i++) {
                texte = texte + "" + (i + 1) + ". " + lignes[i];
                if (i < lignes.length - 1) {
                    texte = texte + "\n";
                }
            }
        }
        return appliquerDisposition(texte);
    }


    /**
     * Cette méthode retourne simplement la valeur de l'attribut listeNumerotee.
     *
     * @return listeNumerotee Un booléen correspondant au type de liste(Puces ou Numérotée).
     */
    public boolean isListeNumerotee() {
        return listeNumerotee;
    }

    /**
     * Cette méthode est la redéfinition de la méthode equals(de la classe StyleMD).
     * Deux objets de type Liste sont considérés comme égaux si tous leurs attributs
     * (disposition et listeNumerotee) sont égaux.
     *
     * @param autreListe L'autre liste avec laquelle comparer cette liste.
     * @return Un booléen correspondant à l'égalité entre les deux listes
     */
    @Override
    public boolean equals(Object autreListe) {
        if (super.equals(autreListe)) {
            if (!(autreListe instanceof Liste)) return false;

            Liste autre = (Liste) autreListe;
            return this.listeNumerotee == autre.listeNumerotee;
        } else {
            return false;
        }
    }
}
