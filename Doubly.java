import java.util.Scanner;

class DNode {
    int data;
    DNode prev;
    DNode next;

    DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Doubly{

    static DNode start = null;

    static void insertAtBeginning(int data) {
        DNode n = new DNode(data);
        if (start == null) {
            start = n;
        } else {
            n.next = start;
            start.prev = n;
            start = n;
        }
    }

    static void insertAtEnd(int data) {
        DNode n = new DNode(data);
        if (start == null) {
            start = n;
            return;
        }
        DNode ptr = start;
        while (ptr.next != null)
            ptr = ptr.next;
        ptr.next = n;
        n.prev = ptr;
    }

    static void insertAfterValue(int data, int key) {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        DNode ptr = start;
        while (ptr != null && ptr.data != key)
            ptr = ptr.next;
        if (ptr == null) {
            System.out.println("Value not found");
            return;
        }
        DNode n = new DNode(data);
        n.next = ptr.next;
        n.prev = ptr;
        if (ptr.next != null)
            ptr.next.prev = n;
        ptr.next = n;
    }

    static void insertBeforeValue(int data, int key) {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        if (start.data == key) {
            insertAtBeginning(data);
            return;
        }
        DNode ptr = start;
        while (ptr != null && ptr.data != key)
            ptr = ptr.next;
        if (ptr == null) {
            System.out.println("Value not found");
            return;
        }
        DNode n = new DNode(data);
        n.prev = ptr.prev;
        n.next = ptr;
        ptr.prev.next = n;
        ptr.prev = n;
    }

    static void deleteAtBeginning() {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        if (start.next == null) {
            start = null;
        } else {
            start = start.next;
            start.prev = null;
        }
    }

    static void deleteAtEnd() {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        if (start.next == null) {
            start = null;
            return;
        }
        DNode ptr = start;
        while (ptr.next != null)
            ptr = ptr.next;
        ptr.prev.next = null;
    }

    static void deleteValue(int key) {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        DNode ptr = start;
        while (ptr != null && ptr.data != key)
            ptr = ptr.next;
        if (ptr == null) {
            System.out.println("Value not found");
            return;
        }
        if (ptr.prev == null)
            deleteAtBeginning();
        else if (ptr.next == null)
            deleteAtEnd();
        else {
            ptr.prev.next = ptr.next;
            ptr.next.prev = ptr.prev;
        }
    }

    static void deleteAfterValue(int key) {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        DNode ptr = start;
        while (ptr != null && ptr.data != key)
            ptr = ptr.next;
        if (ptr == null || ptr.next == null) {
            System.out.println("Deletion not possible");
            return;
        }
        DNode temp = ptr.next;
        ptr.next = temp.next;
        if (temp.next != null)
            temp.next.prev = ptr;
    }

    static void deleteBeforeValue(int key) {
        if (start == null || start.next == null) {
            System.out.println("Deletion not possible");
            return;
        }
        if (start.data == key) {
            System.out.println("No node exists before given value");
            return;
        }
        if (start.next.data == key) {
            start = start.next;
            start.prev = null;
            return;
        }
        DNode ptr = start.next;
        while (ptr != null && ptr.data != key)
            ptr = ptr.next;
        if (ptr == null) {
            System.out.println("Value not found");
            return;
        }
        ptr.prev.prev.next = ptr;
        ptr.prev = ptr.prev.prev;
    }

    static void displayForward() {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        DNode ptr = start;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    static void displayBackward() {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        DNode ptr = start;
        while (ptr.next != null)
            ptr = ptr.next;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- DOUBLY LINKED LIST MENU ---");
            System.out.println("1 Insert at beginning");
            System.out.println("2 Insert at end");
            System.out.println("3 Insert after value");
            System.out.println("4 Insert before value");
            System.out.println("5 Delete at beginning");
            System.out.println("6 Delete at end");
            System.out.println("7 Delete value");
            System.out.println("8 Delete after value");
            System.out.println("9 Delete before value");
            System.out.println("10 Display forward");
            System.out.println("11 Display backward");
            System.out.println("12 Exit");

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
                    displayForward();
                    break;
                case 11:
                    displayBackward();
                    break;
                case 12:
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 12);

        sc.close();
    }
}
