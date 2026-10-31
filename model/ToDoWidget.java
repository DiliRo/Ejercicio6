package model;

import javax.swing.*;

public class ToDoWidget implements InteractiveWidget {
    private int id;
    private String titulo;
    private int memoria;
    private String tarea;
    private boolean completada;

    public ToDoWidget(int id, String titulo, int memoria, String tarea) {
        this.id = id;
        this.titulo = titulo;
        this.memoria = memoria;
        this.tarea = tarea;
        this.completada = false;
    }


    @Override
    public void información() {
        System.out.println(titulo + ": " + tarea);
    }

    @Override
    public void interactuar() {
        completada = !completada;
    }
    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getMemoria() {
        return memoria;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel();
        JLabel etiqueta = new JLabel();
        JButton boton = new JButton("Cambiar estado");

        actualizarEtiqueta(etiqueta);

        boton.addActionListener(e -> {
            interactuar();
            actualizarEtiqueta(etiqueta);
        });

        panel.add(etiqueta);
        panel.add(boton);
        return panel;
    }

    private void actualizarEtiqueta(JLabel etiqueta) {
        String estado = completada ? "Completada" : "Pendiente";
        etiqueta.setText(tarea + " - " + estado);
    }
}