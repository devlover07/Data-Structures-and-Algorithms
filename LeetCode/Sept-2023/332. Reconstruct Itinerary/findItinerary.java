class Solution {
    /*============Euler Path============
        UNDIRECTED GRAPH:
            Every node must have Even Degree, 
            Except 2 nodes: START and END  nodes(have Odd degree)
        
        DIRECTED GRAPH
            Every node must have:
                In Degree == Out Degree
            Except 2 nodes: START and END NODES
                In Degree != Out Degree
    */

    /*======================Euler Circuit===================
        UNDIRECTED GRAPH
            -Every node must have Even Degree.

        DIRECTED GRAPH
            - In Degree == Out Degree(including START and END nodes)
     */
    /* 
        Hierholzer's Algorithm: Every edge must be visited only once.

        Hamiltonion's Algorithm(DFS): Every node must be visited only once.
     */
    private void eulerHierholzer(Map<String, PriorityQueue<String>> map, List<String> result, String from){
        PriorityQueue<String> next = map.get(from);
        while(next != null && !next.isEmpty()){
            String str = next.poll();
            eulerHierholzer(map, result, str);
        }

        result.add(0, from);
    }
    public List<String> findItinerary(List<List<String>> tickets) {

        int n = tickets.size();
        int m = 2;

        HashMap<String, PriorityQueue<String>> s2d = new HashMap<String, PriorityQueue<String>>();
        List<String> journey;
        PriorityQueue<String> pQueue;
        
        for(int i = 0; i<n; i++){
            journey = tickets.get(i);
            if(!s2d.containsKey(journey.get(0))){
                PriorityQueue<String> pq = new PriorityQueue<>();
                // pq.add(journey.get(1));
                s2d.put(journey.get(0), pq);
                // continue;
            }

            pQueue = s2d.get(journey.get(0));
            pQueue.add(journey.get(1));
        }

        List<String> res = new ArrayList<>();
        
        eulerHierholzer(s2d, res, "JFK");

        return res;
    }
}