public class benchmarkTest{
   
   public static void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
   public static void main(String[] args){
        int arr[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Given array ");
        printArray(arr);

        Mergesort ob = new Mergesort();
        ob.mergesort(arr, 0, arr.length-1);

        System.out.println("Sorted array ");
        printArray(arr);
    }
}
