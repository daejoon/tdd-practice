import com.ddoong2.StringCalculator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {

    @Test
    public void NULL_이거나_빈문자열이면_0을_반환한다() {
        assertThat(new StringCalculator(null).result(), is(0));
        assertThat(new StringCalculator("").result(), is(0));
    }

    @Test
    public void 문자열_숫자를_하나_넣으면_그_숫자를_반환한다() {
        assertThat(new StringCalculator("1").result(), is(1));
        assertThat(new StringCalculator("2").result(), is(2));
    }

    @Test
    public void 구분자로_구분된_문자열을_분리한후_합을_반환한다() {
        assertThat(new StringCalculator("1,2").result(), is(3));
        assertThat(new StringCalculator("1:2").result(), is(3));
        assertThat(new StringCalculator("1,2:3").result(), is(6));
        assertThat(new StringCalculator("1:2,3").result(), is(6));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void 지원하지_않는_구분자가_들어가면_UnsupportedOperationException이_발생한다() {
        assertThat(new StringCalculator("1;2").result(), is(3));
    }
}
