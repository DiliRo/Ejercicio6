package model;

import javax.swing.JComponent;

public interface StaticWidget{
    public void información();
    public String getTitulo();
    public int getId();
    public int getMemoria();
    public void setId(int id);
    public void setMemoria(int memoria);
    public JComponent obtenerVista();
}