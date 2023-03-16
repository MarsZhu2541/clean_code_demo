package main.interview.bowling.model;

public class StrikeFrame extends BaseFrame {
    private BaseFrame nextFrame;
    private BaseFrame afterNextFrame;

    public StrikeFrame() {
        super();
    }

    public StrikeFrame(BaseFrame nextFrame, BaseFrame afterNextFrame) {
        super(10);
        this.nextFrame = nextFrame;
        this.afterNextFrame = afterNextFrame;
    }

    public BaseFrame getNextFrame() {
        return nextFrame;
    }

    public void setNextFrame(BaseFrame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public BaseFrame getAfterNextFrame() {
        return afterNextFrame;
    }

    public void setAfterNextFrame(BaseFrame afterNextFrame) {
        this.afterNextFrame = afterNextFrame;
    }

    @Override
    public int getScore() {
        if (nextFrame instanceof StrikeFrame) return 20 + afterNextFrame.getFirstThrow();
        else if (nextFrame instanceof SpareFrame) return 20;
        else return 10 + nextFrame.getScore();
    }

    @Override
    public String getDisplayString() {
        return "First: 10" + " Second: -1 " + " Total: " + getTotal();
    }

}
