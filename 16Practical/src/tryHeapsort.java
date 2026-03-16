import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tryHeapsort {

        // Swap Utility
            private static void swap(String[] arr, int i, int j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        //Bottom-Up Heap Methods:

     // Heapify node i in array of size n (min-heap for alphabetical order)

    private static void heapify(String[] arr, int i, int n) {
                int smallest = i;
                int left = 2*i + 1;
                int right = 2*i + 2;


                if (left < n && arr[left].compareTo(arr[smallest]) < 0)
                    smallest = left;
                if (right < n && arr[right].compareTo(arr[smallest]) < 0)
                    smallest = right;

                if (smallest != i) {
                    swap(arr, i, smallest);
                    heapify(arr, smallest, n);
                }
    }

    //Build heap bottom up
    public static void buildHeapBottomUp(String[] arr) {
                int n = arr.length;
                //Start from last parent node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);  // FIX: swapped args were (arr, n, i)
        }



    }

    //Top Down Heap Methods


    //Insert the element into the heap (top down)
    private static void insert(String[] heap, int size) {
        int i = size - 1;
        while ( i > 0){
                int parent = (i - 1)/2;
                if (heap[i].compareTo(heap[parent]) >= 0) break;
                swap(heap, i, parent);
                i = parent;
            }
        }

    // Build heap top-down
    public static void buildHeapTopDown(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            insert(arr, i + 1); // insert arr[i] into heap of size i
        }
    }
    // HEAP SORT (SHARED)
    public static void heapSort(String[] arr) {
        int n = arr.length;
        // Build max-heap to sort ascending
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extract elements one by one
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }


    public static String[] readWordsFromFile(String filename) {
        List<String> wordsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split line into words, remove non-alphabetic chars
                String[] words = line.split("\\s+");
                for (String w : words) {
                    String clean = w.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!clean.isEmpty()) wordsList.add(clean);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return wordsList.toArray(new String[0]);
    }


    // Main testing
        public static void main(String[] args) {
            String filename = "theAnagrams.tex";

            // Load all words from file
            String[] words = readWordsFromFile(filename);
            System.out.println("Total words loaded: " + words.length);

            // ------------------------
            // Bottom-Up Heap
            // ------------------------
            String[] bottomUpArr = Arrays.copyOf(words, words.length);
            long start = System.nanoTime();
            buildHeapBottomUp(bottomUpArr);
            heapSort(bottomUpArr);
            long end = System.nanoTime();

            System.out.println("\nBottom-Up Sorting completed.");
            System.out.println("Bottom-Up Timing: " + (end - start)/1e6 + " ms");

            // ------------------------
            // Top-Down Heap
            // ------------------------
            String[] topDownArr = Arrays.copyOf(words, words.length);
            start = System.nanoTime();
            buildHeapTopDown(topDownArr);
            heapSort(topDownArr);
            end = System.nanoTime();

            System.out.println("\nTop-Down Sorting completed.");
            System.out.println("Top-Down Timing: " + (end - start)/1e6 + " ms");

            // ------------------------
            // Optional: Preview first 50 words
            // ------------------------
            System.out.println("\nPreview of sorted words (first 50):");
            int preview = Math.min(50, bottomUpArr.length);
            for (int i = 0; i < preview; i++) {
                System.out.print(bottomUpArr[i] + " ");
            }
            System.out.println();
        }
    }

