package cn.blacard.nymph.random;
/**
 * description 
 * author SunAo
 * create time 2016年8月12日 下午3:03:43
 * e-mail : blacard@163.com
 */
public class NumberRandom {
		public static int getRandom(int base,int add,int substract){
			return base+getRandom(add)-getRandom(substract);
		}
		
		private static int getRandom(int base){
			return (int) Math.floor((Math.random()*(base+1)));
		}

		public static int getRandom(int base,int add){
			return getRandom(base,add,0);
		}
}