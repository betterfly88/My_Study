package com.betterfly;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroupTest {

    @Test
    public void ifUll(){
        Group group = new Group();
        group.maxNumberOfAttendees = 100;
        group.numberOfEnrollment = 10;

        Assert.assertFalse(group.isEnrollmentFull());
    }

}