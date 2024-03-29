package Ready;

// Task 2. Print a new number by adding one to each of its digit ( transform 998 --> 10109 )
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner getNumber = new Scanner(System.in);

        System.out.print("Enter any number: ");
        int number = getNumber.nextInt();
        int length = (int) (Math.log10(number) + 1);
        int temp = number;

        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> arrayFinal = new ArrayList<>();

        do {
            array.add(temp % 10);
            temp /= 10;
        } while (temp > 0);

        Collections.reverse(array);


        for (int i = 0; i < length; i++) {
            int nextArray = array.get(i);
            nextArray = nextArray + 1;
            arrayFinal.add(nextArray);
        }

        String result = arrayFinal.toString();

        for (int i = 0; i < length; i++) {
            int nextArrayFinal = arrayFinal.get(i);
            System.out.print(nextArrayFinal);
        }
    }
}
