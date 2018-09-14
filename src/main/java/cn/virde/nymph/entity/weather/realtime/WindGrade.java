package cn.virde.nymph.entity.weather.realtime;

/**
 * 
 * @author Virde
 * 2018年1月24日 下午6:10:08
 */
public class WindGrade {
	
	// 风速 ， 单位 千米每小时（h/km）
	private double speed ;
	private int windGrade ;
	private String name ;
	private String descript ;
		
	public WindGrade(double speed) {
		this.speed = speed ;
		calculation();
	}
	private void calculation() {
		if(speed < 1) {
			windGrade = 0;
			name="无风" ;
			descript = "静，烟直上";
		}else if(speed <= 5) {
			windGrade = 1;
			name = "软风" ;
			descript = "烟示风向";
		}else if(speed <= 11) {
			windGrade = 2;
			name = "轻风" ;
			descript = "感觉有风";
		}else if(speed <= 19) {
			windGrade = 3;
			name = "微风" ;
			descript = "旌旗展开";
		}else if(speed <= 28) {
			windGrade = 4;
			name = "和风" ;
			descript = "吹起尘土";
		}else if(speed <= 38) {
			windGrade = 5 ;
			name = "清风" ;
			descript = "小树摇摆";
		}else if(speed <= 49) {
			windGrade = 6 ;
			name = "强风" ;
			descript = "电线有声";
		}else if(speed <= 61) {
			windGrade = 7 ;
			name = "疾风" ; // 也称 劲风
			descript = "步行困难";
		}else if(speed <= 74) {
			windGrade = 8 ;
			name = "大风" ;
			descript = "折毁树枝";
		}else if(speed <= 88) {
			windGrade = 9 ;
			name = "烈风" ;
			descript = "小损房屋";
		}else if(speed <= 102) {
			windGrade = 10 ;
			name = "狂风" ;
			descript = "拔起树木";
		}else if(speed <= 117) {
			windGrade = 11 ;
			name = "暴风" ;
			descript = "损毁重大";
		}else if(speed <= 134) {
			windGrade = 12 ;
			name = "台风（一级飓风）";
			descript = "摧毁极大";
		}else if(speed <= 149) {
			windGrade = 13;
			name = "台风（一级飓风）" ;
			descript = "";
		}else if(speed <= 166) {
			windGrade = 14 ;
			name = "强台风（二级飓风）" ;
			descript = "";
		}else if(speed <= 183) {
			windGrade = 15 ;
			name = "强台风（三级飓风）" ;
			descript = "";
		}else if(speed <= 201) {
			windGrade = 16 ;
			name = "超强台风（三级飓风）" ;
			descript = "";
		}else if(speed <= 220) {
			windGrade = 17 ;
			name = "超强台风（四级飓风）" ;
			descript = "";
		}else if(speed <= 250) {
			windGrade = 18 ;
			name = "超强台风（四级飓风）" ;
			descript = "";
		}else if(speed <= 372){
			windGrade = 19 ;
			name = "超强台风（五级飓风）" ;
			descript = "";
		}else if(speed <= 513){
			windGrade = 20 ;
			name = "超强台风（五级飓风）" ;
			descript = "地球表面最快的“正常的”风速";
		}else {
			windGrade = 21 ;
			name = "超强台风（五级飓风）" ;
			descript = "超过地球风速最高记录";
		}
	}
	
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getWindGrade() {
		return windGrade;
	}
	public void setWindGrade(int windGrade) {
		this.windGrade = windGrade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public static void main(String[] args) {
		System.out.println(new WindGrade(2132.32).getName());
	}
}

/**
风级 名称 风速(m/s) (km/h) 陆地地面物象 海面波浪 浪高(m) 最高(m)

无风 0.0-0.2 <1 静，烟直上 平静 0.0 0.0 
软风 0.3-1.6 1-5 烟示风向 微波峰无飞沫 0.1 0.1 
轻风 1.6-3.4 6-11 感觉有风 小波峰未破碎 0.2 0.3
微风 3.4-5.5 12-19 旌旗展开 小波峰顶破裂 0.6 1.0
和风 5.5-8.0 20-28 吹起尘土 小浪白沫波峰 1.0 1.5
清风 8.0-10.8 29-38 小树摇摆 中浪折沫峰群 2.0 2.5
强风 10.8-13.9 39-49 电线有声 大浪白沫离峰 3.0 4.0
劲风（疾风） 13.9-17.2 50-61 步行困难 破峰白沫成条 4.0 5.5
大风 17.2-20.8 62-74 折毁树枝 浪长高有浪花 5.5 7.5
烈风 20.8-24.5 75-88 小损房屋 浪峰倒卷 7.0 10.0 
狂风 24.5-28.5 89-102 拔起树木 海浪翻滚咆哮 9.0 12.5
暴风 28.5-32.6 103-117 损毁重大 波峰全呈飞沫 11.5 16.0 
台风 （一级飓风） 32.6-37.0 117-134 摧毁极大 海浪滔天 14.0 - 
台风 （一级飓风） 37.0-41.4 134-149 
强台风 （二级飓风） 41.5-46.1 150-166 
强台风 （三级飓风） 46.2-50.9 167-183 
超强台风 （三级飓风） 51.0-56.0 184-201
超强台风 （四级飓风） 56.1-61.2 202-220 17级以上	 
超强台风 （四级飓风） ≥61.3 ≥221 
超级台风 （五级飓风）≥250				
注1：本表所列风速是指平地上离地10米处的风速值。[2] 
注2：超级台风（super typhoon）为美国对顶级强度台风的称谓。

飓风约翰是中太平洋有纪录以来的第三个五级飓风，
并创下该海域最高的风速纪录，达280公里/小时。
自1994年起，只有飓风伊欧凯在中太平洋达到五级飓风的强度，
它与吉尔玛一样，拥有比约翰更低的气压但较慢的风速。
台风温黛横过本港时的强度相当于美国国家飓风中心热带气旋分级中的二级台风，
当时维多利亚港一度录得的平均风力达133公里/小时，
最高阵风259公里/小时，而大老山亦录得时速284公里/小时的阵风纪录。
台风泰培是地球纪录上最强的热带气旋台风。
目前最高风速的热带气旋是2013年西北太平洋的台风海燕，
平均风速达每小时315公里。地球表面最快的“正常的”风速达到372公里/小时，
这是1934年4月12日在美国新罕布尔什州的华盛顿山记录的，
但是1999年5月在俄克拉荷马州发生的一次龙卷风中，研究人员测到的最快风速达到了513公里/小时。

**/