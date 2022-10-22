package com.test;

public class Worker {
    private boolean isTired;
    private int countCreatedBricks;

    public Worker(boolean isTired) {
        this.isTired = isTired;
    }

    public Worker() {
    }

    public Brick createBrick() throws WorkerTiredException {
        if (countCreatedBricks > 9) {
            isTired = true;
        }

        if (isTired) {
            throw new WorkerTiredException();
        }
        countCreatedBricks++;
        return new Brick();
    }

    public void setTired(boolean tired) {
        isTired = tired;
    }
}
