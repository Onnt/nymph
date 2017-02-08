package cn.blacard.nymph.random;
/**
 * 
 * <h3>快速生成随机数</h3>
 * @author Blacard
 * @联系方式 邮箱：blacard@163.com <br/> 手机：18037170703
 * @createTime 2016年8月12日 下午3:03:43
 */
public class NumberRandom {
		/**
		 * 在某个数的基础上，
		 * 随机增减
		 * @author Blacard
		 * @Create 2016年9月18日 下午5:12:11
		 * @param base 以base为基础
		 * @param add 随机增
		 * @param substract 随即减
		 * @return result
		 */
		public int getRandom(int base,int add,int substract){
			return base+getRandom(add)-getRandom(substract);
		}


		/**
		 * 某个数字 加 另一个数字以内的随机数
		 * @author Blacard
		 * @Create 2016年9月18日 下午5:15:47
		 * @param base 某个数字，用来作为基础值
		 * @param add 基础值 加 这个数字以内的随机数
		 * @return
		 */
		public int getRandom(int base,int add){
			return getRandom(base,add,0);
		}
		
		/**
		 * 在某个数以内的随机数
		 * @author Blacard
		 * @Create 2016年9月18日 下午5:13:48
		 * @param base 某个数字
		 * @return 某个数字以内的随机数，int类型
		 */
		private int getRandom(int base){
			return (int) Math.floor((Math.random()*(base+1)));
		}
}