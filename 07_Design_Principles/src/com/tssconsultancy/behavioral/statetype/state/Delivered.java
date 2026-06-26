package com.tssconsultancy.behavioral.statetype.state;

import com.tssconsultancy.behavioral.statetype.interafaces.IState;
import com.tssconsultancy.behavioral.statetype.model.Packet;

public class Delivered implements IState {
    @Override
    public void prevState(Packet packet) {
        System.out.println("Deliverd -> Shipped state");
        packet.setState(new Shipped());
    }

    @Override
    public void currentState() {
        System.out.println("deliverd state");
    }

    @Override
    public void nextState(Packet packet) {
        System.out.println("No next state of deliverd state");
    }
}
