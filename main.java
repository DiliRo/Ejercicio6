import controller.DashboardController;
import javax.swing.SwingUtilities;
import model.Dashboard;
import view.DashboardView;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard modelo = new Dashboard();
            DashboardView vista = new DashboardView();
            DashboardController controlador =
                    new DashboardController(modelo, vista);

            controlador.iniciar();
        });
    }
}