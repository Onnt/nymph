package cn.blacard.nymph.String;
/**
 * <h3>格式化 各种数据形式</h3>
 * @author Blacard
 * @联系方式 邮箱：blacard@163.com <br/> 手机：18037170703
 * @createTime 2016年9月8日 下午4:05:31
 */
public class NymFormat {
	/**
	 * 格式化 文件大小
	 * 配上单位
	 * @author Blacard
	 * @Create 2016年9月7日 下午5:29:35
	 * @param length
	 * @return
	 */
	public static String fileLength(long length){
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
	public static long parseLong(String str){
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
}
