class Solution {
    int i = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while(i<s.length() && s.charAt(i) != ']') {
            if(!Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i++));
            } else {
                int k = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    k = k*10 + s.charAt(i++) - '0';
                }
                i++;
                String str = decodeString(s);
                i++;
                while(k>0){
                    sb.append(str);
                    k--;
                }
            }
        }
        return sb.toString();
    }
    // public String decodeString(String s) {
    //     Stack<Character> stack = new Stack<>();
        
    //     for(char c : s.toCharArray()) {
    //         if(c != ']') {
    //             stack.push(c);
    //         } else {

    //             StringBuilder sb = new StringBuilder();
    //             while(!stack.isEmpty() && Character.isLetter(stack.peek())) 
    //                 sb.insert(0, stack.pop());
    //             stack.pop();
    //             String sub = sb.toString();

    //             // Check for number to repeat the string
    //             StringBuilder digits = new StringBuilder();
    //             while(!stack.isEmpty() && Character.isDigit(stack.peek()))
    //                 digits.insert(0, stack.pop());
                
    //             int digitsNum = Integer.parseInt(digits.toString());

    //             while(digitsNum > 0) {
    //                 for(char ch : sub.toCharArray()){
    //                     stack.push(ch);
    //                 }
    //                 digitsNum--;
    //             }

    //         }
    //     }

    //     StringBuilder result = new StringBuilder();
    //     while(!stack.isEmpty()) {
    //         result.insert(0, stack.pop());
    //     }
    //     return result.toString();
    // }
}