package cn.virde.nymph.text;

import java.io.*;

/**
 * 读取文本内容
 * @author Blacard
 * 
 * 2016年8月25日 下午9:23:15
 * 2019年9月20日 18:19:06
  */
public class TextRead {

	private File textFile;

	private static final String encoding = "UTF-8";
	private InputStreamReader read;
	BufferedReader bufferedReader;

	public TextRead(String filePath) throws FileNotFoundException, UnsupportedEncodingException {
		textFile = new File(filePath);
		if(!(textFile.isFile() && textFile.exists())){
			throw  new FileNotFoundException();
		}
		read = new InputStreamReader(
				new FileInputStream(textFile),encoding);
		bufferedReader = new BufferedReader(read);
	}

	public TextRead(File textFile) throws FileNotFoundException, UnsupportedEncodingException {
		this.textFile = textFile;
		read = new InputStreamReader(
				new FileInputStream(textFile),encoding);
		bufferedReader = new BufferedReader(read);
	}

	public String nextLine() throws IOException {
		return bufferedReader.readLine();
	}

	public void close() throws IOException {
		read.close();
		bufferedReader.close();
	}

//	public static void main(String[] args) throws IOException {
//		TextRead read = new TextRead("D:\\temp\\email shuju\\2019-04\\info-2019-04-01-1.log");
//		System.out.println(read.nextLine());
//		String line = null;
//		while((line = read.nextLine()) != null){
//			System.out.println(line);
//		}
//	}

}
