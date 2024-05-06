class Solution {
    public String removeStars(String s) {
        int index = 0;
        int len = s.length();
        byte[] bytes = new byte[len];
        s.getBytes(0, len, bytes, 0);
        for(byte ch : bytes) {
            if(ch == '*')
            {
                index--;
            }else {
                bytes[index++] = ch;
            }
        }
        return new String(bytes, 0, index);
        // Stack<Character> characterStack = new Stack<>();
        // for(char c : s.toCharArray()){
        //     if(c == '*') {
        //         characterStack.pop();
        //     }
        //     else {
        //         characterStack.push(c);
        //     }
        // }

        // StringBuilder sb = new StringBuilder();
        // while(!characterStack.isEmpty()) {
        //     sb.insert(0, characterStack.pop());
        // }
        // return sb.toString();
    }
}