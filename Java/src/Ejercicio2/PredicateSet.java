package Ejercicio2;

import Ejercicio1.*;

public class PredicateSet {
    private Predicate predicate;

    public PredicateSet() {
        this.predicate = null;
    }

    public PredicateSet(Predicate predicate) {
        this.predicate = predicate;
    }

    public void add(int x) {
        Predicate newElement = new AtomicPredicate(x);
        if (predicate == null) {
            predicate = newElement;
        } else {
            predicate = new BiPredicate(BiPredicateEnum.OR, predicate, newElement);
        }
    }

    public void remove(int x) {
        Predicate target = new AtomicPredicate(x);
        Predicate negated = new UnitaryPredicate(UnitaryPredicateEnum.NOT, target);
        if (predicate != null) {
            predicate = new BiPredicate(BiPredicateEnum.AND, predicate, negated);
        }
    }

    public boolean belongs(int x) {
        if (predicate == null) return false;
        return predicate.eval(x);
    }

    public boolean isEmpty() {
        if (predicate == null) return true;

        for (int i = 0; i < 1000; i++) {
            if (predicate.eval(i)) {
                return false;
            }
        }
        return true;
    }

    public int choose() {
        if (predicate == null) {
            throw new RuntimeException("El conjunto está vacío");
        }

        for (int i = 0; i < 1000; i++) {
            if (predicate.eval(i)) {
                return i;
            }
        }

        throw new RuntimeException("No se encontró ningún elemento en el conjunto");
    }

    public Predicate getPredicate() {
        return predicate;
    }
}
