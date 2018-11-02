package cn.virde.nymph.random;


/**
 * 
 * <h3>快速生成随机数</h3>
 * @author Blacard
 * 
 * 2016年8月12日 下午3:03:43
 */
public class NumberRandom {
		/**
		 * 在某个数的基础上，
		 * 随机增减
		 * @author Blacard
		 * 2016年9月18日 下午5:12:11
		 * @param base 以base为基础
		 * @param add 随机增
		 * @param substract 随即减
		 * @return 返回 result
		 */
		public long getRandom(long base,long add,long substract){
			return base+getRandom(add)-getRandom(substract);
		}

		/**
		 * 某个数字 加 另一个数字以内的随机数
		 * @author Blacard
		 * 2016年9月18日 下午5:15:47
		 * @param base 某个数字，用来作为基础值
		 * @param add 基础值 加 这个数字以内的随机数
		 * @return 返回
		 */
		public long getRandom(long base,long add){
			return getRandom(base,add,0);
		}
		/**
		 * 按百分比获取boolean值，
		 * 比如 base = 20 ，20%几率返回true。
		 * 算法有待优化。
		 * @author Virde
		 * 2018年4月23日 上午9:56:33
		 * @return 返回
		 */
		public boolean getBoolean(long base) {
			return  getRandom(100) < base ;
		}
		/**
		 * 在某个范围取随机数
		 * @author Virde
		 * 2018年5月10日 下午2:06:59
		 * @param start 开始
		 * @param end 结束
		 * @return 返回
		 */
		public long getRandomRange(long start, long end) {
			return getRandom(start, end - start) ;
		}
		/**
		 * 在某个数以内的随机数
		 * @author Blacard
		 * 2016年9月18日 下午5:13:48
		 * @param base 某个数字
		 * @return 返回 某个数字以内的随机数，int类型
		 */
		private long getRandom(long base){
			return (long) Math.floor((Math.random()*(base+1)));
		}
		
}