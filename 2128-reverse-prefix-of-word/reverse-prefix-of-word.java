class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        int n = word.length();
        if(index == -1 ) return word;
        else {
            StringBuilder sb = new StringBuilder(word.substring(0, index+1));
            return sb.reverse().toString() + word.substring(index+1, n);
            // String str = word.substring(0, index+1);
            // // System.out.println(str);
            // str = reverse(str);
            // String str2 = word.substring(index+1, n);
            // // System.out.println(str2);
            // return str+str2;

        }
    }

    String reverse(String str) {
        String res = "";
        for(int i = str.length() - 1; i>=0;i--) {
            res += str.charAt(i);
        }
        return res;
    }
}