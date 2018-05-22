package com.utils;

public enum FileFormatSupported {
    CSV("csv"),
    Excel("xlsx"),
    OTHERS("");

    private final String name;

    FileFormatSupported(String str) {
        name = str;
    }

    public String toString() {
        return this.name;
    }

    public boolean equalsName(String fileName) {
        return name.equals(fileName);
    }

}
