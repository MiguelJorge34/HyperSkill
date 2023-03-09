package machine;
import java.util.*;

public class CoffeeMachine {
    public static int water = 400;
    public static int milk = 540;
    public static int coffee = 120;
    public static int cups = 9;
    public static int money = 550;
    public static String action;
    public static boolean shutdown = false;
    
    static int howManyCupsCanIMake(int[] ingredientes){
        int water = ingredientes[0];
        int milk = ingredientes[1];
        int coffee = ingredientes[2];


        int maxWater = water/ 200;
        int maxMilk = milk/50;
        int maxCoffee = coffee /15;

        
        if(maxWater == 0 || maxMilk == 0 || maxCoffee == 0){
            return 0;
        }
        else{
            int b = Math.min(maxWater,maxMilk);
            int c = Math.min (b,maxCoffee);

            return c;

        }
    }
   
    static String doIHaveIngredients(int[] ingredientes){
        int water = ingredientes[0];
        int milk = ingredientes[1];
        int coffee = ingredientes[2];
        int cups = ingredientes[3];

        int c = howManyCupsCanIMake(ingredientes) -1;
        
        

        if (cups < howManyCupsCanIMake(ingredientes)){
            
            return "Yes, I can make that amount of coffee (and even "+ c +" more than that)";
        }
        else if (cups == howManyCupsCanIMake(ingredientes)){
           
            return "Yes, I can make that amount of coffee";
        }
         else {
           
            return "No, I can make only "+howManyCupsCanIMake(ingredientes)+ " cup(s) of coffee";
        }

        
       
    }
    static void actionMade(){
        while(!shutdown){
            Scanner scan = new Scanner(System.in);
            String action = scan.next();
            switch (action){
                case ("buy"):
                    buy();
                    break;
                case("fill"):
                    fillMachine();
                    break;

                case("take"):
                    takeMethod();
                    break;
                case("remaining"):
                    printSupplies();
                    break;
                case ("exit"):
                    shutdown = true;
                
            }
        }
        
    }
    public static void printSupplies() {
        System.out.println("The coffee machine has:"+"\n"+ water+" ml of water"+"\n"+milk+" ml of milk"+"\n"+coffee+" g of coffee beans"+"\n"+cups+" disposable cups"+"\n"+money+" of money");
        
    }

    public static void takeMethod(){
        System.out.println("I gave you $"+money);
        money = 0;
        
        
    }

    public static void fillMachine(){
        Scanner scanner1 = new Scanner (System.in);
        System.out.println("Write how many ml of water you want to add: ");
        int addWater = scanner1.nextInt();
        water = water + addWater;

        System.out.println("Write how many ml of milk you want to add:  ");
        int addMilk = scanner1.nextInt();
        milk = milk + addMilk;

         System.out.println("Write how many grams of coffee beans you want to add: ");
         int addCoffee = scanner1.nextInt();
         coffee = coffee + addCoffee;

         System.out.println("Write how many disposable cups you want to add:");
         int addCups = scanner1.nextInt();
         cups = cups + addCups;

    }

    public static void buy(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String chose = scanner.next();
        switch (chose){
            case("1"):
                if(water-250 > 0 && coffee-16 > 0 && cups-1>0){
                     water = water - 250;
                     coffee = coffee -16;
                     money = money + 4;
                     cups = cups -1;
                     System.out.println("I have enough resources, making you a coffee!");
                }
                else if(water-250<0){
                    notEnoughWather();
                    }
                else if(coffee - 15 < 0){
                   notEnoughtCoffee();
                 }
                else if(cups -1 < 0){
                     notEnoughtCups();
                 }
                break;
            case("2"):
                    
                if(water-350 > 0 &&milk-75>0 && coffee-20 > 0 && cups-1>0){
                    water = water - 350;
                    milk = milk -75;
                    coffee = coffee -20;
                    money = money + 7;
                    cups = cups -1;
                   enoughtResources();
                }
                else if(water-350<0){
                    notEnoughWather();
                }
                else if (milk - 75 < 0){
                   notEnoughtMilk();
                }
                else if(coffee - 15 < 0){
                   notEnoughtCoffee();
                }
                else if(cups -1 < 0){
                    notEnoughtCups();
                }
                break;
            case("3"):
                if(water-200 > 0 &&milk-100>0 && coffee-12 > 0 && cups-1>0){
                    water = water - 200;
                    milk = milk -100;
                    coffee = coffee -12;
                    money = money + 6;
                    cups = cups -1;
                    enoughtResources();
                }
                else if(water-200<0){
                    notEnoughWather();
                }
                else if (milk - 100 < 0){
                     notEnoughtMilk();
                 }
                else if(coffee - 12 < 0){
                   notEnoughtCoffee();
                }
                else if(cups -1 < 0){
                     notEnoughtCups();
                 }
                break;
            case("back"):
                 break;
                        
        
    }
    }
    public static void notEnoughWather(){
        System.out.println("Sorry, not enough water!");
    }
    public static void notEnoughtMilk(){
        System.out.println("Sorry, not enough milk!");
    }
    public static void notEnoughtCoffee(){
        System.out.println("Sorry, not enough coffee beans!");
    }
    public static void notEnoughtCups(){
        System.out.println("Sorry, not enough disposable cups!");
    }
    public static void enoughtResources(){
        System.out.println("I have enough resources, making you a coffee!");
    }

    
    




    public static void main(String[] args) {
       
        //int [] ingredientes = new int[4];
        //System.out.println("Write how many ml of water the coffee machine has: ");
        //water = scanner.nextInt();
        //ingredientes [0] = water;
        
        //System.out.println("Write how many ml of milk the coffee machine has:");
        //milk = scanner.nextInt();
        //ingredientes [1] = milk;
        
        //System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        //coffee = scanner.nextInt();
        //ingredientes [2] = coffee;
        
        //System.out.println("Write how many cups of coffee you will need: ");
        //cups = scanner.nextInt();
        //ingredientes [3] = cups;
       
       
        
        //System.out.println(doIHaveIngredients(ingredientes));
        actionMade();
        
    }
}
