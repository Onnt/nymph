package cn.virde.nymph.orderno;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author SunAo
 * @Date 2019/10/8
 **/
public class OrderNoGeneratorTest extends Thread {

    private final static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    private final static ExecutorService exe  = Executors.newCachedThreadPool();

    @Override
    public void run() {
        String order = OrderNoGenerator.Generator13.make();
        if(queue.contains(order)){
            System.out.println("!!!!!!!!!!!!!! "+order);
        }
        queue.add(order);
        super.run();
    }


    public static void main(String[] args) {
        for(int i = 0 ; i < 999;i++){
            exe.execute(new OrderNoGeneratorTest());
        }
    }



}
