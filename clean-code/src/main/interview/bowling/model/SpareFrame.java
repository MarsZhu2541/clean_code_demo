package main.interview.bowling.model;

public class SpareFrame extends BaseFrame {

    private BaseFrame nextFrame;

    public SpareFrame(int firstThrow, BaseFrame nextFrame) {
        super(firstThrow);
        this.nextFrame = nextFrame;
    }

    public SpareFrame() {
        super();
    }

    @Override
    public int getScore() {
        return 10 + nextFrame.getFirstThrow();
    }

    int getSecondThrow() {
        return 10 - getFirstThrow();
    }

    @Override
    public String getDisplayString() {
        return "First: " + getFirstThrow() + " Second: " + getSecondThrow() + " Total: " + getTotal();
    }

    public BaseFrame getNextFrame() {
        return nextFrame;
    }

    public void setNextFrame(BaseFrame nextFrame) {
        this.nextFrame = nextFrame;
    }
}
