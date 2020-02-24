package net.class101.server1.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClientStateTest {

    @Test
    public void 사용자_행동(){
        ClientState o = ClientState.getClientState("o");
        ClientState q = ClientState.getClientState("q");
        ClientState space = ClientState.getClientState(" ");
        ClientState c = ClientState.getClientState("aaa");

        assertTrue(o == ClientState.ORDER);
        assertTrue(q == ClientState.QUIT);
        assertTrue(space == ClientState.EXECUTE);
        assertTrue(c == null);
    }
}