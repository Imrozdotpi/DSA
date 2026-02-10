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
        System.out.print("List: ");
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("NULL");
    }

    static void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = start;
        start = newNode;
    }

    static void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (start == null) {
            start = newNode;
            return;
        }
        Node ptr = start;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = newNode;
    }

    static void insertAfterValue(int value, int after) {
        Node ptr = start;
        while (ptr != null && ptr.data != after) {
            ptr = ptr.next;
        }
        if (ptr == null) {
            System.out.println("Value not found!");
            return;
        }
        Node newNode = new Node(value);
        newNode.next = ptr.next;
        ptr.next = newNode;
    }

    static void insertBeforeValue(int value, int before) {
        if (start == null) {
            System.out.println("List is empty!");
            return;
        }
        if (start.data == before) {
            insertAtBeginning(value);
            return;
        }
        Node prev = null;
        Node curr = start;

        while (curr != null && curr.data != before) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Value not found!");
            return;
        }
        Node newNode = new Node(value);
        prev.next = newNode;
        newNode.next = curr;
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
        while (ptr.next.next != null) {
            ptr = ptr.next;
        }
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
            System.out.println("8 Display");
            System.out.println("9 Exit");

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
                    display();
                    break;
                case 9:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
