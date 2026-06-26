package com.tssconsultancy.behavioral.statetype.interafaces;

import com.tssconsultancy.behavioral.statetype.model.Packet;

public interface IState {
    void prevState(Packet packet);
    void currentState();
    void nextState(Packet packet);
}
