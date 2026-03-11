package lichtman.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectileTest {

    @Test
    void getApex() {
        //given
        Projectile p = new Projectile(0, 0, new Force(50, 50));

        //when
        double[] apexPoint = p.getApex();

        //then
        assertEquals(255.10, apexPoint[0], .01);
        assertEquals(127.55, apexPoint[1], .01);
    }
}