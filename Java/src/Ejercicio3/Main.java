package Ejercicio3;

import Ejercicio1.*;

public class Main {
    public static void main(String[] args) {
    System.out.println("\nEjercicio 3 - Optimización de Predicados");

    Predicate pA = new AtomicPredicate(42);
    Predicate doubleNeg = new UnitaryPredicate(UnitaryPredicateEnum.NOT,
            new UnitaryPredicate(UnitaryPredicateEnum.NOT, pA));

    Predicate optimized = PredicateOptimizer.optimize(doubleNeg);
        System.out.println("Original eval(42): " + doubleNeg.eval(42));
        System.out.println("Optimizado eval(42): " + optimized.eval(42));
        System.out.println("¿Es exactamente pA? " + (optimized == pA));

    Predicate unionSame = new BiPredicate(BiPredicateEnum.OR, pA, pA);
    Predicate optimizedUnion = PredicateOptimizer.optimize(unionSame);
        System.out.println("Optimizado A ∪ A eval(42): " + optimizedUnion.eval(42));

    Predicate empty = new BiPredicate(BiPredicateEnum.AND,
            new UnitaryPredicate(UnitaryPredicateEnum.NOT, pA), pA);
    Predicate intersection = new BiPredicate(BiPredicateEnum.AND, pA, empty);
    Predicate optimizedInt = PredicateOptimizer.optimize(intersection);
        System.out.println("Optimizado A ∩ ∅ eval(42): " + optimizedInt.eval(42));

    }
}
