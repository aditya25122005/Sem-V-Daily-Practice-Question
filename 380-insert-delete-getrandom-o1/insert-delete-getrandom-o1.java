class RandomizedSet {
    HashSet<Integer> hh;
    public RandomizedSet() {
        hh= new HashSet<>();
    }
    
    public boolean insert(int val) {
        return hh.add(val);
    }
    
    public boolean remove(int val) {
        if(!hh.contains(val)) return false;
        return hh.remove(val);
    }
    
    public int getRandom() {
        int size=hh.size();
        List<Integer> ll= new ArrayList<>(hh);
        int idx= (int) (Math.random()*size);
        return ll.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */