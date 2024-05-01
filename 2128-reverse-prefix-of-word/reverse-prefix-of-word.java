class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        int n = word.length();
        if(index == -1 ) return word;
        else {
            StringBuilder sb = new StringBuilder(word.substring(0, index+1));
            return sb.reverse().toString() + word.substring(index+1, n);

        }
    }
}