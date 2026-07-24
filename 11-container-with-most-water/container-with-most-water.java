class Solution {
    public int maxArea(int[] height) {
        // int lb = 0;
        // int rb = height.length-1;
        // int l = 0;
        // int r = rb;

        // while(l<r){
        //     //update left boundary
        //     int lba = (rb-lb)*height[lb];
        //     int la = (rb-l)*height[l];
        //     if(la>lba) lb = l;
        //     //update right boundary
        //     int rba = (rb-lb)*height[rb];
        //     int ra = (r-lb)*height[r];
        //     if(ra>rba) rb = r;
        //     //move l and r
        //     l++;
        //     r--;
        // }
        // return Math.min(height[lb],height[rb])*(rb-lb);
        // 2. What Happens When You Try to "Compensate" on Both Sides?If you try to independently check if a new $l$ or $r$ compensates for the loss:The Dependency Problem: The area depends on a pair of lines $(i, j)$. If you move $l$ independently to see if it makes a better container with the current $right$, you are changing one side of the equation while assuming the other side remains fixed.Missing Combinations: By moving both $l$ and $r$ inward in the same iteration (e.g., l++ and r-- at the end of your loop), you are skipping intermediate indices that might be part of the optimal container.Incorrect Boundaries: In your Java code, variables like lb and rb track your chosen best left and right boundaries, but because you unconditionally execute l++ and r-- at the end of every loop iteration, you rush through the search space. If an intermediate line is actually taller and forms the optimal container with something else, your pointers might step right over it or get desynchronized.

        int l = 0;
        int r = height.length-1;
        int maxArea = 0;
        while(l<r){
            int area = Math.min(height[l], height[r])*(r-l);
            maxArea = Math.max(maxArea, area);
            if(height[l]<height[r]) l++;
            else r--;
        }
        return maxArea;
    }
}