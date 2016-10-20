import java.util.concurrent.BlockingQueue;

/**
 * 
 */

/**
 * @author Owner
 *
 */
public class Producer implements Runnable{

    protected BlockingQueue queue = null;
    private int randomNum = 0;
    
    
    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }
    
    public Producer(BlockingQueue queue, int randomNum) {
        this.queue = queue;
        this.randomNum = randomNum;
    }

    @SuppressWarnings("unchecked")
	public void run() {
        try {
            queue.put(randomNum);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}