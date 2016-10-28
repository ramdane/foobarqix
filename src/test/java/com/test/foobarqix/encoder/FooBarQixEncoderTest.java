package com.test.foobarqix.encoder;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class FooBarQixEncoderTest {

    @Test(expected = NullPointerException.class)
    public void testEncodeNull() {
        FooBarQixEncoder encoder = new FooBarQixEncoder();
        encoder.encode(null);
    }

    @Test
    public void testEncode1() {
        FooBarQixEncoder encoder = new FooBarQixEncoder();
        String result = encoder.encode(1);
        assertThat("Encoding result mismatch", result, equalTo("1"));
    }

    @Test
    public void testEncode15() {
        FooBarQixEncoder encoder = new FooBarQixEncoder();
        String result = encoder.encode(15);

        assertThat("Encoding result mismatch", result, equalTo("FooBarBar"));
    }

    @Test
    public void testEncode21() {
        FooBarQixEncoder encoder = new FooBarQixEncoder();
        String result = encoder.encode(21);
        assertThat("Encoding result mismatch", result, equalTo("FooQix"));
    }

    @Test
    public void testEncode53() {
        FooBarQixEncoder encoder = new FooBarQixEncoder();
        String result = encoder.encode(53);
        assertThat("Encoding result mismatch", result, equalTo("BarFoo"));
    }

    @Test
    public void testEncode33() {
        FooBarQixEncoder encoder = new FooBarQixEncoder();
        String result = encoder.encode(33);
        assertThat("Encoding result mismatch", result, equalTo("FooFooFoo"));
    }

    @Test
    public void testEncode13() {
        FooBarQixEncoder encoder = new FooBarQixEncoder();
        String result = encoder.encode(13);
        assertThat("Encoding result mismatch", result, equalTo("Foo"));
    }


}