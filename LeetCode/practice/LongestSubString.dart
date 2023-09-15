class Solution1 {
  static int lengthOfLongestSubstring(String s) {
    int result = 0;

    int count = 0;
    Map<String, int> map = {};

    for (int i = 0; i < s.length; i++) {
      if (!map.containsKey(s[i])) {
        count++;
        if (i == s.length - 1 && result < count) {
          result = count;
        }
      } else {
        if (result < count) {
          result = count;
        }
        i = map[s[i]]! + 1;
        map.clear();
        count = 1;
      }
      map.addAll({s[i]: i});
    }
    return result;
  }
}

class Solution2 {
  static int lengthOfLongestSubstring(String s) {
    int result = 0;

    Map<String, Map<String, int>> countChar = {};

    for (int i = 0; i < s.length; i++) {
      if (!countChar.containsKey(s[i])) {
        countChar[s[i]] = {
          'count': 1,
          'position': i,
        };

        result++;
      } else {
        int left = lengthOfLongestSubstring(s.substring(0, i));
        int right = lengthOfLongestSubstring(
            s.substring(countChar[s[i]]!['position']! + 1));
        result = left > right ? left : right;
        break;
      }
    }

    return result;
  }

  // int solve(String s, Map<String, Map<String, dynamic>> countChar, int begin,
  //     int end) {
  //   int result = 0;

  //   for (int i = begin; i < end; i++) {
  //     if (countChar[s[i]]!['count'] >= 2) {
  //       result = solve(s, countChar, begin, end)
  //     }
  //   }

  //   return result;
  // }
}

void main() {}