package PlottingAssignment;

import java.sql.SQLOutput;
import java.util.*;

public class Source extends Observable{

    private int randomNumber;

    public int getRandomNumber(){
        return randomNumber;
    }

    public void updateRandomNumber(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                randomNumber = (int) (Math.random() * 100) + 1;
                setChanged();
                notifyObservers();
            }
        }, 500, 500);

    }
}