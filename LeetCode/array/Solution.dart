class Solution {
  int maxProfit(List<int> prices) {
    if (prices.length <= 1) return 0;
    int a = prices.first;
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] <= a) {
        a = prices[i];
      } else {
        if (maxProfit < prices[i] - a) {
          maxProfit = prices[i] - a;
        }
      }
    }
    return maxProfit;
  }
}
