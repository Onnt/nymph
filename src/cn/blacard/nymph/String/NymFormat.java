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
}
