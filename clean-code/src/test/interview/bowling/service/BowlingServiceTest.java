package test.interview.bowling.service;

import main.interview.bowling.service.BowlingService;
import org.junit.Test;

public class BowlingServiceTest {


    @Test
    public void test1(){
        BowlingService bowlingService = new BowlingService();
        bowlingService.startGame();
    }
}
