package com.github.yukihane.example;

public class MyServiceImpl implements MyService {
    @Override
    public MyParam execute(MyParam param) {
        return new MyParam(1L, param.getName(), param.getAge() + 1);
    }
}
