package net.class101.server1.model;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum ClientState {
    ORDER("o"),
    QUIT("q"),
    EXECUTE(" ")
    ;

    private String state;

    ClientState(String state){
        this.state = state;
    }

    public static ClientState getClientState(String input){
        return Stream.of(ClientState.values())
                .filter(state -> state.getState().equals(input))
                .findFirst()
                .orElse(null)
                ;
    }

//    abstract void execute(long pid, long pCount);
}
