import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 */

/**
 * @author <>
 * 
 */
public class Randomizer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Randomizer ram = new Randomizer();
		ram.getRandomNum();
	}

	/**
	 * 
	 */
	public void getRandomNum() {
		int number;
		Random randomMath = new Random();

		// random integers in [0, 100] at a maximum of 25 numbers will be
		// generated
		try {
			for (number = 1; number <= 25; number++) {
				communication(randomMath.nextInt(100)); // Number generated and
														// send it to
														// commincation
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Java Queue Logic implemented
	 * 
	 * @param randomNum
	 * @throws InterruptedException
	 * @throws Exception
	 */
	public void communication(int randomNum) throws InterruptedException,
			Exception {

		try {
			BlockingQueue queue = new LinkedBlockingQueue<>(1024);

			Producer producer = new Producer(queue, randomNum);
			new Thread(producer).start();
			
			
			Callable con = new Consumer(queue);

			ExecutorService executor = Executors.newFixedThreadPool(10);
			Future submit1 = executor.submit(con);

			Object res1 = submit1.get();
			System.out.println("Result :" + res1);
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
