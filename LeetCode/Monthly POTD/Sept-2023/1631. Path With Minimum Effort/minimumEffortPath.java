class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] efforts = new int[n][m];
        
        for(int[] row : efforts){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // dist, row, col => int[]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0, 0, 0});
        
        // dir => direction in the matrix. i.e., right, left, down, up
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(!pq.isEmpty()){
            int[] min = pq.poll();
            int dist = min[0], row = min[1], col = min[2];
            
            if(dist > efforts[row][col]) continue;
            
            if(row == n-1 && col == m-1) return dist;
            
            for(int[] d: dirs){
                int newRow = row+d[0];
                int newCol = col+d[1];
                
                if(newRow >=0 && newRow<n && newCol >= 0 && newCol<m){
                    int newDist = Math.max(dist, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    
                    if(newDist<efforts[newRow][newCol]){
                        efforts[newRow][newCol] = newDist;
                        pq.offer(new int[]{newDist, newRow, newCol});
                    }
                }
            }
            
        }
        
        return 0;
    }
}