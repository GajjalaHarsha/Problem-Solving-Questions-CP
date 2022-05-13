
import java.util.concurrent.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        int a[]={10,5,1,2,57,15,30,7,9};
        QuickSort q=new QuickSort(0, a.length-1, a);
        ExecutorService ex= Executors.newSingleThreadExecutor();
        Future<?> e=ex.submit(q);
        try {
            e.get();
            System.out.println("After Sorting: ");
            for(int i=0;i<a.length;i++) {
                System.out.print(a[i]+" ");
            }
            exit(0);
        }

        catch (Exception exception) {
            System.out.println(exception);
        }



    }
}
