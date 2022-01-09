package com.github.yukihane.example;

public class MyServiceImpl implements MyService {
    @Override
    public MyOutput execute() {
        return new MyOutput(1L, "alice", 16);
    }
}
