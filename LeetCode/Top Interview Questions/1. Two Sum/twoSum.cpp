class Solution {
public:
    std::vector<int> twoSum(std::vector<int>& nums, int target) {
        std::unordered_map<int, int> numIndexMap;
        for (int i = 0; i < nums.size(); ++i) {
            int complement = target - nums[i];
            if (numIndexMap.find(complement) != numIndexMap.end()) {
                return {numIndexMap[complement], i};
            }
            numIndexMap[nums[i]] = i;
        }
        return {};
    }
};
