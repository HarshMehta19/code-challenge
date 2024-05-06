class Solution {
    public String removeStars(String s) {
        Stack<Character> characterStack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '*') {
                characterStack.pop();
            }
            else {
                characterStack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!characterStack.isEmpty()) {
            sb.insert(0, characterStack.pop());
        }
        return sb.toString();
    }
}