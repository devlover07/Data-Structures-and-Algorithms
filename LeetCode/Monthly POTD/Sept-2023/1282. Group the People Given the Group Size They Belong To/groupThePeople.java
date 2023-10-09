class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> hm = new HashMap<>();

        int n = groupSizes.length;
        int gSize;

        for(int i = 0; i<n; i++){
            gSize = groupSizes[i];
            // if(!hm.containsKey(gSize)){
                hm.putIfAbsent(gSize, new ArrayList<>());
            // }

            List<Integer> gFull = hm.get(gSize);
            gFull.add(i);

            if(gFull.size() == gSize){
                res.add(gFull);
                hm.remove(gSize);
            }
        }

        return res;
    }
}