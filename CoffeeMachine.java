package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
     int water = 400;
     int milk = 540;
     int coffeBeans = 120;
     int cups = 9;
     int money = 550;
     String action = "";
     System.out.println("Write action (buy, fill, take, remaining, exit):");
     while(scanner.hasNextLine() && !action.equals("exit") ) {
         action = scanner.nextLine();
         switch (action) {
             case "take":
                 System.out.print("I gave you $" + money + "\n");
                 money = 0;
                 System.out.println("Write action (buy, fill, take, remaining, exit):");
                 break;
             case "fill":
                 System.out.println("Write how many ml of water do you want to add:");
                 water += scanner.nextInt();
                 System.out.println("Write how many ml of milk do you want to add:");
                 milk += scanner.nextInt();
                 System.out.println("Write how many grams of coffee beans do you want to add:");
                 coffeBeans += scanner.nextInt();
                 System.out.println("Write how many disposable cups of coffee do you want to add:");
                 cups += scanner.nextInt();
                 System.out.println("Write action (buy, fill, take, remaining, exit):");
                 break;
             case "buy":
                 cups--;
                 System.out.println("What do you order 1-esspersso, 2-latte, 3-cappucino");
                 String war = scanner.nextLine();
                 switch (war) {
                     case "1":
                         if (water >= 250 && coffeBeans >= 16) {
                             water -= 250;
                             coffeBeans -= 16;
                             money += 4;
                             System.out.println("I have enough resources, making you a coffee!");
                         } else {
                             System.out.println("Refill me!");
                         }
                         break;
                     case "2":
                         if (water >= 350 && coffeBeans >= 20 && milk >= -75) {
                             water -= 350;
                             milk -= 75;
                             coffeBeans -= 20;
                             money += 7;
                             System.out.println("I have enough resources, making you a coffee!");
                         } else {
                             System.out.println("Refill me!");
                         }
                         break;
                     case "3":
                         if (water >= 200 && milk >= 100 && coffeBeans >= 12) {
                             water -= 200;
                             milk -= 100;
                             coffeBeans -= 12;
                             money += 6;
                             System.out.println("I have enough resources, making you a coffee!");
                         } else {
                             System.out.println("Refill me!");
                         }
                         break;
                     case "back":
                         System.out.println("Write action (buy, fill, take, remaining, exit):");
                 }
                 System.out.println("Write action (buy, fill, take, remaining, exit):");
                 break;
             case "remaining":
                 quantity(water, milk, coffeBeans, cups, money);
                 System.out.println("Write action (buy, fill, take, remaining, exit):");
                 break;
         }
     }
    }
    public static int coffePosible(int a,int b,int c){
        a /= 200;
        b /= 50;
        c /= 15;
        if(a <= b && a <= c){
            return a;
        } else if (b <= a && b <= c){
            return b;
        } else {
         return c;
        }
    }
    public static void howManyCups(int a){
        int water = 200*a;
        int milk = 50*a;
        int coffeBeans = 15*a;
        System.out.print("For " + a +" cups of coffee you will need:\n" +
        water + " ml of water\n"+
        milk + " ml of milk\n"+
        coffeBeans + " g of coffee beans\n");
    }
    public static void quantity(int a, int b , int c , int d, int e){
        System.out.print("The coffee machine has:\n" +
                a + " of water\n" +
                b + " of milk\n" +
                c + " of coffee beans\n" +
                d + " of disposable cups\n" +
                e + " of money\n");
    }
}
