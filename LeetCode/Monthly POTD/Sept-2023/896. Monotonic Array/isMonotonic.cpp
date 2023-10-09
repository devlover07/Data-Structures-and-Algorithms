class Solution {
public:
    bool isMonotonic(std::vector<int>& nums) {
        int n = nums.size();
        bool inc = true;
        bool desc = true;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] < 0) {
                inc = false;
            }
            if (nums[i] - nums[i - 1] > 0) {
                desc = false;
            }
        }

        return inc || desc;
    }
};
