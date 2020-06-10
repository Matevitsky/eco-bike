package com.matevitskyi.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private static final String UTF_8 = "UTF-8";

    @Override
    public List<String> readFromFile(String filePath) throws IOException {
        Charset charset = Charset.forName(UTF_8);
        return Files.readAllLines(Paths.get(filePath), charset);
    }

    @Override
    public void writeToFile(List<String> lines, String filePath) throws IOException {
        Files.write(Paths.get(filePath), lines, Charset.defaultCharset());
    }
}
