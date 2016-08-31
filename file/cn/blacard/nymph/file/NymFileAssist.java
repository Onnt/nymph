package cn.blacard.nymph.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * description 
 * author SunAo
 * create time 2016年8月31日 下午5:23:57
 * e-mail : blacard@163.com
 */
public class NymFileAssist {
	protected File file = null;
	protected List<File> allFile = new ArrayList<File>();
	
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
}
