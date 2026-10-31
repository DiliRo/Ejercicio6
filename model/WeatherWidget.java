package model;

import javax.swing.*;

public class WeatherWidget implements InteractiveWidget {
    private int id;
    private String titulo;
    private int memoria;
    private int temperatura;
    private char medidaTemperatura;

    public WeatherWidget(int id, String titulo, int memoria, int temperatura, char medidaTemperatura) {
        this.id = id;
        this.titulo = titulo;
        this.memoria = memoria;
        this.temperatura = temperatura;
        this.medidaTemperatura = medidaTemperatura;
    }

    // Overloading en caso de que todos los weather widgets tengan el mismo titulo
    public WeatherWidget(int id, int memoria, int temperatura, char medidaTemperatura) {
        this.id = id;
        this.memoria = memoria;
        this.temperatura = temperatura;
        this.medidaTemperatura = medidaTemperatura;
    }

    public int getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public char getMedidaTemperatura() {
        return this.medidaTemperatura;
    }

    public void setMedidaTemperatura(char medidaTemperatura) {
        this.medidaTemperatura = medidaTemperatura;
    }

    public void cambioTemperatura() {
        int temp = getTemperatura();

        if (this.medidaTemperatura == 'C') {
            int fahrenheit = (int) (temp * 1.8) + 32;
            setTemperatura(fahrenheit);
            setMedidaTemperatura('F');
        } else {
            int celcius = (int) ((temp - 32) / 1.8);
            setTemperatura(celcius);
            setMedidaTemperatura('C');
        }
    }

    @Override
    public void información() {
        System.out.println("Información");
    };

    @Override
    public void interactuar() {
        System.out.println("Mostrar Info");
    };

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getMemoria() {
        return this.memoria;
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
        JLabel etiqueta = new JLabel(
            "Temperatura: " + getTemperatura() + " °" + getMedidaTemperatura()
        );
        JButton boton = new JButton("Cambiar °C/°F");

        boton.addActionListener(e -> {
            cambioTemperatura();
            etiqueta.setText(
                "Temperatura: " + getTemperatura() + " °" + getMedidaTemperatura()
            );
        });

        panel.add(etiqueta);
        panel.add(boton);

        return panel;
    }
}