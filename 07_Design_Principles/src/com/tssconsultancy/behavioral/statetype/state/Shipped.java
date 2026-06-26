package com.tssconsultancy.behavioral.statetype.state;

import com.tssconsultancy.behavioral.statetype.interafaces.IState;
import com.tssconsultancy.behavioral.statetype.model.Packet;

public class Shipped implements IState {
    @Override
    public void prevState(Packet packet) {
        System.out.println("Ordered -> Shipped state");
        packet.setState(new Ordered());
    }

    @Override
    public void currentState() {
        System.out.println("Shipped state");
    }

    @Override
    public void nextState(Packet packet) {
        System.out.println("Shipped -> Deliverd state");
        packet.setState(new Delivered());
    }
}
