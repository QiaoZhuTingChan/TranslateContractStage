/*package com.jyd.bms.tool;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipUtils {
	private static final Logger log;
    private static final String SEPARATOR = "/";
    
    static {
        log = LoggerFactory.getLogger((Class)ZipUtils.class);
    }
    
    public static List<File> unzipFile(final String zipFilePath, final String extracFolderPath) throws IOException {
        return unzipFile(new File(zipFilePath), extracFolderPath);
    }
    
    public static List<File> unzipFile(final File zipfile, final String extracFolderPath) throws IOException {
        return unZip(zipfile, extracFolderPath);
    }
    
    private static List<File> unZip(final File zipFile, final String outputDirectory) throws IOException {
        final ZipFile file = new ZipFile(zipFile);
        final Enumeration<ZipEntry> e = (Enumeration<ZipEntry>)file.getEntries();
        createDirectory(outputDirectory, "");
        final List<File> files = new ArrayList<File>();
        while (e.hasMoreElements()) {
            final ZipEntry zipEntry = e.nextElement();
            String name = zipEntry.getName();
            ZipUtils.log.info("unziping: {}", (Object)name);
            if (zipEntry.isDirectory()) {
                name = name.substring(0, name.length() - 1);
                FileUtils.makeFolderExists(String.valueOf(outputDirectory) + "/" + name);
            }
            else {
                name = name.replace("\\", "/");
                if (name.indexOf("/") != -1) {
                    createDirectory(outputDirectory, name.substring(0, name.lastIndexOf("/")));
                }
                ZipUtils.log.info("outputDirectory: {},unziping: {}", (Object)outputDirectory, (Object)name);
                final InputStream in = file.getInputStream(zipEntry);
                files.add(FileUtils.createFile(in, outputDirectory, name));
                in.close();
            }
        }
        file.close();
        return files;
    }
    
    public static File makeZip(final String srcFilePath, final String targetZipPath) throws IOException, FileNotFoundException {
        final File srcFile = new File(srcFilePath);
        final File targetZip = new File(targetZipPath);
        return makeZip(srcFile, targetZip);
    }
    
    public static File makeZip(final File srcFile, final File targetZip) throws IOException, FileNotFoundException {
        final ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(targetZip));
        zos.setEncoding("UTF-8");
        
        recurseFiles(srcFile, zos, "");
        zos.close();
        return targetZip;
    }
    
    public static File makeZip(final List<String> srcFilePaths, final File targetZip) throws IOException, FileNotFoundException {
        final File[] srcFiles = new File[srcFilePaths.size()];
        int i = 0;
        for (final String srcFilePath : srcFilePaths) {
            srcFiles[i++] = new File(srcFilePath);
        }
        return makeZip(srcFiles, targetZip);
    }
    
    public static File makeZip(final File[] srcFiles, final File targetZip) throws IOException, FileNotFoundException {
        final ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(targetZip));
        zos.setEncoding("UTF-8");
        for (final File srcFile : srcFiles) {
            recurseFiles(srcFile, zos, "");
        }
        zos.close();
        return targetZip;
    }
    
    private static void recurseFiles(final File file, final ZipOutputStream zos, String dir) throws IOException, FileNotFoundException {
        if (file.isDirectory()) {
            dir = String.valueOf(dir) + file.getName() + "/";
            final String[] fileNames = file.list();
            if (fileNames != null) {
                for (int i = 0; i < fileNames.length; ++i) {
                    recurseFiles(new File(file, fileNames[i]), zos, dir);
                }
            }
        }
        else {
            dir = dir.substring(dir.indexOf("/") + 1);
            final ZipEntry zipEntry = new ZipEntry(String.valueOf(dir) + file.getName());
            zipEntry.setUnixMode(644);
            
            final BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            zos.putNextEntry(zipEntry);
            final byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) >= 0) {
                zos.write(buf, 0, len);
            }
            in.close();
            zos.closeEntry();
        }
    }
    
    private static void createDirectory(String directory, final String subDirectory) {
        if (StringUtils.isBlank(subDirectory)) {
            FileUtils.makeFolderExists(directory);
        }
        else {
            final String[] filderNames = subDirectory.replace("\\", "/").split("/");
            String[] array;
            for (int length = (array = filderNames).length, i = 0; i < length; ++i) {
                String folderName = array[i];
                folderName = "/" + folderName;
                FileUtils.makeFolderExists(String.valueOf(directory) + folderName);
                directory = String.valueOf(directory) + folderName;
            }
        }
    }
    
    public static byte[] compressByteArray(final byte[] nonCompressorData) throws Exception {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final DeflaterOutputStream dout = new DeflaterOutputStream(bos);
        dout.write(nonCompressorData);
        dout.close();
        return bos.toByteArray();
    }
    
    public static byte[] decompressByteArray(final byte[] compressorData) throws Exception {
        return IOUtils.toByteArray((InputStream)new InflaterInputStream(new ByteArrayInputStream(compressorData)));
    }
}
*/