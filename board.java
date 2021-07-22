class board implements global {
    public block[][] blocks = new block[3][3];
    private int state = 0;

    public board() {
        for(int v1 = 0; v1 < 3; ++v1) {
            for(int v2 = 0; v2 < 3; ++v2) {
                this.blocks[v1][v2] = new block();
            }
        }

    }

    public void displayBoard() {
        System.out.print("" + this.blocks[0][0] + "|" + this.blocks[0][1] + "|" + this.blocks[0][2] + "\n");
        System.out.print("" + this.blocks[1][0] + "|" + this.blocks[1][1] + "|" + this.blocks[1][2] + "\n");
        System.out.print("" + this.blocks[2][0] + "|" + this.blocks[2][1] + "|" + this.blocks[2][2] + "\n");
    }

    public void displayPlayerSelectionBoard() {
        int v1 = 1;

        for(int v2 = 0; v2 < 3; ++v2) {
            for(int v3 = 0; v3 < 3; ++v3) {
                System.out.print(this.blocks[v2][v3].getState() == 0 ? v1 : this.blocks[v2][v3]);
                ++v1;
                if (v3 != 2) {
                    System.out.print("|");
                }
            }

            System.out.print("\n");
        }

    }

    public int getState() {
        return this.updateState();
    }

    public int updateState() {
        int v1 = this.checkRow(0) + this.checkRow(1) + this.checkRow(2) + this.checkCol(0) + this.checkCol(1) + this.checkCol(2) + this.checkDiagonals();
        if (v1 != 0) {
            this.state = v1;
        } else {
            this.state = this.checkDraw();
        }

        return this.state;
    }

    private int checkDraw() {
        for(int v1 = 0; v1 < 3; ++v1) {
            for(int v2 = 0; v2 < 3; ++v2) {
                if (this.blocks[v1][v2].getState() == 0) {
                    return 0;
                }
            }
        }

        return 3;
    }

    private int checkRow(int v1) {
        return this.blocks[v1][0].getState() != 0 && this.blocks[v1][0].getState() == this.blocks[v1][1].getState() && this.blocks[v1][1].getState() == this.blocks[v1][2].getState() ? this.blocks[v1][0].getState() : 0;
    }

    private int checkCol(int v1) {
        return this.blocks[0][v1].getState() != 0 && this.blocks[0][v1].getState() == this.blocks[1][v1].getState() && this.blocks[1][v1].getState() == this.blocks[2][v1].getState() ? this.blocks[0][v1].getState() : 0;
    }

    private int checkDiagonals() {
        if (this.blocks[0][0].getState() != 0 && this.blocks[0][0].getState() == this.blocks[1][1].getState() && this.blocks[1][1].getState() == this.blocks[2][2].getState()) {
            return this.blocks[0][0].getState();
        } else {
            return this.blocks[0][2].getState() != 0 && this.blocks[0][2].getState() == this.blocks[1][1].getState() && this.blocks[1][1].getState() == this.blocks[2][0].getState() ? this.blocks[0][2].getState() : 0;
        }
    }

    public boolean makeMove(int v1, int v2) {
        byte v3 = 0;
        byte v4 = 0;
        if (v1 >= 1 && v1 <= 9) {
            if (v1 == 1) {
                v3 = 0;
                v4 = 0;
            }

            if (v1 == 2) {
                v3 = 0;
                v4 = 1;
            }

            if (v1 == 3) {
                v3 = 0;
                v4 = 2;
            }

            if (v1 == 4) {
                v3 = 1;
                v4 = 0;
            }

            if (v1 == 5) {
                v3 = 1;
                v4 = 1;
            }

            if (v1 == 6) {
                v3 = 1;
                v4 = 2;
            }

            if (v1 == 7) {
                v3 = 2;
                v4 = 0;
            }

            if (v1 == 8) {
                v3 = 2;
                v4 = 1;
            }

            if (v1 == 9) {
                v3 = 2;
                v4 = 2;
            }

            if (this.blocks[v3][v4].getState() == 0) {
                this.blocks[v3][v4].setState(v2);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
