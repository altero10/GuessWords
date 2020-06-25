import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        String [] words = {"zegar", "lampa", "obrazek", "tomek", "stół","tablica"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int round = 0;
        int fails = 0;
        String response;
        while (fails <= 3){
            String word = words[random.nextInt(words.length)];
            String hashWord = word;
            for (int i = 0; i<round; i+=5) {
                char randomChar = hashWord.charAt(random.nextInt(hashWord.length()));
                if (randomChar=='*') {
                    i--;
                    continue;
                }
                hashWord = hashWord.replaceFirst(String.valueOf(randomChar), "*");
            }
            System.out.println("Twoje wylosowane słowo to: " + hashWord);
            System.out.print("Podaj słowo: ");
            response = scanner.nextLine();

            if(word.equalsIgnoreCase(response)){
                System.out.println("Gratulacje!");
                round++;
            }else {
                fails++;
                System.out.println("Błędna odpowiedź!");
            }

        }
        System.out.println("Koniec gry! Twoje punkty: " + round);
    }

}
