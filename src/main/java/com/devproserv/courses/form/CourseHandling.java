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

import com.devproserv.courses.config.Conf;
import com.devproserv.courses.model.Course;
import com.devproserv.courses.model.Student;
import javax.servlet.http.HttpServletRequest;

/**
 * Prepares request for further forwarding.
 *
 * @since 1.0.0
 */
abstract class CourseHandling {
    /**
     * Returns course ID parameter.
     * @return Course ID
     */
    public abstract String courseIdParameter();

    /**
     * Returns error message.
     * @return Error message
     */
    public abstract String errorMessageParameter();

    /**
     * Changes entry.
     *
     * @param course Course instance
     * @param user User instance
     */
    public abstract void changeEntry(Course course, Student user);

    /**
     * Returns a string containing the path.
     *
     * @param course Course instance
     * @param user User instance
     * @param request HTTP request
     * @return Path
     */
    public String path(
        final Course course, final Student user,
        final HttpServletRequest request
    ) {
        this.changeEntry(course, user);
        user.prepareJspData(request);
        return Conf.STUDENT_PAGE;
    }
}
