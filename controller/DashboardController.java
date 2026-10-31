package controller;

import model.Dashboard;
import view.DashboardView;

public class DashboardController {
    private final Dashboard modelo;
    private final DashboardView vista;

    public DashboardController(Dashboard modelo, DashboardView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        modelo.init();

        vista.setAccionesGlobales(
            this::ordenarPorMemoria,
            this::actualizarVista
        );

        actualizarVista();
        vista.setVisible(true);
    }

    private void ordenarPorMemoria() {
        modelo.ordenarPorMemoria();
        actualizarVista();
    }

    private void actualizarVista() {
        vista.mostrarWidgets(modelo.getWidgets());
    }
}