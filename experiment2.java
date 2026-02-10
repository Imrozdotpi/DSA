import java.util.Scanner;
public class experiment2 {
    public static void evenIndex(int arr[]){
        System.out.print("Elements at even index: ");
        for(int i = 0; i < arr.length; i+=2){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void oddElements(int arr[]){
        System.out.print("Odd numbers in the array: ");
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 0){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

    }

    public static void reverseOrder(int arr[]){
        System.out.print("Reversed array: ");
        for(int i = arr.length - 1; i >= 0; i--){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void firstAndLast(int arr[]){
        System.out.println("First element is: "  + arr[0] + "and last element is: " + arr[arr.length-1]);

    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];

        System.out.print("Enter 10 elements of the array:");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        
        evenIndex(arr);
        oddElements(arr);
        reverseOrder(arr);
        firstAndLast(arr);
    }
}

