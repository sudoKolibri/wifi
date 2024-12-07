package wifi.java2.T2S18_Hangman;

public class HangmanGame {
    private String wort;
    private int maximaleVersuche;
    private int aktuelleVersuche;
    private StringBuilder bereitsGeraten;

    public HangmanGame(String wort, int maximaleVersuche, int aktuelleVersuche, StringBuilder bereitsGeraten) {
        this.wort = wort;
        this.maximaleVersuche = maximaleVersuche;
        this.aktuelleVersuche = aktuelleVersuche;
        this.bereitsGeraten = bereitsGeraten;
    }

    public String getWort() {
        return wort;
    }
    
    public void setWort(String wort) {
        this.wort = wort;
    }

    public int getMaximaleVersuche() {
        return maximaleVersuche;
    }
    
    public void setMaximaleVersuche(int maximaleVersuche) {
        this.maximaleVersuche = maximaleVersuche;
    }

    public int getAktuelleVersuche() {
        return aktuelleVersuche;
    }

    public void setAktuelleVersuche(int aktuelleVersuche) {
        this.aktuelleVersuche = aktuelleVersuche;
    }

    public StringBuilder getBereitsGeraten() {
        return bereitsGeraten;
    }

    public void setBereitsGeraten(StringBuilder bereitsGeraten) {
        this.bereitsGeraten = bereitsGeraten;
    }

    public String getAktuellesWort() {
        StringBuilder anzeige = new StringBuilder();
        for (char c : wort.toCharArray()) {
            if (bereitsGeraten.indexOf(String.valueOf(c)) >= 0) {
                anzeige.append(c);
                
            } else { anzeige.append("_");
                
            }
      
        }

        return anzeige.toString();
    }

    @Override
    public String toString() {
        return "HangmanGame [wort=" + wort + ", maximaleVersuche=" + maximaleVersuche + ", aktuelleVersuche="
                + aktuelleVersuche + ", bereitsGeraten=" + bereitsGeraten + "]";
    }

}
