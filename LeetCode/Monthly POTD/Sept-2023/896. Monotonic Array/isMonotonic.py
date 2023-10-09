class Solution:
    def isMonotonic(self, nums):
        n = len(nums)
        inc = True
        desc = True

        for i in range(1, n):
            if nums[i] - nums[i - 1] < 0:
                inc = False
            if nums[i] - nums[i - 1] > 0:
                desc = False

        return inc or desc