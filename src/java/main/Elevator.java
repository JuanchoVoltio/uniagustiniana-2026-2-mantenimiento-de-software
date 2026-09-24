class Elevator {
    public int currentLevel;
    public int MAX_LEVEL;
    public int MIN_LEVEL;

    public Elevator(int initialLevel, int minLevel, int maxLevel) {
        this.MIN_LEVEL = minLevel;
        this.MAX_LEVEL = maxLevel;
        this.currentLevel = initialLevel;
    }

    public void goUp() {
        if (currentLevel < MAX_LEVEL) {
            System.out.println("Subiendo....");
            currentLevel++;
        } else {
            System.out.println("Ya estás en el último piso.");
        }
    }

    public void goDown() {
        if (currentLevel > MIN_LEVEL) {
            System.out.println("Bajando....");
            currentLevel--;
        } else {
            System.out.println("Ya estás en el primer piso.");
        }
    }
}
