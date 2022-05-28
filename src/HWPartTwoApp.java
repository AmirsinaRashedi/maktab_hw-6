import domain.MyLinkedList;
import util.Menu;

import java.util.Scanner;

public class HWPartTwoApp {
    public static void main(String[] args) {
        System.out.println("second part");

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        while (true) {

            Scanner intInput = new Scanner(System.in);

            Scanner stringInput = new Scanner(System.in);

            try {

                Menu.welcomeMenu();

                int choice = intInput.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("is myLinkedList empty? ");

                        System.out.println(myLinkedList.isEmpty());

                        break;

                    case 2:

                        Menu.addMenu();

                        choice = intInput.nextInt();

                        switch (choice) {

                            case 1:

                                System.out.print("enter the object: ");

                                myLinkedList.setFirst(stringInput.nextLine());

                                break;

                            case 2:

                                System.out.print("enter the object: ");

                                myLinkedList.setLast(stringInput.nextLine());

                                break;

                            default:

                                break;

                        }

                        break;

                    case 3:

                        Menu.removeMenu();

                        choice = intInput.nextInt();

                        switch (choice) {

                            case 1:

                                System.out.print("enter the index: ");

                                myLinkedList.remove(intInput.nextInt());

                                break;

                            case 2:

                                System.out.print("enter the object: ");

                                myLinkedList.remove(stringInput.nextLine());

                                break;

                            default:

                                break;

                        }

                        break;

                    case 4:

                        Menu.searchMenu();

                        choice = intInput.nextInt();

                        switch (choice) {

                            case 1:

                                System.out.print("enter the index: ");

                                System.out.println(myLinkedList.get(intInput.nextInt()));

                                break;

                            case 2:

                                System.out.print("enter the object: ");

                                System.out.println(myLinkedList.get(stringInput.nextLine()));

                                break;

                            default:

                                break;
                        }

                        break;

                    case 5:

                        myLinkedList.printList();

                        break;

                    case 6:

                        return;

                    default:

                        break;

                }

            } catch (RuntimeException e) {

                e.getStackTrace();

            }

        }

    }

}

