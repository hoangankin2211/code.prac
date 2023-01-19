class Solution {
  List<int> twoSum(List<int> nums, int target) {
    List<int> result = [];

    //////////----Solution_1----//////////
    //   for (int i=0;i<nums.length-1;i++){
    //       for (int j = i+1;j<nums.length;j++){
    //           if (nums[i]+nums[j] == target){
    //               result = [i,j];
    //           }
    //       }
    //   }

    Map<int, int> map = {};

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        result = [i, map[target - nums[i]]!];
        break;
      } else {
        map.addAll({nums[i]: i});
      }
    }

    return result;
  }
}
