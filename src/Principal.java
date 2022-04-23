import java.util.Optional;
import java.io.File;
import java.util.*;

public class Principal {
    static Municipalidad muni = new Municipalidad();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Opcion opciones[] = new Opcion[7];

        opciones[0] = new Opcion(1, "Registrar un nuevo plan", () -> altaPlan());
        opciones[1] = new Opcion(2, "Registrar un nuevo pago", () -> altaPago());
        opciones[2] = new Opcion(3, "Ver los pagos de un contribuyente en particular", () -> filtrarContribuyente());
        opciones[3] = new Opcion(4, "Ver cantidad de planes pagados", () -> verPlanesPagados());
        opciones[4] = new Opcion(5, "Ver sumatoria de deudas registradas", () -> verTotalDeudas());
        opciones[5] = new Opcion(6, "Ver promedio general de intereses adicionales", () -> verPromedioIntereses());
        opciones[6] = new Opcion(7, "Cerrar Sesion", null);

        System.out.println("Elija una opcion del menú: ");
        for (Opcion op : opciones) {
            System.out.println(op.getNumero() + "->  " + op.getTexto());
        }

        int choise = input.nextInt();
        if (choise == 7){
            System.out.println("\nSesion Finalizada ");
        }
        if (choise != 7) {
            for (Opcion op: opciones) {
                opciones[choise - 1].ejecutar();
                System.out.println("\nIngrese otra opcion: ");
                choise = input.nextInt();
            }
        }


    }

    private static void altaPlan() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese el nombre del contribuyente: ");
        String nombre = teclado.next();

        System.out.println("Ingrese la deuda: ");
        float deuda = teclado.nextFloat();

        System.out.println("Ingrese la cantidad de cuotas: ");
        int cuotas = teclado.nextInt();

        Plan p = new Plan(nombre, deuda, cuotas);

        muni.agregarPlan(p);
    }

    private static void altaPago() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("\nIngrese el nombre del contribuyente: ");
        String nombre = teclado.next();
        Plan plan = muni.filtrarPlanPorNombre(nombre);

        System.out.println("\nIngrese la demora (numero de dias despues del vencimiento): ");
        int demora = teclado.nextInt();

        System.out.println("\nIngrese el importe total pagado: ");
        float importe = teclado.nextFloat();

        Pago pago = new Pago(demora, importe);
        plan.agregarPago(pago);

    }

    private static void filtrarContribuyente() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nIngrese el nombre del contribuyente a buscar: ");
        String nombre = teclado.next();
        System.out.println(muni.listadoPagosContribuyente(nombre));
    }

    private static void verPlanesPagados() {
        System.out.println("Cantidad de planes pagados en su totalidad: " + muni.cantidadPlanesPagados());
    }

    private static void verTotalDeudas() {
        System.out.println("Suma de todas las deudas: " + muni.sumatoriaDeuda());
    }

    private static void verPromedioIntereses() {
        System.out.println("Promedio general de intereses: " + muni.promedioIntereses());
    }
}