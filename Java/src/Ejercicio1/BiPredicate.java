package Ejercicio1;

public class BiPredicate implements Predicate {
    private BiPredicateEnum type;
    private Predicate left;
    private Predicate right;

    public BiPredicate(BiPredicateEnum type, Predicate left, Predicate right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean eval(int a) {
        switch (type) {
            case AND:
                return left.eval(a) && right.eval(a);
            case OR:
                return left.eval(a) || right.eval(a);
            default:
                throw new IllegalStateException("Unexpected type: " + type);
        }
    }

    public Predicate getLeft() {
        return left;
    }

    public Predicate getRight() {
        return right;
    }

    public BiPredicateEnum getType() {
        return type;
    }
}

//hola