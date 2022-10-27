/**
 * The mergesort class implements the sorting algorithm mergesort
 * @author Ethan Hartfield
 * 10/26/2022
 */

public class Mergesort extends benchmarkTest{
    /**
     * The merge method merges two subarrays of arr[]
     * @param arr[] The array to be merged
     * @param l The leftmost index of the array
     * @param m The middle index of the array
     * @param r The rightmost index of the array
     */
    public void merge(int arr[], int l, int m, int r){
        //Find the sizes of the two subarrays to be merged
        int size1 = m-l+1;
        int size2 = r-m;
        //Create temp arrays
        int leftArray[] = new int[size1];
        int rightArray[] = new int[size2];
        //Populate temp arrays
        for(int i = 0; i < size1; i++)
            leftArray[i] = arr[l+i];
        for(int i = 0; i < size2; i++)
            rightArray[i] = arr[m+1+i];
        //Merge the two arrays
        int i = 0, j = 0;
        int k = l; //Initial index of merged subarray array
        while(i < size1 && j < size2){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            }
            else{
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        //Copy any remaining elements of the two arrays (if any)
        while (i < size1){
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < size2){
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    /**
     * The mergesort method is the main function that sorts the array
     * Sorts by recurvise calling, while calling the merge method at the end
     * @param arr[] The array to be sorted
     * @param l The leftmost element in the array
     * @param r The rightmost element in the array
     */
    public void mergesort(int arr[], int l, int r){
        if(l<r){
            //Find the mid point
            int m = l+(r-l)/2;
            //Sort the first and second halves
            mergesort(arr, l, m);
            mergesort(arr, m+1, r);
            //Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

}
