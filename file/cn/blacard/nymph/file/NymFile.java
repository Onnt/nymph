package cn.blacard.nymph.file;

import java.io.File;
import java.util.List;


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

}
