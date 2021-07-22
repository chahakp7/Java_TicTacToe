abstract class player {
    public int playerSymbol;
    public board gameBoard;
    public String playerName;

    public abstract void play(board v1);

    public player(board v1, int v2, String v3) {
        this.gameBoard = v1;
        this.playerSymbol = v2;
        this.playerName = v3;
    }

    public String toString() {
        return this.playerName;
    }
}
