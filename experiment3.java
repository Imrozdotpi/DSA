import java.util.Scanner;
public class experiment3 {
    
    public static void sumOfArray(int [] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        System.out.println("Sum of the elements in the array is: " + sum);

    }
    public static void alternateElementSum(int[] arr){
        int alternateSum = 0;
        for(int i = 0; i < arr.length; i+=2){
            alternateSum += arr[i];
        }
        System.out.println("Sum of the alternate elements in the array is: " + alternateSum);
        
    }
    public static void secondHighestElement(int[] arr){
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }
            else if(arr[i] > secondMax && arr[i] != max){
                secondMax = arr[i];
            }

            
        }
        System.out.print("Second highest element in the array is: " + secondMax);

    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println("Enter 5 elements of the array: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        sumOfArray(arr);
        alternateElementSum(arr);
        secondHighestElement(arr);

    }
}

