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
            System.out.println("No se puede subir más, ya está en el piso máximo (" + MAX_LEVEL + ")");
            return;
        }
        System.out.println("Subiendo....");
        currentLevel++;
    }

    public void goDown() {
        if (currentLevel <= MIN_LEVEL) {
            System.out.println("No se puede bajar más, ya está en el piso mínimo (" + MIN_LEVEL + ")");
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
        System.out.println("El ascensor esta en el piso: " + e.currentLevel);

        // Forzamos que llegue al límite máximo
        for (int i = 0; i < 10; i++) {
            e.goUp();
        }
        System.out.println("El ascensor esta en el piso: " + e.currentLevel);

        // Forzamos que llegue al límite mínimo (negativo)
        for (int i = 0; i < 10; i++) {
            e.goDown();
        }
        System.out.println("El ascensor esta en el piso: " + e.currentLevel);
    }
}