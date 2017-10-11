package tech.forum.undertow;

import io.undertow.Undertow;
import io.undertow.util.Headers;

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
