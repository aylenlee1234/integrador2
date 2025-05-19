package Ejercicio7;

public class StackUtils {
    // Devuelve true si el elemento ya estaba, false si no
    public static boolean addToBottomIfNotExists(Stack stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x); // Agrego el elemento porque no estaba
            return false;
        }

        int top = stack.pop();
        boolean found = (top == x) || addToBottomIfNotExists(stack, x);
        stack.push(top);
        return found;
    }
}