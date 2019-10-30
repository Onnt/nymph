```
从提交历史看，这个项目是从2016年8月27开始陆续更新的。
其实是在2015年底就开始不断更新了。到现在2019年已经四年时间了。
这个项目可以说见证了我的很长成长，也说明了我的落后。
进入社会不像在学校，和伙伴的差距很难被预估。一直有一种被同伴不断超越，只有我自己在原地踏步的感觉。
是时候再开始，疯狂学习了。
这个项目太陈旧了，很多代码，很多思想。
是时候更换一个版本，继续前行了。  
新项目的地址是：https://gitee.com/heika/virde-nymph-v2
                                                              2019年10月30日 14:19:07  
                                                                       Virde 
```









- [Nymph](#nymph)
  - [项目简介](#%E9%A1%B9%E7%9B%AE%E7%AE%80%E4%BB%8B)
  - [使用说明](#%E4%BD%BF%E7%94%A8%E8%AF%B4%E6%98%8E)
    - [Nym类使用说明](#nym%E7%B1%BB%E4%BD%BF%E7%94%A8%E8%AF%B4%E6%98%8E)
      - [Nym.lunar 公农历转换](#nymlunar-%E5%85%AC%E5%86%9C%E5%8E%86%E8%BD%AC%E6%8D%A2)
      - [Nym.random 随机数工具](#nymrandom-%E9%9A%8F%E6%9C%BA%E6%95%B0%E5%B7%A5%E5%85%B7)
      - [Nym.system 系统信息](#nymsystem-%E7%B3%BB%E7%BB%9F%E4%BF%A1%E6%81%AF)
      - [Nym.position 地理位置信息](#nymposition-%E5%9C%B0%E7%90%86%E4%BD%8D%E7%BD%AE%E4%BF%A1%E6%81%AF)
      - [Nym.http http请求工具](#nymhttp-http%E8%AF%B7%E6%B1%82%E5%B7%A5%E5%85%B7)
      - [Nym.geocoding 地理位置正逆向解析](#nymgeocoding-%E5%9C%B0%E7%90%86%E4%BD%8D%E7%BD%AE%E6%AD%A3%E9%80%86%E5%90%91%E8%A7%A3%E6%9E%90)
      - [Nym.clazz 类反射工具](#nymclazz-%E7%B1%BB%E5%8F%8D%E5%B0%84%E5%B7%A5%E5%85%B7)
      - [Nym.file 文件操作类](#nymfile-%E6%96%87%E4%BB%B6%E6%93%8D%E4%BD%9C%E7%B1%BB)
      - [Nym.down 下载工具类](#nymdown-%E4%B8%8B%E8%BD%BD%E5%B7%A5%E5%85%B7%E7%B1%BB)
      - [Nym.number 数字工具类](#nymnumber-%E6%95%B0%E5%AD%97%E5%B7%A5%E5%85%B7%E7%B1%BB)
      - [Nym.string 字符串处理工具](#nymstring-%E5%AD%97%E7%AC%A6%E4%B8%B2%E5%A4%84%E7%90%86%E5%B7%A5%E5%85%B7)
    - [数据库操作说明](#%E6%95%B0%E6%8D%AE%E5%BA%93%E6%93%8D%E4%BD%9C%E8%AF%B4%E6%98%8E)
      - [Mysql数据库操作说明](#mysql%E6%95%B0%E6%8D%AE%E5%BA%93%E6%93%8D%E4%BD%9C%E8%AF%B4%E6%98%8E)
        - [生成MySql实例](#%E7%94%9F%E6%88%90mysql%E5%AE%9E%E4%BE%8B)
        - [查询数据库数据](#%E6%9F%A5%E8%AF%A2%E6%95%B0%E6%8D%AE%E5%BA%93%E6%95%B0%E6%8D%AE)
        - [进行增删改等操作](#%E8%BF%9B%E8%A1%8C%E5%A2%9E%E5%88%A0%E6%94%B9%E7%AD%89%E6%93%8D%E4%BD%9C)
    - [实时天气和预报天气](#%E5%AE%9E%E6%97%B6%E5%A4%A9%E6%B0%94%E5%92%8C%E9%A2%84%E6%8A%A5%E5%A4%A9%E6%B0%94)
      - [生成Weather对象](#%E7%94%9F%E6%88%90weather%E5%AF%B9%E8%B1%A1)
      - [获取天气详情](#%E8%8E%B7%E5%8F%96%E5%A4%A9%E6%B0%94%E8%AF%A6%E6%83%85)
  - [未完善，以后升级或者正在开发的功能](#%E6%9C%AA%E5%AE%8C%E5%96%84%E4%BB%A5%E5%90%8E%E5%8D%87%E7%BA%A7%E6%88%96%E8%80%85%E6%AD%A3%E5%9C%A8%E5%BC%80%E5%8F%91%E7%9A%84%E5%8A%9F%E8%83%BD)
    - [未完善的功能](#%E6%9C%AA%E5%AE%8C%E5%96%84%E7%9A%84%E5%8A%9F%E8%83%BD)
    - [以后升级开发的新功能](#%E4%BB%A5%E5%90%8E%E5%8D%87%E7%BA%A7%E5%BC%80%E5%8F%91%E7%9A%84%E6%96%B0%E5%8A%9F%E8%83%BD)
  - [版本更新历史](#%E7%89%88%E6%9C%AC%E6%9B%B4%E6%96%B0%E5%8E%86%E5%8F%B2)

# Nymph 

## 项目简介
这个项目是我平时代码片段的一些积累，以及一些功能的封装打包。如果这里的东西能够帮助到你，那么我会很开心，这里面有一些功能是需要开发者密匙的，比如说 地址位置逆向解析，普通IP定位，彩云天气。如果你需要大量调用，请尽量换成自己的开发者密匙

## 使用说明
### Nym类使用说明
#### Nym.lunar 公农历转换
- 农历时间转为公历时间  
`Nym.lunar.lunarDateTo(Date lunarDate);`
- 公历时间转为农历时间  
`Nym.lunar.toLunarDate(Date date);`

#### Nym.random 随机数工具
- Nym.random.string(String...args);  
  从参数中随机抽取一个字符串作为返回值
- Nym.random.randomChineseAddress()  
  在全国范围内随机返回一个地点的经纬度（暂时还未开发）
- Nym.random.uuid()  
  获取uuid 

#### Nym.system 系统信息
- Nym.system.getMac()  
获取当前系统Mac地址
- Nym.system.getHostName()  
获取当前系统名
- Nym.system.getLANIP()  
获取当前系统IP地址

#### Nym.position 地理位置信息
- Nym.position.getLocationByIp(String ip);  
根据指定的Ip地址获取经纬度，返回LocationEntity对象
- Nym.position.getLocation();  
获取当前系统所在位置的经纬度，返回LocationEntity对象
- Nym.position.getAddressByIp(String ip);  
根据指定的IP地址获取当前位置的自然语言描述。
- Nym.position.getAddress();  
获取当前系统所在位置的自然语言描述。
- Nym.position.locationToAddress(LocationEntity location);  
经纬度转换为自然语言描述的位置信息
- Nym.position.addressToLocation(String address);  
自然语言描述的位置信息转换为经纬度，返回LocationEntity对象。

#### Nym.http http请求工具
- Nym.http.post(String url,List<NameValuePair> params)  
- Nym.http.post(String url,Map<String,String> map)  
发送post请求
- Nym.http.getHtml(String url)  
- Nym.http.get(String url,Map<String,String> params)  
发送get请求

#### Nym.geocoding 地理位置正逆向解析
- Nym.geocoding.locationToAddress(LocationEntity location);
经纬度 转为 自然语言描述的地址
- Nym.geocoding.addressToLocation(String address);
自然语言描述的地址 转为 经纬度

#### Nym.clazz 类反射工具
- Nym.clazz.getField(Class clazz,String key)   
获取clazz内部public static String 修饰的成员变量，  
比如有如下类
```java
public class TestB {
	public static String name = "nameds";
}
```
可以用如下方法获取到这个name变量的值
```java
public class TestA{
	public static void main(String[] args) {
		System.out.println(Nym.clazz.getField(TestB.class, "name"));
	}
}
```
这个方法的名字不是很准确，之后会做些调整

- Nym.clazz.getField(Object a,String key)  
获取对象a中以get开头方法的返回值。主要用于获取POJO对象中的属性值
比如有这个一个POJO类

```java
public class Person {
	private String name ;
	private String pass ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
```
那么可以用下面这样的方式取出指定字段的值
```java
public class Test{
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NotExistFieldException {
		Person p = new Person();
		p.setName("Virde");
		
		System.out.println(Nym.clazz.getField(p, "name"));
		
	}
}
```
输出:
```
Virde
```
#### Nym.file 文件操作类
- Nym.file.getFileBySuffixs(List<File> files,List<String> suffixs);  
从给定的文件筛选以suffixs结尾的文件出来，返回List<File>

- (未测试) Nym.file.newFolder(String folderPath)
- (未测试) Nym.file.newFile(String filePathAndName)
- (未测试) Nym.file.copy(File oldFile,File newFile)
- (未测试) Nym.file.move(File oldFile,File newFile)
- (未测试) Nym.file.copyFolder(String oldPath, String newPath)
- (未测试) Nym.file.delAllFile(String path)
- (未测试) Nym.file.moveFolder(String oldPath, String newPath)
- (未测试) Nym.file.rename(File file,String newName)
- (未测试) Nym.file.delFolder(String folderPath)

#### Nym.down 下载工具类
- Nym.down.downFromUrl(String urlStr,String fileName,String savePath)  
下载urlStr，保存到savePath路径，下载文件命名为fileName
- Nym.down.downFromUrl(String url,String savePath)  
文件名字从url中获取。
- Nym.down.downFromUrl(String url)  
文件默认保存在“D://NymDownLoad”

#### Nym.number 数字工具类
- Nym.number.setCale(int size,double d)  
将d截取size位小数然后返回
- Nym.number.set2decimal(double d)  
将d截取2位小数并返回
- Nym.number.get2decimal(double d)  
将d截取2位小数并格式化为字符串然后返回
- (未开发)Nym.number.arabToChinese()  
将阿拉伯数字转换为中文数字并返回字符串
#### Nym.string 字符串处理工具
- Nym.string.getStringsByReg(String str,String regEx)  
在给定的字符串中匹配对应正则表达式，所有符合表达式的字符打包至集合中返回
- Nym.string.getStringByReg(String str,String regEx)  
在给定的字符串中匹配对应正则表达式，只返回第一个匹配的结果
- Nym.string.replaceBlank(String str)  
去除字符中的所有空白符
- Nym.string.getSuffix(String str)  
获取字符串中的后缀名，如果没有则返回null
- Nym.string.getFileName(String str)  
获取文件名
- Nym.string.isIP(String str)  
判断这个字符串是否是IP地址
- Nym.string.isFormat(String str,String regFormat)  
判断str是否与给定的正则表达式匹配
- Nym.string.getParam(String url,String name)  
返回url连接中名字为name的参数值，每个这个参数，或者发生异常，则返回null
- Nym.string.getParamMap(String pageUrl)  
返回pageUrl中携带的参数，存储到map中返回。如果不包含参数，或者遇到异常则返回空的Map对象
- Nym.string.makeUrlWithParams(String url,Map<String,String> params)  
传入链接和参数，拼接返回为带参数的url连接。


### 数据库操作说明
数据库支持Mysql，SqlServer，MongoDB几种数据库类型。
未来准备扩展到Oracele等其他数据库。

#### Mysql数据库操作说明
##### 生成MySql实例  

数据库连接参数的指定，有两种方式，用Mysql构造函数，或者用ConnInfo。
```java
// 用ConnInfo的构造器
// 参数依次是数据库类型，数据库地址，数据库名，数据库账号，数据库密码
ConnInfo connInfo1 = new ConnInfo(DBStyle.MYSQL,"localhost", "db_name", "db_user_name", "db_pass");
MySql mysql1 = new MySql(connInfo1);

// 也可以用ConnInfo的set方法逐个指定参数
ConnInfo connInfo2 = new ConnInfo();
connInfo.setStyle(DBStyle.MYSQL);
connInfo.setIp("127.0.0.1");
connInfo.setDbName("db_name");
connInfo.setUser("db_user_name");
connInfo.setPass("db_pass");
MySql mysql2 = new MySql(connInfo2);

// 直接用Mysql的构造方式生成Mysql实例
MySql mysql3 = new MySql("localhost","db_name","db_user","db_pass");
```
需要特别说明的是，其中数据库地址默认为3306端口，如果是其他端口，则需要指定。  
比如IP地址为127.0.0.1，端口为3309那么地址参数应该是127.0.0.1:3309

##### 查询数据库数据
用query(String sql, Object[] args, Class clazz)方法完成查询语句
* sql 这个参数是sql语句，用“?”作为占位符代替参数。
* args 参数列表，按sql中占位符的顺序填入参数。
* clazz 返回数据的clazz属性，返回对象的变量名要和数据库表的列名保持一致。
示例:
```java
List<Person> list = mysql.query(
    "select * from person where age > ?",
    new Object[]{18}, Person.class);
```

##### 进行增删改等操作
增删改的的操作主要是由executeSQL(String,Object[])方法来完成。  
示例：  
```java
mysql.executeSQL("UPDATE person SET name = ? WHERE id = ? ", new Object[] {"newName",1});
```
executeSQL(String,Object[])方法的第一个参数为sql语句，其中参数用占位符‘？’代替。
第二个对象数组为参数。按照顺序放入即可。
方法会返回影响数据库表的行数。

### 实时天气和预报天气
天气获取是用的彩云天气的开放API做的二次开发，封装了一些常用的功能。  
和地理位置解析工具一起配合使用，让调用更简洁

#### 生成Weather对象
```java
// 用自然语言描述的地址生成Weather对象
Weather weather =new Weather("上海市");

// 用经纬度生成Weather对象
LocationEntity location = null ;
Weather weather2 =  new Weather(location);

// 用IP地址生成Weather对象，会获取到当前IP所处位置的天气信息
// 不能使用本地IP和局域网IP。如果IP地址为不可用即不可定位IP，将抛出LocationException异常
Weather weather3 = new Weather("180.168.115.186");
```

#### 获取天气详情
```java
// 获取实时天气详情
RealtimeWeatherEntity r = weather.getRealtimeWeather();

// 获取预报天气详情
ForecastWeatherEntity f = weather.getForecastWeather();
```

## 未完善，以后升级或者正在开发的功能
### 未完善的功能
* 文件操作工具，目前还未测试完毕
* SqlServer工具，理论上能链接，但是没有需求所以不完善
* 天气模块目前只具备基础功能，其他有意思的功能已有但还未整理成型
* MongoDB工具，只具备基础的一下功能

### 以后升级开发的新功能
* 邮件收发客户端工具
* Office文件操作工具

## 版本更新历史

* v_0.9.8 2018年5月22日 10:31:51
  1. Mysql使用连接池管理链接
  2. Mysql更改为线程安全
  3. 增加Nym.clazz

* v_0.9.7 2017年7月25日 11:50:27
  1. 去掉了高精度IP定位，用普通IP定位替代
  2. net包方法和结构优化
  3. Weather(String) 增加对IP地址的支持
  4. 增加LocationException异常，并在相应功能上抛
  5. post请求优化，增加Not200Exception和返回请求响应实体
  6. 数据库工具优化完善，支持多线程