package cn.virde.nymph.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.virde.nymph.Nym;

/**
 * 文件操作的辅助类 的 辅助类
 * 一些小的操作 都放在这个地方
 * @author Blacard
 * @联系方式  邮箱：blacard@163.com <br/> 手机：18037170703
 * @Create 2016年8月31日 下午5:23:57
 */
public class NymFileAssist {
	protected File file = null;
	protected List<File> allFile = new ArrayList<File>();
	
	/**
	 * 递归 获取文件夹下所有文件
	 * @author Blacard
	 * @create 2016年9月2日 上午11:13:27
	 * @param path
	 */
	protected void getAllFile(String path){
		File thisFile = new File(path);
		if(thisFile.exists()){
			File[] files = thisFile.listFiles();
			if(files != null && files.length != 0 ){
				for(File file : files){
					if(file.isDirectory()){
						//递归，如果是目录继续调用本方法
						getAllFile(file.getAbsolutePath());
						allFile.add(file);
					}
					else{
						//是文件，加入文件列表
						allFile.add(file);
					}
				}
			}
		}
	}
	
	/**
	 * 筛选匹配多个后缀名
	 * @author Blacard
	 * @create 2016年9月3日 下午11:06:34
 	 * @param files 待筛选的文件列表
	 * @param suffixs 要匹配的多个后缀名
	 * @return 在文件列表里匹配到后缀名的对应文件
	 */
	public List<File> getFileBySuffixs(List<File> files,List<String> suffixs){
		List<File> resFiles = new ArrayList<File>();
		for(File f : files){
			//如果f是文件，and f的后缀名不为空
			if(f.isFile()&&Nym.string.getSuffix(f.getName())!=null){
				//获取到f的后缀名
				String suf = Nym.string.getSuffix(f.getName());
				//当前文件和 循环和所有后缀名 进行对比
				for(String suffix : suffixs){
					if(suf.equals(suffix))
						resFiles.add(f);
				}
			}
		}
		return resFiles;
	}
	/**
	 * 根据后缀名 筛选文件
	 * @author Blacard
	 * @create 2016年9月2日 上午11:14:02 
	 * @param list
	 * @param suffix
	 * @return
	 */
	protected List<File> getFileBySuffix(File[] list,String suffix){
		List<File> lists = new ArrayList<File>();
		for(File file : list)
			lists.add(file);
		List<String> suffixs = new ArrayList<String>();
		suffixs.add(suffix);
		return getFileBySuffixs(lists,suffixs);
	}
	
	/**
	 * 根据多个后缀名筛选文件
	 * 
	 * 将 数组类型的 文件列表 转成 List类型的
	 * @author Blacard
	 * @create 2016年9月4日 上午8:11:24
	 * @param list
	 * @param suffixs
	 * @return
	 */
	protected List<File> getFileBySuffixs(File[] list,List<String> suffixs){
		List<File> lists = new ArrayList<File>();
		for(File file : list){
			lists.add(file);
		}
		return getFileBySuffixs(lists,suffixs);
	}
	/**
	 * 获取所有文件
	 * @author Blacard
	 * @create 2016年9月2日 上午11:14:28
	 * @param file
	 */
	protected void getAllFile(File file){
		getAllFile(file.getAbsolutePath());
	}
}
