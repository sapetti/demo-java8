

interface IDefaultMethod {

    static String getStaticValue() {
        return "Some value";
    }

    default String getAnotherValue() {
        return "Another value";
    }
}


public class DemoDefaultMethods implements IDefaultMethod {

    // Venkat: Un interfaz dice mucho lo que va a hacer, pero nunca hace nada


    // 1. Si un interfaz extiende otro que tiene metodos por defecto, los hereda atomaticamente
    // 2. Puede sobreescribirlos
    // 3. Reglas de herencia

    public static void main(String[] args) {
        DemoDefaultMethods example = new DemoDefaultMethods();

        print(IDefaultMethod.getStaticValue());
//        print(DemoDefaultMethods.getStaticValue()); // NO!

        print(example.getAnotherValue());
    }

    static void print(Object text) {
        System.out.println(text);
    }

}


// Ejemplo para mostrar las reglas de la herencia
interface Car {
    default void move() {
        System.out.println("Car - Move");
    }
    default void stop() {
        System.out.println("Car - Stop");
    }
    default void turn() {
        System.out.println("Car - Turn");
    }
}

interface BetterBreaksCar extends Car {
    @Override
    default void stop() {
        System.out.println("BetterBreaksCar - Stop better");
    }
}

class FastCar {
    public void move() {
        System.out.println("FastCar - Move Faster!");
    }
}

class MyCar extends FastCar implements BetterBreaksCar { }

class TestCar {
    public static void main(String[] args) {
        MyCar car = new MyCar();
        car.move(); // FastCar
        car.turn(); // Car
        car.stop(); // BetterBreaksCar
    }
}
