package org.example;

import java.util.HashMap;
import java.util.Map;

public class UsingMaps {
    public static void main(String... args) {
        Map<String, String> map = new HashMap<>();
        map.put("2222", "ghi");
        map.put("3333", "abc");
        map.put("1111", "def");

        String s1 = map.get("3333");
        String s2 = map.get("9999");
        String s3 = map.getOrDefault("9999", "xyz");
        System.out.println("args = " + s1);
        System.out.println("args = " + s2);
        System.out.println("args = " + s3);

        map.forEach(
                (x, v) -> System.out.println(x + " | " + v)
        );

        map.replaceAll(
                (x, v) -> v.toUpperCase()
        );

        map.forEach(
                (x, v) -> System.out.println(x + " | " + v)
        );

    }
}
