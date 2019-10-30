package cn.virde.nymph.orderno;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author SunAo
 * @Date 2019/10/8
 **/
public class OrderNoGenerator {

    public static String make13(){
        return Generator13.make();
    }
    public static String make16(){
        return Generator16.make();
    }

    static class Generator13{
        private final static AtomicInteger sub = new AtomicInteger(0);
        private final static String machineCode = "0";
        public static String make(){
            StringBuffer sb = new StringBuffer();
            sb.append(machineCode);
            long timestamp = System.currentTimeMillis()/1000;
            sb.append((timestamp+"").substring(1));
            int subValue = sub.incrementAndGet();
            if(subValue > 999){
                synchronized (sub){
                    sub.set(0);
                    return make();
                }
            }
            if(subValue<10){
                sb.append("00");
            } else if(subValue<100){
                sb.append("0");
            }
            sb.append(subValue);
            return sb.toString();
        }
    }

    static class Generator16{
        private final static AtomicInteger sub = new AtomicInteger(0);
        private final static String machineCode = "00";
        public static String make(){
            StringBuffer sb = new StringBuffer();
            sb.append(machineCode);
            long timestamp = System.currentTimeMillis()/1000;
            sb.append((timestamp+"").substring(1));
            int subValue = sub.incrementAndGet();
            if(subValue > 99999){
                synchronized (sub){
                    sub.set(0);
                    return make();
                }
            }
            if(subValue<10){
                sb.append("0000");
            } else if(subValue<100){
                sb.append("000");
            } else if(subValue<1000){
                sb.append("00");
            } else if(subValue<10000){
                sb.append("0");
            }
            sb.append(subValue);
            return sb.toString();
        }
    }
}
