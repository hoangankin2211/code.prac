/**
 * worst case : O(n^2) when pivot have the hightest index while the array is sorted it will llop  
 * average case : O(nlogn)
 * best case : O(nlogn)
 * The choice of pivot strategy and its implementation can significantly influence the actual performance of quicksort
 */
class QuickSort{
    
    static void solve(int[] arr){
        sort(arr,0,arr.length -1);
    }

    static void sort(int[] arr,int low, int hight){
        if (low < hight){
            int pivot = partition(arr,low,hight);
            sort(arr,low,pivot-1);
            sort(arr,pivot+1,hight);
        }
    }

    static int partition(int[] arr, int low,int hight){
        java.util.Random rand = new java.util.Random();
        
        int pivot = rand.nextInt(hight+1);
        int left = low;
        int right = hight;

        while (left <= right){
            while (left < pivot && arr[left] < arr[pivot]) left++;
            while ( right > pivot && arr[right] > arr[pivot]) right--;
            if (left >= right) break;
            swap(arr,left,right);
        }

        return pivot;
    }
    

    static void swap(int[] arr,int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    public static void main(String[] args){
        int[] arr =  {  64, 34, 25, 12, 22, 11, 90};
        solve(arr);
        for (int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

// Quick sort in Java

// import java.util.Arrays;

// class Quicksort {

//   // method to find the partition position
//   static int partition(int array[], int low, int high) {
    
//     // choose the rightmost element as pivot
//     int pivot = array[high];
    
//     // pointer for greater element
//     int i = (low - 1);

//     // traverse through all elements
//     // compare each element with pivot
//     for (int j = low; j < high; j++) {
//       if (array[j] <= pivot) {

//         // if element smaller than pivot is found
//         // swap it with the greatr element pointed by i
//         i++;

//         // swapping element at i with element at j
//         int temp = array[i];
//         array[i] = array[j];
//         array[j] = temp;
//       }
//     }

//     // swapt the pivot element with the greater element specified by i
//     int temp = array[i + 1];
//     array[i + 1] = array[high];
//     array[high] = temp;

//     // return the position from where partition is done
//     return (i + 1);
//   }

//   static void quickSort(int array[], int low, int high) {
//     if (low < high) {

//       // find pivot element such that
//       // elements smaller than pivot are on the left
//       // elements greater than pivot are on the right
//       int pi = partition(array, low, high);
      
//       // recursive call on the left of pivot
//       quickSort(array, low, pi - 1);

//       // recursive call on the right of pivot
//       quickSort(array, pi + 1, high);
//     }
//   }

//   public static void main(String args[]) {

//     int[] data = { 8, 7, 2, 1, 0, 9, 6 };
//     System.out.println("Unsorted Array");
//     System.out.println(Arrays.toString(data));

//     int size = data.length;

//     quickSort(data, 0, size - 1);

//     System.out.println("Sorted Array in Ascending Order: ");
//     System.out.println(Arrays.toString(data));
//   }
// }

