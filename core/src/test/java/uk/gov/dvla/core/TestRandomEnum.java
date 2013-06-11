package uk.gov.dvla.core;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertTrue;

enum TestEnum {
    A(0, "ValueA"),
    B(1, "ValueB"),
    C(2, "ValueC");

    private final int value;
    private final String valueName;

    private TestEnum(int value, String valueName) {
        this.value = value;
        this.valueName = valueName;
    }
}

public class TestRandomEnum {

    @Test
    public void test_random_enum() {
        RandomEnum<TestEnum> testEnum = new RandomEnum<TestEnum>(TestEnum.class);

        assertTrue(Arrays.asList(TestEnum.values()).contains(testEnum.random()));
        assertTrue(Arrays.asList(TestEnum.values()).contains(testEnum.random()));
        assertTrue(Arrays.asList(TestEnum.values()).contains(testEnum.random()));
        assertTrue(Arrays.asList(TestEnum.values()).contains(testEnum.random()));
    }
}
