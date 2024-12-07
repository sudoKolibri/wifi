package wifi.java2.T2S18_Hangman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Ratewörter
        List<String> wortListe = new ArrayList<String>();
        Collections.addAll(wortListe, "Hustsaft", "Hausverbot" , "Hamsterrad", "Ketchup", "Tabelle", "Autobahnkreuz", "Gammelfleisch", "Proteinshake", "Prosecco", "Handschuh", "Alphabet", "Keimling", "Hosentraeger", "Computertisch", "Kleiderkammer", "Rauchverbot");
        // Alphabet
        List<String> alphabet = new ArrayList<String>();
        Collections.addAll(alphabet, "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s" ,"t" ,"u" ,"v" ,"w", "x", "y", "z");
        // Objekt init
        HangmanGame game = new HangmanGame("", 0, 0, new StringBuilder());
        Random rand = new Random();
        int max = wortListe.size();
        int randomNum = rand.nextInt((max));
        game.setWort(wortListe.get(randomNum));
        game.setMaximaleVersuche(6);
        game.setAktuelleVersuche(0);    


        // Scanner Objekt
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("HangMan!");
        System.out.println("Erraten sie das gesuchte Wort, indem sie Buchstabe um Buchstabe erraten.");


        while (game.getAktuelleVersuche() < game.getMaximaleVersuche()) {
            System.out.println("Wort: " + game.getAktuellesWort());
            System.out.println("Bereits geratene Buchstaben: " + game.getBereitsGeraten());
            System.out.println("Verbleibende Versuche: " + (game.getMaximaleVersuche() - game.getAktuelleVersuche()));
            System.out.print("Geben Sie einen Buchstaben ein: ");
        
            String userInput = scanner.nextLine().toLowerCase();
        
            if (userInput.length() != 1 || !alphabet.contains(userInput)) {
                System.out.println("Ungültige Eingabe! Bitte geben Sie einen einzelnen Buchstaben (a-z) ein.");
                continue;
            }
        
            if (game.getBereitsGeraten().indexOf(userInput) >= 0) {
                System.out.println("Sie haben den Buchstaben bereits geraten: " + userInput);
                continue; // Keine Versuche zählen
            }
            
            game.getBereitsGeraten().append(userInput); // Füge den geratenen Buchstaben hinzu
        
            if (game.getWort().contains(userInput)) {
                System.out.println("Richtig!");
            } else {
                // Nur zählen, wenn der Buchstabe nicht im Wort ist
                game.setAktuelleVersuche(game.getAktuelleVersuche() + 1);
                System.out.println("Falsch!");
            }
        
            // Prüfen, ob das Spiel gewonnen wurde
            if (!game.getAktuellesWort().contains("_")) {
                System.out.println("Glückwunsch, Sie haben das Wort erraten!");
                break;
            }
        }
        

        if (game.getAktuelleVersuche() == game.getMaximaleVersuche()) {
            System.out.println("Leider haben Sie verloren! Das Wort war: " + game.getWort());
            
        }

        scanner.close();


    }
}