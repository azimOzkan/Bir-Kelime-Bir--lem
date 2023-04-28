
import java.util.Random;
import java.util.Scanner;


public class BirKelime {
       
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        char[] letters = "abcdefghIijklmnopqrstuvyz".toCharArray();
        StringBuilder sb = new StringBuilder();

        // rastgele harfler oluşturmak için dizi kullanma
        System.out.println("8 harfli kelime sorusu icin harfler:");
        for (int i = 0; i < 8; i++) {
            char randomChar = letters[rand.nextInt(letters.length)];
            sb.append(randomChar);
            System.out.print(randomChar + " ");
        }

        // joker harfi kullanma
        System.out.print("\nJoker harf kullanmak istiyor musunuz? (E/H): ");
        String jokerAnswer = input.nextLine().toUpperCase();
        if (jokerAnswer.equals("E")) {
            sb.append(letters[rand.nextInt(letters.length)]);
            System.out.println("Joker harf: " + sb.charAt(8));
        }

        String lettersString = sb.toString();
        System.out.println("Lutfen " + lettersString + " harfleri kullanarak bir kelime turetin: ");
        String userAnswer = input.nextLine().toLowerCase();

        if (isValidWord(userAnswer, lettersString)) {
            System.out.println("Tebrikler, dogru kelimeyi turettiniz!");
        } else {
            System.out.println("Maalesef, yanlis kelime turettiniz.");
        }
    }

    // kullanıcının kelimeyi harflerden oluşturup oluşturmadığını kontrol etme
    public static boolean isValidWord(String word, String letters) {
        for (char c : word.toCharArray()) {
            int index = letters.indexOf(c);
            if (index == -1) {
                return false;
            } else {
                letters = letters.substring(0, index) + letters.substring(index + 1);
            }
        }
        return true;
    }
}
                        