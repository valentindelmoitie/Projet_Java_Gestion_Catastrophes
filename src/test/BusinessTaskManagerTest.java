package test;

import business.BusinessTaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessTaskManagerTest {

    private BusinessTaskManager businessTaskManager;

    @BeforeEach
    public void setUp(){
        businessTaskManager = new BusinessTaskManager();
    }

    @Test
    void calculatePourc() {
        assertEquals(50.0,businessTaskManager.calculatePourc(1000,500),0.01);
    }

    @Test
    void calculatePourcDividedByZero() {
        assertEquals(0.0,businessTaskManager.calculatePourc(0,1248584),0.01);
    }
}