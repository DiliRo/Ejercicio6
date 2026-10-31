package model;
import javax.swing.JComponent;
public interface InteractiveWidget{
    public void información();
    public void interactuar();
    public String getTitulo();
    public int getId();
    public int getMemoria();
    public void setId(int id);
    public void setMemoria(int memoria);
    public JComponent obtenerVista();
}
