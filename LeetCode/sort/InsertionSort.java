
/*
Best case: O(n)
Worst case: O(n^2)

Space Complexity: O(1)
*/


class InsertionSort{
    public static void solve(int[] arr){
        if (arr.length < 1){
            return;
        }

        int length = arr.length;
        
        for (int i=1;i<length;i++){
            int pos = i;
            while(pos>0 && arr[pos-1] > arr[pos]){
                swap(arr,pos,pos-1);
                pos--;
            }
        }

        for (int i=0;i<length;i++){
            System.out.println(arr[i]);
        }
    }

    static void swap(int[] arr,int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
        
    public static void main(String[] args){
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        solve(arr);
    }
}