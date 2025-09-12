package utnfc.isi.back.menu;

import java.util.List;

public class App {
    public static void main(String[] args) {
        var ctx = ApplicationContext.getInstance();
        ctx.put("instrucciones", "Demo etapa 2");

        var opciones = List.of(
            new MenuOption(1, "Hola mundo", c -> System.out.println("¡Hola!")),
            new MenuOption(2, "Mostrar hora", c -> System.out.println(java.time.LocalTime.now()))
        );
        new Menu("Menú Funcional — Etapa 2", opciones.toArray(new MenuOption[0])).run(ctx);
    }
    }
