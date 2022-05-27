import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HWPartOneApp {
    public static void main(String[] args) {

        System.out.println("first part");

        Scanner intInput = new Scanner(System.in);

        System.out.print("please enter how many number you want to add:");
        int arrayListLength = intInput.nextInt();

        if (arrayListLength > 0)
            System.out.println("please enter " + arrayListLength + " numbers with one space between each number");

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < arrayListLength; i++) {
            try {
                arrayList.add(intInput.nextInt());

            } catch (InputMismatchException e) {

                intInput.next();

                System.out.print("your entry #" + (i + 1) + " is not a number! please insert a replacing integer: ");

                while (true) {

                    try {
                        Scanner tryIntInput = new Scanner(System.in);

                        arrayList.add(tryIntInput.nextInt());

                        break;

                    } catch (InputMismatchException error) {
                        System.out.print("your entry #" + (i + 1) + " is not a number! please insert a replacing integer: ");
                    }
                }


            }
        }

        System.out.print("your array is : ");

        for (Integer num : arrayList)
            System.out.print(num + "\t");

        System.out.println();

        removeImproperDous(arrayList);

        System.out.println();
        System.out.print("your array after adjusting is : ");

        for (Integer num : arrayList)
            System.out.print(num + "\t");
    }

    private static void removeImproperDous(ArrayList<Integer> arrayList) {

        for (int i = 0; i < arrayList.size(); i++) {

            try {

                if (arrayList.get(i) > arrayList.get(++i)) {

                    arrayList.remove(i);
                    arrayList.remove(i - 1);

                    i -= 2;

                }

            } catch (IndexOutOfBoundsException e) {
                arrayList.remove(i - 1);
            }

        }
    }
}
