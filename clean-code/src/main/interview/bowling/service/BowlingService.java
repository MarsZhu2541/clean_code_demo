package main.interview.bowling.service;

import main.interview.bowling.model.BaseFrame;
import main.interview.bowling.util.FrameFactory;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BowlingService {
    private static Scanner sc = new Scanner(System.in);

    private static Random random = new Random();
    private static List<BaseFrame> frameList;

    public void startGame() {
        frameList = FrameFactory.getFrameList();

        System.out.println("============Welcome to bowling game(enter -1 to quit)============");


        BaseFrame frame;
        for (int i = 0; i < 10; i++) {
            if (frameList.size() <= i) {
                int scoreInput = getScoreInput();
                if (scoreInput == 10) {
                    frame = FrameFactory.createFrameByScore(10, -1);
                } else {
                    int nextScoreInput = getScoreInput();
                    frame = FrameFactory.createFrameByScore(scoreInput, nextScoreInput);
                }
            } else {
                frame = frameList.get(i);
            }

            int index = frameList.indexOf(frame);
            int lastTotal = index == 0 ? 0 : frameList.get(index - 1).getTotal();
            frame.setTotal(lastTotal + frame.getScore());

            System.out.println(frame.getDisplayString());
        }
    }


    public static int getScoreInput() {
        System.out.print("Please enter the score:");
        int score = random.nextInt(11);
        System.out.println(score);
        if (score == -1) {
            System.exit(0);
        }
        return score;
    }
}
