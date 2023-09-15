
/**
 * Best case : O(n) using another temporary variable(temp) to check whenever the swap action happened in a loop
 * Average case : O(n^2)
 * Worst case : O(n^2)
 */

class BubbleSort {
    public static void solve(int[] arr){
        if (arr.length == 0){
            return;
        }

        int length = arr.length;
        
        for (int i = 0;i <length;i++){
            boolean swapped = false;
            for (int j = 0;j < length - i - 1;j++){
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    swapped = true;
                }
            }
            if (!swapped){
                break;
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
        int[] arr = {3,7,2,8,6,3,4,1,0};
        solve(arr);
    }
}