class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int high = piles[piles.length-1];
        int res = high;
        while(l<=high){
            int mid = l+(high-l)/2;
            int tt = 0;
            for(int b:piles) tt+=Math.ceil((double)b/mid);
            if(tt<=h){
                high = mid-1;
                res = mid;
            }
            else l = mid+1;
        }
        return res;
    }
}