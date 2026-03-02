public class chainedHash {

    private static class Node {
        String key;
        String value;
        Node next;

        Node(String k, String v) {
            key = key;
            value = value;

        }
    }

    private Node[] table;
    private int m;

    public chainedHash(int m) {
        this.m = m;
        table = new Node[m + 1];
    }

    private int hash(String key) {
        int h = Math.abs(key.hashCode());
        return (h % m) + 1;
    }

    public void insert(String key, String value) {
        int i = hash(key);
        Node head = table[i];

        if (head == null) {
            table[i] = new Node(key, value);
            return;
        }
        Node current = head;
        Node prev = null;

        while (current != null) {

            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }
        prev.next = new Node(key, value);
    }

    public String lookup(String key) {
        int i = hash(key);
        Node current = table[i];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public String remove(String key) {
        int i = hash(key);
        Node current = table[i];
        Node prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null)
                    table[i] = current.next;
                else
                    prev.next = current.next;
                return current.value;
            }
            prev = current;
            current = current.next;
        }

        return null;
    }
    public boolean isInTable(String key) {
        return lookup(key) != null;
    }

}



