package model;

public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        if (saldo >= 10000) {
            activa = true;
        } else {
            activa = false;
        }
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    @Override
    public String consignarDinero(float monto) {
         String mensaje="Su cuenta está inactiva";
        if (activa) {
            return super.consignarDinero(monto);
        }
        return mensaje;
    }

    public String retirarDinero(float monto) {
        String mensaje="Su cuenta está inactiva";
        if(activa){
            return super.retirarDinero(monto);
        }
        return mensaje;
    }

    public String extractoMens(){
        String mensaje="";
        int numRetirosExcedentes=getNumRetiros()-4;
        if(numRetirosExcedentes>0) {
            setSaldo(getSaldo() - (numRetirosExcedentes *1000));
        }
        if(getSaldo()>10000){
            mensaje="Su cuenta está activa";
        }else{
            mensaje="Cuenta inactiva";
        }
        return mensaje;
    }
    public void mostrarMensajeAhorros(){
        System.out.println("Saldo: "+ getSaldo()+"\n"+"comision mensual"+getComisionMens()+"\n"+"Número de transacciones realizadas: "+(getNumRetiros()+getNumConsignaciones()));;
    }


}
