package A2Practical;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Shuffling {
//This is going to look very suspicious git commit wise, but I had forgotten to push the repo so I am forced to add the code very slowly so please understand that I am not using AI just made a VERY DUMB mistake
    private static final int RUNS = 60000;

    /* =========================================================
       (a) slowshuffle – improved very bad method
       ========================================================= */
    public static int[] slowshuffle(int N) {
        int[] shuffled = new int[N + 1];          // indices 1..N
        boolean[] isNotPresent = new boolean[N + 1];
        Random rand = new Random();

        // initially all values are not present
        for (int i = 1; i <= N; i++) {
            isNotPresent[i] = true;
        }

        int i = 0;

        // generate until N-1 elements are found
        while (i < N - 1) {
            int r = rand.nextInt(N) + 1; // [1..N]

            if (isNotPresent[r]) {
                i++;
                shuffled[i] = r;
                isNotPresent[r] = false;
            }
        }

        // find the last remaining value efficiently
        for (int k = 1; k <= N; k++) {
            if (isNotPresent[k]) {
                shuffled[N] = k;
                break;
            }
        }

        return shuffled;
    }
/* =========================================================
       (b) shufflebiased – efficient but biased (First method on qu b)
       ========================================================= */
    public static int[] shufflebiased(int N) {
        int[] shuffled = new int[N + 1]; // indices 1..N
        Random rand = new Random();

        // initialise shuffled[i] = i
        for (int i = 1; i <= N; i++) {
            shuffled[i] = i;
        }

        // exactly N swaps (biased)
        for (int i = 1; i <= N; i++) {
            int r = rand.nextInt(N) + 1; // [1..N]
            int temp = shuffled[i];
            shuffled[i] = shuffled[r];
            shuffled[r] = temp;
        }

        return shuffled;
    }
/* =========================================================
       (b) unbiased shuffle – jar / Fisher–Yates method (Second method mentioned in qu b)
       ========================================================= */
    public static int[] shuffle(int N) {
        int[] B = new int[N];
        Random rand = new Random();

        // B = [1, 2, ..., N]
        for (int i = 0; i < N; i++) {
            B[i] = i + 1;
        }

        // extract balls one by one
        for (int b = 0; b < N; b++) {
            int r = rand.nextInt(N - b) + b; // [b..N-1]
            int temp = B[b];
            B[b] = B[r];
            B[r] = temp;
        }

        return B;
    }


