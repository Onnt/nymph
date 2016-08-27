package cn.blacard.nymph.file.out;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * description 
 * author SunAo
 * create time 2016年8月4日 上午11:15:47
 * e-mail : blacard@163.com
 */
public class TextOut {

	private File file;
	public TextOut(String str){
		this.file = new File(str);
	}
	
	public TextOut(File file){
		this.file = file;
	}
	
	
	public void putln(String str){
		FileWriter fw = null;
		try {
			//
			fw = new FileWriter(file, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(str);
		pw.flush();
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void put(String str){
		FileWriter fw = null;
		try {
			
			fw = new FileWriter(file, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.print(str);
		pw.flush();
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
