package cinema;
import java.util.*;
import java.lang.Math.*;

public class Cinema {
    public static int [][] sala = new int[30][30];
    public static boolean acabar = false;
    public static int x ;
    public static int y;

    public static void displaySala(int rows, int columns){
        for(int i = 0 ; i < rows +1 ; i++){
            for (int j = 0 ; j < columns+ 1 ; j++){
                if(sala[i][j] == rows && i != 0 && j !=0 ){
                    System.out.print("S ");
                }
                else if (sala[i][j] == -1){
                     System.out.print("B ");
                }
                else if(sala[i][j] == 0) {
                     System.out.print(" ");
                }
                else{
                    System.out.print(sala[i][j]+" ");
                }
            }
            
        System.out.println();

        }
    }
     public static int totalIncome(int rows, int columns){
        int seats = rows* columns;
        if (seats < 60){
            return 10*rows*columns;
        }
        else{
            if(rows % 2 == 0){
                return 10*(rows/2)*columns + 8 * (rows/2) * columns;
            }
            else {
                int rows10 =(rows-1)/2;
                int rows8 = (rows+1)/2;
                return rows10 * columns * 10 + rows8 * columns * 8;
                
            }
            
        }
    }
   public static int singleTicketPrince(int rows,int columns, int x , int y){
       int ticket = 0;
       if(rows * columns <= 60){
            ticket = 10;
       }
       else if(rows % 2 == 0 && rows / 2 >= x || rows % 2 != 0 && (rows+1)/2 > x){
           ticket = 10;
       }else {
           ticket = 8;
       }
       return ticket;
   }

    public static int totalTicketsPrice(int rows,int columns){
        int ticket = 0  ;
        int total = 0;
        for(int i = 0 ; i < rows+1 ; i++){
            for (int j = 0 ; j < columns+1 ; j++){
                if(sala[i][j] == -1){
                    int r = i;
                    int w = j;
                    if(rows * columns <= 60){
                        ticket = 10;
                        total = total + ticket;
                    }
                     else if(rows % 2 == 0 && rows / 2 >= r || rows % 2 != 0 && (rows+1)/2 > r){
                       ticket = 10;
                         total = total + ticket;
                     }else {
                         ticket = 8;
                         total = total + ticket;
                     }
                    
                
            }
           
            
            
        }
        
        
    }
        return total;
    }
       
        
        
        
    
    
     public static int ticketsBought(int rows, int columns){
         int contador = 0;
         for(int i = 0 ; i < rows+1 ; i++ ){
             for(int j = 0; j < columns+1; j++ ){
                 if(sala[i][j] == -1){
                     contador++;
                 }
             }
         }
         return contador;
     }
    
      public static void getPercentage(int rows, int columns){
        double totalSeats = rows * columns;
        
        double ocupation = ticketsBought(rows,columns);
        

        double percetange = (ocupation / totalSeats) *100;
        System.out.println(percetange);

        System.out.printf("Percentage %.2f%%%n: ",percetange);
         
        
    }

   
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt(); 
        
        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();
        
        
        
        for(int i = 0 ; i < rows+1 ; i++){
            for (int j = 0 ; j < columns+1 ; j++){
                if(i==0){
                    sala[i][j] = j;
                }
                else if(j == 0){
                    sala[i][j] = i;
                }
                else{
                    sala[i][j] = rows;
                }
            }
        }
        
        
        while(!acabar){
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int num = scanner.nextInt();
            switch(num){
                    
                case 1:
                    System.out.println("Cinema:");
                    displaySala(rows,columns);
                    break;
                case 2:
                    boolean input = false;
                    while(!input){
                        
                        System.out.println("Enter a row number:");
                        x = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        y = scanner.nextInt();
                        if ( x >rows || y > columns || x <= 0 || y <= 0){
                            System.out.println("Wrong input!");
                                                        }
                        else if(sala[x][y] == -1 ){
                            System.out.println("That ticket has already been purchased!");
                        
                        }
                        else{
                            
                            System.out.println("Ticket price: $"+singleTicketPrince(rows,columns,x,y));
                            sala[x][y] = -1;
                            input = true;
                            break;
                        }
                        
                    }
                    break;
                    
            
                      

                case 3:
                    
                    
                    System.out.println("Number of purchased tickets: "+ ticketsBought(rows,columns));
                    getPercentage(rows,columns);
                    System.out.println("Current income: $"+totalTicketsPrice(rows,columns));
                    System.out.println("Total income: $"+totalIncome(rows, columns));
                    break;
                    
                    
                    
                case 0:
                    acabar = true;
                    break;
                    }
                
            
        }
        
    }
}
