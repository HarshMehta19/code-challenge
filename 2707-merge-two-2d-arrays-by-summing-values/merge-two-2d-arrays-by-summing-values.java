class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i=0, j=0;
        List<int[]> list = new ArrayList<>();
        while(i < nums1.length && j < nums2.length) {
            int id1 = nums1[i][0], val1 = nums1[i][1];
            int id2 = nums2[j][0], val2 = nums2[j][1];

            if(id1 < id2) {
                list.add(new int[]{id1, val1});
                i++;
            } else if(id1 > id2) {
                list.add(new int[]{id2, val2});
                j++;
            } else {
                list.add(new int[]{id2, val1 + val2});
                i++;
                j++;
            }
        }

        while(i < nums1.length) {
            list.add(nums1[i++]);
        }
        while(j<nums2.length) {
            list.add(nums2[j++]);
        }
        return list.toArray(new int[list.size()][]);
        // int[][] res = new int[list.size()][2];

        // for(int k=0;k<list.size();k++) {
        //     res[k] = list.get(k);
        // }

        // return res;
    }
}