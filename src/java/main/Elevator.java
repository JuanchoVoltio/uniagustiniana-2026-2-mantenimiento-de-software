class Elevator {
    private final int minLevel;
    private final int maxLevel;
    private int currentLevel;

    public Elevator(int initialLevel, int minLevel, int maxLevel) {
        if (minLevel > maxLevel) {
            throw new IllegalArgumentException("minLevel no puede ser mayor que maxLevel");
        }
        if (initialLevel < minLevel || initialLevel > maxLevel) {
            throw new IllegalArgumentException("initialLevel debe estar entre minLevel y maxLevel");
        }
        this.currentLevel = initialLevel;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void goUp() {
        if (currentLevel >= maxLevel) {
            System.out.println("No se puede subir más, ya está en el piso máximo (" + maxLevel + ")");
            return;
        }
        System.out.println("Subiendo....");
        currentLevel++;
    }

    public void goDown() {
        if (currentLevel <= minLevel) {
            System.out.println("No se puede bajar más, ya está en el piso mínimo (" + minLevel + ")");
            return;
        }
        System.out.println("Bajando....");
        currentLevel--;
    }
}

class Main {
    public static void main(String[] args) {
        // Ascensor entre el piso 0 y el piso 5, empezando en el piso 1
        Elevator e = new Elevator(1, 0, 5);

        e.goUp();
        e.goUp();
        System.out.println("El ascensor esta en el piso: " + e.getCurrentLevel());

        // Forzamos que llegue al límite máximo
        for (int i = 0; i < 10; i++) {
            e.goUp();
        }
        System.out.println("El ascensor esta en el piso: " + e.getCurrentLevel());

        // Forzamos que llegue al límite mínimo (negativo)
        for (int i = 0; i < 10; i++) {
            e.goDown();
        }
        System.out.println("El ascensor esta en el piso: " + e.getCurrentLevel());
    }
}