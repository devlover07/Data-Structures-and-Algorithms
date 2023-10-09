class Solution {
    isMonotonic(nums) {
        const n = nums.length;
        let inc = true;
        let desc = true;

        for (let i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] < 0) {
                inc = false;
            }
            if (nums[i] - nums[i - 1] > 0) {
                desc = false;
            }
        }

        return inc || desc;
    }
}