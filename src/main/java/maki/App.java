package maki;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {
    public static void main(String[] args) {
        IO.println("this is running");
        var app = Javalin.create(config -> {
            config.routes.apiBuilder(() -> {
                path("/hello", () -> {
                    get(HelloController::getHello);
                    path("/{name}", () -> {
                        post(HelloController::postHello);
                    });
                });
            });
            config.staticFiles.add("/public", Location.CLASSPATH);
        }).start(6969);
    }
}
