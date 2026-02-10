import java.util.Scanner;
class lab1 {
    static int[] arr = new int[100];
    static int size = 0;

    static void display(){
        if(size == 0){
            System.out.println("Array is empty!");
            return;
        }
        System.out.print("Array:");
        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
    }

    static void traverse(){
        display();
    }

    static void search(int target){
        if(size == 0){
            System.out.println("Array is empty!");
            return;
        }
        for(int i = 0; i < size; i++){
            if(arr[i] == target){
                System.out.println("Value is located on " + i);
                return;
            }          
        }
        System.out.println("Value not found!");

    }

    static void insertAtBeginning(int value){
        if(size == arr.length){
            System.out.println("Array overflow!");
            return;
        }
        for(int i = size; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = value;
        size++;
    }

    static void insertAtEnd(int value){
        if(size == arr.length){
            System.out.println("Array overflow!");
            return;
        }
        arr[size] = value;
        size++;
    }

    static void insertAtIndex(int value, int index) throws Exception{
        if(index > size || index < 0){
            throw new Exception("invalid choice!");
        }
        if(size == arr.length){
            System.out.println("Array overflow!");
            return;
        }
        for(int i = size; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = value;
        size++;
    }

    static void insertAfterIndex(int value, int index){
        if(size == arr.length){
            System.out.print("Array overflow!");
            return;
        }

        if(index < 0 || index >= size){
            System.out.print("Invalid index!");
            return;
        }

        for(int i = size; i > index + 1; i--){
            arr[i] = arr[i-1];
        }
        arr[index + 1] = value;
        size++;

    }

    static void insertBeforeIndex(int value, int index){
        if(size == arr.length){
            System.out.print("Array overflow!");
            return;
        }

        if(index < 0 || index > size){
            System.out.print("Invalid index!");
            return;
        }

        for(int i = size; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = value;
        size++;

    }


    static void deleteAtIndex(int index) throws Exception{
        if(size == 0){
            throw new Exception("Array is empty!");
        }
        if(index >= size || index < 0){
            throw new Exception("Invalid index!");
        }
        for(int i = index; i < size-1; i++){
            arr[i] = arr[i+1];
        }
        size--;

    }

    static void deleteAtBeginning(){
        if (size == 0){
            System.out.println("Array is empty!");
            return;
        }
        for(int i = 0; i < size - 1; i++){
            arr[i] = arr[i+1];
        }
        size--;
    }

    static void deleteAtEnd(){
        if(size == 0){
            System.out.println("Array is empty!");
            return;
        }
        size--;

    }

    static void deleteAfterIndex(int index){
        if(size == 0){
            System.out.println("Array is empty!");
            return;
        }
        if(index < 0 || index >= size){
            System.out.print("invalid index choice!");
            return;
        }
        size = index + 1;

    }

    static void deleteBeforeIndex(int index){
        if(size == 0){
            System.out.println("Array is empty!");
            return;
        }
        if(index <= 0 || index >= size){
            System.out.print("Invalid index choice!");
            return;
        }
        int j = 0;
        for(int i = index; i < size; i++){
            arr[j] = arr[i];
            j++;
        }
        size = size - index;

    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;

        while(true){
            System.out.println("_______MENU_______");
            System.out.println("1) Insert at beginning");
            System.out.println("2) Insert at end");
            System.out.println("3) Insert at index");
            System.out.println("4) Insert before a given index");
            System.out.println("5) Insert after a given index");
            System.out.println("6) Delete at index");
            System.out.println("7) Delete before a given index");
            System.out.println("8) Delete after a given index");
            System.out.println("9) Delete at beginning");
            System.out.println("10) Delete at end");
            System.out.println("11) Traverse the array");
            System.out.println("12) Search for an element");
            System.out.println("13) Exit");
            System.out.print("Enter your choice:");

            choice = sc.nextInt();

            try{
                switch(choice){
                    case 1:
                        System.out.print("Enter value:");
                        int val1 = sc.nextInt();
                        insertAtBeginning(val1);
                        display();
                        break;
                    
                    case 2:
                        System.out.print("Enter value:");
                        int val2 = sc.nextInt();
                        insertAtEnd(val2);
                        display();
                        break;
                    
                    case 3:
                        System.out.print("Enter value:");
                        int val3 = sc.nextInt();
                        System.out.print("Enter index on which value is to be inserted:");
                        int val4 = sc.nextInt();
                        insertAtIndex(val3,val4);
                        display();
                        break;

                    case 4:
                        System.out.print("Enter value:");
                        int val5 = sc.nextInt();
                        System.out.print("Enter index before which value is to be inserted:");
                        int val6 = sc.nextInt();
                        insertBeforeIndex(val5, val6);
                        display();
                        break;
                    
                    case 5:
                        System.out.print("Enter value:");
                        int val7 = sc.nextInt();
                        System.out.print("Enter index after which value is to be inserted:");
                        int val8 = sc.nextInt();
                        insertAfterIndex(val7, val8);
                        display();
                        break;
                        

                    case 6:
                        System.out.print("Enter index:");
                        int val9 = sc.nextInt();
                        deleteAtIndex(val9);
                        display();
                        break;

                    case 7:
                        System.out.print("Enter index before which values have to be deleted:");
                        int val10 = sc.nextInt();
                        deleteBeforeIndex(val10);
                        display();
                        break;

                    case 8:
                        System.out.print("Enter index after which values have to be deleted:");
                        int val11 = sc.nextInt();
                        deleteAfterIndex(val11);
                        display();
                        break;

                    case 9:                        
                        deleteAtBeginning();
                        display();
                        break;

                    case 10:
                        deleteAtEnd();
                        display();
                        break;

                    case 11:
                        traverse();
                        break;

                    case 12:
                        System.out.println("Enter element to search: ");
                        int val15 = sc.nextInt();
                        search(val15);
                        break;
                    
                    case 13:
                        System.out.println("Thank you!");
                        return;

                    default:
                        System.err.println("Invalid choice!");

                }
        
            }
            
            catch (Exception e){
                System.err.println("Exception occurred:" + e.getMessage());
            }
            
        }
    }



    
}
