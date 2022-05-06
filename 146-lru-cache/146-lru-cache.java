class LRUCache  extends LinkedHashMap<Integer, Integer>  {
    int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer r = super.get(key);
        return (r == null) ? -1 : r;
    }

    public void put(int key, int value) {
        super.put(key, value);
        // System.out.println(this);
    }

    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */