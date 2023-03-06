/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author liamflynn
 */
public class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    public void setUp() {
        calc = new Calculator();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAdd() {
        // call the add method
        Integer result = calc.add(3, 4);

        // test that the add method returned the correct result
        assertThat(result, is(7));

        assertThat(calc.add(1, 2), is(3));
        assertThat(calc.add(5, -4), is(1));
        assertThat(calc.add(-5, 4), is(-1));
        assertThat(calc.add(4, -8), is(-4));
        assertThat(calc.add(-1, -5), is(-6));
    }

    @Test
    public void testMultiply() {
        assertThat(calc.multiply(1, 2), is(2));
        assertThat(calc.multiply(5, -4), is(-20));
        assertThat(calc.multiply(-5, 4), is(-20));
        assertThat(calc.multiply(4, -8), is(-32));
        assertThat(calc.multiply(-1, -5), is(5));
    }

}
