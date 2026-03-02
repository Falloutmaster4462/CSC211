public class openHash {


    private static  class Node{
            String key;
            String value;

            Node(String k, String v ){
                key = key;
                value = value;
            }
    }

private Node[] table;
    private int size = 0;
    private int m;

    public openHash(int m){
        this.m = m;
        //Indices 1...m
        table = new Node[m + 1];
    }

    private int hash(String key){
        int h = Math.abs(key.hashCode());
        return (h % m) + 1;
    }

    public void insert(String Key, String Value){
       // if (isFull(()) return;
        int i = hash(Key);
        int start = i;

        while (table[i] != null && !table[i].key.equals(Key)){
            //Linear probing
            i = (i % m) + 1;
            if (i == start)
                return;
        }

        if (table[i] == null){
            table[i] = new Node(Key, Value);
            size++;
        }else{
            table[i].value=Value;
        }
    }
}
