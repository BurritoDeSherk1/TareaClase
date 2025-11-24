import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int limite;
        do {
            System.out.print("Ingresa el límite máximo de productos: ");
            limite = sc.nextInt();

            if (limite <= 0) {
                System.out.println("ERROR: El límite debe ser mayor que 0.");
            }
        } while (limite <= 0);


        int productosIngresados = 0;
        float totalIVA = 0;
        float totalIMC = 0;
        float totalVentas = 0;


        for (int i = 1; i <= limite; i++) {

            System.out.println(" Registro del producto " + i + " ---");

            sc.nextLine();


            System.out.print("Nombre del producto: ");
            String nombre = sc.nextLine();


            float precioBase;
            do {
                System.out.print("Precio base: ");
                precioBase = sc.nextFloat();

                if (precioBase <= 0) {
                    System.out.println("ERROR: El precio debe ser positivo.");
                }
            } while (precioBase <= 0);


            int aplicaIVA;
            do {
                System.out.print("¿Tiene IVA? (1 = sí, 0 = no): ");
                aplicaIVA = sc.nextInt();

                if (aplicaIVA != 0 && aplicaIVA != 1) {
                    System.out.println("ERROR: Solo se acepta 0 o 1.");
                }
            } while (aplicaIVA != 0 && aplicaIVA != 1);


            float iva = (aplicaIVA == 1) ? precioBase * 0.12f : 0;
            float imc = precioBase * 0.015f;
            float precioFinal = precioBase + iva + imc;


            productosIngresados++;
            totalIVA += iva;
            totalIMC += imc;
            totalVentas += precioFinal;


            System.out.println("Nombre: " + nombre);
            System.out.println("Precio base: $" + precioBase);
            System.out.println("IVA aplicado: $" + iva);
            System.out.println("IMC aplicado: $" + imc);
            System.out.println("Precio final: $" + precioFinal);
        }

        System.out.println("RESUMEN DEL DÍA");
        System.out.println("Productos ingresados:" + productosIngresados);
        System.out.println("Total recaudado en IVA: $" + totalIVA);
        System.out.println("Total recaudado en IMC: $" + totalIMC);
        System.out.println("Monto total de ventas: $" + totalVentas);

    }
}
