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

import com.devproserv.courses.model.UserRoles;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a login form on web page.
 *
 * @since 1.0.0
 */
public final class LoginForm implements Form {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(
        LoginForm.class
    );

    @Override
    public String validate(final HttpServletRequest request) {
        final String login          = request.getParameter("login");
        final String password       = request.getParameter("password");
        final Validation validation = new LoginValidation(login, password);
        final String path;
        if (validation.validated()) {
            LOGGER.debug("Login '{}' and password are valid.", login);
            path = validPath(request, login, password);
        } else {
            path = invalidPath(validation, request, login);
        }
        return path;
    }

    /**
     * Handles invalid path.
     * @param validation Validation
     * @param request HTTP Request
     * @param login Login
     * @return Path
     */
    private static String invalidPath(
        final Validation validation,
        final HttpServletRequest request, final String login
    ) {
        LOGGER.info("Invalid credentials for login {}", login);
        request.setAttribute("message", validation.errorMessage());
        return EnrollForm.LOGIN_PAGE;
    }

    /**
     * Handles valid path.
     * @param request HTTP Request
     * @param login Login
     * @param password Password
     * @return Path
     */
    private static String validPath(
        final HttpServletRequest request, final String login,
        final String password
    ) {
        return new UserRoles(login, password).build().path(request);
    }
}
