import java.util.Random;
import java.util.Scanner;

class game implements global 
{
    board brd;
    player xPlay;
    player oPlay;
    int turn;
    boolean done = false;

    public game() 
    {
        Scanner v1 = new Scanner(System.in);
        this.brd = new board();
        String v2 = "player1";
        String v3 = "player2";
        int v4 = 0;
        System.out.println("--------------------------------------");
        System.out.println("OXOXOXOXO     Tic            XOXOXOXOX");
        System.out.println("XOXOXOXOX         Tac        OXOXOXOXO");
        System.out.println("OXOXOXOXO            Toe     XOXOXOXOX");
        System.out.println("--------------------------------------\n");
        

        while(!this.done) {
            System.out.println("Hello, Welcome to TicTacToe");
            System.out.println("Please select any of the below game option!!!: 1. Human vs Human \n 2. Human vs AI \n 3. AI vs AI");
            v4 = v1.nextInt();
            switch(v4) 
            {
                case 1:
                    System.out.print("Enter name for player X: ");
                    v2 = v1.next().trim();
                    System.out.print("Enter name for player O: ");
                    v3 = v1.next().trim();
                    this.done = true;
                    break;
                case 2:
                    System.out.print("Enter name for player X: ");
                    v2 = v1.next().trim();
                    System.out.print("Enter name for player O: ");
                    v3 = v1.next().trim();
                    System.out.println("This is CK_Bot");
                    System.out.println("Tensed? " + v2 + ", I am easy to beat\n");
                    this.done = true;
                    break;
                case 3:
                    System.out.print("Please enter Novice AI player X name: ");
                    v2 = v1.next().trim();
                    System.out.print("Please enter Advanced AI player O name: ");
                    v3 = v1.next().trim();
                    this.done = true;
                    break;
                default:
                    System.out.println("Select any...");
            }
        }

        if (v4 == 1) {
            this.xPlay = new HumanPlayer(this.brd, 1, v2);
            this.oPlay = new HumanPlayer(this.brd, 2, v3);
        } else if (v4 == 2) {
            this.xPlay = new HumanPlayer(this.brd, 1, v2);
            this.oPlay = new AIPlayer(this.brd, 2, v3);
        } else {
            this.xPlay = new AIPlayer(this.brd, 1, v2);
            this.oPlay = new AIPlayer(this.brd, 2, v3);
        }

        System.out.println("Lets Begin!!!:" + v2 + " VS. " + v3 );
    
    }

    public void start() {
        Random v1 = new Random();
        boolean v2 = false;
        this.turn = v1.nextInt(2) + 1;
        if (this.turn == 1) {
            System.out.println(this.xPlay.playerName + " Congo X,you'll start\n");
        } else {
            System.out.println(this.oPlay.playerName + " Congo O,you'll start\n");
        }

        while(!v2) {
            if (this.turn == 1) {
                System.out.println("\nPlayer X's Turn, lets go " + this.xPlay.playerName + ":");
                this.xPlay.play(this.brd);
            } else {
                System.out.println("\nPlayer O's Turn, lets go  " + this.oPlay.playerName + ":");
                this.oPlay.play(this.brd);
            }

            if (this.brd.getState() != 0) {
                v2 = true;
            }

            if (!v2) {
                if (this.turn == 1) {
                    this.turn = 2;
                } else {
                    this.turn = 1;
                }
            }
        }

        this.brd.displayBoard();
        if (this.brd.getState() == 3) {
            System.out.println("\nThere is no winner!!!");
        } else if (this.turn == 1) {
            System.out.println("\nThe winner of the match is player " + this.xPlay);
        } else {
            System.out.println("\nThe winner of the match is player " + this.oPlay);
        }

    }
}
