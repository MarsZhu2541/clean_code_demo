package main.interview.bowling.model;

import static main.interview.bowling.service.BowlingService.getScoreInput;

public abstract class BaseFrame {
    private int firstThrow = -1;
    private int total;
    public abstract int getScore();
    public abstract String getDisplayString();

    public BaseFrame() {
    }

    public BaseFrame(int firstThrow) {
        this.firstThrow = firstThrow;
    }

    public int getFirstThrow() {
        if(firstThrow==-1){
            setFirstThrow(getScoreInput());
        }
        return firstThrow;
    }

    public void setFirstThrow(int firstThrow) {
        this.firstThrow = firstThrow;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
