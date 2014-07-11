package uk.gov.dvla.core;

import java.util.Random;

public class RandomEnum<E extends Enum> {

    private static final Random random = new Random();
    private final E[] values;

    public RandomEnum(Class<E> token) {
        values = token.getEnumConstants();
    }

    public E random() {
        return values[random.nextInt(values.length)];
    }
}