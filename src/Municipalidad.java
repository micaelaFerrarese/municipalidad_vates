import java.util.ArrayList;

public class Municipalidad {

    ArrayList<Plan> planes;

    public Municipalidad() {
        this.planes = new ArrayList<>();
    }
    //Metodos:

    public void agregarPlan(Plan p){
        planes.add(p);
    }
    public int cantidadPlanesPagados() {
        int aux = 0;
        for (Plan p: planes) {
            p.estaPagadoTotalmente();
            aux ++;
        }
        return aux;
    }

    public float sumatoriaDeuda() {
        float aux = 0f;
        for (Plan p : planes) {
            aux += p.getDeuda();
        }
        return aux;
    }

    public String listadoPagosContribuyente(String nombre) {
        String imprimir = "Listado para el Contribuyente : " + nombre;
        for (Plan p: planes) {
            p.getNombre().equals(nombre);
            imprimir = p.listadoDePagos();
        }
        return imprimir;
    }

    public float promedioIntereses() {
        float acu = 0f;
        int cont = 0;
        float prom = 0f;
        for (Plan p: planes) {
            acu += p.sumaInteresesCobrados();
            cont++;
        }
        prom = acu / cont;
        return prom;
    }

    public Plan filtrarPlanPorNombre(String nombre){
        return planes.stream().filter(plan -> plan.getNombre().equals(nombre)).findFirst().get();
    }



}




