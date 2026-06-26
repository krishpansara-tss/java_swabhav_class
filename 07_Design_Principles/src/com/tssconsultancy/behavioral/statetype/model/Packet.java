package com.tssconsultancy.behavioral.statetype.model;

import com.tssconsultancy.behavioral.statetype.interafaces.IState;
import com.tssconsultancy.behavioral.statetype.state.Ordered;

public class Packet {
    IState state = new Ordered();

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public void next() {
        state.nextState(this);
    }

    public void prev() {
        state.prevState(this);
    }

    public void current() {
        state.currentState();
    }

    @Override
    public String toString() {
        return "Packet{" +
                "state=" + state +
                '}';
    }
}
