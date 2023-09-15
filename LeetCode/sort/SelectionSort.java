/**
 * Best case: O(n^2)
 * Average case: O(n^2)
 * Worst case: O(n^2)
 */

class SelectionSort {
    
    public static void solve(int[] arr){
        int length = arr.length;
        
        if (length < 1){
            return;
        }
        for (int i=0;i<length-1;i++){
            int minIndex = i;
            for (int j = i+1;j<length;j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }

            if (minIndex != i){
                swap(arr,minIndex,i);
            }
        }
        
        for (int i = 0;i<  length;i++){
            System.out.println(arr[i]);
        }
    }

    static void swap(int[] arr,int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args){
        int[] arr =  {64, 34, 25, 12, 22, 11, 90};
        solve(arr);
    }
}