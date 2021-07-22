
import java.util.Scanner;

class HumanPlayer extends player {
    public HumanPlayer(board v1, int v2, String v3) {
        super(v1, v2, v3);
    }

    public void play(board v1) {
        Scanner var4 = new Scanner(System.in);
        super.gameBoard = v1;

        boolean v3;
        do {
            System.out.println("CK_Bot:Enter your move by choosing a number from the empty moves: ");
            v1.displayPlayerSelectionBoard();
            int v2 = var4.nextInt();
            v3 = v1.makeMove(v2, this.playerSymbol);
            if (!v3) {
                System.out.println("CK_Bot: Oooops! it's invalid");
            }
        } while(!v3);

    }
}
