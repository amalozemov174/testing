package com.test;

public class BrickFactory {
    private static final int WATER_RECEIPT_COUNT = 1000;
    private static final int SAND_RECEIPT_COUNT = 1000;
    private Worker worker;
    private int sandCount;
    private int waterCount;

    public BrickFactory(Worker worker, int sandCount, int waterCount) {
        this.worker = worker;
        this.sandCount = sandCount;
        this.waterCount = waterCount;
    }

    public boolean checkFactoryHasWorker() {
        return worker != null;
    }

    public Brick createBrick() throws WorkerTiredException {
        if (waterCount < WATER_RECEIPT_COUNT || sandCount < SAND_RECEIPT_COUNT) {
            throw new NotEnoughResourcesException("Недостаточно песка или воды для создания кирпича");
        }
        waterCount -= WATER_RECEIPT_COUNT;
        sandCount -= SAND_RECEIPT_COUNT;
        return worker.createBrick();
    }
}
