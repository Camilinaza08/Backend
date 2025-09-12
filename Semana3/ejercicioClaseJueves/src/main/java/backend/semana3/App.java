
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )

    {   
        Scanner lector = null;
        try{
            URL location = App.class.getResource("alquileres_verano.csv");
            File archivoCsv = new File(location.toUri());
             lector = new Scanner(archivoCsv); 
            lector.nextLine();
            
            while(lector.hasNext()){
                String linea = lector.nextLine();
                String[] items = linea.split(";");



            }
        }
            catch(NumberFormatException e){
                System.out.println("Error al importar y convertir cadenas a enteros");
            }
            finally{
                if(lector != null){
                    lector.close();
                }
            }
    }
}
