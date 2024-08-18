package VendingMachine;

public enum Money {
    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    final int value;

    Money(int value) {
        this.value = value;
    }
}
