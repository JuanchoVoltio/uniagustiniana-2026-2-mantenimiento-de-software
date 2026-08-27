class Elevator {
    public int currentLevel;
    public int MAX_LEVEL;
    public int MIN_LEVEL;

    public Elevator(initialLevel) {
        this.currentLevel = initialLevel;
    }

    public void goUp() {
        System.out.println("Subiendo....")
        currentLevel++;
    }

    public void goDown() {
        System.out.println("Bajando....")
        currentLevel--;
    }
}
