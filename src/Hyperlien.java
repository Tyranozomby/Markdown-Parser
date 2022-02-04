public class Hyperlien extends StyleMD {

    private final String url;

    public Hyperlien(String url, int disposition) {
        super(disposition);

        if (url == null || url.trim().equals("")) {
            this.url = "http://localhost";
        } else {
            this.url = url;
        }
    }

    @Override
    public String formater(String texte) {
        return "[" + texte + "] (\"" + url + "\")";
    }
}
