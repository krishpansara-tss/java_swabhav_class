package com.tssconsultancy.behavioral.stratagytype.stratagy;

import com.tssconsultancy.behavioral.stratagytype.interfaces.IOperation;

public class AddOperation implements IOperation {
    @Override
    public void doOperation(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a+b));
    }
}
