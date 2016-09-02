package cn.blacard.nymph.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.blacard.nymph.String.StringTool;

/**
 * description 
 * author SunAo
 * create time 2016年8月31日 下午5:23:57
 * e-mail : blacard@163.com
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
						getAllFile(file.getAbsolutePath());
						allFile.add(file);
					}
					else{
						allFile.add(file);
					}
				}
			}
		}
	}
	
	/**
	 * 根据后缀名获取文件
	 * @author Blacard
	 * @Create 2016年9月1日 下午4:01:28
	 * @param suffix
	 * @return
	 */
	protected List<File> getFileBySuffix(List<File> files,String suffix){
		List<File> resFiles = new ArrayList<File>();
		for(File f : files){
			if(f.isFile()&&StringTool.getSuffix(f.getName())!=null&&StringTool.getSuffix(f.getName()).equals(suffix))
				resFiles.add(f);
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
		return getFileBySuffix(lists,suffix);
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
