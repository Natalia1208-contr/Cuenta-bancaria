package aplicacion;
import model.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Cuenta Bancaria--------");
        Cuenta cuenta = new Cuenta(100000, 11);
        float interesMensual = cuenta.calcularIntMensual();
        String consignar= cuenta.consignarDinero(30000);
        String retiro=cuenta.retirarDinero(7000);
        String retiroU=cuenta.retirarDinero(5000);
        float calcularExtracto=cuenta.calcularExtractoMensual();
        cuenta.mostrarInfo();

        System.out.println("cuenta de ahorros--------");
        CuentaAhorros cuentaAhorros = new CuentaAhorros(1000000, 11);
        float interesMens = cuentaAhorros.calcularIntMensual();
        String consignarD= cuentaAhorros.consignarDinero(30000);
        String retiro1=cuentaAhorros.retirarDinero(20000);
        String retiro2=cuentaAhorros.retirarDinero(2000);
        String retiro3=cuentaAhorros.retirarDinero(4000);
        String retiro4=cuentaAhorros.retirarDinero(6000);
        String retiro5=cuentaAhorros.retirarDinero(3000);
        String retiro6=cuentaAhorros.retirarDinero(8000);
        float calcularExtractoM=cuentaAhorros.calcularExtractoMensual();
        cuentaAhorros.mostrarMensajeAhorros();

        System.out.println("cuenta corriente--------");
        CuentaCorriente cuentaCorriente = new CuentaCorriente(1000000f, 11f);
        float interesMensu = cuentaCorriente.calcularIntMensual();
        String consignarDin= cuentaCorriente.consignarDinero(3000f);
        String retiroUno=cuentaCorriente.retirarDineroSobre(720000f);
        String retiroDos=cuentaCorriente.retirarDineroSobre(300000f);
        String retiroTres=cuentaCorriente.retirarDineroSobre(4000f);
        float calcularExtractoMen=cuentaAhorros.calcularExtractoMensual();
        cuentaCorriente.mostrarMensajeCorriente();

    }
}




