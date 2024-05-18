class SmallestInfiniteSet {

    byte nums[];
    int smallest=1;
     SmallestInfiniteSet() {
       nums = new byte[1001];
    }
    
    public int popSmallest() {
        for(int i = smallest;i<1001;i++){
            if(nums[i]!=1){
                smallest = i;
                nums[i]=1;
                break;
            }
        }
        return smallest;
    }
    
    public void addBack(int num) {
         if(nums[num]==1){
            nums[num]=0;
        }
        if(smallest>num){
            smallest=num;
        }
    }

    // int cur;
    // Set<Integer> s;

    // public SmallestInfiniteSet() {
    //     cur = 1;
    //     s = new HashSet<>();
    // }
    
    // public int popSmallest() {
    //     if(!s.isEmpty()) {
    //         int res = Collections.min(s);
    //         s.remove(res);
    //         return res;
    //     } else {
    //         cur++;
    //         return cur - 1;
    //     }
    // }
    
    // public void addBack(int num) {
    //     if(cur > num) {
    //         s.add(num);
    //     }
    // }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */