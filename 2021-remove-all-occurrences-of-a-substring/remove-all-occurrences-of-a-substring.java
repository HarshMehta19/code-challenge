class Solution {
    public String removeOccurrences(String s, String part) {
        
        if(s.equals(part)) return "";
        int m = s.length(), n = part.length();
        if(m<n) return s;

        int i=0, j=0;

        while(i<s.length() && j < s.length()) {
            if(j-i + 1 < n)
                j++;
            else {
                String subStr = s.substring(i, j+1);
                if(subStr.equals(part))
                {
                    s = s.substring(0, i) + s.substring(j+1);
                    i=0;
                    j=0;
                } else {
                    i++;
                    j++;
                }
            }
        }

        return s;
    }
}