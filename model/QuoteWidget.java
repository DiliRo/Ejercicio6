package model;
import javax.swing.*;
public class QuoteWidget implements StaticWidget{
    private int id;
    private String titulo;
    private int memoria;
    private String[] frases = new String[31];

    public QuoteWidget(int id, String titulo, int memoria){
        this.id = id;
        this.titulo = titulo;
        this.memoria = memoria;
        this.frases = new String[]{
            "La vida es lo que pasa mientras estás ocupado haciendo otros planes.",
            "El éxito es la suma de pequeños esfuerzos repetidos día tras día.",
            "No cuentes los días, haz que los días cuenten.",
            "La felicidad no es algo hecho. Viene de tus propias acciones.",
            "El único modo de hacer un gran trabajo es amar lo que haces.",
            "No importa cuán lento vayas, siempre y cuando no te detengas.",
            "La mejor manera de predecir el futuro es inventarlo.",
            "El fracaso es simplemente la oportunidad de comenzar de nuevo, esta vez de manera más inteligente.",
            "La vida es 10% lo que me ocurre y 90% cómo reacciono a ello.",
            "No busques el momento perfecto, busca el momento y hazlo perfecto.",
            "El éxito no es la clave de la felicidad. La felicidad es la clave del éxito.",
            "No importa lo que hagas, hazlo con pasión o no lo hagas en absoluto.",
            "La vida es demasiado corta para estar viviendo el sueño de otra persona.",
            "El único límite a nuestros logros de mañana está en nuestras dudas de hoy.",
            "No esperes. El tiempo nunca será justo.",
            "La vida no se trata de encontrarte a ti mismo, sino de crearte a ti mismo.",
            "El coraje no siempre ruge. A veces el coraje es la voz tranquila al final del día diciendo: 'Lo intentaré de nuevo mañana'.",
            "No hay atajos hacia cualquier lugar que valga la pena ir.",
            "La creatividad es inteligencia divirtiéndose.",
            "El éxito consiste en ir de fracaso en fracaso sin perder el entusiasmo.",
            "No importa cuántas veces fracases, solo necesitas acertar una vez.",
            "La vida es como montar en bicicleta. Para mantener el equilibrio, debes seguir adelante.",
            "El optimismo es la fe que conduce al logro. Nada puede realizarse sin esperanza y confianza.",
            "No te preocupes por los fracasos; preocúpate por las oportunidades que pierdes cuando ni siquiera lo intentas.",
            "La mejor manera de empezar algo es dejar de hablar y comenzar a hacerlo.",
            "El único lugar donde el éxito viene antes que el trabajo es en el diccionario.",
            "No importa lo lento que vayas mientras no te detengas.",
    };
    }

    public String getFrase(){
        int random = (int) (Math.random()*31)+1;
        String frase = frases[random];
        return frase;
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
        return new JPanel();
    }
}