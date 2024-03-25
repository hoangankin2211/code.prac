import java.util.Random;

class MajorityElement {
        // public int majorityElement(int[] nums) {
        //     if (nums.length == 1){
        //         return nums[0];
        //     }

        //     Map<String,Integer> map = new HashMap<>();
            
        //     int maxNum = 0;
        //     int result = 0;

        //     for (int i =0 ;i< nums.length;i++){
        //         if (map.containsKey(String.valueOf(nums[i]))){
        //             map.put(String.valueOf(nums[i]), map.get(String.valueOf(nums[i]))+1);
        //         }
        //         else {
        //             map.put(String.valueOf(nums[i]),1);
        //         }

        //         if (map.get(String.valueOf(nums[i])) > (nums.length/2) && maxNum < map.get(String.valueOf(nums[i])) ){
        //             maxNum = map.get(String.valueOf(nums[i]));
        //             result = nums[i];
        //         }
        //     }

        //     return result;
        // }
        public static void quickSort(int[] nums, int left, int right) {
            if (left < right) {
                int pivot = partition(nums, left, right);
                quickSort(nums, left, pivot - 1);
                quickSort(nums, pivot + 1, right);
            }
        }
    
        public static int partition(int[] arr, int left, int right) {
            java.util.Random rand = new java.util.Random();
            int pivotIndex = left + rand.nextInt(right - left + 1);
            int pivotValue = arr[pivotIndex];
            swap(arr, pivotIndex, right); // Move pivot to end
            int storeIndex = left;
            for (int i = left; i < right; i++) {
                if (arr[i] < pivotValue) {
                    swap(arr, i, storeIndex);
                    storeIndex++;
                }
            }
            swap(arr, storeIndex, right); // Move pivot to its final place
            return storeIndex;
        }
    
        static void swap(int[] arr, int index1, int index2) {
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
        static public int majorityElement(int[] nums){

            quickSort(nums,0,nums.length-1);

            int result = nums[0];
            int maxNum = 1;
            int currentNum = 0;

            for (int i =1 ; i<nums.length ;i++){
                currentNum+=1;
                if (nums[i-1] != nums[i]){
                    if (maxNum < currentNum) {
                        result = nums[i-1];
                        maxNum = currentNum;
                    }
                    currentNum = 1;
                }
                else {
                    if (i == nums.length - 1){
                        if (maxNum < currentNum) {
                            result = nums[i-1];
                            maxNum = currentNum;
                      }
                    }
                }
            }

            return result;
        }

    public static void main(String[] args) {
        int[] arr = new int[]{
            3,2,3
        };

        System.err.println(majorityElement(arr));
        
    }

}