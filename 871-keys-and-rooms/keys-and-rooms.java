class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] keys = new int[rooms.size()];
        Arrays.fill(keys, -1);
        keys[0]++;

        // for(int i = 0;i<rooms.size();i++){
            for(int j=0;j<rooms.get(0).size();j++) {
                if(rooms.get(0).get(j)!=0)
                    goToKeyRoom(rooms.get(0).get(j), rooms, keys);
                    // keys[rooms.get(i).get(j)]++;
            // }
        }
        // for(List<Integer> items : rooms){

        // }

        for(int i=1;i<rooms.size();i++) {
            if(keys[i] == -1) return false;
        }
        return true;
    }

    private void goToKeyRoom(int room, List<List<Integer>> rooms, int[] keys) {
        if(keys[room] > 0) return;
        keys[room]++;
        for(int key : rooms.get(room)) {
            // for(int item: key)
                goToKeyRoom(key, rooms, keys);
        }
    }
}