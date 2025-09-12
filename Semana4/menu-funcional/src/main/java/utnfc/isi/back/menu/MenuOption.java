package utnfc.isi.back.menu;
public class MenuOption {
    private final int code;
    private final String label;
    private final FuncAction action;

    public int getCode(){
        return code;
    }
    public String getLabel(){
        return label;
    }
    public FuncAction action(){
        return action;
    }

    public MenuOption(int cod, String etiqueta, FuncAction accion){
        code = cod;
        label = etiqueta;
        action = accion;
    }
}
