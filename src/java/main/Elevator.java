/**
 * Clase principal de ejecución.
 */
class Main {
    public static void main(String[] args) {
        // Ascensor entre el piso 0 y el piso 5, empezando en el piso 1
        Elevator e = new Elevator(1, 0, 5);

        e.goUp();
        e.goUp();
        System.out.println("El ascensor esta en el piso: " + e.getCurrentLevel());

        e.goDown();
        System.out.println("El ascensor esta en el piso: " + e.getCurrentLevel());

        // Intentamos forzar un error: bajar hasta salir del rango mínimo
        try {
            e.goDown();
            e.goDown();
        } catch (IllegalStateException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        // Intentamos forzar un error: subir hasta salir del rango máximo
        try {
            for (int i = 0; i < 10; i++) {
                e.goUp();
            }
        } catch (IllegalStateException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println("Piso final: " + e.getCurrentLevel());
        System.out.println(e);

        // Ejemplo de validación al crear un ascensor con datos inválidos
        try {
            Elevator invalido = new Elevator(10, 0, 5);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error al crear ascensor: " + ex.getMessage());
        }
    }
}

/**
 * Representa un ascensor que se mueve entre un piso mínimo y un piso máximo.
 * El estado del ascensor (piso actual) solo puede modificarse mediante
 * los métodos {@link #goUp()} y {@link #goDown()}, que respetan los límites
 * definidos al momento de construir el objeto.
 */
class Elevator {
    private int currentLevel;
    private final int maxLevel;
    private final int minLevel;

    /**
     * Crea un ascensor en un piso inicial dentro del rango permitido.
     *
     * @param initialLevel piso inicial del ascensor
     * @param minLevel piso mínimo permitido
     * @param maxLevel piso máximo permitido
     * @throws IllegalArgumentException si minLevel es mayor que maxLevel,
     *         o si initialLevel está fuera del rango [minLevel, maxLevel]
     */
    public Elevator(int initialLevel, int minLevel, int maxLevel) {
        if (minLevel > maxLevel) {
            throw new IllegalArgumentException(
                "El piso mínimo (" + minLevel + ") no puede ser mayor que el piso máximo (" + maxLevel + ")"
            );
        }
        if (initialLevel < minLevel || initialLevel > maxLevel) {
            throw new IllegalArgumentException(
                "El piso inicial (" + initialLevel + ") está fuera del rango permitido [" + minLevel + ", " + maxLevel + "]"
            );
        }
        this.currentLevel = initialLevel;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
    }

    /**
     * Sube un piso el ascensor.
     *
     * @throws IllegalStateException si el ascensor ya está en el piso máximo
     */
    public void goUp() {
        if (currentLevel >= maxLevel) {
            throw new IllegalStateException("El ascensor ya está en el piso máximo (" + maxLevel + ")");
        }
        System.out.println("Subiendo....");
        currentLevel++;
    }

    /**
     * Baja un piso el ascensor.
     *
     * @throws IllegalStateException si el ascensor ya está en el piso mínimo
     */
    public void goDown() {
        if (currentLevel <= minLevel) {
            throw new IllegalStateException("El ascensor ya está en el piso mínimo (" + minLevel + ")");
        }
        System.out.println("Bajando....");
        currentLevel--;
    }

    /**
     * @return el piso actual del ascensor
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * @return el piso máximo permitido para este ascensor
     */
    public int getMaxLevel() {
        return maxLevel;
    }

    /**
     * @return el piso mínimo permitido para este ascensor
     */
    public int getMinLevel() {
        return minLevel;
    }

    @Override
    public String toString() {
        return "Elevator{currentLevel=" + currentLevel + ", minLevel=" + minLevel + ", maxLevel=" + maxLevel + "}";
    }
}