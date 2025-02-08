class NumberContainers {

    HashMap<Integer, TreeSet<Integer>> map;
    HashMap<Integer, Integer> trackIndx;
    public NumberContainers() {

        map = new HashMap<>();
        trackIndx = new HashMap<>();
        
    }
    
    public void change(int index, int number) {
        if(trackIndx.containsKey(index)) {
            int prev = trackIndx.get(index);
            map.get(prev).remove(index);
            if(map.get(prev).isEmpty()) {
                map.remove(prev);
            }
        }

        trackIndx.put(index, number);
        map.computeIfAbsent(number, s -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        if(!map.containsKey(number)) return -1;

        return map.get(number).first();

    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */