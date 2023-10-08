func maxDotProduct(nums1 []int, nums2 []int) int {
    n := len(nums1)
    m := len(nums2)

    dp := make([][]int, n+1)
    for i := range dp {
        dp[i] = make([]int, m+1)
        for j := range dp[i] {
            dp[i][j] = math.MinInt32
        }
    }

    for i := 1; i <= n; i++ {
        for j := 1; j <= m; j++ {
            if i == 1 {
                dp[i][j] = max(dp[i][j-1], nums1[i-1]*nums2[j-1])
            } else if j == 1 {
                dp[i][j] = max(dp[i-1][j], nums1[i-1]*nums2[j-1])
            } else {
                dp[i][j] = nums1[i-1] * nums2[j-1]
                dp[i][j] = max(dp[i][j], dp[i-1][j-1]+dp[i][j])
                dp[i][j] = max(dp[i][j], dp[i-1][j])
                dp[i][j] = max(dp[i][j], dp[i][j-1])
            }
        }
    }

    return dp[n][m]
}

func max(x, y int) int {
    if x > y {
        return x
    }
    return y
}