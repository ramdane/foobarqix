package com.test.foobarqix;

import com.test.foobarqix.encoder.FooBarQixEncoder;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        System.out.println("Print encoded values of [1-100]: ");

        FooBarQixEncoder foobarqix = new FooBarQixEncoder();

        IntStream.range(1, 100)
                .mapToObj(foobarqix::encode)
                .forEach(System.out::println);

    }
}
