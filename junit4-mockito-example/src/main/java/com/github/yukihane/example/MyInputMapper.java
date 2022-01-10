package com.github.yukihane.example;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MyInputMapper {

    MyInputMapper INSTANCE = Mappers.getMapper(MyInputMapper.class);

    MyInput convert(MyInputDTO output);
}
