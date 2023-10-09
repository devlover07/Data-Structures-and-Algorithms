class Solution {
    public boolean isMonotonic(int[] nums) {
        
        int n = nums.length;
        boolean inc = true;
        boolean desc = true;

        for(int i = 1; i<n; i++){
            if(nums[i] - nums[i-1] < 0) inc = false;

            if(nums[i] - nums[i-1] > 0) desc = false;
        }

        return inc || desc;
    }
}