class Main {
    public static void main(String[] args) {
        Elevator e = new Elevator(1);

        e.goUp();
        e.goUp();

        System.out.println("El ascensor esta en el piso: " + e.getCurrentLevel());
    }
}

class Elevator {
    private int currentLevel;
    private final int MAX_LEVEL = 10;
    private final int MIN_LEVEL = 1;

    public Elevator(int initialLevel) {
        if (initialLevel >= MIN_LEVEL && initialLevel <= MAX_LEVEL) {
            this.currentLevel = initialLevel;
        } else {
            this.currentLevel = MIN_LEVEL;
        }
    }

    public void goUp() {
        if (currentLevel < MAX_LEVEL) {
            System.out.println("Subiendo....");
            currentLevel++;
        } else {
            System.out.println("Ya esta en el ultimo piso.");
        }
    }

    public void goDown() {
        if (currentLevel > MIN_LEVEL) {
            System.out.println("Bajando....");
            currentLevel--;
        } else {
            System.out.println("Ya esta en el primer piso.");
        }
    }

    public int getCurrentLevel() {
        return currentLevel;
    }
}
