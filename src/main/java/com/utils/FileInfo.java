package com.utils;

public class FileInfo {

    private static String fileName;
    private static long fileSize;
    private static String fileExtension;
    private static String mimeType;

    public static void setFileName(String fileName) {
        FileInfo.fileName = fileName;
    }

    public static String getFileName() {
        return fileName;
    }

    public static void setMimeType(String mimeType) {
        FileInfo.mimeType = mimeType;
    }

    public static String getMimeType() {
        return mimeType;
    }


    public static void setSize(long fileSize) {
        FileInfo.fileSize = fileSize;
    }

    public static long getSize() {
        return fileSize;
    }


    public static void setFileExtension(String fileExtension) {
        FileInfo.fileExtension = fileExtension;
    }

    public static String getFileExtension() {
        return fileExtension;
    }
}
