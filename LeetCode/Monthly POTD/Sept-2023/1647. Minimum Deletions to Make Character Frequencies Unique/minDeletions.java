class Solution {
    public int minDeletions(String s) {
        
        /*======My Approch=========
        int n = s.length();
        HashMap<Character, Integer> charFreq = new HashMap<>();
        char ch;
        

        for(int i = 0; i<n; i++){
            ch = s.charAt(i);
            if(!charFreq.containsKey(ch)){
                charFreq.put(ch, 1);
                continue;
            }

            charFreq.put(ch, charFreq.get(ch)+1);
        }

        ArrayList<Integer> values = new ArrayList(charFreq.values());
        int vSize = values.size();
        Collections.sort(values);

        HashSet<Integer> hs = new HashSet<>();
        hs.add(values.get(0));
        int count = 0;
        int val;

        for(int i = 1; i<vSize; i++){
            val = values.get(i);
            while(hs.contains(val) && val>0){
                val--;
                count++;
            }

            hs.add(val);
        }

        return count;
        */

        // ======================Editorial Approch 1====================
        /*
        // Store the frequency of each character
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        
        int deleteCount = 0;
        // Use a set to store the frequencies we have already seen
        HashSet<Integer> seenFrequencies = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            // Keep decrementing the frequency until it is unique
            while (frequency[i] > 0 && seenFrequencies.contains(frequency[i])) {
                frequency[i]--;
                deleteCount++;
            }
            // Add the newly occupied frequency to the set
            seenFrequencies.add(frequency[i]);
        }
        
        return deleteCount;
        */

        // Store the frequency of each character
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        
        // Add the frequencies to the priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                pq.add(frequency[i]);
            }
        }
        
        int deleteCount = 0;
        while (pq.size() > 1) {
            int topElement  = pq.remove();
            
            // If the top two elements in the priority queue are the same
            if (topElement == pq.peek()) {
                // Decrement the popped value and push it back into the queue
                if (topElement - 1 > 0) {
                    pq.add(topElement - 1);
                }
                deleteCount++;
            }
        }
        
        return deleteCount;
    }
}