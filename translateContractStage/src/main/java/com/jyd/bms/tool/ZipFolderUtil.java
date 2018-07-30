package com.jyd.bms.tool;  
  
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
  
/** 
 * 压缩算法类 
 * 实现文件压缩，文件夹压缩，以及文件和文件夹的混合压缩  
 * 
 */  
public class ZipFolderUtil {  
  
    private static ZipOutputStream zipOutputStream;
    private static FileInputStream fileInputStream;
    
    /** 
     * 压缩文件夹 
     * @param srcfile 
     */  
    public static void folderTozip(File srcfile,File targetFile) {  
        try {  
             if (targetFile.exists())  {
            	 System.out.println(targetFile+"的压缩文件已存在");
            	 return;
             }
        	zipOutputStream = new ZipOutputStream(new FileOutputStream(targetFile));  
        	zipOutputStream.setEncoding("utf-8");
            if (srcfile.isFile()) {  
                zipFile(srcfile, zipOutputStream, "");  
            } else {  
                File[] list = srcfile.listFiles();  
                for (int i = 0; i < list.length; i++) {  
                    compress(list[i], zipOutputStream, "");  
                }  
            }  
            System.out.println("压缩完毕");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (zipOutputStream != null)  
                	zipOutputStream.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
   
  
    /** 
     * 压缩单个文件 
     * @param srcfile 
     * @param zipOutputStream 
     * @param basedir 
     */  
    public static void zipFile(File srcfile, ZipOutputStream zipOutputStream, String basedir) {  
        if (!srcfile.exists()) { 
            return;  
    	}
        try {  
        	int len;
        	byte[] buf = new byte[1024];  
            fileInputStream = new FileInputStream(srcfile);  
            zipOutputStream.setEncoding("utf-8");
            zipOutputStream.putNextEntry(new ZipEntry(basedir + srcfile.getName()));  
            while ((len = fileInputStream.read(buf)) > 0) {  
            	zipOutputStream.write(buf, 0, len);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (zipOutputStream != null)  
                	zipOutputStream.closeEntry();  
                if (fileInputStream != null)  
                	fileInputStream.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
    
    /** 
     * 压缩文件夹里的文件 
     * 起初不知道是文件还是文件夹--- 统一调用该方法 
     * @param file 
     * @param zipOutputStream 
     * @param basedir 
     */  
    private static void compress(File file, ZipOutputStream zipOutputStream, String basedir) {  
        /* 判断是目录还是文件 */  
    	zipOutputStream.setEncoding("utf-8");
        if (file.isDirectory()) {  
            zipDirectory(file, zipOutputStream, basedir);  
        } else {  
            zipFile(file, zipOutputStream, basedir);  
        }  
    }  
  
    /** 
     * 压缩文件夹 
     * @param dirFile 
     * @param zipOutputStream 
     * @param basedir 
     */  
    public static void zipDirectory(File dirFile, ZipOutputStream zipOutputStream, String basedir) {  
        if (!dirFile.exists()) { 
            return;  
        }
        File[] files = dirFile.listFiles();  
        for (int i = 0; i < files.length; i++) {  
            /* 递归 */  
        	zipOutputStream.setEncoding("utf-8");
            compress(files[i], zipOutputStream, basedir + dirFile.getName() + "/");  
        }  
    } 
}  