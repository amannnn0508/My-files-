package InternshinJava;


import java.util.Scanner;// for user input basically players

class TicTacToeGame {// class containing methods and members for  Tic Tac Toe game

    String[][] board = new String[3][3];// 2 d array  for board which consists of row and column 0-2
    Scanner sc = new Scanner(System.in);// for user input
    int p1i, p1j;//   p1-> player 1 ,  i -> row , j-> column
    int p2i, p2j; // p2->
    int h, v, d; // these variables store the result of the horizontal , vertical and diagonal checking method for winning

    void modifyBoard(){ // this method modifies board with a space instead of null
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                board[i][j]=" ";
            }
        }
    }

    void printBoard() {


        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print("|" + board[r][c] + " ");
            }
            System.out.print("|" + '\n');
        }
    }// printing board after players move

    int horizontalCheck() {   //  check winnings horizontally like-> 00 01 02 , 10 11 12, 20 21 22 .
        for (int r = 0; r < 3; r++) {
            if (board[r][0] != null) {

                if (board[r][0].equalsIgnoreCase("X") && board[r][1].equalsIgnoreCase("X") && board[r][2].equalsIgnoreCase("X")) {
                    return 0;
                }
                else if (board[r][0].equalsIgnoreCase("O") && board[r][1].equalsIgnoreCase("O") && board[r][2].equalsIgnoreCase("O")) {
                    return 1;

                }
            }
        }


        return -1;
    }// horizontally checking winnings of any player

    int verticalCheck() { // vertical check  -> 00 10 20 , 01 11 21 , 02 12 22
        for (int r = 0; r < 3; r++) {
            if (board[0][r] != null) {

                if (board[0][r].equalsIgnoreCase("X") && board[1][r].equalsIgnoreCase("X") && board[2][r].equalsIgnoreCase("X")) {
                    return 0;

                } else if (board[0][r].equalsIgnoreCase("O") && board[1][r].equalsIgnoreCase("O") && board[2][r].equalsIgnoreCase("O")) {
                    return 1;

                }

            }
        }

        return -1;
    } // vertically checking winnings of any player

    int diagonalCheck() {        // 2 diagonal to check 1-> top left to bottom right( 00 11 22  )  and 2-> top right to bottom left (02 11 20) 11 is common
        if (board[0][0] != null) {

            if (board[0][0].equalsIgnoreCase("X") && board[1][1].equalsIgnoreCase("X") && board[2][2].equalsIgnoreCase("X")) {
                return 0;
            } else if (board[0][0].equalsIgnoreCase("O") && board[1][1].equalsIgnoreCase("O") && board[2][2].equalsIgnoreCase("O")) {
                return 1;
            }
        }// top left to bottom right

        else if (board[0][2] != null) {// top right to bottom left
            if (board[0][2].equalsIgnoreCase("X") && board[1][1].equalsIgnoreCase("X") && board[2][0].equalsIgnoreCase("X")) {

                return 0;
            } else if (board[0][2].equalsIgnoreCase("O") && board[1][1].equalsIgnoreCase("O") && board[2][0].equalsIgnoreCase("O")) {
                return 1;
            }


        }//top right to bottom left

        return -1;
    }// diagonal

    void start() {

        modifyBoard();
        int i=0;

        do {
            System.out.print(" Player 1 enter value of row [0,1,2]: ");
            p1i = sc.nextInt();
            System.out.print("  Player 1 enter value of column  [0,1,2]: ");
            p1j = sc.nextInt();

            if(board[p1i][p1j].equalsIgnoreCase(" ")){ // you can't enter your symbol X or O if the space is not empty
                board[p1i][p1j] = "X";// p1 -> X
               if(i!=4){
                   printBoard();
               }
            }

            else {
                System.out.println("The position you entered is already filled , so enter the row and column again carefully!!");
                System.out.print(" Player 1 enter value of row [0,1,2]: ");
                p1i = sc.nextInt();
                System.out.print("  Player 1 enter value of column  [0,1,2]: ");
                p1j = sc.nextInt();
                if(board[p1i][p1j].equalsIgnoreCase(" ")){
                    board[p1i][p1j] = "X";// p1 -> X
                    printBoard();
                }
            }

            if (i >= 2) {


                h = horizontalCheck();
                v = verticalCheck();
                d = diagonalCheck();

                if(h==0 || v==0 || d==0){
                        System.out.println("player 1 win [X]");
                        break;
                    }
                    else if(h==1 || v==1 || d==1 ){
                        System.out.println("player 2 win [O]");
                        break;
                    }
            }

             if(i<4){
               System.out.print(" Player 2 enter value of row [0,1,2]: ");
               p2i = sc.nextInt();
               System.out.print("  Player 2 enter value of column  [0,1,2]: ");
               p2j = sc.nextInt();
              if( board[p2i][p2j].equalsIgnoreCase(" ")){
                  board[p2i][p2j] = "O";
              }
              else {
                  System.out.println("The position you entered is already filled , so enter the row and column again carefully!!");
                  System.out.print(" Player 2 enter value of row [0,1,2]: ");
                  p2i = sc.nextInt();
                  System.out.print("  Player 2 enter value of column  [0,1,2]: ");
                  p2j = sc.nextInt();
                  if( board[p2i][p2j].equalsIgnoreCase(" ")){
                      board[p2i][p2j] = "O";
                  }

              }

           }


             printBoard();

             if (i >= 2) {
                h = horizontalCheck();
                v = verticalCheck();
                d = diagonalCheck();

                if(h==0 || v==0 || d==0){
                    System.out.println("player 1 win [X]");
                    break;
                }
                else if(h==1 || v==1 || d==1 ){
                    System.out.println("player 2 win [O]");
                    break;
                }

                }

             if(i==4){
                 if(h==-1 && v==-1 && d==-1){
                     System.out.println( "Draw");
                     break;
                 }
             }




            i++;
        } while (i<5);


    } // combine all methods to make game work properly
}


public class TicTacToeInJAVA {
    public static void main(String[] args) {

        TicTacToeGame t1 =new TicTacToeGame();
        System.out.println("Tic Tac Toe Game ");

        t1.start();
    }
}
