// class Solution {
//     public long wonderfulSubstrings(String word) {
//         int n = word.length();
//         if(n <=1) return n;

//         Set<Character> set = new HashSet<Character>();
//         long count = n;

//         for(int i =0;i<n;i++){
//             set.clear();
//             set.add(word.charAt(i));
//             for(int j=i+1;j<n;j++) {

//                 if(set.contains(word.charAt(j))) set.remove(word.charAt(j));
//                 else set.add(word.charAt(j));
//                 if(set.size()<=1) count++;
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public long wonderfulSubstrings(String word) {
        long[] count = new long[1024]; // 2^10 to store XOR values
        long result = 0;
        int prefixXor = 0;
        count[prefixXor] = 1;

        for (char ch : word.toCharArray()) {
            int charIndex = ch - 'a';
            prefixXor ^= 1 << charIndex;
            result += count[prefixXor];
            for (int i = 0; i < 10; i++) {
                result += count[prefixXor ^ (1 << i)];
            }
            count[prefixXor]++;
        }

        return result;
    }
}
