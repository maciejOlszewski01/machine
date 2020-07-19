package machine;

import java.util.Scanner;

public class CoffeeMachine {

    int water;
    int milk;
    int coffeBeans;
    int cups;
    int money;

    public CoffeeMachine(int water, int milk, int coffeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeBeans = coffeBeans;
        this.cups = cups;
        this.money = money;
    }


    public static void main(String[] args) {

        STATE state = STATE.ACTION;

        CoffeeMachine automat = new CoffeeMachine(400, 540, 120, 9, 550);
        CoffeeMachine esspresso = new CoffeeMachine( 250, 0, 16 , 1 , 4);
        CoffeeMachine latte = new CoffeeMachine(350 , 75 , 20 , 1 , 7);
        CoffeeMachine cappuccino = new CoffeeMachine(200 , 100 , 12 , 1 , 6);

        Scanner scanner = new Scanner(System.in);
        while (state != STATE.OFF)
        switch (state) {
            case ACTION:
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                String action = scanner.nextLine();
                switch (action) {
                    case "take":
                        System.out.println();
                        System.out.print("I gave you $" + automat.money + "\n");
                        System.out.println();
                        automat.money = 0;
                        continue;
                    case "fill":
                        System.out.println();
                        System.out.println("Write how many ml of water do you want to add:");
                        automat.water += scanner.nextInt();
                        System.out.println("Write how many ml of milk do you want to add:");
                        automat.milk += scanner.nextInt();
                        System.out.println("Write how many grams of coffee beans do you want to add:");
                        automat.coffeBeans += scanner.nextInt();
                        System.out.println("Write how many disposable cups of coffee do you want to add:");
                        automat.cups += scanner.nextInt();
                        System.out.println();
                        continue;
                    case "remaining":
                        System.out.println();
                        automat.quantity();
                        System.out.println("");
                        continue;
                    case "exit":
                        state = STATE.OFF;
                        System.out.println("It was pleasure to serve you! :)");
                        continue;
                    case "buy":
                        System.out.println("What do you want to buy? 1-esspresso, 2 - latt, 3 - cappucino," +
                                " back - to main menu:");
                        state = STATE.CHOOSING_TYPE_OF_COFFE;
                        continue;
                }
                break;
            case CHOOSING_TYPE_OF_COFFE:
                action = scanner.nextLine();

                switch (action){
                    case "1":
                        automat = makeCoffe(automat , esspresso);
                        state = STATE.ACTION;
                        continue;

                    case "2":
                        automat = makeCoffe(automat, latte);
                        state = STATE.ACTION;
                        continue;

                    case "3":
                        automat = makeCoffe(automat, cappuccino);
                        state = STATE.ACTION;
                        continue;
                    default:
                        state = STATE.ACTION;
                }
                break;
        }

    }
    public void quantity(){
        System.out.print("The coffee machine has:\n" +
                this.water + " of water\n" +
                this.milk + " of milk\n" +
                this.coffeBeans + " of coffee beans\n" +
                this.cups + " of disposable cups\n" +
                this.money + " of money\n");
    }
    public static CoffeeMachine makeCoffe(CoffeeMachine a, CoffeeMachine b){
        if(a.water < b.water || a.cups < b.cups || a.coffeBeans < b.coffeBeans || a.milk < b.milk){
            System.out.println("NOT ENOUGH RESOURCES");
            return  a;
        }else {
            System.out.println("I have enough resources to make you a coffe");
            return new CoffeeMachine(a.water - b.water, a.milk - b.milk,
                    a.coffeBeans - b.coffeBeans, a.cups - b.cups, a.money + b.money);
        }
    }
}
enum STATE {
    ACTION,
    CHOOSING_TYPE_OF_COFFE,
    OFF;
}
