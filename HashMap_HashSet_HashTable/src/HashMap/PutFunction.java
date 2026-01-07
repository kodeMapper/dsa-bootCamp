package HashMap;
import java.util.*;

public class PutFunction {

    static class HashMap<K, V> { // generics (don't know the type)

        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // nodes
        private int N; // buckets
        private LinkedList <Node> buckets[]; // declare the array

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4]; // initialized

            // initialize empty LL in each bucket
            for(int i=0; i<4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // hashing function
        private int hashFunction(K key) {
            int bucketIndex = key.hashCode();
            bucketIndex = Math.abs(bucketIndex) % N; // 0 <= BI <= (N-1)
            return bucketIndex;
        }

        // search in LL which is at bucket[bucketIndex]
        private int searchInLL(K key, int bucketIndex) {
            LinkedList<Node> ll = buckets[bucketIndex];

            for(int i=0; i<ll.size(); i++) {
                if(ll.get(i).key == key) {
                    return i; // nodeIndex;
                }
            }
            return -1;
        }

        // re-Hashing
        private void reHash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];

            for(int i=0; i< N*2; i++) {
                buckets[i] = new LinkedList<>();
            }

            for(int i=0; i<oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];

                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        // PUT
        public void put(K key, V value) {
            int bucketIndex = hashFunction(key); // get bucket index
            int nodeIndex = searchInLL(key, bucketIndex); // search in the LL

            if(nodeIndex == -1) { // key not exists in the LL
                buckets[bucketIndex].add(new Node(key, value));
                n++; // a node is inserted
            } else { // node/key already exists
                Node node = buckets[bucketIndex].get(nodeIndex);
                node.value = value;
            }

            double lambda = (double) n/N;
            if(lambda > 2.0) { // lambda should <= threshold
                // re-Hashing
                reHash();
            }
        }

        // GET
        public V get(K key) {
            int bucketIndex = hashFunction(key); // get bucket index
            int nodeIndex = searchInLL(key, bucketIndex); // search in the LL

            if(nodeIndex == -1) { // key not exists in the LL
                return null;
            } else { // node/key already exists
                Node node = buckets[bucketIndex].get(nodeIndex);
                return node.value;
            }
        }

        // REMOVE
        public V remove(K key) {
            int bucketIndex = hashFunction(key); // get bucket index
            int nodeIndex = searchInLL(key, bucketIndex); // search in the LL

            if(nodeIndex == -1) { // key not exists in the LL
                return null;
            } else { // node/key already exists
                Node node = buckets[bucketIndex].remove(nodeIndex);
                n--;
                return node.value;
            }
        }

        // containsKey
        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key); // get bucket index
            int nodeIndex = searchInLL(key, bucketIndex); // search in the LL

            if(nodeIndex == -1) { // key not exists in the LL
                return false;
            } else { // node/key already exists
                return true;
            }
        }

        // isEmpty
        public boolean isEmpty() {
            return n==0;
        }

        // keySet
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++) { //bi
                LinkedList<Node> ll = buckets[i];
                for(int j=0; j<ll.size(); j++) { //ni
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public static void main(String[] args) {
            HashMap <String, Integer> map = new HashMap<>();
            map.put("India", 190);
            map.put("China", 290);
            map.put("US", 90);
            map.put("Russia", 30);
            map.put("Poland", 10);

            ArrayList<String> keys = map.keySet();
            for(int i=0; i<keys.size(); i++) {
                System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
            }
        }
    }
}
