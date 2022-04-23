import java.util.*;
import java.util.stream.Collectors;

public class Plan {

    private final String nombre;
    private final float deuda;
    private final int cuotas;
    
    ArrayList<Pago> pagos;

    public Plan(String nombre, float deuda, int cuotas) {
        this.nombre = nombre;
        this.deuda = deuda;
        this.cuotas = cuotas;
        this.pagos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public float getDeuda() {
        return deuda;
    }

    public int getCuotas() {
        return cuotas;
    }

    //Metodos:

    public void agregarPago(Pago pago){
        pagos.add(pago);
    }

    public boolean estaPagadoTotalmente(){
        if (pagos.size() == cuotas){
                return true;
        } else {
            return false;
        }
    }

    public String listadoDePagos() {
        StringBuilder salida = new StringBuilder();

        for (Pago pago : pagos) {
            salida.append(pago.toString() + "\n");
        }

        return salida.toString();
    }

    public float sumaInteresesCobrados() {
        float aux = 0f;
        for (Pago pago : pagos) {
            if (pago != null) {
                aux += pago.getInteresesAdicionales();
            }
        }
        return aux;
    }


    @Override
    public String toString() {
        return "Plan{" +
                "nombre='" + nombre + '\'' +
                ", deuda=" + deuda +
                ", cuotas=" + cuotas +
                '}';
    }

}
