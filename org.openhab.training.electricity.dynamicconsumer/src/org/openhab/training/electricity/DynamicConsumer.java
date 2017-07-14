package org.openhab.training.electricity;

import org.openhab.training.electricity.provider.ElectricityProvider;

public interface DynamicConsumer {

    void providerAdded(ElectricityProvider provider);

    void providerRemoved(ElectricityProvider provider);

}
