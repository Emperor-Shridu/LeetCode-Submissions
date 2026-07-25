class Solution {
    public int trap(int[] height) {
        int maxH = 0;
        int maxHind = -1;
        for(int i = 0; i<height.length; i++){
            if(height[i]>maxH){
                maxH = height[i];
                maxHind = i;
            }
        }
        int lmax = 0;
        int rmax = 0;

        int a = 0;
        for(int l = 0; l<maxHind; l++){
            if(height[l]>lmax) lmax=height[l];
            a+=lmax-height[l];
        }
        for(int r = height.length-1; r>maxHind; r--){
            if(height[r]>rmax) rmax=height[r];
            a+=rmax-height[r];
        }
        return a;
    }
}