package Splitwise.Expense.Split;

public class SplitFactory {

    public ExpenseSplit getExpenseSplit(SplitType splitType){
        switch (splitType){
            case UNIFORM_AMOUNT -> {
                return new UniformExpenseSplit();
            }
            case NON_UNIFORM_AMOUNT -> {
                return new NonUniformExpenseSplit();
            }
            case PERCENTAGE -> {
                return new PercentageExpenseSplit();
            }
            default -> {
                return null;
            }
        }
    }
}
