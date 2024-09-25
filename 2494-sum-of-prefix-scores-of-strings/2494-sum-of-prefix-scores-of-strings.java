class Solution {
    Node root = new Node(); // Trie root.

    class Node {
        int score = 0;
        Node[] child = new Node[26];
    }

    public int[] sumPrefixScores(String[] words) {
        for(String word : words){
            Node temp = root;
            for(char ch : word.toCharArray()) {
                if(temp.child[ch-'a'] == null)
                    temp.child[ch-'a'] = new Node();
                temp.child[ch-'a'].score++;
                temp = temp.child[ch-'a'];
            }
        }

        int[] res = new int[words.length];
        for(int i=0;i<res.length; i++) {
            res[i] = calculate(words[i]);
        }

        return res;
    }

    private int calculate(String str) {
        int ans = 0;
        Node temp = root;
        for(char ch : str.toCharArray()) {
            ans+= temp.child[ch-'a'].score;
            temp = temp.child[ch-'a'];
        }
        return ans;
    }
}