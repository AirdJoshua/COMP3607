package com.groupassignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry;

public class FilesIterator implements IFileIterator {
    private int index;
    private ArrayList<File> files = getFilesFromFolder();

    @Override
    public Boolean hasNext() {
        if (index < files.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public File next() {
        return files.get(index++);
    }

    private ArrayList<File> getFilesFromFolder() {
        File folder = new File("filesToRename");
        ArrayList<File> pdfFiles = new ArrayList<File>();

        File[] files = folder.listFiles();
        System.out.println(files);
        
        for (File file : files) {
            if (file.getName().contains(".zip")) {
                unzipFile(file);
            }

        }

        files = folder.listFiles();
        for (File file : files) {
            if (file.getName().contains(".pdf")) {
                pdfFiles.add(file);
            }
        }
        return pdfFiles;
    }

    private void unzipFile(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String fileName = ze.getName();
                File newFile = new File("filesToRename/" + fileName);
                newFile.createNewFile();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                byte[] buffer = new byte[1024];
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
