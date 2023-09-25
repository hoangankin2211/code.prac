import java.util.ArrayList;
import java.util.List;

public class test {
    static public String replace(String word, char gone, char here) {
        char[] words = word.toCharArray();

        for (int i = 0; i < words.length; i++) {
            if (words[i] == gone) {
                words[i] = here;
            }
        }

        return new String(words);
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static public void selectionSort(int[] args) {
        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[j] < args[i]) {
                    swap(args, i, j);
                }
            }
        }
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

    static public void bubbleSort(int[] args) {
        for (int i = 1; i < args.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < args.length - i; j++) {
                if (args[j] > args[j + 1]) {
                    swap(args, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

      static public boolean isValid(String s) {
        if (s.isEmpty() || s.length() % 2 != 0){
            return false;
        }

        List<Character> stack = new ArrayList<>();
        boolean isExistClose = false;

        for (char c : s.toCharArray()){
            if (c == '('){
               stack.add(0, ')'); 
            }
            else if (c == '{'){
                stack.add(0, '}');
            }
            else if (c == '[') {
                stack.add(0, ']');
            }
            else {
                if (stack.isEmpty()){
                    return false;
                }

                char firstChar = stack.get(0);
                isExistClose = true;
                stack.remove(0);
                if (firstChar != c){
                    return false;
                }
            }
        }
        if (!isExistClose || !stack.isEmpty()){
            return false;
        }

        return true;
    }

    static public void insertionSort(int[] args){
        for (int i = 0; i< args.length;i++){
            int currentPos = i;
            while(currentPos > 0 && args[currentPos] < args[currentPos - 1]){
                swap(args, currentPos -1, currentPos);
                currentPos--;
            }
        }
    }

    public static void main(String[] args) {
       System.out.println(isValid("[[[]"));
       /*
        * ]]]

        */
    }
}