import java.io.*;

public class SortThread extends Thread {
    private PrintWriter out = null;
    private BufferedReader in = null;

    public SortThread(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    //排序线程的线程体。
    public void run() {
        int MAXWORDS = 50;

        if (out != null && in != null) {
            try {
                String[] listOfWords = new String[MAXWORDS];
                int numwords = 0;
 
                while ((listOfWords[numwords] = in.readLine()) != null)
                    numwords++;
                quicksort(listOfWords, 0, numwords-1);
                for (int i = 0; i < numwords; i++)
                    out.println(listOfWords[i]);
                out.close();
            } catch (IOException e) {
                System.err.println("SortThread run: " + e);
            }
        }
    }

    //实现快速排序算法。
    private static void quicksort(String[] a, int lo0, int hi0) {
        int lo = lo0;
        int hi = hi0;

        if (lo >= hi)
            return;

        String mid = a[(lo + hi) / 2];
        while (lo < hi) {
            while (lo<hi && a[lo].compareTo(mid) < 0)
                lo++;
            while (lo<hi && a[hi].compareTo(mid) > 0)
                hi--;
            if (lo < hi) {
                String T = a[lo];
                a[lo] = a[hi];
                a[hi] = T;
                lo++;
                hi--;
            }
        }
        if (hi < lo) {
            int T = hi;
            hi = lo;
            lo = T;
        }
        quicksort(a, lo0, lo);
        quicksort(a, lo == lo0 ? lo+1 : lo, hi0);
    }
}
