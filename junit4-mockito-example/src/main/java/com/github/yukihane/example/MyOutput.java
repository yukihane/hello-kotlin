package com.github.yukihane.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyOutput {
    private long id;
    private String name;
    private int age;
}
