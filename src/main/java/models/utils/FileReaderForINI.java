package models.utils;

import java.io.*;
import java.util.*;

public final class FileReaderForINI {

    private FileReaderForINI() {
    }

    public static Optional<Map<String, String>> readIniAsMap(String targetFile) {
        Properties properties = read(targetFile);
        if (properties == null) return Optional.empty();
        Map<String, String> map = new TreeMap<>();
        for (String s : properties.stringPropertyNames()) {
            map.put(s, properties.getProperty(s));
        }
        return Optional.of(map);
    }

    public static Optional<List<String>> readIniAsList(String targetFile) {
        Properties properties = read(targetFile);
        if (properties == null) return Optional.empty();
        List<String> list = new ArrayList<>();
        list.addAll(properties.stringPropertyNames());
        return Optional.of(list);
    }

    private static Properties read(String targetFile) {
        Properties properties = new Properties();
        try (InputStream in = new FileInputStream(targetFile)) {
            properties.load(in);
        } catch (IOException e) {
            return null;
        }
        return properties;
    }
}
