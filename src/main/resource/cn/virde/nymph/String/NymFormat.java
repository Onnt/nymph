package cn.virde.nymph.String;

import java.util.Date;

import cn.virde.nymph.Nym;

/**
 * <h3>格式化 各种数据形式</h3>
 * @author Blacard
 * @联系方式 邮箱：blacard@163.com <br/> 手机：18037170703
 * @createTime 2016年9月8日 下午4:05:31
 */
public class NymFormat {
	/**
	 * 将数字转换为 自然语言描述的文件大小
	 * @author Blacard
	 * @Create 2016年9月7日 下午5:29:35
	 * @param length
	 * @return
	 */
	public String fileLength(long length){
		int level = 0 ;
		String fmt = "";
		while(length > 1024){
			length = length / 1024;
			level++;
		}
		switch(level){
			case 0:
				fmt = " B";
				break;
			case 1:
				fmt = " KB";
				break;
			case 2:
				fmt = " MB";
				break;
			case 3:
				fmt = " GB";
				break;
			case 4:
				fmt = " TB";
				break;
			case 5:
				fmt = "PB";
				break;
			case 6:
				fmt = "EB";
				break;
				default : ;
		}
		return length+fmt;
	}
	/**
	 * 将以数字加单位形式的文件大小转换成具体数字
	 * 例：“3.3MB” 转换为 “3460300” 
	 * 目前仅支持 KB,MB,GB 单位的转换
	 * @author Blacard
	 * @create 2016年9月19日 上午11:42:32
	 * @param str 数字加单位形式表示的文件大小
	 * @return 转换后的纯数字文件大小
	 */
	public  long fileSizeToLong(String str){
		//获取到参数的数字部分
		float n = Float.parseFloat(str.substring(0,str.length()-2));
		//获取到参数的单位部分
		String unit = str.substring(str.length()-2,str.length());
		//定义返回结果
		long result = 0;
		//将参数的数字部分转换成long类型，乘1000是防止丢失小数部分
		long  num = (long)(n*1000);
		switch(unit.toUpperCase()){
		case "KB":
			result = 1024*num;
			break;
		case "MB":
			result = 1024*1024*num;
			break;
		case "GB":
			result =  1024*1024*1024*num;
			break;
		}
		//将上面的1000还回去
		result = result/1000;
		return result;
	}
	
	public String getAPM(Date date){
		return getAPM(Nym.time.toString(date));
	}
	public String getAPM(String time){
		int hour = Integer.parseInt(time.substring(11, 13));
		String apm = "";
		switch(hour){
		case 0:
			apm = "子时";
			break;
		case 1:
			apm = "丑时";
			break;
		case 2:
			apm = "丑时";
			break;
		case 3:
			apm = "寅时";
			break;
		case 4:
			apm = "寅时";
			break;
		case 5:
			apm = "早上";
			break;
		case 6:
			apm = "早上";
			break;
		case 7:
			apm = "早上";
			break;
		case 8:
			apm = "早上";
			break;
		case 9:
			apm = "上午";
			break;
		case 10:
			apm = "上午";
			break;
		case 11:
			apm = "中午";
			break;
		case 12:
			apm = "中午";
			break;
		case 13:
			apm = "下午";
			break;
		case 14:
			apm = "下午";
			break;
		case 15:
			apm = "下午";
			break;
		case 16:
			apm = "下午";
			break;
		case 17:
			apm = "下午";
			break;
		case 18:
			apm = "下午";
			break;
		case 19:
			apm = "晚上";
			break;
		case 20:
			apm = "晚上";
			break;
		case 21:
			apm = "晚上";
			break;
		case 22:
			apm = "晚上";
			break;
		case 23:
			apm = "子时";
			break;
		}
		return apm;
	}
}
