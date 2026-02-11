import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class linkedlist {

    static Node start = null;

    static void display() {
        if (start == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        Node ptr = start;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("NULL");
    }

    static void insertAtBeginning(int value) {
        Node n = new Node(value);
        n.next = start;
        start = n;
    }

    static void insertAtEnd(int value) {
        Node n = new Node(value);
        if (start == null) {
            start = n;
            return;
        }
        Node ptr = start;
        while (ptr.next != null)
            ptr = ptr.next;
        ptr.next = n;
    }

    static void insertAfterValue(int value, int key) {
        Node ptr = start;
        while (ptr != null && ptr.data != key)
            ptr = ptr.next;
        if (ptr == null) {
            System.out.println("Value not found!");
            return;
        }
        Node n = new Node(value);
        n.next = ptr.next;
        ptr.next = n;
    }

    static void insertBeforeValue(int value, int key) {
        if (start == null) {
            System.out.println("List is empty!");
            return;
        }
        if (start.data == key) {
            insertAtBeginning(value);
            return;
        }
        Node prev = null;
        Node curr = start;
        while (curr != null && curr.data != key) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Value not found!");
            return;
        }
        Node n = new Node(value);
        prev.next = n;
        n.next = curr;
    }

    static void deleteAtBeginning() {
        if (start == null) {
            System.out.println("List is empty!");
            return;
        }
        start = start.next;
    }

    static void deleteAtEnd() {
        if (start == null) {
            System.out.println("List is empty!");
            return;
        }
        if (start.next == null) {
            start = null;
            return;
        }
        Node ptr = start;
        while (ptr.next.next != null)
            ptr = ptr.next;
        ptr.next = null;
    }

    static void deleteValue(int value) {
        if (start == null) {
            System.out.println("List is empty!");
            return;
        }
        if (start.data == value) {
            start = start.next;
            return;
        }
        Node prev = null;
        Node curr = start;
        while (curr != null && curr.data != value) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Value not found!");
            return;
        }
        prev.next = curr.next;
    }

    static void deleteAfterValue(int key) {
        if (start == null) {
            System.out.println("List is empty!");
            return;
        }
        Node ptr = start;
        while (ptr != null && ptr.data != key)
            ptr = ptr.next;
        if (ptr == null || ptr.next == null) {
            System.out.println("Deletion not possible!");
            return;
        }
        ptr.next = ptr.next.next;
    }

    static void deleteBeforeValue(int key) {
        if (start == null || start.next == null) {
            System.out.println("Deletion not possible!");
            return;
        }
        if (start.next.data == key) {
            start = start.next;
            return;
        }
        Node prev = null;
        Node curr = start;
        while (curr.next != null && curr.next.data != key) {
            prev = curr;
            curr = curr.next;
        }
        if (curr.next == null) {
            System.out.println("Value not found!");
            return;
        }
        prev.next = curr.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1 Insert at beginning");
            System.out.println("2 Insert at end");
            System.out.println("3 Insert after value");
            System.out.println("4 Insert before value");
            System.out.println("5 Delete at beginning");
            System.out.println("6 Delete at end");
            System.out.println("7 Delete value");
            System.out.println("8 Delete after value");
            System.out.println("9 Delete before value");
            System.out.println("10 Display");
            System.out.println("11 Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertAtBeginning(sc.nextInt());
                    break;
                case 2:
                    insertAtEnd(sc.nextInt());
                    break;
                case 3:
                    insertAfterValue(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    insertBeforeValue(sc.nextInt(), sc.nextInt());
                    break;
                case 5:
                    deleteAtBeginning();
                    break;
                case 6:
                    deleteAtEnd();
                    break;
                case 7:
                    deleteValue(sc.nextInt());
                    break;
                case 8:
                    deleteAfterValue(sc.nextInt());
                    break;
                case 9:
                    deleteBeforeValue(sc.nextInt());
                    break;
                case 10:
                    display();
                    break;
                case 11:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
