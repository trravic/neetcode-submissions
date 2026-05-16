public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

}
class LRUCache {

    private int cap;
    private HashMap<Integer,Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        next.prev = prev;
        prev.next = next;
    }

    void insert(Node node){
        // always add the node just before right node;
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {   
        // Check if hashmap already contains key 
        // if it has make it as hot (remove + insert) and then return node.val;
        // else return -1;
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // Put 
        // what if it already contains - Make it as hot (remove + insert)
        // what if not already contains - 
        // case1 : check the map has space - if so add it to right ( insert method)
        // case2 : if map is full - evict - but in which order - lru - 
        //         meaning make remove method always points the left.next LRU Node evict the node
        //         and remove from your hashmap too 

        if(cache.containsKey(key)){
            remove(cache.get(key));
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if(cache.size() > cap){
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}


/**

Explanation:
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 10);  // cache: {1=10}
lRUCache.get(1);      // return 10
lRUCache.put(2, 20);  // cache: {1=10, 2=20}
lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
lRUCache.get(2);      // returns 20 
lRUCache.get(1);      // return -1 (not found)

null <- left -> right -> null
             <-

for inserting node (1)

we can keep track of recently to right 
Node prev = this.right.prev;
prev.next = node;
(1) node.next=right node.prev=right.prev
this.right.prev = node;

null <- left -> 1 -> right -> null
             <-   <-
for get() if it contains key it means its accessed - make it as hot

remove and then insert 

get the node address of 1 

prev = node.prev;
next = node.next;
prev.next = next;
next.prev = prev;



*/