package CombiningMultipleCompletableFutures;

import java.awt.image.DataBufferUShort;
import java.util.concurrent.CompletableFuture;

public class CancelMethod {
    public static void main(String[] args) {
        CompletableFuture<Integer>Future1=CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 200;
        });

        Future1.cancel(true);

        if (Future1.isCancelled()){
            System.out.println("The Task Has Been Canceled");
        }else{
            System.out.println(Future1.join());
        }
    }
}
