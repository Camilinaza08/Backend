package backend;

import java.net.URL;

import backend.menu.ApplicationContext;
import backend.menu.ItemMenu;
import backend.menu.Menu;
import backend.services.EmpleadoService;
import backend.services.TarjetaCreditoService;
import backend.services.EmpresaService;

public class App {
    public static void main(String[] args) {
        var ctx = ApplicationContext.getInstance();
        Menu menu = new Menu();
        menu.setTitulo("Menu de Opciones de Empleados");

        Acciones acciones = new Acciones();

        URL folderPath = App.class.getResource("/files"); //Puede definir la ruta que desee
        ctx.put("path", folderPath);
        ctx.registerService(EmpleadoService.class, new EmpleadoService());
        ctx.registerService(TarjetaCreditoService.class, new TarjetaCreditoService());
        ctx.registerService(EmpresaService.class, new EmpresaService());

        menu.addOpcion(new ItemMenu(1, "Cargar Empleados", acciones::importarCsv));
        menu.addOpcion(new ItemMenu(2, "Gastos por Tarjeta", acciones::gastosPorTarjeta));
        menu.addOpcion(new ItemMenu(3, "Gastos y comision por empresa", acciones::gastosPorEmpresa));
        menu.addOpcion(new ItemMenu(4, "Tarjetas a vencer", acciones::proximosVencimientos));
        menu.addOpcion(new ItemMenu(5, "Mayor y Menor Saldo de Gastos", acciones::mayorYMenorSaldo));

        menu.ejecutar(ctx);
    }
}
