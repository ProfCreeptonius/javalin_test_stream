package maki;

import io.javalin.http.Context;

public class HelloController {
    static void getHello(Context ctx) {
        ctx.result("Hello from Controller\n");
    }
    static void postHello(Context ctx) {
        String name = ctx.pathParam("name");
        IO.println("%s says hello\n".formatted(name));
        ctx.result("Hello %s\n".formatted(name));
    }
}
