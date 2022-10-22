package integration;

import com.test.*;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BrickFactoryIT {

    @Test
    @DisplayName("создание уставшего работника")
    public void createTiredWorkerIT() {
        Worker worker = new Worker(true);
        int sandCount = 15000;
        int waterCount = 15000;
        BrickFactory brickFactory = new BrickFactory(worker, sandCount, waterCount);
        Assertions.assertThrows(WorkerTiredException.class, () -> brickFactory.createBrick());
    }

    @Test
    @DisplayName("создание кирпича с недостаточным количесвтом ресурсов")
    public void notEnoughREsourcesforCreatBrickIT() {
        Worker worker = new Worker(true);
        int sandCount = 100;
        int waterCount = 500;
        BrickFactory brickFactory = new BrickFactory(worker, sandCount, waterCount);
        Assertions.assertThrows(NotEnoughResourcesException.class, () -> brickFactory.createBrick());
    }

    @Test
    @DisplayName("создание кирпича")
    @SneakyThrows
    public void testCreatBrickIT() {
        Worker worker = new Worker();
        int sandCount = 2000;
        int waterCount = 2000;
        int expect = 2;
        BrickFactory brickFactory = new BrickFactory(worker, sandCount, waterCount);
        ArrayList<Brick> bricks = new ArrayList<Brick>();
        for (int i = 0; i < sandCount/1000; i++) {
            bricks.add(brickFactory.createBrick());
        }
        int actual = bricks.size();
        Assertions.assertEquals(expect, actual);
    }

}
