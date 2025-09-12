
public class App {
    URL location = App.class.getResource("alquileres_verano.csv");

    try{
        File archivoCss = new File(location.toUri());
        Scanner lector = new Scanner(archivoCsv)
    }catch(URISyntaxException e){
        System.out.println("La ubicaciòn del csv no genero una ruta correcta");
    }
    catch(FileNotFoundException e){
        System.out.println("El archivo que desea importar no existe");
    }
}
