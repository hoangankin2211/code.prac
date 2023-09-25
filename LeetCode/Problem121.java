class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }  

        int maxProfit = 0;
        int cheapestPrice = prices[0];

        for (int i =1 ;i< prices.length;i++){
            if (prices[i] <  cheapestPrice){
                cheapestPrice = prices[i];
            }
            else{
                if (prices[i] - cheapestPrice > maxProfit){
                    maxProfit = prices[i] - cheapestPrice;
                }
            }
        }

        return maxProfit;
    }
}