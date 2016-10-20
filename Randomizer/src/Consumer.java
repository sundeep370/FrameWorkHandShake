import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;


/**
 * @author Owner
 *
 */
public class Consumer implements Callable{

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public Object call() {
    	
    	boolean isPrime = false;
        try {
        	Primes primes = new Primes();
        	isPrime = primes.isPrime(queue.take());
        	System.out.println("Verifing Prime Number:"+isPrime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isPrime;
    }
}
