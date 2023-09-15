class Solution {
  // bool isAnagram(String s, String t) {
  //   if (s.length != t.length) {
  //     return false;
  //   }

  //   bool result = true;

  //   Map<String, int> flag1 = {};

  //   for (int i = 0; i < s.length; i++) {
  //     if (!flag1.containsKey(s[i])) {
  //       flag1.addAll({s[i]: 0});
  //     } else {
  //       flag1.update(s[i], (value) => value = value + 1);
  //     }
  //   }

  //   Map<String, int> flag2 = {};

  //   for (int i = 0; i < t.length; i++) {
  //     if (!flag1.containsKey(t[i])) {
  //       return false;
  //     } else {
  //       if (!flag2.containsKey(t[i])) {
  //         flag2.addAll({t[i]: 0});
  //       } else {
  //         flag2.update(t[i], (value) => value = value + 1);
  //       }
  //     }
  //   }

  //   print(flag1);
  //   print(flag2);

  //   flag1.forEach((key, value) {
  //     if (value != flag2[key]!) {
  //       result = false;
  //     }
  //   });

  //   return result;
  // }

  bool isAnagram(String s, String t) {
    if (s.length != t.length) {
      return false;
    }
    int sum1 = 0;
    int sum2 = 0;
    for (int i = 0; i < s.length; i++) {
      if (!t.contains(s[i])) {
        return false;
      }
    }
    return true;
  }
}

void main() {
  new Solution().isAnagram("aacc", 'ccac');
}
