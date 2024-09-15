class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 2);
        map.put('i', 4);
        map.put('o', 8);
        map.put('u', 16);

        Map<Integer, Integer> occurence = new HashMap<>();
        occurence.put(0, -1);

        int mask = 0;
        int maxLength = 0;

        for(int i = 0; i< s.length();i++) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {
                mask ^= map.get(c);
            }

            if (occurence.containsKey(mask)) {
                maxLength = Math.max(maxLength, i - occurence.get(mask));
            } else {
                occurence.put(mask, i);
            }
        }

        return maxLength;
    }
}