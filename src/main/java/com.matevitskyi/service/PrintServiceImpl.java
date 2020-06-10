package com.matevitskyi.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintServiceImpl implements PrintService {

    @Override
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public void printBikeCatalog(List bikeCatalog) {
        bikeCatalog.forEach(bike -> print(bike.toString()));
    }
}
