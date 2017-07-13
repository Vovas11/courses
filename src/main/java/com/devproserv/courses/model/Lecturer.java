package com.devproserv.courses.model;

/**
 * Represents the entity of the Lecturer. Maps the table 'lecturers' in the database.
 * 
 * @author vovas11
 * @see UserDao
 */
public class Lecturer extends User {

    // additional fields representing columns in the table 'lecturers'
    private String degree;

    public String getDegree() {
        return degree;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
}