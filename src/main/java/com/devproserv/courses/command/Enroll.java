/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Vladimir
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

import com.devproserv.courses.form.EnrollCourseHandling;
import com.devproserv.courses.form.EnrollForm;
import com.devproserv.courses.model.Db;
import com.devproserv.courses.model.Response;
import javax.servlet.http.HttpServletRequest;

/**
 * Handles course number user inputs to subscribe to desired courses.
 *
 * @since 0.5.0
 */
public final class Enroll implements Command {
    /**
     * Enroll form instance.
     */
    private final EnrollForm form;

    /**
     * Default constructor.
     */
    Enroll() {
        this(new EnrollForm(new EnrollCourseHandling(new Db())));
    }

    /**
     * Primary constructor.
     *
     * @param form Enroll form
     */
    Enroll(final EnrollForm form) {
        this.form = form;
    }

    @Override
    public Response response(final HttpServletRequest request) {
        return this.form.validate(request);
    }
}
