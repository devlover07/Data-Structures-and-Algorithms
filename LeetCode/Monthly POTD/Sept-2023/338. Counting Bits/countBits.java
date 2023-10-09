class Solution {
    public int[] countBits(int n) {
        
        // Old O(nlogn) solution
    //     int[] ans = new int[n+1];
    //     ans[0] = 0;

    //     for(int i = 1; i<=n; i++){
    //         ans[i] = noOfBits(i);
    //     }

    //     return ans;
    // }

    // private int noOfBits(int num){
    //     int count = 0;
    //     while(num>0){
    //         num = num & (num-1);
    //         count++;
    //     }

    //     return count;


        // New DP solution 1
        
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
        

        // New DP solution 2
        // int[] ans = new int[n + 1];
        // for (int i = 1; i <= n; ++i) {
        //     ans[i] = ans[i & (i - 1)] + 1;
        // }
        // return ans;
        
        }
}