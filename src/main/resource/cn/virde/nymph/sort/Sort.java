package cn.virde.nymph.sort;

import java.util.List;


import cn.virde.nymph.Nym;

/**
 * 这个类的作用就是：我给你一个列表，指定一个字段。你根据这个字段帮我排序，升降我来指定
 * 或者，我给你一个数组，你帮我把数组排序。
 * 又或者，……
 * @author SunAo
 * @date 2018年4月13日 下午5:11:26
 */
public class Sort {
	public final static int DESC = 1;
	public final static int ACS = -1;
	
//	public <T> List<T> sort(List<T> list ,String field,int type) {
		
//		for(int i = 0 ; i < list.size() - 1;i++)  {  
//            for(int j = 0 ; j <  list.size() - 1- i ;  j++){
//            	T t = list.get(i);
//                if(list.get(j).getSum() < list.get(j+1).getSum()){
//                	TradeDto temp = list.get(j) ;
//                	list.set(j, list.get(j+1));
//                	list.set(j+1, temp);
//                }  
//            }  
//        }  
//		return list ;
//	}
}
