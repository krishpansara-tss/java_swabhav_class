package com.tssconsultancy.behavioral.statetype;

import com.tssconsultancy.behavioral.statetype.model.Packet;

public class Main {
    public static void main(String[] args) {
        Packet packet = new Packet();

        packet.current();

        packet.next();
        packet.current(); // Shipped

        packet.next();
        packet.current();

        packet.next();

        packet.prev();
        packet.current();
    }
}
