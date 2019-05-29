package generic;

public class GenericMethodTest {

    // generic method printArray
    public static <E> void printArray(E[] inputArray) {
        //display array elements
        for (E el : inputArray) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        //Create arrays of int, double, and char
        Integer[] intArray = {1, 8, 2, 5, 99, 23};
        Double[] doubleArray = {1.1, 2.5, 8.88, 25.1, 8.0};
        Character[] charArray = {'d', 'v', 'm', 'i', 'j'};

        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);
    }


}
