package com.course.rest_with_springboot_and_java_erudi;

public class Greetings {

    private final long id;
    private final String message;


    public Greetings(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }


}
