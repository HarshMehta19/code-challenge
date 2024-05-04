class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        String vowels = "aeiouAEIOU";
        for(char c : s.toCharArray()) {
            if(vowels.indexOf(c) != -1)
                sb.append(c);
        }
        int i2 = sb.length() - 1;
        for(int i =0;i<s.length();i++) {
            if(vowels.indexOf(s.charAt(i)) == -1) {
                res.append(s.charAt(i));
            } else {
                res.append(sb.charAt(i2));
                i2--;
            }
        }

        return res.toString();

    }
}