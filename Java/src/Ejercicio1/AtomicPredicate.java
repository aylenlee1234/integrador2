package Ejercicio1;

public class AtomicPredicate implements Predicate {
    private final int value;

    public AtomicPredicate(int value) {
        this.value = value;
    }

    @Override
    public boolean eval(int a) {
        return a == value;
    }
}
