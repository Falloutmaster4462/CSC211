//4551372
//Nikaj Jazeel Nilraj
//MCS Prac 16/02/2026




// Importing clases
import java.util.Random;
public class MCS {
    
//Counters and their initalisation
static long countOn3 = 0;
static long countOn2A = 0;
static long countOn2B = 0;
static long countOn = 0;


// Implementation for O(n^3):

public static int mcsOn3(int[] x){
    //Copy paste the below 2 lines for later
    int n = x.length;
    int maxsofar = 0;

    for (int low = 0; low < n; low++) {
        for (int high = low; high < n; high++) {
             int sum =0;
             for ( int r  = low; r <= high; r++ ) {
                 sum += x[r];
                 //Inc global counter
                 countOn3++;
             }
             if (sum > maxsofar) {
                 maxsofar = sum;
             }
        }
    }
    return maxsofar;
}

// Implementation of O(n^2) VERSION A:

public static int mcsOn2A(int[] x){
    //pasted the below 2 lines from the first func.
    int n = x.length;
    int maxsofar = 0;

    for (int low = 0; low < n; low++) {
        int sum =0;
        for (int r  = low; r < n; r++){
            sum += x[r];
            countOn2A++; //Inc global counter
        if (sum > maxsofar) {
            maxsofar = sum;
        }
    }
    }
    return maxsofar;
}


// Implementation of O(n^2) VERSION B (Prefix sums):
public static int mcsOn2B(int[] x){

    int n = x.length;
   int[] sumTo = new int[n + 1];

   for (int i = 1; i <= n; i++) {
       sumTo[i] = sumTo[i - 1] + x[i - 1];
   }

   int maxsofar = 0;
   for(int low = 0; low < n; low ++){
       for (int high = low; high < n; high ++){
           int sum = sumTo[high + 1 ] - sumTo[low];
           //Inc global counter!
           countOn2B++;
           if (sum > maxsofar)
               maxsofar = sum;

       }

   }
        return maxsofar;
}

// Implementation of O(n) :

public static int mcsOn(int[] x){

    int maxSoFar = 0;
    int maxToHere = 0;

    for ( int i = 0; i < x.length; i++ ) {
        maxToHere = Math.max(maxToHere +  x[i], 0);
        //Inc global counter!
        countOn++;
        maxSoFar = Math.max(maxSoFar, maxToHere);

    }
    return maxSoFar;
}

// Generating array for output

public static int[] generateArray(int n ){
    Random rand = new Random();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
        x[i] = rand.nextInt(20) - 10;
    }
    return x;
}

// Main func to test!:
public static void main(String[] args) {

    int[] testSizes = {100, 1000, 10000, 100000, 1000000};

    System.out.printf("%-10s %-15s %-15s %-15s %-15s\n",
            "n", "O(n^3)", "O(n^2)A", "O(n^2)B", "O(n)");

    for (int n : testSizes) {
        int[] X = generateArray(n);

        countOn3 = countOn2A = countOn2B = countOn = 0;

        if (n <= 2000)  // prevent extreme runtime so I do not crash my system
            mcsOn3(X);

        if (n <= 50000) {
            mcsOn2A(X);
            mcsOn2B(X);
        }

        mcsOn(X);
       //tbl and coloumn creation
        System.out.printf("%-10d %-15d %-15d %-15d %-15d\n",
                n, countOn3, countOn2A, countOn2B, countOn);
    }
}
}
        

