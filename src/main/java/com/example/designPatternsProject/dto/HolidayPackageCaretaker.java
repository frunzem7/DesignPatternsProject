package com.example.designPatternsProject.dto;

import java.util.Stack;

public class HolidayPackageCaretaker {
    private Stack<HolidayPackageMemento> mementoStack = new Stack<>();

    public void saveMemento(HolidayPackageMemento memento) {
        mementoStack.push(memento);
    }

    public HolidayPackageMemento restoreMemento() {
        if (!mementoStack.isEmpty()) {
            return mementoStack.pop();
        }
        return null;
    }
}