package com.github.yukihane.example;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MyParamMapper {

    MyParamMapper INSTANCE = Mappers.getMapper(MyParamMapper.class);

    MyParamDTO convert(MyParam output);

    MyParam convert(MyParamDTO output);
}
