package com.github.yukihane.example;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MyOutputMapper {

    MyOutputMapper INSTANCE = Mappers.getMapper(MyOutputMapper.class);

    MyOutputDTO convert(MyOutput output);
}
