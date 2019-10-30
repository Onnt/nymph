package cn.virde.nymph.util;

import org.junit.Test;

/**
 * @author SunAo
 * @Date 2019/7/11
 **/
public class IdCardUtilsTest {

    @Test
    public void test15To18(){
        // 正常参数
        String after1 = IdCardUtils.convert15CardTo18("411381930910421");
        System.out.println("正常参数转换后：" + after1);

        // 错误参数 - 长度错误 - 18位有效身份证号
        String after2 = IdCardUtils.convert15CardTo18("411381199309104215");
        System.out.println("错误参数转换后：" + after2);

        // 错误参数 - 长度错误 - 17位数字
        String after3 = IdCardUtils.convert15CardTo18("41138119930910421");
        System.out.println("错误参数转换后：" + after3);
    }

    @Test
    public void getInfoFromIdCard(){
        // 15位身份证
        String idCard = "411381930910421";
        System.out.println(IdCardUtils.getBirthByIdCard(idCard));
        System.out.println(IdCardUtils.getYearByIdCard(idCard));
        System.out.println(IdCardUtils.getAgeByIdCard(idCard));

        // 18位身份证
        idCard = "411381199309104215";
        System.out.println(IdCardUtils.getBirthByIdCard(idCard));
        System.out.println(IdCardUtils.getYearByIdCard(idCard));
        System.out.println(IdCardUtils.getAgeByIdCard(idCard));
    }

    @Test
    public void validIdCard(){
        // 正确的身份证
        String rightIdCard = "411381199309104215";
        System.out.println("正确："+IdCardUtils.validateIdCard18(rightIdCard));
        // 错误的身份证
        String errorIdCard = "411381199309104216";
        System.out.println("错误："+IdCardUtils.validateIdCard18(errorIdCard));

        String l15IdCard = "411381690910421";
        // 使用兼容15和18位校验方法
        System.out.println("通用方法检测15位：" + IdCardUtils.validateIdCard(l15IdCard));
        System.out.println("通用方法检测18位：" + IdCardUtils.validateIdCard(rightIdCard));
    }
}
