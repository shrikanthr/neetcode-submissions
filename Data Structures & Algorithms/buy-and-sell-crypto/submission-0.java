class Solution {
    public int maxProfit(int[] prices) {
     int maxProf = 0;
     int buy = 0;
     int sell = buy+1;
     while(sell<prices.length){
        maxProf = Math.max(maxProf, prices[sell]-prices[buy]);
        if(prices[buy]>prices[sell]){
            buy = sell;
        }

        sell++;
     }

     return maxProf;
    }
}
