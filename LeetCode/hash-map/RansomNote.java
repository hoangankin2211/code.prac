import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mapLetters = new int[26];
        Arrays.fill(mapLetters,  0);

        int i = 0;
        int j = 0;
        
        char[] ran = ransomNote.toCharArray();
        char[] ma = magazine.toCharArray();

        while (i < ran.length || j < ma.length){
            if (i < ran.length){
                mapLetters[(int)ran[i]]--;
            }
            if (i < ma.length){
                mapLetters[(int)ma[i]]++;
            }
        }

        for (int element : mapLetters){
            if (element < 0){
                return false;
            }
        }
        
        return true;
    }
}