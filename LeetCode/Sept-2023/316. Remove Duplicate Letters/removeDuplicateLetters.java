class Solution {

    public String removeDuplicateLetters(String s) {
        
        int[] lastIndex = new int[26]; //Stores the last index of every character
        int n = s.length();

        for(int i = 0; i<n; i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }

        boolean[] visited = new boolean[26]; //keep track of whether the character is visited or not
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<n; i++){
            int curr = s.charAt(i) - 'a';

            if(visited[curr]) continue;

            while(!stack.isEmpty() && stack.peek() > curr && lastIndex[stack.peek()] > i){
                visited[stack.pop()] = false;
            }

            stack.push(curr);
            visited[curr] = true;
        }

        StringBuilder str = new StringBuilder();

        while(!stack.isEmpty()){
            str.append((char)(stack.pop() + 'a'));
        }

        return str.reverse().toString();
    }
}