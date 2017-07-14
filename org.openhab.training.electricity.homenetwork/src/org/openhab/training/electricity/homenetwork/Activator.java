package org.openhab.training.electricity.homenetwork;

import java.util.Dictionary;
import java.util.Properties;

import org.openhab.training.electricity.provider.ElectricityProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

    private static BundleContext context;
    private ServiceRegistration homeElectricityRegistration;

    static BundleContext getContext() {
        return context;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        Dictionary props = new Properties();
        ElectricityProvider provider = new HomeElectricityNetwork();
        homeElectricityRegistration = bundleContext.registerService(ElectricityProvider.class.getName(), provider,
                props);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
        homeElectricityRegistration.unregister();
    }

}
