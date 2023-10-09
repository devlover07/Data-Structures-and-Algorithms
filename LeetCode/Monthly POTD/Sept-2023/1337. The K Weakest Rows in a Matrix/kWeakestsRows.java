class Solution {
    
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[] rowStrength = new int[m];
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mat[i][mid] == 1) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            rowStrength[i] = left; // Count of soldiers in the row
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int minStrength = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < m; j++) {
                if (rowStrength[j] < minStrength) {
                    minStrength = rowStrength[j];
                    minIndex = j;
                }
            }
            rowStrength[minIndex] = Integer.MAX_VALUE; // Mark this row as visited
            res[i] = minIndex;
        }

        return res;
    }
}

// class Solution {
    
//     public int[] kWeakestRows(int[][] mat, int k) {
//         int m = mat.length;
//         int n = mat[0].length;

//         int[] rowStrength = new int[m];
//         for (int i = 0; i < m; i++) {
//             int left = 0;
//             int right = n - 1;
//             while (left <= right) {
//                 int mid = left + (right - left) / 2;
//                 if (mat[i][mid] == 1) {
//                     left = mid + 1;
//                 } else {
//                     right = mid - 1;
//                 }
//             }
//             rowStrength[i] = left; // Count of soldiers in the row
//         }

//         int[] res = new int[k];
//         for (int i = 0; i < k; i++) {
//             int minStrength = Integer.MAX_VALUE;
//             int minIndex = -1;
//             for (int j = 0; j < m; j++) {
//                 if (rowStrength[j] < minStrength) {
//                     minStrength = rowStrength[j];
//                     minIndex = j;
//                 }
//             }
//             rowStrength[minIndex] = Integer.MAX_VALUE; // Mark this row as visited
//             res[i] = minIndex;
//         }

//         return res;
//     }


// }