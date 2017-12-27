import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class Test extends Thread{
	@Override
    public void run(){
       try{
            Thread.sleep(1000);
            }catch (InterruptedException e){
            e.printStackTrace();
            }
            System.out.print("run");
    }
    public static void main(String[] args){
    	int i = 5;
    	int j = 10; 
    	System.out.println(i + ~j);
    }

}