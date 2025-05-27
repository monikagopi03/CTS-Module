
public class TypeCastingDemo {
    public static void main(String[] args) {
        double decimalValue = 9.78;
        int castedInt = (int) decimalValue;

        int wholeNumber = 10;
        double castedDouble = wholeNumber;

        System.out.println("Original double: " + decimalValue);
        System.out.println("Casted to int: " + castedInt);
        System.out.println("Original int: " + wholeNumber);
        System.out.println("Casted to double: " + castedDouble);
    }
}
