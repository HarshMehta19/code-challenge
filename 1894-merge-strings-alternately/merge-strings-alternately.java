class Solution {
    public String mergeAlternately(String word1, String word2) {
        // int i = 0, j =0;
        // String res = "";
        // int l1 = word1.length(), l2 = word2.length();
        // while(i < l1 && j < l2) {
        //     res += new Character(word1.charAt(i)).toString() + new Character(word2.charAt(j)).toString();
        //     i++;
        //     j++;
        // }

        // if(i<l1) {
        //     res += word1.substring(i, l1);
        // }
        // else if(j < l2) {
        //     res += word2.substring(j, l2);
        // }
        // return res;
        int i =0;
        StringBuilder res = new StringBuilder();
        while(i < word1.length() || i < word2.length()) {
            if(i < word1.length()) {
                res.append(word1.charAt(i));
            }
            if(i < word2.length()) {
                res.append(word2.charAt(i));
            }
            i++;
        }
        return res.toString();
        
    }
}