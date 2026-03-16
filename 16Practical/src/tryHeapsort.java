import java.util.Arrays;
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
                int left = 2*i;
                int right = 2*i + 1;


                if (left < n && arr[left].compareTo(arr[smallest]) < 0)
                    smallest = left;
                if (right < n && arr[right].compareTo(arr[smallest]) < 0)
                    smallest = right;

                if (smallest != i) {
                    swap(arr, i, smallest);
                    heapify(arr, smallest, j);
                }
    }

    //Build heap bottom up
    public static void buildHeapBottomUp(String[] arr) {
                int n = arr.length;
                //Start from last parent node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }



    }

    //Top Down Heap Methods


    //Insert the element into the heap (top down)
    private static void insert(String[] heap, int size) {
        int i = size - 1;
        while ( i > 0){
            int parent = (i - 1)/2;
            while (i > 0) {
                int parent = (i - 1) / 2;
                if (heap[i].compareTo(heap[parent]) >= 0) break;
                swap(heap, i, parent);
                i = parent;
            }
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
}
