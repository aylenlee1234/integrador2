package Ejercicio6;

public interface PriorityQueue {

    void add(int priority, int value);
    void remove();
    boolean isEmpty();
    int getFirst();
    int getPriority();

}

