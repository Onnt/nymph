package cn.virde.nymph.random;

import cn.virde.nymph.Nym;

public class Random extends NumberRandom{

	/**
	 * 随机获取一个参数
	 * @author Virde
	 * @time 2018年1月25日 上午11:32:07
	 * @param args
	 * @return
	 */
	public String string(String...args) {
		int randomIndex = Nym.random.getRandom(0, args.length-1);
		return args[randomIndex];
	}
}
