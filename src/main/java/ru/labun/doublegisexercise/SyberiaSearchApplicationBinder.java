package ru.labun.doublegisexercise;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import ru.labun.doublegisexercise.service.SearcherService;
import ru.labun.doublegisexercise.service.doublegis.DoubleGisService;
import ru.labun.doublegisexercise.service.doublegis.DoubleGisServiceImpl;
import ru.labun.doublegisexercise.service.doublegis.SearcherServiceImpl;

/**
 * Created by constantine on 06/02/16.
 */
public class SyberiaSearchApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(DoubleGisServiceImpl.class).to(DoubleGisService.class);
        bind(SearcherServiceImpl.class).to(SearcherService.class);
    }
}
