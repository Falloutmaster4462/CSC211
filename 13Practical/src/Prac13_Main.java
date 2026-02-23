import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Prac13_Main {

    // Create the node class
    static class Node {
        //Initialse var
        int key;
        String data;

        Node(int k, String d) {
            key = k;
            data = d;

        }
    }
    static Node[] array;
    static int N = 0;

    //Linear Search:

    static Node linearSearch(Node[] arr, int key){
        for (int i = 0; i < N; i++) {
            if (arr[i].key == key)
                return arr[i];
        }
        return null;
    }

    //Binary Search:

    static Node binarySearch(Node[] arr, int key){

        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = (high + low)/2;

            if (arr[mid].key == key)
                return arr[mid];

            if (arr[mid].key < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        //Load file for reading and computation
       BufferedReader br = new BufferedReader(new FileReader("ulysses.numbered"));
       ArrayList<Node> list = new ArrayList<>();

       String line;
       //Data parsing logic
       while ((line = br.readLine()) != null) {
           String[] parts = line.split("\\s+",2);
           int key = Integer.parseInt(parts[0]);
           String data = parts.length > 1 ? parts[1] : "";
           list.add(new Node(key, data));

       }
       // Closed file after reading.
       br.close();

       array = list.toArray(new Node[0]);
       N = array.length;

       //Repetition and random logic
       int repetitions = 30;
       Random rand = new Random();

       //Created timers
       double linearTime = 0, linearTime2 = 0;
       double binaryTime =0, binaryTime2 =0;


        //Linear Search Timer:

        for (int i = 0; i < repetitions; i++) {
            int key = 1 +  rand.nextInt(32654);

            long Start =  System.nanoTime();
            linearSearch(array, key);
            long Finish = System.nanoTime();

            double time = (Finish - Start)/ 1_000_000.0;

            linearTime += time;
            linearTime2 += time*time;
        }

        double linearAverage = linearTime / repetitions;
        double linearStd = Math.sqrt((linearTime2 - repetitions * linearAverage * linearAverage)/(repetitions - 1 ));

        //Binary Search Timer:

        for (int i = 0; i < repetitions; i++) {
            int key = 1 +  rand.nextInt(32654);
            long Start =  System.nanoTime();
            binarySearch(array, key);
            long finish = System.nanoTime();
            double time = (finish - Start)/ 1_000_000.0;

            binaryTime2 += time*time;
            binaryTime += time;
        }







    }

}
