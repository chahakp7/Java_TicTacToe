import java.util.Random;

public class AIPlayer extends player implements global {
    public AIPlayer(board v1, int v2, String v3) {
        super(v1, v2, v3);
    }

    public void play(board v1) {
        boolean v2 = false;
        int v3 = this.randomLegal();
        v1.makeMove(v3, this.playerSymbol);
        System.out.println(this.playerName + ": made a change of random move at position" + v3);
    }

    private int senseWin() {
        for(int v1 = 0; v1 < 3; ++v1) {
            for(int v2 = 0; v2 < 3; ++v2) {
                if (this.gameBoard.blocks[v1][v2].getState() == 0) {
                    int v3 = 0;
                    if (this.gameBoard.blocks[0][v2].getState() == this.playerSymbol) {
                        ++v3;
                    }

                    if (this.gameBoard.blocks[1][v2].getState() == this.playerSymbol) {
                        ++v3;
                    }

                    if (this.gameBoard.blocks[2][v2].getState() == this.playerSymbol) {
                        ++v3;
                    }

                    if (v3 == 2) {
                        return 3 * v1 + 1 + v2;
                    }

                    v3 = 0;
                    if (this.gameBoard.blocks[v1][0].getState() == this.playerSymbol) {
                        ++v3;
                    }

                    if (this.gameBoard.blocks[v1][1].getState() == this.playerSymbol) {
                        ++v3;
                    }

                    if (this.gameBoard.blocks[v1][2].getState() == this.playerSymbol) {
                        ++v3;
                    }

                    if (v3 == 2) {
                        return 3 * v1 + 1 + v2;
                    }

                    v3 = 0;
                    if (v1 == 0 && v2 == 2 || v1 == 1 && v2 == 1 || v1 == 2 && v2 == 0) {
                        if (this.gameBoard.blocks[0][2].getState() == this.playerSymbol) {
                            ++v3;
                        }

                        if (this.gameBoard.blocks[1][1].getState() == this.playerSymbol) {
                            ++v3;
                        }

                        if (this.gameBoard.blocks[2][0].getState() == this.playerSymbol) {
                            ++v3;
                        }

                        if (v3 == 2) {
                            return 3 * v1 + 1 + v2;
                        }
                    }

                    v3 = 0;
                    if (v1 == 0 && v2 == 0 || v1 == 1 && v2 == 1 || v1 == 2 && v2 == 2) {
                        if (this.gameBoard.blocks[0][0].getState() == this.playerSymbol) {
                            ++v3;
                        }

                        if (this.gameBoard.blocks[1][1].getState() == this.playerSymbol) {
                            ++v3;
                        }

                        if (this.gameBoard.blocks[2][2].getState() == this.playerSymbol) {
                            ++v3;
                        }

                        if (v3 == 2) {
                            return 3 * v1 + 1 + v2;
                        }
                    }
                }
            }
        }

        return 0;
    }

    private int senseLoss() {
        byte v4;
        if (this.playerSymbol == 1) {
            v4 = 2;
        } else {
            v4 = 1;
        }

        for(int v1 = 0; v1 < 3; ++v1) {
            for(int v2 = 0; v2 < 3; ++v2) {
                if (this.gameBoard.blocks[v1][v2].getState() == 0) {
                    int v3 = 0;
                    if (this.gameBoard.blocks[0][v2].getState() == v4) {
                        ++v3;
                    }

                    if (this.gameBoard.blocks[1][v2].getState() == v4) {
                        ++v3;
                    }

                    if (this.gameBoard.blocks[2][v2].getState() == v4) {
                        ++v3;
                    }

                    if (v3 == 2) {
                        return 3 * v1 + 1 + v2;
                    }

                    v3 = 0;
                    if (this.gameBoard.blocks[v1][0].getState() == v4) {
                        ++v3;
                    }

                    if (this.gameBoard.blocks[v1][1].getState() == v4) {
                        ++v3;
                    }

                    if (this.gameBoard.blocks[v1][2].getState() == v4) {
                        ++v3;
                    }

                    if (v3 == 2) {
                        return 3 * v1 + 1 + v2;
                    }

                    v3 = 0;
                    if (v1 == 0 && v2 == 2 || v1 == 1 && v2 == 1 || v1 == 2 && v2 == 0) {
                        if (this.gameBoard.blocks[0][2].getState() == v4) {
                            ++v3;
                        }

                        if (this.gameBoard.blocks[1][1].getState() == v4) {
                            ++v3;
                        }

                        if (this.gameBoard.blocks[2][0].getState() == v4) {
                            ++v3;
                        }

                        if (v3 == 2) {
                            return 3 * v1 + 1 + v2;
                        }
                    }

                    v3 = 0;
                    if (v1 == 0 && v2 == 0 || v1 == 1 && v2 == 1 || v1 == 2 && v2 == 2) {
                        if (this.gameBoard.blocks[0][0].getState() == v4) {
                            ++v3;
                        }

                        if (this.gameBoard.blocks[1][1].getState() == v4) {
                            ++v3;
                        }

                        if (this.gameBoard.blocks[2][2].getState() == v4) {
                            ++v3;
                        }

                        if (v3 == 2) {
                            return 3 * v1 + 1 + v2;
                        }
                    }
                }
            }
        }

        return 0;
    }

    private int randomLegal() {
        int v3 = 0;
        int[] v4 = new int[9];
        Random v5 = new Random();

        for(int v1 = 0; v1 < 3; ++v1) {
            for(int v2 = 0; v2 < 3; ++v2) {
                if (this.gameBoard.blocks[v1][v2].getState() == 0) {
                    v4[v3++] = 3 * v1 + 1 + v2;
                }
            }
        }

        return v4[v5.nextInt(v3)];
    }
}
