
import java.util.Random;
import java.util.Scanner;

public class BirIslem {

    
     
    public static void main(String[] args) {

  Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[6];
        int target;
        for (int i = 0; i < 6; i++) {
            numbers[i] = r.nextInt(10) + 1; // 1-10 arası rastgele bir sayı üretiyoruz.
            System.out.print(numbers[i] + " ");
        }
        target = r.nextInt(900) + 100; // 100-1000 arası rastgele bir hedef sayı üretiyoruz.
        System.out.println("\nHedef sayi: " + target);
        System.out.println("Lutfen 4 islem icin sirayla +, -, *, / isaretlerinden birini secin ve ENTER tusuna basin.");
        System.out.println("Ornegin: + - * /");
        String[] operations = new String[4];
        for (int i = 0; i < 4; i++) {
            operations[i] = scanner.next();
        }
        int closest = Integer.MAX_VALUE;
        String closestExpression = "";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == j) continue;
                for (int k = 0; k < 6; k++) {
                    if (i == k || j == k) continue;
                    for (int l = 0; l < 6; l++) {
                        if (i == l || j == l || k == l) continue;
                        int result = evaluate(numbers[i], numbers[j], numbers[k], numbers[l], operations);
                        int diff = Math.abs(result - target);
                        if (diff < closest) {
                            closest = diff;
                            closestExpression = numbers[i] + " " + operations[0] + " " + numbers[j] + " " + operations[1] + " " + numbers[k] + " " + operations[2] + " " + numbers[l] + " " + operations[3] + " = " + result;
                        }
                    }
                }
            }
        }
        System.out.println("En yakın sonuç: " + closestExpression);
    }

public static void evaluate(int a, int b, int c, int d, String[] operations, int[] numbers) {
    
    
        int result = 0;
        switch (operations[0]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b != 0) {
                    result = a / b;
                }
                break;
        }
        switch (operations[1]) {
            case "+":
                result += c;
                break;
            case "-":
                result -= c;
                break;
            case "*":
                result *= c;
                break;
            case "/":
                if (c != 0) {
                    result /= c;
                }
                break;
        }
        switch (operations[2]) {
            case "+":
                result += d;
                break;
            case "-":
                result -= d;
                break;
            case "*":
                result *= d;
                break;
            case "/":
                if (d != 0) {
                    result /= d;
                }
                break;
        }
       switch (operations[3]) {
    case "+":
        result += numbers[4];
        break;
    case "-":
        result -= numbers[4];
        break;
    case "*":
        result *= numbers[4];
        break;
    case "/":
        if (numbers[4] != 0) {
            result /= numbers[4];
        } else {
            // Eğer bölme işlemi yapılacak sayı sıfır ise hata mesajı verilebilir.
            System.out.println("Hata: Sıfıra bölme işlemi yapılamaz.");
        }
        break;
       }
}

    private static int evaluate(int number, int number0, int number1, int number2, String[] operations) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}