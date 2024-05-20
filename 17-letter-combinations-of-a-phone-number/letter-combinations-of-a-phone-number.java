class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> list = new ArrayList<>();

        tracking(digits, 0, map, list, new StringBuilder());
        return list;
    }

    void tracking(String digit, int index, HashMap<Integer, String> map, List<String> list, StringBuilder builder){
        if(index>= digit.length()) {
            list.add(builder.toString());
            return;
        }

        String digits = map.get(digit.charAt(index) - '0');
        for(char c: digits.toCharArray()) {
            builder.append(c);
            tracking(digit, index+1, map, list, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}