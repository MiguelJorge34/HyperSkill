package numbers;
import java.util.*;
import java.lang.*;
    

public class Main {
    public static void isItABuzzNumber(long n){
        if (n <= 0){
            System.out.println("This number is not natural!");
        }
        else{
            if (n % 7 == 0 && n % 10 == 7){
                    System.out.println("Properties of "+n);
                    System.out.println("buzz: true");
                    
                    
                    doesItHasAZero(n);
                    isItPalindromic(n);
                    grapfullNumber(n);
                    isItEvenOrOdd(n);
                    // System.out.println("Explanation:");
                    // System.out.println(n+" is divisible by 7 and ends with 7.");
                }
            else if (n % 7 == 0){
                    System.out.println("Properties of "+n);
                    System.out.println("buzz: true");
                    isItEvenOrOdd(n);
                    
                    doesItHasAZero(n);
                    isItPalindromic(n);
                    grapfullNumber(n);
                     isItEvenOrOdd(n);
                    // System.out.println("Explanation:");
                    // System.out.println(n+" is divisible by 7.");
                    
                }
            else if(n % 10 == 7){
                    System.out.println("Properties of "+n);
                    System.out.println("buzz: true");    
                    isItEvenOrOdd(n);
                    
                    doesItHasAZero(n);
                    isItPalindromic(n);
                    grapfullNumber(n);
                    isItEvenOrOdd(n);
                    // System.out.println("Explanation:");
                    // System.out.println(n+" is ends with 7.");
                    
                }
            else{
                    System.out.println("Properties of "+n);
                    System.out.println("buzz: false");
                    
                    
                    doesItHasAZero(n);
                    isItPalindromic(n);
                    grapfullNumber(n);
                    isItEvenOrOdd(n);
                    // System.out.println("Explanation:");
                    // System.out.println(n+" is neither divisible by 7 nor does it end with 7.");
                }
            }
        }
    public static void doesItHasAZero(long n){
        String stringN = Long.toString(n);
        int contador = 0;
        long [] checkForZero = new long[stringN.length()];
        for (int i = 0; i < stringN.length(); i++)
        {
            checkForZero[i] = stringN.charAt(i)-48;;
        }
        for (int i = 0; i < stringN.length(); i++)
        {
            if(checkForZero[i] == 0 && i != 0){
                System.out.println("duck: true");
                break;
            }
            else{
                contador++;
            }
            
            }
        if (checkForZero.length == contador ){
            System.out.println("duck: false");
        }
        
        }
        
    
    
      public static void isItEvenOrOdd(long n){
        if (n % 2 == 0){
            System.out.println("even: true.");
            System.out.println("odd: false.");
        }
        else{
            System.out.println("even: false.");
            System.out.println("odd: true.");
        }
    }

    public static void isItPalindromic(long n){
        String stringN = Long.toString(n);
        // int contador = 0;
        long [] checkForPalindromic = new long[stringN.length()];
        boolean palidromic = true;
        for (int i = 0; i < stringN.length(); i++)
        {
            checkForPalindromic[i] = stringN.charAt(i)-48;;
        }
        if(checkForPalindromic.length == 1){
             if (palidromic){
                System.out.println("palindromic: true");
             }
            else{
                System.out.println("palindromic: false");
            }
        }
        else{
            for(int j = 0; j <checkForPalindromic.length; j++){
                for (int h = checkForPalindromic.length-1; h >= 0; h--){
                    if (checkForPalindromic[j] != checkForPalindromic[h] ){
                        palidromic = false;
                    }
                }
            }
            if (palidromic){
                System.out.println("palindromic: true");
            }
            else{
                System.out.println("palindromic: false");
            }
        }
    }
    public static void grapfullNumber(long n){
        String stringN = Long.toString(n);
        // int contador = 0;
        long [] checkgrapfullNumber = new long[stringN.length()];
        for (int i = 0; i < stringN.length(); i++)
        {
            checkgrapfullNumber[i] = stringN.charAt(i)-48;;
        }
        if (checkgrapfullNumber.length <= 2){
            System.out.println("gapful: false");
        }
        else if(n%(checkgrapfullNumber[0]* 10 +checkgrapfullNumber[checkgrapfullNumber.length-1])==0){
            System.out.println("gapful: true");
        }
        else{
            System.out.println("gapful: false");
        }
        
        
    }
        
  
    
    public static void main(String[] args) {
        Scanner scanner =new  Scanner(System.in);
        boolean finish = false;
        System.out.println("Welcome to Amazing Numbers!");

        System.out.println("Supported requests:");
        System.out.println("enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.");
        
        while(!finish){
            
            System.out.println("Enter a request:");
        
            
        
            long chose = scanner.nextLong();
            
            if(chose < 0){
                System.out.println("The first parameter should be a natural number or zero.");
            }else if (chose == 0){
                System.out.println("Goodbye");
                finish = true;
                    
            }else{
                long n = chose;
                isItABuzzNumber(n);
                
                }
                   
                    
                        
                
            }
        }
    
}
