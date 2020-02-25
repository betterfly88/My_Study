package net.class101.server1.model;

import lombok.Getter;
import lombok.Setter;


@Getter
public class User {
    private final String userName;
    @Setter
    private long productId;
    @Setter
    private int orderCounts;

    public User(String userName) {
        this.userName = userName;
    }
}
