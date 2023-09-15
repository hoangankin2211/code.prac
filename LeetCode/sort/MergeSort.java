/*
Time Complexity: O(nlog(n))
*/


class MergeSort{
    static void solve(int[] arr){
        if (arr.length < 1){
            return;
        }
        sort(arr,0,arr.length-1);
    }

    static void sort(int[] arr,int low,int high){
        if (low >= high){
            return;
        }

        int mid = (high - low)/2 + low; 
        sort(arr,low,mid); 
        sort(arr,mid+1,high);
        
        merge(arr,low,mid,mid+1,high);
    }

    static void merge(int[] arr,int left1,int right1,int left2,int right2){
        int count1 = left1;
        int count2 = left2;
        int count = 0;
        int[] newArr = new int[right1 - left1 + right2 - left2 + 2];
        
        while (count1 <= right1 && count2<=right2){
            if (arr[count1] < arr[count2]){
                newArr[count++] = arr[count1++];
            }
            else {
                newArr[count++] = arr[count2++];
            }
        }
        
        while (count1<=right1){
            newArr[count++] = arr[count1++];
        }
        
        while (count2<=right2){
            newArr[count++] = arr[count2++];
        }
            
        int index = 0;
        for (int i = left1;i<=right1;i++){
            arr[i] = newArr[index++];
        }
        for (int i = left2;i<=right2;i++){
            arr[i] = newArr[index++];
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
        for (int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}