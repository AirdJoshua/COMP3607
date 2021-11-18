package com.groupassignment;

public class RenameContext{
    private IChangeName strategy;

    public RenameContext(IChangeName strategy) {
        this.strategy = strategy;
    }

    public Student changePdfName() {
        return strategy.changePdfName();
    }
}
