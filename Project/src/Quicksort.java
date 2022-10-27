/**
 * The quicksort class sorts the elements by using the quicksort algorithm.
 * @author Ethan Hartfield
 * 10/26/2022
 */


public class Quicksort extends benchmarkTest{
    /**
     * The swap method is a utility function that swaps two elements
     * In the same array
     * @param arr The array in which the elements are in
     * @param i The first of the indexes to swap
     * @param j The second of the indexes to swap
     */
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     * The medianof3 method finds the median of the left, middle, and right
     * Values to use as the pivot value
     * While finding the median, it is also sorting the values in the array
     * @param arr The array that we need to sort
     * @param l The leftmost index of the array
     * @param r The rightmost index of the array
     * @return The median of the left, middle, and right values
     */
    public static int medianof3(int[] arr, int l, int r){
        int m = (l+r)/2;
        if(arr[l]>arr[m])
            swap(arr, l, m);
        if(arr[l]>arr[r])
            swap(arr, l, r);
        if(arr[m]>arr[r])
            swap(arr, m, r);
        swap(arr, m, r-1);
        return arr[r-1];
    }
    /**
     * The partition method places the pivot value
     * In the correct position in the sorted array and ensures
     * That all smaller elements are to the left, 
     * And all larger elements are to the right
     * @param arr The array to be partitioned
     * @param l The leftmost index of the array
     * @param r The rightmost index of the array
     * @param pivot The pivot value
     */
    static int partition(int[] arr, int l, int r, int pivot){
        int lPtr = l;
        int rPtr = r-1;
        while(true){
            while(arr[++lPtr]<pivot)
            ;
            while(arr[--rPtr]>pivot)
            ;
            if(lPtr>=rPtr)
                break;
            else
                swap(arr, lPtr, rPtr);
        }
        swap(arr, lPtr, r-1);
        return lPtr;
    }
    /**
     * The quicksort method is the main method that sorts the array
     * By calling medianof3 and partition, and recursivly calling itself
     * @param arr The array to be sorted
     * @param l The leftmost index of the array
     * @param r The rightmost index of the array
     */
    public static void quicksort(int arr[], int l, int r){
        int size = r-l+1;
        if(size<=3)
            manualSort(arr, l, r);
        else{
            int m = medianof3(arr, l, r);
            int p = partition(arr, l, r, m);
            quicksort(arr, l, p-1);
            quicksort(arr, p+1, r);
        }
    }
    /**
     * The manualSort method is used for when the array
     * Only has 3 or less elements to sort
     * @param arr The array to sort
     * @param l The leftmost index in the array
     * @param r The rightmost index in the array
     */
    public static void manualSort(int[] arr, int l, int r){
        int size = r-l+1;
        if(size<=1)
            return;
        if(size==2){
            if(arr[l]>arr[r])
                swap(arr, l, r);
            return;
        }
        else{
            if(arr[l]>arr[r-1])
                swap(arr, l, r-1);
            if(arr[l]>arr[r])
                swap(arr, l, r);
            if(arr[r-1]>arr[r])
                swap(arr, r-1, r);
        }
    }

}

