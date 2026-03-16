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

    private static void heapify(String[] arr, int i, int j) {
                int smallest = i;
                int left = 2*i;
                int right = 2*j + 1;


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
}