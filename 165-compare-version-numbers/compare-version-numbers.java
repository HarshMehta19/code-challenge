class Solution {
    public int compareVersion(String version1, String version2) {
        // int n = Math.min(version1.length(), version2.length());
        // System.out.println(version1.split("\\."));
        var v1 = version1.split("\\.");
        var v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);
        for(int i =0;i<n;i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if(num1 < num2) return -1;
            if(num1 > num2) return 1;
        }
        return 0;
        // int i =0, j = 0;
        // while(i<n && j<n) {
        //     if(version1.charAt(i) == version2.charAt(j)){
        //         i++;
        //         j++;
        //     } else if (version1.charAt(i) == '0') {
        //         i++;
        //     } else if (version2.charAt(j) == '0') {
        //         j++;
        //     } else {
        //         return -1;
        //     }
        // }
        // return 0;
        
    }
}