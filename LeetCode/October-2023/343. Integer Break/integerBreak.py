class Solution:
    def integerBreak(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0] = 0
        dp[1] = 1
        dp[2] = 1

        for i in range(3, n + 1):
            for j in range(1, i):
                x = j
                y = i - x
                dp[i] = max(dp[i], max(x * y, dp[y] * x))

        return dp[n]