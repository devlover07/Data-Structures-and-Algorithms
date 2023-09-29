public class Solution {
    public int colorful(int A) {
        
        String str = A+"";
        int n = str.length();

        Set<Integer> products = new HashSet<>();
        int prod = 1;

        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                prod *= Character.getNumericValue(str.charAt(j));
                if(products.contains(prod)) return 0;
                products.add(prod);
            }
            prod = 1;
        }

        return 1;
    }
}