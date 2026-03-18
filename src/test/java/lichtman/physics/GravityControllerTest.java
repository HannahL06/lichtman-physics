package lichtman.physics;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.mockito.Mockito.*;

class GravityControllerTest {

    @Test
    void updateForce() {

        //given
        GravityComponent gComp = mock();
        JTextField xField = mock();
        JTextField yField = mock();
        JTextField tField = mock();
        JLabel angleLabel = mock();
        JLabel magLabel = mock();
        JLabel apexLabel = mock();

        GravityController gc = new GravityController(gComp, tField, xField, yField,
                angleLabel, magLabel, apexLabel);

        doReturn("15").when(tField).getText();
        doReturn(-127.55).when(gComp).getApex();

        //when
        gc.updateForce(7, 5);

        //then
        verify(gComp).setForce(new Force(7, 5));
        verify(xField).setText("7.0");
        verify(yField).setText("5.0");
        verify(magLabel).setText("Magnitude: 8.6023");
        verify(angleLabel).setText("Angle: 35.5377");
        verify(gComp).setTime(15);
        verify(apexLabel).setText("Apex: 127.5500");
    }
}