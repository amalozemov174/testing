package unit;


import com.test.Brick;
import com.test.BrickFactory;
import com.test.Worker;
import com.test.WorkerTiredException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrickFactoryTest {

    @Test
    @DisplayName("тестирование метода checkFactoryHasWorker на true")
    public void myThrowsBrickFactory() {
        //
    }

    @Test
    @DisplayName("тестирование метода checkFactoryHasWorker на true")
    public void checkFactoryHasWorkerTestTrue() {
        Worker worker = Mockito.mock(Worker.class);
        BrickFactory brickFactory = new BrickFactory(worker, 0, 0);
        boolean expect = true;
        boolean actual = brickFactory.checkFactoryHasWorker();
        Assertions.assertEquals(expect, actual);
    }

    @Test
    @DisplayName("тестирование метода checkFactoryHasWorker на false")
    public void checkFactoryHasWorkerTestFalse() {
        //Worker worker = Mockito.mock(Worker.class);
        BrickFactory brickFactory = new BrickFactory(null, 0, 0);
        boolean expect = false;
        boolean actual = brickFactory.checkFactoryHasWorker();
        Assertions.assertEquals(expect, actual);
    }

    @Test
    @DisplayName("тестирование метода createBrick на создание 10 кирпичей")
    @SneakyThrows
    public void createBrickTestTenBricks() {
        Worker worker = Mockito.mock(Worker.class);
        int sandCount = 10000;
        int waterCount = 10000;
        BrickFactory brickFactory = new BrickFactory(worker, sandCount, waterCount);
        ArrayList<Brick> bricks = new ArrayList<Brick>();
        for (int i = 0; i < 10; i++) {
            bricks.add(brickFactory.createBrick());
        }
        int expect = 10;
        int actual = bricks.size();
        Assertions.assertEquals(expect, actual);
    }

    @ParameterizedTest
    @DisplayName("тестирование метода createBrick на создание кирпичей")
    @SneakyThrows
    @CsvFileSource(resources = "/test.csv", delimiter = ';')
    public void createBrickTestBricks(Integer sandCount, Integer waterCount, Integer expect) {
        Worker worker = Mockito.mock(Worker.class);
        BrickFactory brickFactory = new BrickFactory(worker, sandCount, waterCount);
        ArrayList<Brick> bricks = new ArrayList<Brick>();
        for (int i = 0; i < expect; i++) {
            bricks.add(brickFactory.createBrick());
        }
        int actual = bricks.size();
        Assertions.assertEquals(expect, actual);
    }
}
