import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Single_TTT.java;

public class SuperTTT{
   static List<String> superBoard = new ArrayList<String>();
   static void main(String args[]) throws InterruptedException {
      Scanner input = new Scanner(System.in);
      Single_TTT singleGame = new Single_TTT();
      System.out.println("Welcome to Super Tic-Tac-Toe!");
      System.out.println("When selecting an answer the input is (123,456,789)");
      System.out.println("The current board is: ");
      for(int i=0; i<9; i++){
         superBoard.add("-");
         System.out.print('-');
         if(i%3==0){
            System.out.println();
         }
      }
      
      do{
         System.out.println("Select the board to play: ");
      }while(Single_TTT.check_for_win(superBoard)==false);
      
   }

   
}