package Ejercicio7;

public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(3);
        s.push(2);
        s.push(1);

        StackUtils.addToBottomIfNotExists(s, 0); // lo agrega
        StackUtils.addToBottomIfNotExists(s, 2); // no lo agrega

        s.print(); // Esperado: 1 2 3 0
    }
}
