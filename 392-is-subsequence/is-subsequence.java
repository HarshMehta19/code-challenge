class Solution {
    public boolean isSubsequence(String s, String t) {
        int indexOfS = 0, indexOfT = 0;
        while(indexOfS < s.length() && indexOfT < t.length()) {
            if(s.charAt(indexOfS) == t.charAt(indexOfT)) {
                indexOfS++;
            }
            indexOfT++;
        }
        if(indexOfS == s.length()) return true;
        return false;
    }
}