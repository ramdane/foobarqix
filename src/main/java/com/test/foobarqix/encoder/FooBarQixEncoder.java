package com.test.foobarqix.encoder;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * FooBarQixEncoder
 */
public class FooBarQixEncoder {

    private static final String EMPTY = "";

    /**
     * Substitutions indexed by digit[0-9]
     */
    private static final String[] SUBSTITUTIONS = {EMPTY, EMPTY, EMPTY, "Foo", EMPTY, "Bar", EMPTY, "Qix", EMPTY, EMPTY, EMPTY};

    public String encode(Integer number) {
        Objects.requireNonNull(number, "Number cannot be null");

        final StringBuilder result = new StringBuilder();
        result.append(divisionEncoding(number));
        result.append(contentEncoding(number));

        if (result.length() == 0) {
            //No matching found. return number as string
            return number.toString();
        }

        return result.toString();
    }

    /**
     * Performs encoding based on content
     *
     * @param number number to encode
     * @return encoded result
     */
    private String contentEncoding(Integer number) {
        return getDigits(number)
                .map(this::getSubstitution)
                .collect(Collectors.joining());
    }

    /**
     * Performs encoding based on division
     *
     * @param number number to encode
     * @return encoded result
     */
    private String divisionEncoding(Integer number) {
        return IntStream.range(1, 10)
                .filter(digit -> number % digit == 0)
                .mapToObj(this::getSubstitution)
                .collect(Collectors.joining());
    }

    private String getSubstitution(Integer digit) {
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException(String.format("Invalid digit %d", digit));
        }
        return SUBSTITUTIONS[digit];
    }

    /**
     * Split a number into a stream of digits
     *
     * @param number number to split
     * @return a stream of the number's digits
     */
    private Stream<Integer> getDigits(Integer number) {
        Objects.requireNonNull(number, "Number cannot be null");
        return number.toString().chars()
                .mapToObj(ch -> (char) ch)
                .map(String::valueOf)//String representation
                .map(Integer::valueOf);
    }


}
