package ru.labun.doublegisexercise;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.glassfish.jersey.test.TestProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.labun.doublegisexercise.service.SearcherService;
import ru.labun.doublegisexercise.service.doublegis.DoubleGisService;
import ru.labun.doublegisexercise.service.doublegis.DoubleGisServiceMock;
import ru.labun.doublegisexercise.service.doublegis.SearcherServiceImpl;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;

/**
 * Created by constantine on 06/02/16.
 */
public class SyberiaSearchApplicationTest extends JerseyTestNg.ContainerPerMethodTest {
    public static final String EXPECTED_RESULT = "[{\"Название\":\"Формула Кино IMAX, кинотеатр\",\"Адрес\":\"Новокузнецк, ДОЗ, 10а\",\"Рейтинг Флампа\":\"4.2\"},{\"Название\":\"Синема Парк, кинотеатр\",\"Адрес\":\"Новосибирск, Красный проспект, 101\",\"Рейтинг Флампа\":\"3.7\"},{\"Название\":\"Вавилон, киноцентр\",\"Адрес\":\"Омск, Лермонтова, 2\"}]";

    @Override
    protected Application configure() {
        ResourceConfig config = new ResourceConfig()
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(DoubleGisServiceMock.class).to(DoubleGisService.class);
                        bind(SearcherServiceImpl.class).to(SearcherService.class);
                    }
                })
                .register(new JacksonFeature())
                .register(SyberiaSearchResource.class);

        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return config;
    }

    @Test
    public void should_return_top_cinemas() throws Exception {
        String actualResult = target("syberia-searcher").path("кинотеатр").request()
                .get().readEntity(new GenericType<>(String.class));
        Assert.assertEquals(EXPECTED_RESULT, actualResult);
    }
}
