package com.github.yukihane.example;

public class MyServiceImpl implements MyService {
    @Override
    public MyOutput execute(MyInput param) {
        return new MyOutput(1L, param.getName(), param.getAge() + 1);
    }
}
