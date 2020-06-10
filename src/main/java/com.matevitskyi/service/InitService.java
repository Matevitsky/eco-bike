package com.matevitskyi.service;

import java.io.IOException;

public interface InitService {
    void initDB(String filePath) throws IOException;
}
