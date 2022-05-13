import java.util.concurrent.*;

public class QuickSort implements Runnable {
    int start;
    int end;
    int a[];
    QuickSort(int start, int end, int a[]) {
        this.start=start;
        this.end=end;
        this.a=a;
    }

    @Override
    public void run() {
        if(start>=end) {
            return ;
        }
        int index=start;
        start+=1;
        int size=end;
        while(start<=end) {
            if(a[start]<=a[index]){
                start+=1;
            }
            else if(a[end]>a[index]) {
                end-=1;
            }
            else {
                int t=a[start];
                a[start]=a[end];
                a[end]=t;
            }
        }

        int t=a[end];
        a[end]=a[index];
        a[index]=t;
        QuickSort left=new QuickSort(index, end-1, a);
        QuickSort right=new QuickSort(end+1, size, a);
        ExecutorService ex= Executors.newFixedThreadPool(2);
        Future<?> f=ex.submit(left);
        Future<?> f1=ex.submit(right);
        try {
            f.get();
            f1.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return ;
    }
}
