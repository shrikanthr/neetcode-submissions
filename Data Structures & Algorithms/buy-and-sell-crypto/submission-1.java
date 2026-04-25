class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int max = Integer.MIN_VALUE;
        while(r<prices.length) {
            if(prices[r]>prices[l]){
                max = Math.max(max, prices[r]-prices[l]);
            } else {
                l = r;
            }
            r++;
        }

        return max == Integer.MIN_VALUE?0:max;
    }
}
