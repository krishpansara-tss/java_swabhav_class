package com.tssconsultancy.behavioral.stratagytype;

import com.tssconsultancy.behavioral.stratagytype.model.OperationStrategy;
import com.tssconsultancy.behavioral.stratagytype.stratagy.AddOperation;
import com.tssconsultancy.behavioral.stratagytype.stratagy.MultiplyOperation;

public class Main {
    public static void main(String[] args) {
        OperationStrategy operationStrategy = new OperationStrategy(new AddOperation());

        operationStrategy.doOperation(5 ,10);
        operationStrategy.setiOperation(new MultiplyOperation());
        operationStrategy.doOperation(5 ,10);

    }
}
