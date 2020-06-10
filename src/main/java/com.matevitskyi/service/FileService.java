package com.matevitskyi.service;

import java.io.IOException;
import java.util.List;

public interface FileService {
    List<String> readFromFile(String filePath) throws IOException;

    void writeToFile(List<String> lines, String filePath) throws IOException;
}
