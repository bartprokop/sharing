package name.prokop.bart.core;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

/**
 *
 * @author Bart Prokop
 */
public class EntryPoint {

    public static void main(String... args) {
        Undertow.Builder undertowBuilder = Undertow.builder();
        undertowBuilder.addHttpListener(8080, "localhost");
        undertowBuilder.setHandler(e -> {
            e.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
            e.getResponseSender().send("Hello World");
        });
        Undertow server = undertowBuilder.build();
        server.start();
    }

}
