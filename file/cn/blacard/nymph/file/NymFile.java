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
	
	public List<File> getAllFiles(){
		getAllFile(this.file);
		return allFile;
	}

	private void getAllFile(File file){
		getAllFile(file.getAbsolutePath());
	}

	/**
	 * 根据后缀名获取文件
	 * @author Blacard
	 * @Create 2016年9月1日 下午4:01:28
	 * @param suffix
	 * @return
	 */
	public List<File> getFileBySuffix(String suffix){
		List<File> files = getAllFiles();
		List<File> resFiles = new ArrayList<File>();
		for(File f : files){
			if(f.isFile()&&StringTool.getSuffix(f.getName())!=null&&StringTool.getSuffix(f.getName()).equals(suffix))
				resFiles.add(f);
		}
		return resFiles;
	}
}
