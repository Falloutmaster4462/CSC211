public class chainedHash {

    private static  class Node{
        String key;
        String value;

        Node(String k, String v ){
            key = key;
            value = value;
        }
    }

    private Node[] table;
    private int m;

    public chainedHash(int m){
        this.m = m;
        table = new Node[m + 1];
    }

    private int hash(String key){
        int h = Math.abs(key.hashCode());
        return (h%m) + 1;
    }

    public void insert( String key, String value){
        int i = hash(key);
        Node head = table[i];

        if (head == null){
            table[i] = new Node(key, value);
            return;
        }
    }
}
