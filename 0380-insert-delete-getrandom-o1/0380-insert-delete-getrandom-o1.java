class RandomizedSet {

    HashMap<Integer, Integer> map;  // value: index of array
    
    List<Integer> list;
    
    Random random = new Random();
    
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        // move last element to removed elememt
        int currIndex = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(currIndex, lastElement);
        map.put(lastElement, currIndex);
        
        // remove last elemnet
        list.remove(list.size() - 1);
        map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */