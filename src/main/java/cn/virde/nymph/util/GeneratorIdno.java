package cn.virde.nymph.util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SunAo
 * @Date 2019/9/27
 **/
public class GeneratorIdno {

    /** 省、直辖市代码表 */
    public static final String provinceCodeArr[] = {
            "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37", "41",
            "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71",
            "81", "82", "91"
    };
    public static Map<String, String> provinceCodes = new HashMap<String, String>();
    static {
        provinceCodes.put("11", "北京");
        provinceCodes.put("12", "天津");
        provinceCodes.put("13", "河北");
        provinceCodes.put("14", "山西");
        provinceCodes.put("15", "内蒙古");
        provinceCodes.put("21", "辽宁");
        provinceCodes.put("22", "吉林");
        provinceCodes.put("23", "黑龙江");
        provinceCodes.put("31", "上海");
        provinceCodes.put("32", "江苏");
        provinceCodes.put("33", "浙江");
        provinceCodes.put("34", "安徽");
        provinceCodes.put("35", "福建");
        provinceCodes.put("36", "江西");
        provinceCodes.put("37", "山东");
        provinceCodes.put("41", "河南");
        provinceCodes.put("42", "湖北");
        provinceCodes.put("43", "湖南");
        provinceCodes.put("44", "广东");
        provinceCodes.put("45", "广西");
        provinceCodes.put("46", "海南");
        provinceCodes.put("50", "重庆");
        provinceCodes.put("51", "四川");
        provinceCodes.put("52", "贵州");
        provinceCodes.put("53", "云南");
        provinceCodes.put("54", "西藏");
        provinceCodes.put("61", "陕西");
        provinceCodes.put("62", "甘肃");
        provinceCodes.put("63", "青海");
        provinceCodes.put("64", "宁夏");
        provinceCodes.put("65", "新疆");
        provinceCodes.put("71", "台湾");
        provinceCodes.put("81", "香港");
        provinceCodes.put("82", "澳门");
        provinceCodes.put("91", "国外");
    }


    public static String generator(int begin,int end){
        return generator(provinceCodeArr, begin,end,-1 );
    }
    public static String generator(String[] provinceCodes,int begin,int end,int gender){
        if(provinceCodes == null || provinceCodes.length == 0 ) return null;
        int length = provinceCodes.length;
        String provinceCode = provinceCodes[(int)(Math.random()*length)];
        String cityCode = randomCityCode();
        String birth = randomBirth(begin,end);
        int pCode = getRandom(0, 99,0);
        String policeCode = pCode < 10 ? "0"+pCode : ""+pCode;
        String genderCode = null;
        switch (gender){
            case 0 :
                genderCode = (String) getOne("0","2","4","6","8");
                break;
            case 1:
                genderCode = (String) getOne("1","3","5","7","9");
                break;
            case -1:
                genderCode = (String) getOne("1","3","5","7","9","0","2","4","6","8");
                break;
        }
        String code17 = provinceCode + cityCode + birth + policeCode + genderCode;
        String code18 = IdnoUtils.IdnoBaseCal.generatorLastCode(code17);
        return code17+code18;
    }

    private static String randomCityCode(){
        int cityCode = (int)(Math.random()*10000);
        if(cityCode < 1000 || cityCode > 9999){
            return randomCityCode();
        }
        return cityCode+"";
    }

    private static String randomBirth(int begin,int end){
        int year = getRandom(begin/10000,end/10000-begin/10000 ,0);
        int month = getRandom(1,11,0);
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 01);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int day = getRandom(maxDay);
        String mon = month < 10 ?"0"+month : ""+month;
        int respDate = Integer.parseInt( year + mon + (day<10?"0"+day:day));
        if(respDate < begin || respDate > end){
            return  randomBirth(begin,end );
        }
        return respDate+"";
    }
    private static int getRandom(int base){
        return (int) Math.floor((Math.random()*(base+1)));
    }
    public static int getRandom(int base,int add,int substract){
        return base+getRandom(add)-getRandom(substract);
    }
    public static Object getOne(Object...args) {
        if(args.length == 0 ) return null;
        int randomIndex = getRandom(0, args.length-1,0);
        return args[randomIndex];
    }
    public static void main(String[] args) {
//        for(int i = 0 ; i < 1000; i ++){
//            System.out.println(generator(20190901,20191030));
//        }
        System.out.println("张志伟".hashCode());
    }
}
