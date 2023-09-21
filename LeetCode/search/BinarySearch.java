import java.util.*;

/* 
    Best case = O(1)
    Average case = O(log(n))
    Worst case = O(log(n))
*/

class BinarySearch{
    public static int search(List<Integer> list, int value){
        if (list.isEmpty()){
            return -1;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left <= right){
            int mid = (right - left) / 2 + left;
            int element = list.get(mid);
            if (element == value){
                return mid;
            }
            else if (element < value){
                left = mid+1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
    
    public static void main(String args[]){
        System.out.println(search(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20),11));
    }
}