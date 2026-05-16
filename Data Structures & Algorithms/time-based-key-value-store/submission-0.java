class TimeMap {
    private Map<String, TreeMap<Integer, String>> tmap;
    public TimeMap() {
        tmap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        tmap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!tmap.containsKey(key)) return "";
        TreeMap<Integer, String> timestamps = tmap.get(key);
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
/**

1 - alice - happy

2

*/