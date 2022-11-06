package PlottingAssignment;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

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
                randomNumber = (int) (Math.random() * 200) + 1;
                setChanged();
                notifyObservers();
            }
        }, 10*1000, 10*1000);

    }
}