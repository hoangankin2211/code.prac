class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()){
            return true;
        }

        String str = s.toLowerCase().replaceAll("[^A-Za-z0-9]+", "");
        
        for (int i = 0; i<str.length()/2;i++){
            if (str.charAt(i) != str.charAt(str.length() - i - 1)){
                return false;
            }    
        }

        return true;
    }
}