package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dashboard {
    private final ArrayList<Object> widgets = new ArrayList<>();

    public void init() {
        widgets.clear();

        widgets.add(new WeatherWidget(1, "Clima 1", 20, 25, 'C'));
        widgets.add(new WeatherWidget(2, "Clima 2", 25, 30, 'C'));

        widgets.add(new AlertWidget(
            3, "Alerta 1", 15, "Revisar sistema", NivelPrioridad.ALTO
        ));
        widgets.add(new AlertWidget(
            4, "Alerta 2", 18, "Memoria baja", NivelPrioridad.MEDIO
        ));

        widgets.add(new QuoteWidget(5, "Frase 1", 10));
        widgets.add(new QuoteWidget(6, "Frase 2", 12));

        widgets.add(new ClockWidget(7, "Reloj 1", 8, LocalTime.now()));
        widgets.add(new ClockWidget(8, "Reloj 2", 8, LocalTime.now()));

        widgets.add(new ToDoWidget(9, "Tarea 1", 14, "Entregar proyecto"));
        widgets.add(new ToDoWidget(10, "Tarea 2", 14, "Estudiar Java"));
    }

    public List<Object> getWidgets() {
        return new ArrayList<>(widgets);
    }

    public boolean interactuarPorId(int id) {
        for (Object widget : widgets) {
            if (obtenerId(widget) == id && widget instanceof InteractiveWidget) {
                ((InteractiveWidget) widget).interactuar();
                return true;
            }
        }
        return false;
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

    private int obtenerId(Object widget) {
        if (widget instanceof InteractiveWidget) {
            return ((InteractiveWidget) widget).getId();
        }
        return ((StaticWidget) widget).getId();
    }

    private static int obtenerMemoria(Object widget) {
        if (widget instanceof InteractiveWidget) {
            return ((InteractiveWidget) widget).getMemoria();
        }
        return ((StaticWidget) widget).getMemoria();
    }

    private static class WidgetOrdenable implements Comparable<WidgetOrdenable> {
        private final Object widget;

        private WidgetOrdenable(Object widget) {
            this.widget = widget;
        }

        @Override
        public int compareTo(WidgetOrdenable otro) {
            return Integer.compare(
                obtenerMemoria(widget),
                obtenerMemoria(otro.widget)
            );
        }
    }
}