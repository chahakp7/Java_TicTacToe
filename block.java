class block implements global {
    private int state = 0;

    public block() {
    }

    public boolean setState(int v1) {
        if (this.isValidState(v1)) {
            this.state = v1;
            return true;
        } else {
            return false;
        }
    }

    public int getState() {
        return this.state;
    }

    public boolean isValidState(int v1) {
        return v1 == 2 || v1 == 1;
    }

    public String toString() {
        if (this.state == 0) {
            return " ";
        } else {
            return this.state == 1 ? "x" : "o";
        }
    }
}
