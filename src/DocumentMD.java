import java.util.ArrayList;

/**
 * Cette classe modélise un document <b>Markdown</b>.
 * Un tel document est composé d'une liste ordonnée d'ElementTextuelMD.
 *
 * @author TODO
 * @version Hiver 2022
 */
public class DocumentMD {

    /**
     * La liste ordonnée des éléments textuels <b>Markdown</b> qui constituent ce document.
     */
    private final ArrayList<ElementTextuelMD> elements;

    /**
     * Ce constructeur instancie la liste elements qui doit être vide.
     */
    public DocumentMD() {
        elements = new ArrayList<ElementTextuelMD>();
    }

    /**
     * ;
     * Cette méthode retourne le nombre d'éléments textuel <b>Markdown</b> dans ce document
     *
     * @return Le nombre d'éléments textuels <b>Markdown</b> du document.
     */
    public int taille() {
        return elements.size();
    }

    /**
     * Cette méthode permet d'ajouter l'élément textuel <b>Markdown</b> eltTextMD à la fin de ce document.
     *
     * @param eltTexteMD L'élément textuel <b>Markdown</b> à ajouter à la fin de ce document.
     * @throws ElementTextuelMDInvalideException Lorsque l'ElementTextuelMD est null.
     */
    public void ajouterElementTextuel(ElementTextuelMD eltTexteMD) throws ElementTextuelMDInvalideException {
        if (eltTexteMD == null)
            throw new ElementTextuelMDInvalideException();

        elements.add(eltTexteMD);
    }

    /**
     * Cette méthode permet d'insérer l'élément eltTexteMD donné, à la position donnée, dans ce document.
     *
     * @param position   La position, dans ce document, où l'on veut ajouter eltTexteMD.
     * @param eltTexteMD L'élément textuel <b>Markdown</b> à ajouter dans ce document, à la position donnée.
     * @throws ElementTextuelMDInvalideException Lorsque l'ElementTextuelMD est null.
     */
    public void ajouterElementTextuel(int position, ElementTextuelMD eltTexteMD) throws ElementTextuelMDInvalideException {
        if (eltTexteMD == null)
            throw new ElementTextuelMDInvalideException();
        if (position < 0 || position > taille())
            throw new IndexOutOfBoundsException();

        elements.add(position, eltTexteMD);
    }

    /**
     * Cette méthode permet de supprimer l'élément textuel <b>Markdown</b> se trouvant à la position donnée, dans ce document.
     *
     * @param position La position, dans ce document, de l'élément textuel <b>Markdown</b> à supprimer.
     * @return L'élément supprimé.
     */
    public ElementTextuelMD supprimerElementTextuel(int position) {
        if (position < 0 || position > taille())
            throw new IndexOutOfBoundsException();

        return elements.remove(position);
    }

    /**
     * Cette méthode permet de remplacer un élément textuel <b>Markdown</b> existant à la position donnée,
     * dans ce document, par celui passé en paramètre (eltTexteMD).
     *
     * @param position   La position, dans ce document, de l'élément textuel <b>Markdown</b> à remplacer par eltTexteMD.
     * @param eltTexteMD L'élément textuel <b>Markdown</b> avec lequel on veut remplacer l'élément à la position donnée.
     * @return L'élément remplacé.
     * @throws ElementTextuelMDInvalideException Lorsque l'ElementTextuelMD est null.
     */
    public ElementTextuelMD remplacerElementTextuel(int position, ElementTextuelMD eltTexteMD) throws ElementTextuelMDInvalideException {
        if (eltTexteMD == null)
            throw new ElementTextuelMDInvalideException();
        if (position < 0 || position > taille())
            throw new IndexOutOfBoundsException();

        return elements.set(position, eltTexteMD);
    }

    /**
     * Cette méthode retourne l'élément textuel <b>Markdown</b> existant à la position donnée, dans ce document.
     *
     * @param position La position, dans ce document, de l'élément textuel <b>Markdown</b> qu'on veut obtenir.
     * @return L'élément <b>Markdown</b> dans ce document, à la position donné.
     */
    public ElementTextuelMD obtenirElementTextuel(int position) {
        if (position < 0 || position > taille())
            throw new IndexOutOfBoundsException();

        return elements.get(position);
    }

    /**
     * Cette méthode permet de modifier le style de l'élément textuel <b>Markdown</b> existant à la position donnée,
     * dans ce document, par le style donné.
     *
     * @param position La position, dans ce document, de l'élément textuel <b>Markdown</b> dont on veut modifier le style par le style donné.
     * @param style    Le nouveau style qu'on veut assigner à l'élément textuel <b>Markdown</b> se trouvant à la position donnée, dans ce document.
     * @throws StyleMDInvalideException Lorsque le texte est null ou vide.
     */
    public void modifierStyle(int position, StyleMD style) throws StyleMDInvalideException {
        if (position < 0 || position > taille())
            throw new IndexOutOfBoundsException();
        if (style == null)
            throw new StyleMDInvalideException();

        obtenirElementTextuel(position).setStyle(style);
    }

    /**
     * Cette méthode permet de modifier le texte de l'élément textuel <b>Markdown</b> existant à la position donnée,
     * dans ce document, par le texte donné.
     *
     * @param position La position, dans ce document, de l'élément textuel <b>Markdown</b> dont on veut modifier le texte par le texte donné.
     * @param texte    Le nouveau texte qu'on veut assigner à l'élément textuel <b>Markdown</b> se trouvant à la position donnée, dans ce document.
     * @throws StyleMDInvalideException Lorsque le texte est null ou vide.
     */
    public void modifierTexte(int position, String texte) throws StyleMDInvalideException {
        if (position < 0 || position > taille())
            throw new IndexOutOfBoundsException();
        if (texte == null || texte.trim().isEmpty())
            throw new StyleMDInvalideException();

        try {
            obtenirElementTextuel(position).setTexte(texte);
        } catch (ElementTextuelMDInvalideException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cette méthode retourne le texte formaté selon le style <b>Markdown</b> de l'élément textuel <b>Markdown</b> existant à la position donnée, dans ce document.
     *
     * @param position La position, dans ce document, de l'élément textuel <b>Markdown</b> dont on veut obtenir le texte au format <b>Markdown</b>.
     * @return Le texte formaté selon le style <b>Markdown</b> de l'élément textuel présent à la position donnée.
     */
    public String obtenirMarkdown(int position) {
        if (position < 0 || position > taille())
            throw new IndexOutOfBoundsException();

        return obtenirElementTextuel(position).toString();
    }

    /**
     * Cette méthode retourne une chaine formée de la concaténation de tous les éléments textuels <b>Markdown</b> de ce document (formaté selon leur style <b>Markdown</b>),
     * dans l'ordre.
     * <p>
     * Un document vide retourne une chaine vide.
     *
     * @return La chaine formée de la concaténation de tous les éléments textuels <b>Markdown</b> de ce document, formaté selon leur style.
     */
    @Override
    public String toString() {
        String retour = "";

        for (ElementTextuelMD element : elements) {
            retour = retour + element.toString();
        }
        return retour;
    }
}

