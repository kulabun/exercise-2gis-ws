package ru.labun.doublegisexercise;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by constantine on 06/02/16.
 */
public class SyberiaSearchApplicationServer {
    public static void main(String[] args) throws Exception {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(8081).build();
        ResourceConfig config = new ResourceConfig()
                .register(new SyberiaSearchApplicationBinder())
                .register(new JacksonFeature())
                .register(SyberiaSearchResource.class);
        Server server = JettyHttpContainerFactory.createServer(baseUri, config);
        server.start();
        server.join();
    }
}
