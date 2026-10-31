package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;
import model.*;

public class DashboardView extends JFrame {
    private final JPanel contenedorWidgets = new JPanel(new GridLayout(0, 2, 10, 10));
    private Runnable accionOrdenar;
    private Runnable accionActualizar;

    public DashboardView() {
        setTitle("Dashboard de widgets");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Dashboard de widgets", SwingConstants.CENTER);
        JButton botonOrdenar = new JButton("Ordenar por memoria");
        JButton botonActualizar = new JButton("Actualizar");

        JPanel barraSuperior = new JPanel();
        barraSuperior.add(titulo);
        barraSuperior.add(botonOrdenar);
        barraSuperior.add(botonActualizar);

        botonOrdenar.addActionListener(e -> {
            if (accionOrdenar != null) {
                accionOrdenar.run();
            }
        });

        botonActualizar.addActionListener(e -> {
            if (accionActualizar != null) {
                accionActualizar.run();
            }
        });

        add(barraSuperior, BorderLayout.NORTH);
        add(new JScrollPane(contenedorWidgets), BorderLayout.CENTER);
    }

    public void setAccionesGlobales(Runnable accionOrdenar, Runnable accionActualizar) {
        this.accionOrdenar = accionOrdenar;
        this.accionActualizar = accionActualizar;
    }

    public void mostrarWidgets(List<Object> widgets) {
        contenedorWidgets.removeAll();

        for (Object widget : widgets) {
            JComponent vista;
            String titulo;

            if (widget instanceof InteractiveWidget) {
                InteractiveWidget interactivo = (InteractiveWidget) widget;
                vista = interactivo.obtenerVista();
                titulo = interactivo.getTitulo();
            } else {
                StaticWidget estatico = (StaticWidget) widget;
                vista = estatico.obtenerVista();
                titulo = estatico.getTitulo();
            }

            JPanel tarjeta = new JPanel(new BorderLayout());
            tarjeta.setBorder(BorderFactory.createTitledBorder(titulo));
            tarjeta.add(vista, BorderLayout.CENTER);
            contenedorWidgets.add(tarjeta);
        }

        contenedorWidgets.revalidate();
        contenedorWidgets.repaint();
    }
}