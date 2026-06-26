package com.tssconsultancy.behavioral.statetype.state;

import com.tssconsultancy.behavioral.statetype.interafaces.IState;
import com.tssconsultancy.behavioral.statetype.model.Packet;

public class Ordered implements IState {
    @Override
    public void prevState(Packet packet) {
        System.out.println("No prev state of Ordered state");
    }

    @Override
    public void currentState() {
        System.out.println("orderd state");
    }

    @Override
    public void nextState(Packet packet) {
        System.out.println("Orderd -> Shipped state");
        packet.setState(new Shipped());
    }
}
