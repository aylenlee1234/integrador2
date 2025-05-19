package Ejercicio1;

public class BiPredicate implements Predicate {
    private final BiPredicateEnum op;
    private final Predicate left;
    private final Predicate right;

    public BiPredicate(BiPredicateEnum op, Predicate left, Predicate right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean eval(int a) {
        return switch (op) {
            case AND -> left.eval(a) && right.eval(a);
            case OR -> left.eval(a) || right.eval(a);
        };
    }
}
