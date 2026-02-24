import java.util.Scanner;

class CDNode {
    int data;
    CDNode prev;
    CDNode next;

    CDNode(int data) {
        this.data = data;
        this.prev = this;
        this.next = this;
    }
}

public class CircularLL {

    static CDNode start = null;

    // 1. Insert at beginning
    static void insertAtBeginning(int data) {
        CDNode n = new CDNode(data);
        if (start == null) {
            start = n;
            return;
        }
        CDNode last = start.prev;
        n.next = start;
        n.prev = last;
        last.next = n;
        start.prev = n;
        start = n;
    }

    // 2. Insert at end
    static void insertAtEnd(int data) {
        CDNode n = new CDNode(data);
        if (start == null) {
            start = n;
            return;
        }
        CDNode last = start.prev;
        n.next = start;
        n.prev = last;
        last.next = n;
        start.prev = n;
    }

    // 3. Insert after value
    static void insertAfterValue(int data, int key) {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        CDNode ptr = start;
        do {
            if (ptr.data == key) {
                CDNode n = new CDNode(data);
                n.next = ptr.next;
                n.prev = ptr;
                ptr.next.prev = n;
                ptr.next = n;
                return;
            }
            ptr = ptr.next;
        } while (ptr != start);

        System.out.println("Value not found");
    }

    // 4. Insert before value
    static void insertBeforeValue(int data, int key) {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        CDNode ptr = start;
        do {
            if (ptr.data == key) {
                CDNode n = new CDNode(data);
                n.next = ptr;
                n.prev = ptr.prev;
                ptr.prev.next = n;
                ptr.prev = n;
                if (ptr == start)
                    start = n;
                return;
            }
            ptr = ptr.next;
        } while (ptr != start);

        System.out.println("Value not found");
    }

    // 5. Delete at beginning
    static void deleteAtBeginning() {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        if (start.next == start) {
            start = null;
            return;
        }
        CDNode last = start.prev;
        start = start.next;
        start.prev = last;
        last.next = start;
    }

    // 6. Delete at end
    static void deleteAtEnd() {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        if (start.next == start) {
            start = null;
            return;
        }
        CDNode last = start.prev;
        last.prev.next = start;
        start.prev = last.prev;
    }

    // 7. Delete a value
    static void deleteValue(int key) {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        CDNode ptr = start;
        do {
            if (ptr.data == key) {
                if (ptr.next == ptr) {
                    start = null;
                } else {
                    ptr.prev.next = ptr.next;
                    ptr.next.prev = ptr.prev;
                    if (ptr == start)
                        start = ptr.next;
                }
                return;
            }
            ptr = ptr.next;
        } while (ptr != start);

        System.out.println("Value not found");
    }

    // 8. Delete after value
    static void deleteAfterValue(int key) {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        CDNode ptr = start;
        do {
            if (ptr.data == key) {
                CDNode temp = ptr.next;
                if (temp == ptr) {
                    System.out.println("Deletion not possible");
                    return;
                }
                ptr.next = temp.next;
                temp.next.prev = ptr;
                if (temp == start)
                    start = temp.next;
                return;
            }
            ptr = ptr.next;
        } while (ptr != start);

        System.out.println("Value not found");
    }

    // 9. Delete before value
    static void deleteBeforeValue(int key) {
        if (start == null || start.next == start) {
            System.out.println("Deletion not possible");
            return;
        }
        CDNode ptr = start;
        do {
            if (ptr.data == key) {
                CDNode temp = ptr.prev;
                if (temp == ptr) {
                    System.out.println("Deletion not possible");
                    return;
                }
                temp.prev.next = ptr;
                ptr.prev = temp.prev;
                if (temp == start)
                    start = ptr;
                return;
            }
            ptr = ptr.next;
        } while (ptr != start);

        System.out.println("Value not found");
    }

    // 10. Display forward
    static void displayForward() {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        CDNode ptr = start;
        do {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        } while (ptr != start);
        System.out.println();
    }

    // 11. Display backward
    static void displayBackward() {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        CDNode ptr = start.prev;
        CDNode last = ptr;
        do {
            System.out.print(ptr.data + " ");
            ptr = ptr.prev;
        } while (ptr != last);
        System.out.println();
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- CIRCULAR DOUBLY LINKED LIST MENU ---");
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
                case 1: insertAtBeginning(sc.nextInt()); break;
                case 2: insertAtEnd(sc.nextInt()); break;
                case 3: insertAfterValue(sc.nextInt(), sc.nextInt()); break;
                case 4: insertBeforeValue(sc.nextInt(), sc.nextInt()); break;
                case 5: deleteAtBeginning(); break;
                case 6: deleteAtEnd(); break;
                case 7: deleteValue(sc.nextInt()); break;
                case 8: deleteAfterValue(sc.nextInt()); break;
                case 9: deleteBeforeValue(sc.nextInt()); break;
                case 10: displayForward(); break;
                case 11: displayBackward(); break;
                case 12: System.out.println("Thank you"); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 12);

        sc.close();
    }
}