package com.example;

import java.time.Duration;

public class Use {
    public static void main(String[] args) {
        // Kotlin Duration を戻り値にもつ関数はコンパイルエラー
        // long duration = App.create();

        Duration data = App.createJava();
        System.out.println("Duration: " + data.toMillis() + " ms");
    }
}
