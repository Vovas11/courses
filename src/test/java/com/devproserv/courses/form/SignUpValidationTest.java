/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Vladimir
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.devproserv.courses.form;

import org.junit.Assert;
import org.junit.Test;

/**
 * Contains unit-tests to check functionality of {@link SignUpValidation} class.
 *
 * @since 1.0.0
 */
public final class SignUpValidationTest {
    /**
     * Test.
     */
    @Test
    public void testValidatedOk() {
        final Validation validation = new SignUpValidation(
            "user", "password", "firstName", "lastName", "faculty"
        );
        final boolean result = validation.validated();
        Assert.assertTrue("Should be true", result);
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedOkLoginEndsDigit() {
        final Validation validation = new SignUpValidation(
            "user4", "pass", "firstName", "lastName", "faculty"
        );
        final boolean result = validation.validated();
        Assert.assertTrue(result);
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedNull() {
        final Validation validation = new SignUpValidation(
            null, null, "firstName", "lastName", "faculty"
        );
        final boolean result = validation.validated();
        final String message = validation.errorMessage();
        Assert.assertFalse(result);
        Assert.assertEquals(
            "Username and password should not be empty!", message
        );
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedEmpty() {
        final Validation validation = new SignUpValidation(
            "", "pass", "firstName", "lastName", "faculty"
        );
        final boolean result = validation.validated();
        final String message = validation.errorMessage();
        Assert.assertFalse(result);
        Assert.assertEquals(
            "Username and password should not be empty!", message
        );
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedLoginBeginsDigit() {
        final Validation validation = new SignUpValidation(
            "25user", "pass", "firstName", "lastName", "faculty"
        );
        final boolean result = validation.validated();
        final String message = validation.errorMessage();
        Assert.assertFalse(result);
        Assert.assertEquals(
            "Username should not start with a digit or non letter!", message
        );
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedLoginBeginsNotLetter() {
        final Validation validation = new SignUpValidation(
            "#user", "pass", "firstName", "lastName", "faculty"
        );
        final boolean result = validation.validated();
        final String message = validation.errorMessage();
        Assert.assertFalse(result);
        Assert.assertEquals(
            "Username should not start with a digit or non letter!", message
        );
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedLoginContainsSpaceOne() {
        final Validation validation = new SignUpValidation(
            " user", "pass", "firstName", "lastName", "faculty"
        );
        final boolean result = validation.validated();
        final String message = validation.errorMessage();
        Assert.assertFalse(result);
        Assert.assertEquals(
            "Username should not start with a digit or non letter!", message
        );
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedLoginContainsSpaceTwo() {
        final Validation validation = new SignUpValidation(
            "user name", "pass", "firstName", "lastName", "faculty"
        );
        final boolean result = validation.validated();
        final String message = validation.errorMessage();
        Assert.assertFalse(result);
        Assert.assertEquals(
            "Username should contain only letters and digits!", message
        );
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedLoginStartsWithUnderscore() {
        final Validation validation = new SignUpValidation(
            "_user", "pass", "firstName", "lastName", "faculty"
        );
        final boolean result = validation.validated();
        final String message = validation.errorMessage();
        Assert.assertFalse(result);
        Assert.assertEquals(
            "Username should not start with a digit or non letter!", message
        );
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedFirstNameNull() {
        final Validation validation = new SignUpValidation(
            "user", "pass", null, "lastName", "faculty"
        );
        final boolean result = validation.validated();
        final String message = validation.errorMessage();
        Assert.assertFalse(result);
        Assert.assertEquals("First name should not be empty!", message);
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedFirstNameEmpty() {
        final Validation validation = new SignUpValidation(
            "user", "pass", "", "lastName", "faculty"
        );
        final boolean result = validation.validated();
        final String message = validation.errorMessage();
        Assert.assertFalse(result);
        Assert.assertEquals("First name should not be empty!", message);
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedLastNameNull() {
        final Validation validation = new SignUpValidation(
            "user", "pass", "firstName", null, "faculty"
        );
        final boolean result = validation.validated();
        final String message = validation.errorMessage();
        Assert.assertFalse(result);
        Assert.assertEquals("Last name should not be empty!", message);
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedLastNameEmpty() {
        final Validation validation = new SignUpValidation(
            "user", "pass", "firstName", "", "faculty"
        );
        final boolean result = validation.validated();
        final String message = validation.errorMessage();
        Assert.assertFalse(result);
        Assert.assertEquals("Last name should not be empty!", message);
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedFacultyNull() {
        final Validation validation = new SignUpValidation(
            "user", "pass", "firstName", "lastName", null
        );
        final boolean result = validation.validated();
        final String message = validation.errorMessage();
        Assert.assertFalse(result);
        Assert.assertEquals("Faculty should not be empty!", message);
    }

    /**
     * Test.
     */
    @Test
    public void testValidatedFacultyEmpty() {
        final Validation validation = new SignUpValidation(
            "user", "pass", "firstName", "lastName", ""
        );
        final boolean result = validation.validated();
        final String message = validation.errorMessage();
        Assert.assertFalse(result);
        Assert.assertEquals("Faculty should not be empty!", message);
    }
}
