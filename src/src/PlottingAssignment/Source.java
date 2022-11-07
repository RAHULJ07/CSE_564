package PlottingAssignment;

import java.util.*;

/**
 * Source class to generate random number.
 * @version 1.0.0.
 */
public class Source extends Observable{

    private int randomNumber;

    /**
     * get current random number
     * @return random number
     */
    public int getRandomNumber(){
        return randomNumber;
    }

    /**
     * Updates the random number according to timer and notifies observers.
     */
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