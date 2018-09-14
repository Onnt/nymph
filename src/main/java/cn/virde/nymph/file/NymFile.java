package cn.virde.nymph.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Blacard
 
 * 2016年9月3日 下午11:00:30
 */
public class NymFile extends NymFileAssist{
	
	public NymFile(String path){
		this.file = new File(path);
	}
	public NymFile(File file){
		this.file = file;
	}
	
	/**
	 * 获取所有文件
	 * 包含 目录和文件
	 * @author Blacard
	 * 2016年9月2日 上午11:14:56
	 * @return 返回
	 */
	public List<File> getAllFiles(){
		getAllFile(this.file);
		return allFile;
	}
	/**
	 * 根据后缀名筛选文件
	 * 
	 * @author Blacard
	 * 2016年9月2日 上午11:15:08
	 * @param suffix 后缀名
	 * @return 返回
	 */
	public List<File> getFileBySuffix(String suffix){
		List<String> suffixs = new ArrayList<String>();
		suffixs.add(suffix);
		return getFileBySuffixs(getAllFiles(),suffixs);
	}
	public List<File> getFileBySuffixs(List<String> suffixs){
		return getFileBySuffixs(getAllFiles(),suffixs);
	}                                                                                                                                                                                                                             
	/**
	 * 根据后缀名筛选当前文件夹下文件
	 * @author Blacard
	 * 2016年9月2日 上午11:15:28
	 * @param suffix 后缀名
	 * @return 返回
	 */
	public List<File> getCurrDirFileBySuffix(String suffix){
		return getFileBySuffix(this.file.listFiles(),suffix);
	}
	public List<File> getCurrDirFileBySuffixs(List<String> suffixs){
		return getFileBySuffixs(this.file.listFiles(),suffixs);
	}
	/**
	 * 获取文件大小
	 * 如果是文件夹 则 统计文件夹下所有文件的大小
	 * @author Blacard
	 * 2016年9月7日 下午4:16:27
	 * @return 返回
	 */
	public long length(){
		if(file.isFile())
			return file.length();
		else{
			getAllFiles();
			long length = 0;
			for(File f : allFile){
				length = length + f.length();
			}
			return length;
		}
	}
}
