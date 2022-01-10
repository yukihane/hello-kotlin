package com.github.yukihane.example;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyController {

    private final MyService service;
    private final MyInputMapper inputMapper;
    private final MyOutputMapper outputMapper;

    public MyOutputDTO index(MyInputDTO input) {
        MyInput param = inputMapper.convert(input);
        MyOutput output = service.execute(param);
        MyOutputDTO result = outputMapper.convert(output);
        return result;
    }
}
