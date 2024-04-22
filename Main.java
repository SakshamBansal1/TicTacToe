import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // Initialize the board with empty spaces
        char board[][]=new char[3][3];
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                board[row][col]=' ';
            }
        }
        
        int gameDraw=0;
        char player='X';
        boolean gameOver=false;

        // Play the game
        while(!gameOver){
            printBoard(board);
            System.out.print("Player-> "+player+" turn."+" Enter (row col) -> ");
            int row=sc.nextInt();                               //taking input for row and space 
            int col=sc.nextInt();                               // with space b/w them
            try{
                if(row>=3 || col>=3){                           //handle array index error
                    throw new Exception("s");
                }
                else{
                    if(board[row][col]==' ' && row<3 && col<3){
                        board[row][col]=player;
        
                        gameOver=haveWon(board,player);
                        if(gameOver){
                            break;
                        }
                        else if(draw(board)){
                            gameDraw=1;
                            printBoard(board);
                            System.out.println("Game has been draw");
                            break;
                        }
                        else
                        player=(player=='X') ? 'O' : 'X';     //Switch the current player
                    }
                    else{
                        System.out.println("Invalid Move");
                    }
                }
            }
            catch(Exception e){                                //error handler
                if(e.getMessage()=="s"){
                    System.out.println("Invalid Move");
                }
            }
        }
        if (gameDraw==0) {                                      //if game is Draw
            printBoard(board);
        System.out.println("Player : "+player+" has won the game.");
        }
        sc.close();
    }

    // Check if the board is full
    public static boolean draw(char board[][]) {
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                if(board[row][col]==' '){
                    return false;
                }
            }
        }
        return true;
    }

    // Check if there's a winner
    public static boolean haveWon(char board[][], char player) {
        // Check rows
        for(int row=0;row<3;row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }

        // Check columns
        for(int col=0;col<3;col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }

        // Check diagonals
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }

    // Print the current state of the board
    public static void printBoard(char board[][]) {
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }
}