import java.util.*;

class EstructurasDatosTarea {

    public static void main(String[] args) {
        String expresion = "((a + b) * (c - d))";
        System.out.println("Validando expresión: " + expresion);
        System.out.println("¿Es válida? " + validarParentesis(expresion));

        System.out.println("\n--- --- ---\n");
        Queue<String> colaProcesos = new LinkedList<>();
        colaProcesos.add("Proceso_Impresion");
        colaProcesos.add("Proceso_Calculo_Nomina");
        colaProcesos.add("Proceso_Renderizado");

        atenderProcesos(colaProcesos);
    }

    public static boolean validarParentesis(String s) {
        Stack<Character> pila = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                if (pila.isEmpty()) return false;
                pila.pop();
            }
        }
        return pila.isEmpty();
    }

    public static void atenderProcesos(Queue<String> cola) {
        System.out.println("Iniciando despacho de procesos...");
        while (!cola.isEmpty()) {
            String proceso = cola.poll();
            System.out.println("Atendiendo: " + proceso + " [OK]");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
        System.out.println("Todos los procesos han sido completados.");
    }
}