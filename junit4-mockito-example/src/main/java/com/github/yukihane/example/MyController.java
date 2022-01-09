package com.github.yukihane.example;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyController {

    private final MyService myService;
    private final MyOutputMapper mapper;

    public MyOutputDTO index() {
        MyOutput output = myService.execute();
        MyOutputDTO result = mapper.convert(output);
        return result;
    }
}
