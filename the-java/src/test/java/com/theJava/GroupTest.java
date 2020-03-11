package com.theJava;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroupTest {
    @Test
    public void isFull(){
        Group group = new Group();
        group.maxNumberOfAttendees = 100;
        group.numberOfEnrollment = 10;

        assertFalse(group.isEnrollmentFull());
    }

}