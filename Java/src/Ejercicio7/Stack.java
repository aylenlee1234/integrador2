package Ejercicio7;

public class Stack {
    private Node top;

    private static class Node {
        int value;
        Node next;
    }

    public void push(int x) {
        Node n = new Node();
        n.value = x;
        n.next = top;
        top = n;
    }

    public int pop() {
        if (top == null) throw new RuntimeException("Empty stack");
        int value = top.value;
        top = top.next;
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (top == null) throw new RuntimeException("Empty stack");
        return top.value;
    }

    public void print() {
        Node current = top;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
