class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2) {
            return false;
        }

        HashMap<Character, Integer> s1Count = new HashMap<>();
        HashMap<Character, Integer> s2Count = new HashMap<>();

        for(int i=0;i<n1;i++) {
            s1Count.put(s1.charAt(i), 1 + s1Count.getOrDefault(s1.charAt(i),0));
            s2Count.put(s2.charAt(i), 1 + s2Count.getOrDefault(s2.charAt(i),0));
        }

        if(s1Count.equals(s2Count)) return true;

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            char charRight = s2.charAt(right);
            s2Count.put(charRight, s2Count.getOrDefault(charRight, 0) + 1);
            
            char charLeft = s2.charAt(left);
            s2Count.put(charLeft, s2Count.get(charLeft) - 1);
            if (s2Count.get(charLeft) == 0) {
                s2Count.remove(charLeft);
            }
            
            left++;
            
            if (s1Count.equals(s2Count)) {
                return true;
            }
        }


        return false;
    }
}