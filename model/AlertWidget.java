package model;
import javax.swing.*;
public class AlertWidget implements InteractiveWidget{
    private int id;
    private String titulo;
    private int memoria;
    private String Mensaje;
    private NivelPrioridad prioridad;

    public AlertWidget(int id, String titulo, int memoria, String Mensaje, NivelPrioridad prioridad){
        this.id = id;
        this.titulo = titulo;
        this.memoria = memoria;
        this.Mensaje = Mensaje;
        this.prioridad = prioridad;
    }

    public String getMensaje(){
        return this.Mensaje;
    }

    public void setMensaje(String Mensaje){
        this.Mensaje = Mensaje;
    }

    public NivelPrioridad getPrioridad(){
        return this.prioridad;
    }

    public void setPrioridad(NivelPrioridad prioridad){
        this.prioridad = prioridad;
    }


    @Override
    public void información(){
        System.out.println("Información");
    };

    @Override
    public void interactuar() {
        System.out.println(getMensaje());
    }

    @Override
    public String getTitulo(){
        return this.titulo;
    }
    
    @Override
    public int getId(){
        return this.id;
    }

    @Override
    public int getMemoria(){
        return this.memoria;
    }

    @Override
    public void setId(int id){
        this.id = id;
    }

    @Override
    public void setMemoria(int memoria){
        this.memoria = memoria;
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel();
        JLabel etiqueta = new JLabel(
            getMensaje() + " - Prioridad: " + getPrioridad()
        );
        JButton boton = new JButton("Ver alerta");

        boton.addActionListener(e -> {
            interactuar();
            etiqueta.setText(getMensaje() + " - Prioridad: " + getPrioridad());
        });

        panel.add(etiqueta);
        panel.add(boton);
        return panel;
    }
}
