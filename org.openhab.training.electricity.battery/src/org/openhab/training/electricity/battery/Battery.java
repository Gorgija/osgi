package org.openhab.training.electricity.battery;

import org.openhab.training.electricity.provider.ElectricityProvider;

public class Battery implements ElectricityProvider {

    private final static int CAPACITY = 20;

    @Override
    public boolean provide(int value) {
        return true;
    }
}