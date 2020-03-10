package com.betterfly;

public class Group {
    int maxNumberOfAttendees;
    int numberOfEnrollment;

    public boolean isEnrollmentFull(){
        if(maxNumberOfAttendees == 0){
            return false;
        }

        if(numberOfEnrollment < maxNumberOfAttendees){
            return false;
        }

        return true;
    }
}
