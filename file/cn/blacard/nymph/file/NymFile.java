package cn.blacard.nymph.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.blacard.nymph.String.StringTool;


public class NymFile extends NymFileAssist{
	
	public NymFile(String path){
		this.file = new File(path);
	}
	public NymFile(File file){
		this.file = file;
	}
	
	/**
	 * 获取所有文件
	 * @author Blacard
	 * @create 2016年9月2日 上午11:14:56
	 * @return
	 */
	public List<File> getAllFiles(){
		getAllFile(this.file);
		return allFile;
	}
	/**
	 * 根据后缀名筛选文件
	 * @author Blacard
	 * @create 2016年9月2日 上午11:15:08
	 * @param suffix
	 * @return
	 */
	public List<File> getFileBySuffix(String suffix){
		return getFileBySuffix(getAllFiles(),suffix);
	}
	/**
	 * 根据后缀名筛选当前文件夹下文件
	 * @author Blacard
	 * @create 2016年9月2日 上午11:15:28
	 * @param suffix
	 * @return
	 */
	public List<File> getCurrDirFileBySuffix(String suffix){
		return getFileBySuffix(this.file.listFiles(),suffix);
	}
}
