class Solution {
    // public String reverseVowels(String s) {
    //     StringBuilder sb = new StringBuilder();
    //     StringBuilder res = new StringBuilder();
    //     String vowels = "aeiouAEIOU";
    //     for(char c : s.toCharArray()) {
    //         if(vowels.indexOf(c) != -1)
    //             sb.append(c);
    //     }
    //     int i2 = sb.length() - 1;
    //     for(int i =0;i<s.length();i++) {
    //         if(vowels.indexOf(s.charAt(i)) == -1) {
    //             res.append(s.charAt(i));
    //         } else {
    //             res.append(sb.charAt(i2));
    //             i2--;
    //         }
    //     }

    //     return res.toString();

    // }
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String vowels = "aeiouAEIOU";
        
        while (start < end) {
            // Move start pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[start]) == -1) {
                start++;
            }
            
            // Move end pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[end]) == -1) {
                end--;
            }
            
            // Swap the vowels
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            
            // Move the pointers towards each other
            start++;
            end--;
        }
        
        String answer = new String(word);
        return answer;
    }
}