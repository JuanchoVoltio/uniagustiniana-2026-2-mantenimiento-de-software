class Main {
    public static void main(String[] args) {
        // Inicializamos con piso actual 1, mínimo 1, máximo 5
        Elevator e = new Elevator(1, 1, 5);
        
        e.goUp();
        e.goUp();
        e.goDown();
        
        // Intento de bajar más allá del límite
        e.goDown(); 
        e.goDown(); 
        
        System.out.println("El ascensor está en el piso: " + e.getCurrentLevel());
    }
}

class Elevator {
    // 1. Encapsulamiento: Las propiedades deben ser privadas
    private int currentLevel;
    private final int MAX_LEVEL;
    private final int MIN_LEVEL;

    // 2. Inicialización: El constructor debe recibir o definir los límites
    public Elevator(int initialLevel, int minLevel, int maxLevel) {
        this.MIN_LEVEL = minLevel;  
        this.MAX_LEVEL = maxLevel;
        
        // Validación inicial para asegurar que no empiece fuera de límites
        if (initialLevel >= minLevel && initialLevel <= maxLevel) {
            this.currentLevel = initialLevel;
        } else {
            this.currentLevel = minLevel; // Valor por defecto seguro
        }
    }

    public void goUp() {
        // 3. Validación de límites al subir
        if (currentLevel < MAX_LEVEL) {
            System.out.println("Subiendo....");
            currentLevel++;
        } else {
            System.out.println("Ya estás en el último piso (" + MAX_LEVEL + "). No puedes subir más.");
        }
    }

    public void goDown() {
        // 3. Validación de límites al bajar
        if (currentLevel > MIN_LEVEL) {
            System.out.println("Bajando....");
            currentLevel--;
        } else {
            System.out.println("Ya estás en la planta baja (" + MIN_LEVEL + "). No puedes bajar más.");
        }
    }
    
    // 4. Getter para acceder al estado sin permitir que se modifique desde afuera
    public int getCurrentLevel() {
        return currentLevel;
    }
}