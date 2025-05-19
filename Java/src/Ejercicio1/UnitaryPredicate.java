package Ejercicio1;

public class UnitaryPredicate implements Predicate {
    private UnitaryPredicateEnum type;
    private Predicate operand;

    public UnitaryPredicate(UnitaryPredicateEnum type, Predicate operand) {
        this.type = type;
        this.operand = operand;
    }

    @Override
    public boolean eval(int a) {
        switch (type) {
            case IDENTITY:
                return operand.eval(a);
            case NOT:
                return !operand.eval(a);
            default:
                throw new IllegalStateException("Unexpected type: " + type);
        }
    }

    public Predicate getOperand() {
        return operand;
    }

    public UnitaryPredicateEnum getType() {
        return type;
    }
}