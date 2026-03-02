import java.util.*;
public class Hash {

    // Created static var
    static final int N = 1 << 20; //2^20 = 1,048,576
    static  final int MAX_USED = 950_000;
    static  final int REPETITIONS = 30;

    static class Pair{
        String key;
        String value;

        Pair(String k, String v){
            key = k;
            value = v;
        }
    }

    static void generateData(){

        //Generate keys from 1 to N
        String[] keys =  new String[N];

        for (int i = 0; i < N; i++)
            keys[i] = Integer.toString(i + 1);

        //Shuffle Time:
        List<String> list = Arrays.asList(keys);
        Collections.shuffle(list);

        // Assign shuffle keys and values

        for (int i =0; i < N; i++){
            data[i] = new Pair(keys[i], Integer.toString(i));


        }
    }

    //Open Hash:

    static double runOpenHash(int entries, int m) {

        long totalTime = 0;

        for (int r = 0; r < REPETITIONS; r++) {
            openHash table = new openHash(m);

            for (int i = 0; i < entries; i++ )
                table.insert(data[i].key, data[i].value);
            long start = System.currentTimeMillis();

            for (int i = 0; i < entries; i++)
                table.lookup(data[i].key);

            long end = System.currentTimeMillis();
            totalTime += (end - start);




        }
        return (totalTime / 1000.0)/ REPETITIONS;
    }

    static double runChainedHash(int entries, int m) {
        long totalTime = 0;

        for (int r = 0; r < REPETITIONS; r++) {
            chainedHash table = new chainedHash(m);
            for (int i = 0; i < entries; i++ )
                table.insert(data[i].key, data[i].value);
            long start = System.currentTimeMillis();
            for (int i = 0; i < entries; i++)
                table.lookup(data[i].key);
            long end = System.currentTimeMillis();
            totalTime += (end - start);
        }
        return (totalTime / 1000.0)/ REPETITIONS;
    }

    //Gimme code - Reference to lecture
    static Pair[] data = new Pair[N];

    public static void main(String[] args) {



    }
}