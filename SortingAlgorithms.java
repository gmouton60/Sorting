
package sorting.algorithms;
//import for random numbers,user input, and time
import java.util.Scanner;
import java.util.Random;
import java.time.Instant;
import java.time.Duration;
/**
 *
 * @author gmouto6
 */
public class SortingAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Please enter the size of your file:");
        //gets user input
        Scanner input = new Scanner(System.in);
        int listSize = input.nextInt();
        
        int[] array = new int[listSize];
        Random rand = new Random();
        
        //creates an array of random numbers to sort
        for(int i= 0 ; i<listSize; i++)
            array[i] = rand.nextInt(1000);
        
        //calls and gets the time of selection sort
        Instant start = Instant.now();
        selectionSort(array.clone());
        Instant finish = Instant.now();
        System.out.println("SelectionSort Time is: "+ Duration.between(start, finish).toMillis());
        
        //calls and gets the time of bubble sort
        start = Instant.now();
        BubbleSort(array.clone());
        finish = Instant.now();
        System.out.println("Time is: "+ Duration.between(start, finish).toMillis());
	
        
        //calls and gets the time of short circuit bubble sort
        start = Instant.now();
        SCBubbleSort(array.clone());
        finish = Instant.now();
        System.out.println("Time is: "+ Duration.between(start, finish).toMillis());
        
        
        //calls and gets the time of insertion sort
        start = Instant.now();
        insertionSort(array.clone());
        finish = Instant.now();
        System.out.println("InsertionSort Time is: "+ Duration.between(start, finish).toMillis());
        
        
        start = Instant.now();
        mergeSort(array.clone());
        finish = Instant.now();
        System.out.println("MergeSort Time is: "+ Duration.between(start, finish).toMillis());
        
        
        int low = 0;
        int high = array.length-1;
        start = Instant.now();
        quickSort(array.clone(),low ,high);
        finish = Instant.now();
        System.out.println("QuickSort Time is: "+ Duration.between(start, finish).toMillis());

    }
    //implements bubble sort to sort the array
     public static void BubbleSort(int arr[]) 
    { 
        long count = 0;
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++){
                count++;
                if (arr[j] > arr[j+1]) 
                { 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
            }
        System.out.println("BubbleSort count is: "+ count);
    } 

    //implements short circuit bubble sort to sort the array
    public static void SCBubbleSort(int[] array){
        long count =0;
        for(int i = 0; i < array.length; i++){
          boolean swap = false;
          for(int j = 0; j < array.length-i-1; j++){
            count++;
            if(array[j] > array[j+1]){
              int temp = array[j];
              array[j] = array[j+1];
              array[j+1] = temp;
              swap = true;
            }
          }
          if(!swap)
            break;
        }
        System.out.println("SCBubbleSort count is: "+ count);
    }
    //implements selection sort to sort the array
    public static void selectionSort(int[] arr) {
        long count = 0;
        for (int i = 0; i < arr.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                count++;
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        //System.out.println("SelectionSort count is: "+ count);
    }
    //implements insertion sort to sort the array
    public static void insertionSort(int arr[]) {
        int i, key, j;
        long count = 0;
        for (i = 1; i < arr.length; i++){
            key = arr[i];
            j = i - 1;
            count++;
            while (j>= 0 && arr[j] > key){
                
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        //System.out.println("InsertionSort count is: "+ count);
    }
    
    
    public static void mergeSort(int array[])
    {
        if (array.length < 2)
            return;
        int mid = array.length / 2;
        int[] l = new int[mid];
        int[] r = new int[array.length - mid];
        for(int i = 0; i < mid; i++){
            l[i] = array[i];
        }
        for (int i = mid; i < array.length; i++){
            r[i - mid] = array[i];
        }
        mergeSort(l);
        mergeSort(r);
        merge(array, l, r, mid, array.length - mid);
    }
    
    
    public static void merge(int[] array, int[] l, int[] r, int left, int right) 
    {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k] = l[i];
                i++;
            }
            else {
                array[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < left){
            array[k++] = l[i++];
        }
        while (j < right){
            array[k++] = r[j++];
        }
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;
 
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
	int i = low, j = high;
	while (i <= j) {
            while (arr[i] < pivot) {
		i++;
            }
 
            while (arr[j] > pivot) {
		j--;
            }
            if (i <= j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		i++;
		j--;
            }
	}
	if (low < j)
            quickSort(arr, low, j);
        if (high > i)
            quickSort(arr, i, high);
    }
    
}
