import java.util.Scanner;
public class experiment1 {

    public static int differenceMaxMin(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }           
              
        }
         return max - min;    
    }
public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
   
    System.out.print("Enter size of the array:");
    int n = sc.nextInt();

    int arr[] = new int[n];

    System.out.print("Enter elements:");
    for(int i = 0; i < n; i++){
        arr[i] = sc.nextInt();
    }

    int diff = differenceMaxMin(arr);
    System.out.println("The difference between max and min elements of the array is: " + diff);

}
    
}

