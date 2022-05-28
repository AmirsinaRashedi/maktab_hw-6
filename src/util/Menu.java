package util;

public class Menu {

    public static void welcomeMenu() {
        System.out.println();
        System.out.println("1- isEmpty");
        System.out.println("2- add node");
        System.out.println("3- remove node");
        System.out.println("4- search list");
        System.out.println("5- print list");
        System.out.println("6-exit");
        System.out.print("choose: ");
    }

    public static void addMenu() {
        System.out.println();
        System.out.println("1- add first");
        System.out.println("2- add last");
        System.out.print("choose: ");
    }

    public static void removeMenu() {
        System.out.println();
        System.out.println("1- with index");
        System.out.println("2- with object");
        System.out.print("choose: ");
    }

    public static void searchMenu() {
        System.out.println();
        System.out.println("1- with index");
        System.out.println("2- with object");
        System.out.print("choose: ");
    }
}
