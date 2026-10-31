package model;

import java.time.LocalTime;
import javax.swing.*;


public class ClockWidget implements StaticWidget{
    private int id;
    private String titulo;
    private int memoria;
    private LocalTime hora;

    public ClockWidget(int id, String titulo, int memoria, LocalTime hora){
        this.id = id;
        this.titulo = titulo;
        this.memoria = memoria;
        this.hora = hora;
    }

    public LocalTime horaActual(){
        this.hora = LocalTime.now();
        return this.hora;
    }



    @Override
    public void información(){
        System.out.println("Información");
    };

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
            horaActual().format(
                java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")
            )
        );
        panel.add(etiqueta);
        return panel;
    }
}