package main.interview.bowling.model;


import static main.interview.bowling.service.BowlingService.getScoreInput;

public class CommonFrame extends BaseFrame {
    private int secondThrow;

    public CommonFrame(int firstThrow, int secondThrow) {
        super(firstThrow);
        this.secondThrow = secondThrow;
    }

    public int getSecondThrow() {
        if (secondThrow == -1) {
            setSecondThrow(getScoreInput());
        }
        return secondThrow;
    }

    public void setSecondThrow(int secondThrow) {
        this.secondThrow = secondThrow;
    }

    @Override
    public int getScore() {
        return getFirstThrow() + getSecondThrow();
    }

    @Override
    public String getDisplayString() {
        return "First: " + getFirstThrow() + " Second: " + getSecondThrow() + " Total: " + getTotal();
    }

}
