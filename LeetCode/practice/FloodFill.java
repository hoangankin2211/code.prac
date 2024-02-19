public class FloodFill {
    public static void main(String[] args){
        new Solution().floodFill(null, 0, 0, 0);
    }   
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        fill(image,sr,sc,image[sr][sc],color);
        return image;
    }

    public void fill(int[][] image, int sr, int sc,int color, int newColor){
        
        if (sr < 0 || sc < 0 || sr > image.length - 1 || sc > image[0].length - 1 || image[sr][sc] != color){
            return;
        }

        image[sr][sc] = newColor;

        fill(image,sr-1,sc,color,newColor);
        fill(image,sr+1,sc,color,newColor);
        fill(image,sr,sc-1,color,newColor);
        fill(image,sr,sc+1,color,newColor);
    }
}