/*
 * This file is generated by jOOQ.
 */
package com.devproserv.courses.jooq.tables.records;


import com.devproserv.courses.jooq.tables.Archive;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ArchiveRecord extends UpdatableRecordImpl<ArchiveRecord> implements Record3<Integer, Integer, String> {

    private static final long serialVersionUID = -356614227;

    /**
     * Setter for <code>coursedb.archive.course_id</code>.
     */
    public void setCourseId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>coursedb.archive.course_id</code>.
     */
    public Integer getCourseId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>coursedb.archive.stud_id</code>.
     */
    public void setStudId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>coursedb.archive.stud_id</code>.
     */
    public Integer getStudId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>coursedb.archive.mark</code>.
     */
    public void setMark(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>coursedb.archive.mark</code>.
     */
    public String getMark() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Archive.ARCHIVE.COURSE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Archive.ARCHIVE.STUD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Archive.ARCHIVE.MARK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getCourseId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getStudId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getMark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getCourseId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getStudId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getMark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArchiveRecord value1(Integer value) {
        setCourseId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArchiveRecord value2(Integer value) {
        setStudId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArchiveRecord value3(String value) {
        setMark(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArchiveRecord values(Integer value1, Integer value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ArchiveRecord
     */
    public ArchiveRecord() {
        super(Archive.ARCHIVE);
    }

    /**
     * Create a detached, initialised ArchiveRecord
     */
    public ArchiveRecord(Integer courseId, Integer studId, String mark) {
        super(Archive.ARCHIVE);

        set(0, courseId);
        set(1, studId);
        set(2, mark);
    }
}
