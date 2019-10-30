package cn.virde.nymph.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author SunAo
 * @Date 2019/7/23
 **/
public class IPUtils {

    public static boolean isValidIP(String ipAddr){
        if(ipAddr == null || ipAddr.length() < 7 || ipAddr.length() > 15 || "".equals(ipAddr)){
            return false;
        }
        return ipAddr.matches("((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))");
    }

    public static boolean isLocalIP(String ipAddr){
        String rexp = "(127\\.0\\.0\\.1)|(localhost)|(10\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})|(172\\.((1[6-9])|(2\\d)|(3[01]))\\.\\d{1,3}\\.\\d{1,3})|(192\\.168\\.\\d{1,3}\\.\\d{1,3})";
        return ipAddr.matches(rexp);
    }

    public static boolean isIPV4(String addr) {
        if (null == addr) {
            return false;
        } else {
            String rexp = "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";
            Pattern pat = Pattern.compile(rexp);
            Matcher mat = pat.matcher(addr);
            boolean ipAddress = mat.find();
            return ipAddress;
        }
    }
    public static boolean isIPV6(String addr) {
        if (null == addr) {
            return false;
        } else {
            String rexp = "^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}$";
            Pattern pat = Pattern.compile(rexp);
            Matcher mat = pat.matcher(addr);
            boolean ipAddress = mat.find();
            return ipAddress;
        }
    }
}
