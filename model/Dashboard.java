package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Dashboard {
    private ArrayList<Object> widgets = new ArrayList<>();

    public void init() {
        widgets.clear();

        widgets.add(new WeatherWidget(1, "Clima 1", 20, 25, 'C'));
        widgets.add(new WeatherWidget(2, "Clima 2", 25, 30, 'C'));

        widgets.add(new AlertWidget(3, "Alerta 1", 15, "Revisar sistema", NivelPrioridad.ALTO));
        widgets.add(new AlertWidget(4, "Alerta 2", 18, "Memoria baja", NivelPrioridad.MEDIO));

        widgets.add(new QuoteWidget(5, "Frase 1", 10));
        widgets.add(new QuoteWidget(6, "Frase 2", 12));

        widgets.add(new ClockWidget(7, "Reloj 1", 8, LocalTime.now()));
        widgets.add(new ClockWidget(8, "Reloj 2", 8, LocalTime.now()));

        widgets.add(new ToDoWidget(9, "Tarea 1", 14, "Entregar proyecto"));
        widgets.add(new ToDoWidget(10, "Tarea 2", 14, "Estudiar Java"));
    }

    public void listarWidgets() {
        for (int i = 0; i < widgets.size(); i++) {
            Object widget = widgets.get(i);
            System.out.println(
                "Índice: " + i
                + " | ID: " + obtenerId(widget)
                + " | Título: " + obtenerTitulo(widget)
                + " | Memoria: " + obtenerMemoria(widget)
            );
        }
    }

    public void interactuarPorIndice(int indice) {
        if (indice < 0 || indice >= widgets.size()) {
            System.out.println("Índice inválido");
            return;
        }

        interactuar(widgets.get(indice));
    }

    public void interactuarPorId(int id) {
        for (Object widget : widgets) {
            if (obtenerId(widget) == id) {
                interactuar(widget);
                return;
            }
        }

        System.out.println("No se encontró un widget con ese ID");
    }

    public void ordenarPorMemoria() {
        ArrayList<WidgetOrdenable> ordenados = new ArrayList<>();

        for (Object widget : widgets) {
            ordenados.add(new WidgetOrdenable(widget));
        }

        Collections.sort(ordenados);
        widgets.clear();

        for (WidgetOrdenable elemento : ordenados) {
            widgets.add(elemento.widget);
        }
    }

    private void interactuar(Object widget) {
        if (widget instanceof WeatherWidget) {
            ((WeatherWidget) widget).cambioTemperatura();
        } else if (widget instanceof AlertWidget) {
            ((AlertWidget) widget).interactuar();
        } else if (widget instanceof ToDoWidget) {
            ((ToDoWidget) widget).interactuar();
        } else if (widget instanceof InteractiveWidget) {
            ((InteractiveWidget) widget).interactuar();
        } else {
            System.out.println("Este widget no tiene interacción");
        }
    }

    private int obtenerId(Object widget) {
        if (widget instanceof InteractiveWidget) {
            return ((InteractiveWidget) widget).getId();
        }
        return ((StaticWidget) widget).getId();
    }

    private String obtenerTitulo(Object widget) {
        if (widget instanceof InteractiveWidget) {
            return ((InteractiveWidget) widget).getTitulo();
        }
        return ((StaticWidget) widget).getTitulo();
    }

    private int obtenerMemoria(Object widget) {
        if (widget instanceof InteractiveWidget) {
            return ((InteractiveWidget) widget).getMemoria();
        }
        return ((StaticWidget) widget).getMemoria();
    }

    private static class WidgetOrdenable implements Comparable<WidgetOrdenable> {
        private Object widget;

        public WidgetOrdenable(Object widget) {
            this.widget = widget;
        }

        @Override
        public int compareTo(WidgetOrdenable otro) {
            int memoriaActual = obtenerMemoria(this.widget);
            int memoriaOtra = obtenerMemoria(otro.widget);
            return Integer.compare(memoriaActual, memoriaOtra);
        }

        private int obtenerMemoria(Object widget) {
            if (widget instanceof InteractiveWidget) {
                return ((InteractiveWidget) widget).getMemoria();
            }
            return ((StaticWidget) widget).getMemoria();
        }
    }
        public void mostrarDashboard() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame ventana = new javax.swing.JFrame("Dashboard");
            ventana.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

            javax.swing.JPanel contenedor =
                    new javax.swing.JPanel(new java.awt.GridLayout(0, 2, 10, 10));

            for (Object widget : widgets) {
                javax.swing.JComponent vista;

                if (widget instanceof InteractiveWidget) {
                    vista = ((InteractiveWidget) widget).obtenerVista();
                } else {
                    vista = ((StaticWidget) widget).obtenerVista();
                }

                javax.swing.JPanel tarjeta =
                        new javax.swing.JPanel(new java.awt.BorderLayout());

                tarjeta.setBorder(
                        javax.swing.BorderFactory.createTitledBorder(obtenerTitulo(widget))
                );
                tarjeta.add(vista, java.awt.BorderLayout.CENTER);
                contenedor.add(tarjeta);
            }

            ventana.setContentPane(new javax.swing.JScrollPane(contenedor));
            ventana.setSize(800, 600);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}