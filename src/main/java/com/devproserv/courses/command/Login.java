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
package com.devproserv.courses.command;

import com.devproserv.courses.form.LoginForm;
import com.devproserv.courses.servlet.AppContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Treats data from login web form.
 *
 * @since 1.0.0
 */
public final class Login implements Command {
    /**
     * Login form.
     */
    private LoginForm form;

    /**
     * Default constructor.
     *
     * @param context Application context
     */
    public Login(final AppContext context) {
        this(new LoginForm(context));
    }

    /**
     * Primary constructor.
     *
     * @param form Login form instance
     */
    public Login(final LoginForm form) {
        this.form = form;
    }

    @Override
    public String path(final HttpServletRequest request) {
        return this.form.validate(request);
    }
}