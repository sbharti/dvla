package com.utils;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.util.ArrayList;

public class DirectoryUtility {

    private ArrayList<FileInfo> filesInfo = new ArrayList<>();



    public void extractFileInfo(String path, FileFormatSupported fileFormat) {
        File directory = new File(path);

        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile() && isSupportedFileType(file, fileFormat)) {
                populateFilesInfo(file);
            } else if (file.isDirectory()) {
                extractFileInfo(file.getAbsolutePath(), fileFormat);
            }
        }
    }

    private boolean isSupportedFileType(File file, FileFormatSupported fileFormat) {
        return file.getName().endsWith(fileFormat.toString());
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }

    private void populateFilesInfo(File file) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(file.getName());
        fileInfo.setSize(file.length());
        fileInfo.setMimeType(new MimetypesFileTypeMap().getContentType(file));
        fileInfo.setFileExtension(getFileExtension(file));
        filesInfo.add(fileInfo);
    }

    public ArrayList<FileInfo> getFilesInfo() {
        return filesInfo;
    }
}
