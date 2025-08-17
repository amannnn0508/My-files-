package InternshinJava;

import java.sql.SQLOutput;
import java.util.Scanner;

class ConnectFour{
    String [][] board= new String[6][7];
    Scanner sc= new Scanner(System.in);
    int player1 ,player2; // p1-> red [R] , p2-> Blue [B]
    int h,v,d;

    void modifyBoard(){
        //modifying board
        for(int i=0;i<6;i++){
            for(int j=0; j<7;j++){
                board[i][j]="-";
            }
        }
}

  void printBoard(){
      System.out.println("[ Connect Four ]");
      for(int x=0;x<6;x++){
          for(int y=0; y<7;y++){
              System.out.print(" "+board[x][y]+" ");
          }
          System.out.println();
      }
  }



    int horizontalCheck(){ // 6 rows
         int r;// no of rows
         int c;// no of columns
        for(r=5;r>=0;r--){
            for(c=0;c<=3;c++){
                if(!board[r][c].equals("-")){
                    if(board[r][c].equals("R")&& board[r][c+1].equals("R")&&board[r][c+2].equals("R")&&board[r][c+3].equals("R")){
                        return 0;
                    }
                    if(board[r][c].equals("B")&& board[r][c+1].equals("B")&&board[r][c+2].equals("B")&&board[r][c+3].equals("B")){
                        return 1;
                    }
                }
            }
        }
        return -1;
    }

    int verticalCheck(){ // 7 columns
        int r;// no of rows
        int c;// no of columns

            for(c=0;c<=6;c++){
                for(r=5;r>=3;r--){
                if(!board[r][c].equals("-")){
                    if(board[r][c].equals("R")&& board[r-1][c].equals("R")&&board[r-2][c].equals("R")&&board[r-3][c].equals("R")){
                        return 0;
                    }
                    if(board[r][c].equals("B")&& board[r-1][c].equals("B")&&board[r-2][c].equals("B")&&board[r-3][c].equals("B")){
                        return 1;
                    }
                }
            }
        }
        return -1;
    }

    int diagonalCheck(){
        int r, c;
        // bottom left to top right
        for(r=5;r>=3;r--){
            for(c=0;c<=3;c++){
                if(!board[r][c].equals("-")){
                    if(board[r][c].equals("R")&& board[r-1][c+1].equals("R")&&board[r-2][c+2].equals("R")&&board[r-3][c+3].equals("R")){
                        return 0;
                    }

                    if(board[r][c].equals("B")&& board[r-1][c+1].equals("B")&&board[r-2][c+2].equals("B")&&board[r-3][c+3].equals("B")){
                        return 1;
                    }

                }

            }
        }

        //bottom right top left
        for(r=5;r>=3;r--) {
            for(c=6;c>=3;c--){
                if(!board[r][c].equals("-")){
                    if(board[r][c].equals("R")&& board[r-1][c-1].equals("R")&&board[r-2][c-2].equals("R")&&board[r-3][c-3].equals("R")){
                        return 0;
                    }

                    if(board[r][c].equals("B")&& board[r-1][c-1].equals("B")&&board[r-2][c-2].equals("B")&&board[r-3][c-3].equals("B")){
                        return 1;
                    }

                }

            }
        }

        return -1;
    }

    void start(){
        modifyBoard();
        int count=1;
        System.out.println("Player 1 ->[R] Red & Player 2 ->[B] Blue");
        do{

           System.out.print("Player 1 [R] Enter Column (0-6): ");// 7 column
           player1 = sc.nextInt();
           for(int r=5;r>=0;r--){
               if(board[0][player1].equals("-")) { //
                   if (board[r][player1].equals("-")) {
                       board[r][player1] = "R";
                       break;
                   }
               }
               else {
                   do{
                       System.out.println("The column you selected is completely filled so ,select another one !!");
                       System.out.print("Player 1 [R] Enter Column (0-6): ");
                       player1 = sc.nextInt();
                       for(int i=5;i>=0;i--) {
                           if (board[0][player1].equals("-")) {
                               if (board[r][player1].equals("-")) {
                                   board[r][player1] = "R";
                                   break;
                               }
                           }
                       }
                   } while(!board[0][player1].equals("-"));


               }
           }
           printBoard();
           if(count>3){
               h=horizontalCheck();
               v=verticalCheck();
               d=diagonalCheck();

               if(h==0 || v==0 || d==0){
                   System.out.println("Player 1 [R]  Win !!");
                   break;
               }
               else if (h==1 || v==1 || d==1){
                   System.out.println("Player 2 [B]  Win !!");
                   break;
               }

           }

           System.out.print("\n Player 2 [B] Enter Column (0-6): ");// 7 column
           player2 = sc.nextInt();
           for(int r=5;r>=0;r--){
               if(board[0][player2].equals("-")) {
                   if (board[r][player2].equals("-")) {
                       board[r][player2] = "B";
                       break;
                   }
               }

               else {
                   do{
                       System.out.println("The column you selected is completely filled so ,select another one !!");
                       System.out.print("Player 2 [B] Enter Column (0-6): ");
                       player1 = sc.nextInt();
                       for(int i=5;i>=0;i--) {
                           if (board[0][player2].equals("-")) {
                               if (board[r][player2].equals("-")) {
                                   board[r][player2] = "B";
                                   break;
                               }
                           }
                       }
                   } while(!board[0][player2].equals("-"));


               }


           }

           printBoard();

           if(count>3){
               h=horizontalCheck();
               v=verticalCheck();
               d=diagonalCheck();

               if(h==0 || v==0 || d==0){
                   System.out.println("Player 1 [R]  Win !!");
                   break;
               }
               else if (h==1 || v==1 || d==1){
                   System.out.println("Player 2 [B]  Win !!");
                   break;
               }

           }

           if(count==21){
               if(h==-1 && v==-1 && d==-1){
                   System.out.println("Draw");
               }

           }

           count++;
       }while(count<=21);





    }

}




public class ConnectFourgame {
    public static void main(String[] args) {

        ConnectFour c1 = new ConnectFour();
        System.out.println("Connect Four Game using java !! ");
        c1.start();



    }
}
