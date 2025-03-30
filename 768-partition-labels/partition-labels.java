class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastPos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastPos[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();

        int size = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            size++;

            end = Math.max(end, lastPos[s.charAt(i) - 'a']);
            if (end == i) {
                result.add(size);
                size = 0;
            }
        }

        return result;
    }
}