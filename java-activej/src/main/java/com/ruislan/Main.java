package com.ruislan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.activej.eventloop.Eventloop;
import io.activej.http.*;
import io.activej.inject.annotation.Eager;
import io.activej.inject.annotation.Provides;
import io.activej.inject.module.Module;
import io.activej.launcher.Launcher;
import io.activej.reactor.Reactor;
import io.activej.reactor.nio.NioReactor;
import io.activej.service.ServiceGraphModule;

public class Main extends Launcher {

    record JsonResult(String hello) {
    }

    static ObjectMapper objectMapper = new ObjectMapper();

    static String toJson(final Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static final int PORT = 6000;

    @Provides
    NioReactor reactor() {
        return Eventloop.create();
    }

    @Provides
    AsyncServlet servlet(Reactor reactor) {
        return RoutingServlet.builder(reactor)
                .with(
                        HttpMethod.GET,
                        "/",
                        request -> HttpResponse.ok200()
                                .withJson(toJson(new JsonResult("world")))
                                .toPromise()
                ).build();
    }

    @Provides
    @Eager
    HttpServer server(NioReactor reactor, AsyncServlet servlet) {
        return HttpServer.builder(reactor, servlet)
                .withListenPort(PORT)
                .build();
    }

    @Override
    protected Module getModule() {
        return ServiceGraphModule.create();
    }

    @Override
    protected void run() throws Exception {
        logger.info("HTTP Server is now available at http://localhost:" + PORT);
        awaitShutdown();
    }

    public static void main(String[] args) throws Exception {
        Launcher launcher = new Main();
        launcher.launch(args);
    }
}