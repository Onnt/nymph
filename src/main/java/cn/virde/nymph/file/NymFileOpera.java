package cn.virde.nymph.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class NymFileOpera extends NymFileAssist{
  
	public void newFolder(String folderPath) {
	    File myFilePath = new File(folderPath); 
	    if (!myFilePath.exists()) { 
	      myFilePath.mkdir(); 
	    }
	}

   public void newFile(String filePathAndName) throws IOException {
	   File myFilePath = new File(filePathAndName);
	   if(!myFilePath.exists()){
		   myFilePath.createNewFile();
	   } 
   }

   @SuppressWarnings("unused")
   public void copy(File oldFile,File newFile) throws IOException { 
       if (oldFile.exists()) {
    	   InputStream inStream = new FileInputStream(oldFile); 
           FileOutputStream fs = new FileOutputStream(newFile); 
           byte[] buffer = new byte[512]; 
    	   int bytesum = 0; 
           int byteread = 0; 
           while ( (byteread = inStream.read(buffer)) != -1) { 
        	   bytesum += byteread; //字节数 文件大小 
               fs.write(buffer, 0, byteread); 
           } 
           inStream.close(); 
           fs.close();
       } 

   }

   public void move(File oldFile,File newFile) throws IOException { 
       copy(oldFile,newFile); 
       oldFile.delete();
   }
   
   private void copyFolder(String oldPath, String newPath) {

       try { 
           (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹 
           File a=new File(oldPath); 
           String[] file=a.list(); 
           File temp=null; 
           for (int i = 0; i < file.length; i++) { 
               if(oldPath.endsWith(File.separator)){ 
                   temp=new File(oldPath+file[i]); 
               } 
               else{ 
                   temp=new File(oldPath+File.separator+file[i]); 
               }

               if(temp.isFile()){ 
                   FileInputStream input = new FileInputStream(temp); 
                   FileOutputStream output = new FileOutputStream(newPath + "/" + 
                           (temp.getName()).toString()); 
                   byte[] b = new byte[1024 * 5]; 
                   int len; 
                   while ( (len = input.read(b)) != -1) { 
                       output.write(b, 0, len); 
                   } 
                   output.flush(); 
                   output.close(); 
                   input.close(); 
               } 
               if(temp.isDirectory()){//如果是子文件夹 
                   copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]); 
               } 
           } 
       } 
       catch (Exception e) { 
           System.out.println("复制整个文件夹内容操作出错"); 
           e.printStackTrace();

       }

   }

   /**
    * 这个方法没有验证，暂不开放使用
    * @param path 路径
    */
   @SuppressWarnings("unused")
   private void delAllFile(String path) { 
       File file = new File(path); 
       if (!file.exists()) { 
           return; 
       } 
       if (!file.isDirectory()) { 
           return; 
       } 
       String[] tempList = file.list(); 
       File temp = null; 
       for (int i = 0; i < tempList.length; i++) { 
           if (path.endsWith(File.separator)) { 
               temp = new File(path + tempList[i]); 
           } 
           else { 
               temp = new File(path + File.separator + tempList[i]); 
           } 
           if (temp.isFile()) { 
               temp.delete(); 
           } 
           if (temp.isDirectory()) { 
               delAllFile(path+"/"+ tempList[i]);//先删除文件夹里面的文件 
               delFolder(path+"/"+ tempList[i]);//再删除空文件夹 
           } 
       } 
   }

   @SuppressWarnings("unused")
   private void moveFolder(String oldPath, String newPath) { 
       copyFolder(oldPath, newPath); 
       delFolder(oldPath);

   } 
   
	@SuppressWarnings("unused")
	private void rename(File file,String newName){
		
	}

	private void delFolder(String folderPath) {
		   
	}

	public String[] getAudioSuffix(){
		String[] audios = {"mp3","wma","flac","ape","aiff","amr","aac","m4a"};
		return audios ;
	}

	public String[] getVideoSuffix(){
		String[] videos = {"rmvb","rm","mkv","avi","mp4","ts","wmv","3gp","flv","mpg","mpe","mpeg","asf","mov","m4v"};
		return videos ;
	}
	public String[] getImageSuffix(){
		String[] images = {"bmp","pcx","tiff","gif","jpeg","jpg","tga","exif","fpx","svg","psd","cdr","pcd","dxf","ufo","eps","ai","png","hdri","raw","emf"};
		return images ;
	}
}
