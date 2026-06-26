package com.tssconsultancy.behavioral.stratagytype.model;

import com.tssconsultancy.behavioral.stratagytype.interfaces.IOperation;

public class OperationStrategy implements IOperation {
    IOperation operation;

    public OperationStrategy(IOperation operation) {
        this.operation = operation;
    }

    public IOperation getiOperation() {
        return operation;
    }

    public void setiOperation(IOperation operation) {
        this.operation = operation;
    }

    @Override
    public void doOperation(int a, int b) {
        operation.doOperation(a, b);
    }
}
