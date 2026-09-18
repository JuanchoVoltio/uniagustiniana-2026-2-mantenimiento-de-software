class Elevator {
    public int currentLevel;
    public int MAX_LEVEL;
    public int MIN_LEVEL;

    public Elevator(int initialLevel, int minLevel, int maxLevel) {
        this.currentLevel = initialLevel;
        this.MIN_LEVEL = minLevel;
        this.MAX_LEVEL = maxLevel;
    }

    public void goUp() {
        if (currentLevel >= MAX_LEVEL) {
            System.out.println("Ya en el nivel máximo, no se puede subir más.");
            return;
        }
        System.out.println("Subiendo....");
        currentLevel++;
    }

    public void goDown() {
        if (currentLevel <= MIN_LEVEL) {
            System.out.println("Ya en el nivel mínimo, no se puede bajar más.");
            return;
        }
        System.out.println("Bajando....");
        currentLevel--;
    }
}
