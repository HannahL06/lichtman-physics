package lichtman.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForceTest {

    @Test
    void getMagnitude() {
        //given
        Force f = new Force(7, 3);
        double x = f.getX();
        double y = f.getY();

        //when
        double mag = f.getMagnitude();

        //then
        assertEquals(7.62, mag, 0.1);
    }

    @Test
    void addForces() {
        //given
        Force f1 = new Force(3, 4);
        Force f2 = new Force(-2, 3);

        //when
        Force f3 = f1.addForces(f2);

        //then
        assertEquals(1, f3.getX(), 0.1);
        assertEquals(7, f3.getY(), 0.1);
    }

    @Test
    void getDegrees() {
        // given
        Force f = new Force(3, 4);

        //when
        double degrees = f.getDegrees();

        //then
        assertEquals(53.13, degrees, 0.1);
    }

    @Test
    void gravity() {

        Force f1 = new Force(37.0365, 28.9360);
        Force gravity = new Force(0, -9.8);

        double increment = 0.001;
        Force scaledGravity = gravity.scale(increment);

        double time = 5.0;
        double x = 0.0;
        double y = 0.0;

        for (double i = 0; i < time; i++) {
            f1 = f1.addForces(scaledGravity);
            Force scaledF1 = f1.scale(increment);
            x += scaledF1.getX();
            y += scaledF1.getY();
        }

        assertEquals(185.182, x, 0.001);
        assertEquals(22.155, y, 0.001);

    }

    //@Test
    //void apply() {}
}
