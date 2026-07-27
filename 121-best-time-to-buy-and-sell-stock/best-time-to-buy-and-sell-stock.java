class Solution {
    public int maxProfit(int[] prices) {
        // dp soln
        // int maxP = 0;
        // int buy = prices[0];
        // for(int sell:prices){
        //     maxP = Math.max(maxP, sell-buy);
        //     buy = Math.min(buy, sell);
        // }
        // return maxP;

        // 2ptr soln, left = buy, right = current sell. if traversing with r, at a sell, we need best purchased on left => when r<l l = r;

        int l = 0;
        int maxP = 0;

        for(int r = 1; r<prices.length; r++){
            if(prices[l]>prices[r]) l = r;
            else{
                maxP = Math.max(maxP, prices[r]-prices[l]);
            }
        }
        return maxP;
    }
}