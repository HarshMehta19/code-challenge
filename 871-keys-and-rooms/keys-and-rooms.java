class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] keys = new boolean[rooms.size()];
        // Arrays.fill(keys, -1);
        keys[0]= true;

        for(int key: rooms.get(0)){
            goToKeyRoom(key, rooms, keys);
        }
        // for(int j=0;j<rooms.get(0).size();j++) {
        //     goToKeyRoom(rooms.get(0).get(j), rooms, keys);
        // }

        for(int i=1;i<rooms.size();i++) {
            if(keys[i] == false) return false;
        }
        return true;
    }

    private void goToKeyRoom(int room, List<List<Integer>> rooms, boolean[] keys) {
        if(keys[room]) return;
        keys[room]= true;
        for(int key : rooms.get(room)) {
                goToKeyRoom(key, rooms, keys);
        }
    }
}