import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LAB4 {
    Node start;

    public void insert_at_end(int data) {
        Node new_node = new Node(data);
        if (start == null) {
            System.out.println("Inserting at the beginning as the list is empty");
            insert_at_beginning(data);
        }
        else {
            Node ptr = start;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new_node;
        }
    }

    public void insert_at_beginning(int data) {
        Node new_node = new Node(data);
        if  (start == null) {
            start = new_node;
        }
        else {
            new_node.next = start;
            start = new_node;
        }
        }

    public void insert_at_position(int data, int position) {
        if (start == null || position == 1) {
            System.out.println("Inserting at the beginning as the list is empty or position is 0");
            insert_at_beginning(data);
        }
        else {
            Node new_node = new Node(data);
            Node ptr = start;
            int count = 1;
            while (count < position-1 && ptr.next != null) {
                ptr = ptr.next;
                count++;
            }
            new_node.next = ptr.next;
            ptr.next = new_node;
        }
    }

    public void insert_after_value(int data, int value) {
        if (start == null) {
            System.out.println("Linked list is empty");
        }
        else {
            Node new_node = new Node(data);
            Node ptr = start;
            while (ptr != null && ptr.data != value) {
                ptr = ptr.next;
            }
            if (ptr != null) {
                new_node.next = ptr.next;
                ptr.next = new_node;
            }
            else {
                System.out.println("Value not found in the list");
            }
        }
    }

    public void insert_before_value(int data, int value) {
        if (start == null) {
            System.out.println("Linked list is empty");
        }
        else if (start.data == value) {
            System.out.println("Inserting at the beginning as the value is found at the start");
            insert_at_beginning(data);
        }
        else {
            Node new_node = new Node(data);
            Node ptr = start;
            while (ptr.next != null && ptr.next.data != value) {
                ptr = ptr.next;
            }
            if (ptr.next != null) {
                new_node.next = ptr.next;
                ptr.next = new_node;
            }
            else {
                System.out.println("Value not found in the list");
            }
        }
    }

    public void delete_at_beginning() {
        if (start == null) {
            System.out.println("Linked list is empty");
        }
        else {
            start = start.next;
        }
    }

    public void delete_at_end () {
        if (start == null) {
            System.out.println("Linked list is empty");
        }
        else if (start.next == null) {
            start = null;
        }
        else {
            Node ptr = start;
            while (ptr.next.next != null) {
                ptr = ptr.next;
            }
            ptr.next = null;
        }
    }

    public void delete_at_position(int position) {
        if (start == null) {
            System.out.println("Linked list is empty");
        }
        else if (position == 1) {
            delete_at_beginning();
        }
        else {
            Node ptr = start;
            int count = 1;

            while (count < position-1 && ptr.next != null) {
                ptr = ptr.next;
                count++;
            }
            if (ptr.next != null) {
                ptr.next = ptr.next.next;
            }
            else {
                System.out.println("Position is out of bounds");
            }
        }
    }

    public void delete_after_value(int value) {
        if (start == null) {
            System.out.println("Linked list is empty");
        }
        else {
            Node ptr = start;
            while (ptr != null && ptr.data != value) {
                ptr = ptr.next;
            }
            if (ptr != null && ptr.next != null) {
                ptr.next = ptr.next.next;
            }
            else if (ptr != null) {
                System.out.println("No node exists after the given value");
            }
            else {
                System.out.println("Value not found in the list");
            }
        }
    }

    public void delete_before_value(int value) {
        if (start == null) {
            System.out.println("Linked list is empty");
        }
        else if (start.data == value) {
            System.out.println("No node exists before the given value");
        }
        else if (start.next != null && start.next.data == value) {
            delete_at_beginning();
        }
        else {
            Node ptr = start;
            while (ptr.next != null && ptr.next.data != value) {
                ptr = ptr.next;
            }
            if (ptr.next != null) {
                ptr.next = ptr.next.next;
            }
            else {
                System.out.println("Value not found in the list");
            }
        }
    }

    public void search(int value) {
        if (start == null) {
            System.out.println("Linked list is empty");
        }
        else {
            Node ptr = start;
            int position = 1;
            boolean found = false;
            while (ptr != null) {
                if (ptr.data == value) {
                    System.out.println("Value found at position: " + position);
                    found = true;
                    break;
                }
                ptr = ptr.next;
                position++;
            }
            if (!found) {
                System.out.println("Value not found in the list");
            }
        }
    }

    public void display() {
        if (start == null) {
            System.out.println("Linked list is empty");
        }
        else {
            Node ptr = start;
            while(ptr != null) {
                System.out.println(ptr.data);
                ptr = ptr.next;
            }
        }
    }

    public static void main(String[] args) {
        LAB4 list = new LAB4();
        Scanner sc = new Scanner(System.in);
        int choice, data, position;

        do {
            System.out.println("1. Insert at end");
            System.out.println("2. Insert at beginning");
            System.out.println("3. Insert at position");
            System.out.println("4) Insert after value");
            System.out.println("5) Insert before value");
            System.out.println("6) Delete at beginning");
            System.out.println("7) Delete at end");
            System.out.println("8) Delete at position");
            System.out.println("9) Delete after value");
            System.out.println("10) Delete before value");
            System.out.println("11) Search Value");
            System.out.println("12) Display");
            System.out.println("13) Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();
                    list.insert_at_end(data);
                    break;
                case 2:
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();
                    list.insert_at_beginning(data);
                    break;
                case 3:
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();
                    System.out.print("Enter position to insert: ");
                    position = sc.nextInt();
                    list.insert_at_position(data, position);
                    break;
                case 4:
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();
                    System.out.print("Enter value after which to insert: ");
                    int value_after = sc.nextInt();
                    list.insert_after_value(data, value_after);
                    break;
                case 5:
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();
                    System.out.print("Enter value before which to insert: ");
                    int value_before = sc.nextInt();
                    list.insert_before_value(data, value_before);
                    break;
                case 6:
                    list.delete_at_beginning();
                    break;
                case 7:
                    list.delete_at_end();
                    break;
                case 8:
                    System.out.print("Enter position to delete: ");
                    position = sc.nextInt();
                    list.delete_at_position(position);
                    break;
                case 9:
                    System.out.print("Enter value after which to delete: ");
                    int value_after_delete = sc.nextInt();
                    list.delete_after_value(value_after_delete);
                    break;
                case 10:
                    System.out.print("Enter value before which to delete: ");
                    int value_before_delete = sc.nextInt();
                    list.delete_before_value(value_before_delete);
                    break;
                case 11:
                    System.out.print("Enter value to search: ");
                    int value_to_search = sc.nextInt();
                    list.search(value_to_search);
                    break;
                case 12:
                    list.display();
                    break;
                default:
                    System.out.println("Invalid choice!!");
            }
        } while (choice != 12);

        sc.close();
    }
}