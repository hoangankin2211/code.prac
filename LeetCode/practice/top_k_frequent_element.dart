class Solution {
  List<int> topKFrequent(List<int> nums, int k) {
    List<int> result = [];

    Map<int, int> count = {};

    nums.forEach((element) {
      if (!count.containsKey(element)) {
        count.addAll({element: 1});
      } else {
        count.update(element, (value) => value = value + 1);
      }
    });

    List<MapEntry<int, int>> list = count.entries.toList();
    list.sort((a, b) => b.value.compareTo(a.value));

    return [for (int i = 0; i < k; i++) list.elementAt(i).key];
  }
}

void main() {
  print(new Solution().topKFrequent([1, 1, 1, 2, 2, 3], 2));
}
