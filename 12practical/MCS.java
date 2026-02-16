//4551372
//Nikaj Jazeel Nilraj
//MCS Prac 16/02/2026


// Importing clases
import java.util.Random;

//Counters and their initalisation
static long countOn3 = 0;
static long countOn2A = 0;
static long countOn2B = 0;
static long countOn = 0;


// Implementation for O(n^3):

public static int mcsOn3(int[] x){
    int n = x.length;
    int maxsofar = 0;

    for (int low = 0; low < n; low++) {
        for (int high = low; high < n; high++) {
             int sum =0;
             for ( int r  = low; r <= high; r++ ) {
                 sum += x[r];
                 countOn3++;
             }
             if (sum > maxsofar) {
                 maxsofar = sum;
             }
        }
    }
    return maxsofar;
}
