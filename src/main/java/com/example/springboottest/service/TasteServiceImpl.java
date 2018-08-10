package com.example.springboottest.service;

import com.example.springboottest.model.Taste;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


@Service("tasteService")
public class TasteServiceImpl implements TasteService {

    private static final AtomicLong counter = new AtomicLong();

    private static Map<Integer, Taste> taste;

    static {
        taste = populateDummyTaste();
    }

    private static Map<Integer, Taste> populateDummyTaste() {
        Map<Integer, Taste> taste = new HashMap<>();
        taste.put(-1, new Taste(12340, 15151, 222, 44, 3));
        return taste;
    }

    @Override
    public Taste findById(int id) {
        if (taste.containsKey(id)) {
            return taste.get(id);
        }
        return null;
    }
}
