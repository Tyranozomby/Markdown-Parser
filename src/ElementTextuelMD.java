/**
 * Cette classe modélise un élément de texte devant être formaté dans un style Markdown donné.
 *
 * @author TODO
 * Code permanent : TODO
 * Courriel : TODO
 * Cours : INF2120-H22
 * @version 2022-02-05
 */
public class ElementTextuelMD {
    /**
     * L'élément textuel à formater.
     */
    private String texte;

    /**
     * Le style Markdown dans lequel on veut formater le texte.
     */
    private StyleMD style;

    /**
     * Ce constructeur construit un ElementTextuelMD en initialisant ses attributs
     * texte et style par les valeurs correspondantes données en paramètres.
     *
     * @param texte Le texte de l'objet ElementTextuelMDà créer.
     * @param style Le style Markdown de l'objet ElementTextuelMDà créer.
     * @throws ElementTextuelMDInvalideException Lorsque l'élément texte est null ou vide.
     * @throws StyleMDInvalideException          Lorsque l'élément style est null.
     */
    public ElementTextuelMD(String texte, StyleMD style) throws ElementTextuelMDInvalideException, StyleMDInvalideException {
        if (texte == null || texte.trim().isEmpty()) {
            throw new ElementTextuelMDInvalideException();
        }
        if (style == null) {
            throw new StyleMDInvalideException();
        }

        this.texte = texte;
        this.style = style;
    }

    /**
     * Cette méthode retourne simplement la valeur de l'attribut texte.
     *
     * @return texte Un String correspondant au texte.
     */
    public String getTexte() {
        return texte;
    }

    /**
     * Cette méthode permet de modifier l'attribut texte de cet
     * ElementTextuelMD par le texte donné en paramètre.
     *
     * @param texte Le nouveau texte à assigner à cet objet.
     * @throws ElementTextuelMDInvalideException Lorsque l'élément texte est null ou vide.
     */
    public void setTexte(String texte) throws ElementTextuelMDInvalideException {
        if (texte == null || texte.trim().isEmpty()) {
            throw new ElementTextuelMDInvalideException();
        }
        this.texte = texte;
    }

    /**
     * Cette méthode retourne simplement la valeur de l'attribut style.
     *
     * @return style La valeur de l'objet StyleMD.
     */
    public StyleMD getStyle() {
        return style;
    }

    /**
     * Cette méthode permet de modifier l'attribut style de cet ElementTextuelMD
     * par le style donné en paramètre.
     *
     * @param style Le nouveau style à assigner à cet objet.
     * @throws StyleMDInvalideException Lorsque l'élément style est null.
     */
    public void setStyle(StyleMD style) throws StyleMDInvalideException {
        if (style == null) {
            throw new StyleMDInvalideException();
        }
        this.style = style;
    }

    /**
     * Cette méthode retourne le texte de cet ElementTextuelMD formaté selon le
     * style de cet ElementTextuelMD.
     *
     * @return Un String correspondant au texte formater selon le style.
     */
    @Override
    public String toString() {
        return style.formater(texte);
    }
}
