class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return new ArrayList<>();
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        List<String> list = new ArrayList<>();

        tracking(digits, 0, map, list, new StringBuilder());
        return list;
    }

    void tracking(String digit, int index, HashMap<Character, char[]> map, List<String> list, StringBuilder builder){
        if(index>= digit.length()) {
            list.add(builder.toString());
            return;
        }

        char[] digits = map.get(digit.charAt(index));
        for(char c: digits) {
            builder.append(c);
            tracking(digit, index+1, map, list, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}