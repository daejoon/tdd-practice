package com.ddoong2.name_inverter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * NameInverterTest
 *
 * Created by kdj on 2018. 8. 6.
 */
public class NameInverterTest {

    private NameInverter nameInverter = new NameInverter();

    @Test
    public void 이름과_성을_뒤집는다() {
        assertThat(invert(null), is(""));
        assertThat(invert(""), is(""));
        assertThat(invert("name"), is("name"));
        assertThat(invert("first last"), is("last, first"));
        assertThat(invert("    name     "), is("name"));
        assertThat(invert("first     last"), is("last, first"));
        assertThat(invert("Mr. first last"), is("last, first"));
        assertThat(invert("first last BS. Phd."), is("last, first BS. Phd."));
        assertThat(invert("   Robert Martin II esq."), is("Martin, Robert II esq."));
    }

    private String invert(String name) {
        return nameInverter.invert(name);
    }
}
