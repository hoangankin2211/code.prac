class Solution {
  String longestCommonPrefix(List<String> strs) {
    if (strs.length <= 0) {
      return "";
    }

    String result = strs.first;

    for (int i = 1; i < strs.length; i++) {
      RegExp regExp = RegExp("^[${result}]+\B");
      result = regExp.stringMatch(strs.elementAt(i)) ?? "";
      print(result);
      if (result.isEmpty) {
        break;
      }
    }
    return result;
  }
}

void main() {
  print(Solution().longestCommonPrefix(["flower", "flow", "flight"]));
}
