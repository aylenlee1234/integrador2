package Ejercicio1;

public class UnitaryPredicate implements Predicate {
    private final UnitaryPredicateEnum op;
    private final Predicate value;

    public UnitaryPredicate(UnitaryPredicateEnum op, Predicate value) {
        this.op = op;
        this.value = value;
    }

    @Override
    public boolean eval(int a) {
        return switch (op) {
            case IDENTITY -> value.eval(a);
            case NOT -> !value.eval(a);
        };
    }
}
