public class MysterySort {
    public static void main(String[] args){
        int[] arr = new int[7];
        arr[0] = 1;
        arr[1] = 31;
        arr[2] = 3;
        arr[3] = 7;
        arr[4] = 1;
        arr[5] = 7;
        arr[6] =2;
        mysterySort(arr);

    }
    
    static void mysterySort(int[] values){
        int curInd;

        for (int pos = 1;pos<values.length;pos++){
            curInd  = pos;
            while(curInd>0 && values[curInd] < values[curInd - 1]){
                swap(values,curInd,curInd-1);
                curInd--;
            }
        }

        for (int num : values){
            System.out.println(num);
        }
    }

    static void swap(int[] values,int index1,int index2){
        int temp = values[index1];
        values[index1] = values[index2];
        values[index1] = temp;
    }
}
