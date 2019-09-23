package com.tonasolution;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();


        CountdownThread countdownThread1 = new CountdownThread(countdown);
        countdownThread1.setName("Thread 1");
        CountdownThread countdownThread2 = new CountdownThread(countdown);
        countdownThread2.setName("Thread 2");

        countdownThread1.start();
        countdownThread2.start();
    }
}


class Countdown {
    public void doCountdown(){
        String color;

        switch(Thread.currentThread().getName()){
            case "Thread 1" :
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2" :
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }
        synchronized(this){
            for(int i=10; i > 0; i--){
                System.out.println(color + " " + Thread.currentThread().getName() + ": i " + i);
            }
        }
    }
}

class CountdownThread extends Thread {
    private Countdown countdown;

    public CountdownThread(Countdown _countdown){
        countdown = _countdown;
    }

    public void run(){
        countdown.doCountdown();
    }
}
