public class Solution {

    int mod = 1000000007;

    private int merge(int[] ar, int s, int m, int e){

        int n = (e-s+1);
        int p1 = s;
        int p2 = (m+1);
        int p3 = 0;
        int[] res = new int[n];
        int ans = 0;

        while(p1<=m && p2<=e){
            if(ar[p1]<=ar[p2]){
                res[p3] = ar[p1];
                p1++;
            } else {
                res[p3] = ar[p2];
                p2++;
                ans += (m-p1+1)%mod;
            }

            p3++;
        }

        while(p1<=m){
            res[p3] = ar[p1];
            p1++;
            p3++;
        }

        while(p2<=e){
            res[p3] = ar[p2];
            p2++;
            p3++;
        }

        for(int i = 0; i<n; i++){
            ar[s+i] = res[i];
        }

        return ans;
    }

    private int mergeSort(int[] ar, int s, int e){

        if(s == e) return 0;

        int m = (s+e)/2;

        int l = mergeSort(ar, s, m)%mod;
        int r = mergeSort(ar, m+1, e)%mod;

        return (l+r+merge(ar, s, m, e)%mod)%mod;
    }
    public int solve(int[] A) {

        int n = A.length;
        return mergeSort(A, 0, n-1)%mod;
    }
}
