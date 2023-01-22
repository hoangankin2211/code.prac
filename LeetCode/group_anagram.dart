class Solution {
  List<List<String>> groupAnagrams(List<String> strs) {
    Map<String, List<String>> mapString = {};

    for (int i = 0; i < strs.length; i++) {
      bool isAdded = false;
      String key = "";
      List<int> tracker = List.generate(26, (index) => -1);
      strs[i].split("").forEach((element) {
        tracker[element.codeUnitAt(0) - 'a'.codeUnitAt(0)]++;
      });

      tracker.forEach((element) {
        if (element != "-1") {
          key += element.toString();
        }
      });

      if (!mapString.containsKey(key)) {
        mapString.addAll({
          key: [strs[i]]
        });
      } else {
        mapString.update(key, (value) {
          value.add(strs[i]);
          return value;
        });
      }
    }

    mapString.forEach((key, value) {
      print(value);
    });
    return mapString.entries.map((e) => e.value).toList();
  }
}

void main() {
  // print("ddddddddddg".split(''));
  new Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]);
}
