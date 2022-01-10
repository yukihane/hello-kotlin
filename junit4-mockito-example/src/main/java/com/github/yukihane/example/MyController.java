package com.github.yukihane.example;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyController {

    private final MyService service;
    private final MyParamMapper paramMapper;

    public MyParamDTO index(final MyParamDTO input) {
        final MyParam param = paramMapper.convert(input);
        final MyParam output = service.execute(param);
        return paramMapper.convert(output);
    }
}
