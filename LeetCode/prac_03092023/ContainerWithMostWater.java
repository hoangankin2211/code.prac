package prac_03092023;

class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }       
        int max = 0 ;
        int i =0, j = height.length - 1 ;
        while (i < j) {
            int x = j - i;
            int y = Math.min(height[i], height[j]);
            if (max < x*y){
                max =x*y;
            }
            if (height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }              
        return max;
    }

    public static int maxArea2(int[] height) {
        if (height.length <= 1) {
            return 0;
        }       
        int max = 0 ;
        
        for (int i = 0 ;i < height.length -1 ;i++ ){
            System.err.println();
            for (int j = height.length -1 ; j>i;j--){
                int x = j - i;
                int y = Math.min(height[i], height[j]);
                if (max < x*y){
                    max =x*y;
                }
            }
        }              
        return max;
    }  
    public static void main(String[] args){
        System.err.println( ContainerWithMostWater.maxArea(new int[]{1,1}));

        /*
         * i = 1 
         * j = 7 -> 1
         * 7 * 7 
         */
    }
}