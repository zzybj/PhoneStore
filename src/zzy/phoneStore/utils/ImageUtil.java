package zzy.phoneStore.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ImageUtil {

	public static FileInputStream readImage(String path) throws Exception{
		return new FileInputStream(new File(path));
	}
	
	public static void readBinImage(InputStream in,String path) throws Exception{
		File file = new File(path);
		String pp = (String) path.substring(0, path.lastIndexOf('/'));
		if(!file.exists()){
			new File(pp).mkdir();
		}
		FileOutputStream fos = null;
		fos = new FileOutputStream(file); 
		int len=0;
		byte[] buf = new byte[1024];
		while((len=in.read(buf))!=-1 ){
			fos.write(buf,0,len);
		}
		fos.flush();
		fos.close();
	}
	
}
