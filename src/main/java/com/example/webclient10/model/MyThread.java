package com.example.webclient10.model;


public class MyThread {

    private String threadName;
    private String stateName;
    private String state;

    public MyThread() {
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "MyThread{" +
                "threadName='" + threadName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
