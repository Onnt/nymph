package cn.virde.nymph.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SunAo
 * @Date 2019/9/23
 **/
public class IdnoUtils {

    /** 中国公民身份证号码最大长度。 */
    public static final int CHINA_ID_MAX_LENGTH = 18;

    /**
     * 验证身份证号码是否正确
     * @param idno 身份证号码
     * @return 是否正确
     */
    public static boolean validate(String idno){
        // 如果不是18位
        if(idno.length() != CHINA_ID_MAX_LENGTH)  return false;
        // 如果是未来的日期
        Date date = IdnoBaseCal.getBirthday(idno);
        if(date == null || date.getTime() > System.currentTimeMillis()) return false;
        return IdnoBaseCal.validateLastCode(idno);
    }

    public static Date getBirthday(String idno){
        return IdnoBaseCal.getBirthday(idno);
    }

    public static String generatorRandomIdno(){
        return null;
    }

    static class IdnoBaseCal{


        public static String generatorLastCode(String code17){
            if( ! isNum(code17)) return null;
            char[] cArr = code17.toCharArray();
            if(cArr == null) return null;
            int[] iCard = converCharToInt(cArr);
            int iSum17 = getPowerSum(iCard);
            return getCheckCode18(iSum17);
        }

        public static boolean validateLastCode(String idno){
            String code17 = idno.substring(0, 17);
            String code18 = idno.substring(17, 18);
            // 判断最后一位是否正确
            String val = generatorLastCode(code17);
            return val != null && val.equalsIgnoreCase(code18);
        }
        /**
         * 获取出生日期
         * @param idno 身份证号码
         * @return 出生日期
         */
        public static Date getBirthday(String idno){
            if(idno==null) return null;
            String date = idno.substring(6, 14);
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            try {
                return format.parse(date);
            } catch (ParseException e) {
                return null;
            }
        }
        /**
         * 数字验证
         *
         * @param val
         * @return 提取的数字。
         */
        public static boolean isNum(String val) {
            return val == null || "".equals(val) ? false : val.matches("^[0-9]*$");
        }
        /**
         * 将字符数组转换成数字数组
         *
         * @param ca  字符数组
         * @return 数字数组
         */
        private static int[] converCharToInt(char[] ca) {
            int len = ca.length;
            int[] iArr = new int[len];
            try {
                for (int i = 0; i < len; i++) {
                    iArr[i] = Integer.parseInt(String.valueOf(ca[i]));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return iArr;
        }


        /** 每位加权因子 */
        public static final int power[] = {
                7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2
        };
        /**
         * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
         *
         * @param iArr
         * @return 身份证编码。
         */
        private static int getPowerSum(int[] iArr) {
            int iSum = 0;
            if (power.length == iArr.length) {
                for (int i = 0; i < iArr.length; i++) {
                    for (int j = 0; j < power.length; j++) {
                        if (i == j) {
                            iSum = iSum + iArr[i] * power[j];
                        }
                    }
                }
            }
            return iSum;
        }


        /**
         * 将power和值与11取模获得余数进行校验码判断
         *
         * @param iSum
         * @return 校验位
         */
        public static String getCheckCode18(int iSum) {
            String sCode = null;
            switch (iSum % 11) {
                case 10:
                    sCode = "2";
                    break;
                case 9:
                    sCode = "3";
                    break;
                case 8:
                    sCode = "4";
                    break;
                case 7:
                    sCode = "5";
                    break;
                case 6:
                    sCode = "6";
                    break;
                case 5:
                    sCode = "7";
                    break;
                case 4:
                    sCode = "8";
                    break;
                case 3:
                    sCode = "9";
                    break;
                case 2:
                    sCode = "x";
                    break;
                case 1:
                    sCode = "0";
                    break;
                case 0:
                    sCode = "1";
                    break;
            }
            return sCode;
        }
    }

}
