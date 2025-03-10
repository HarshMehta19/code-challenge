class Solution {
    public long countOfSubstrings(String word, int k) {
        long a = helper(word, k);
        long b = helper(word, k+1);

        return a - b;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private long helper(String s, int k) {
        int left =0, right = 0;

        long ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;

        while(left <s.length()) {
            char ch = s.charAt(left);

            if(isVowel(ch))
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            else
                count++;

            while(map.size() == 5 && count >= k) {
                ans += (long)(s.length() - left);

                char chj = s.charAt(right);
                if(isVowel(chj)) {
                    if(map.get(chj) == 1) map.remove(chj);
                    else    map.put(chj, map.get(chj) - 1);

                } else
                    count--;

                right++;
            }
            left++;
        }
        return ans;
    }
}