/**
 * Cette classe modélise un élément de texte devant être formaté dans un style Markdown donné.
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
     */
    public ElementTextuelMD(String texte, StyleMD style) throws ElementTextuelMDInvalideException, StyleMDInvalideException {
        if( texte == null || texte.trim().isEmpty())
            throw new ElementTextuelMDInvalideException();
        if( style == null)
            throw new StyleMDInvalideException();
        this.texte = texte;
        this.style = style;
    }

    /**
     * Cette méthode retourne simplement la valeur de l'attribut texte.
     *
     * @return texte
     */
    public String getTexte() {
        return texte;
    }

    /**
     * Cette méthode permet de modifier l'attribut texte de cet
     * ElementTextuelMD par le texte donné en paramètre.
     *
     * @param texte Le nouveau texte à assigner à cet objet.
     */
    public void setTexte(String texte) throws ElementTextuelMDInvalideException {
        if( texte == null || texte.trim().isEmpty())
            throw new ElementTextuelMDInvalideException();
        this.texte = texte;
    }

    /**
     * Cette méthode retourne simplement la valeur de l'attribut style.
     *
     * @return style
     */
    public StyleMD getStyle() {
        return style;
    }

    /**
     * Cette méthode permet de modifier l'attribut style de cet ElementTextuelMD
     * par le style donné en paramètre.
     * @param style Le nouveau style à assigner à cet objet
     */
    public void setStyle(StyleMD style) throws StyleMDInvalideException {
        if( style == null)
            throw new StyleMDInvalideException();
        this.style = style;
    }

    /**
     * Cette méthode retourne le texte de cet ElementTextuelMD formaté selon le
     * style de cet ElementTextuelMD.
     * @return
     */
    @Override
    public String toString() {
        return style.formater(texte);
    }
}
