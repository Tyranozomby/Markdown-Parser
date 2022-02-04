public class Hyperlien extends StyleMD {

    private final String url;

    public Hyperlien(String url, int disposition) {
        super(disposition);

        if (url == null || url.trim().equals("")) {
            this.url = "http://localhost";
        } else {
            this.url = url.trim();
        }
    }

    @Override
    public String formater(String texte) {
        return "[" + texte + "] (" + url + ")";
    }

    public String getUrl(){
        return url;
    }

    @Override
    public boolean equals(Object o) {
//        super.equals();
//        if (!(autreStyle instanceof StyleMD))
//            return false;
//
//        StyleMD autre = (StyleMD) autreStyle;
//        return this.disposition == autre.disposition;
    }

}
