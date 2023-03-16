package main.interview.bowling.util;

import main.interview.bowling.model.BaseFrame;
import main.interview.bowling.model.CommonFrame;
import main.interview.bowling.model.SpareFrame;
import main.interview.bowling.model.StrikeFrame;

import java.util.ArrayList;
import java.util.List;

import static main.interview.bowling.service.BowlingService.getScoreInput;

public class FrameFactory {
    private static List<BaseFrame> frameList = new ArrayList<>();

    public static List<BaseFrame> getFrameList() {
        return frameList;
    }

    public static BaseFrame createFrameByScore(int firstThrow, int secondThrow) {

        if (firstThrow == 10){
            StrikeFrame frame = new StrikeFrame();
            frameList.add(frame);
            BaseFrame nextFrame = createFrameByScore(getScoreInput(), getScoreInput());
            frame.setNextFrame(nextFrame);
            if(nextFrame instanceof StrikeFrame){
                frame.setAfterNextFrame(createFrameByScore(getScoreInput(), getScoreInput()));
            }
            return frame;
        }
        else if (firstThrow + secondThrow >= 10){
            SpareFrame spareFrame = new SpareFrame();
            frameList.add(spareFrame);
            spareFrame.setFirstThrow(firstThrow);
            if(firstThrow + secondThrow > 10) System.out.println("change secondThrow to: "+(10-firstThrow));
            spareFrame.setNextFrame(createFrameByScore(getScoreInput(), getScoreInput()));
            return spareFrame;
        }
        else {
            CommonFrame commonFrame = new CommonFrame(firstThrow, secondThrow);
            frameList.add(commonFrame);
            return commonFrame;
        }
    }
}
