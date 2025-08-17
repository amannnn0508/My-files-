package InternshinJava;

import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args) {
        Random r= new Random();
        int random= r.nextInt(100);
        Scanner sc= new Scanner(System.in);
        System.out.println("Guess a Number ");
        int num;
        int score=0;

        do {
            System.out.print("Enter num(0-100): ");
             num= sc.nextInt();

            if(num>random){
                System.out.println("You guessed a greater number");
            }
            else if (num<random){
                System.out.println("You guessed a smaller number");
            }
            else System.out.println("You guessed the number correctly ");

            score++;
        }while(num!=random);

        System.out.println("Your Score : "+score);// score represents the no of try you took to guess the number , so as less the  score is as better you played or guessed the number.




    }
}
