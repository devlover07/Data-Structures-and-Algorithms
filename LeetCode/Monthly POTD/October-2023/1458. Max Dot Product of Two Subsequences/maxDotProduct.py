class Solution:
    def maxDotProduct(self, nums1, nums2):
        n = len(nums1)
        m = len(nums2)

        dp = [[float('-inf')] * (m + 1) for _ in range(n + 1)]

        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if i == 1:
                    dp[i][j] = max(dp[i][j - 1], nums1[i - 1] * nums2[j - 1])
                elif j == 1:
                    dp[i][j] = max(dp[i - 1][j], nums1[i - 1] * nums2[j - 1])
                else:
                    dp[i][j] = nums1[i - 1] * nums2[j - 1]
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + dp[i][j])
                    dp[i][j] = max(dp[i][j], dp[i - 1][j])
                    dp[i][j] = max(dp[i][j], dp[i][j - 1])

        return dp[n][m]