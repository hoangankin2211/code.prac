class Solution {
  bool isValid(String s) {
    bool result = false;

    if (s.length.isEven) {
      for (int i = 0; i < s.length / 2; i++) {
        if (s[i] == '[') {
          result = s[s.length - i - 1] == ']';
        } else if (s[i] == '{') {
          result = s[s.length - i - 1] == '}';
        } else {
          result = s[s.length - i - 1] == ')';
        }
        if (!result) return result;
      }
    }

    return result;
  }
}
