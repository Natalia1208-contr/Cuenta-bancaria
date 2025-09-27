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

    public float calcularExtractoMensual(){
        int numRetirosExcedentes=getNumRetiros()-4;
        float comision=0;
        if(numRetirosExcedentes>0) {
            comision=numRetirosExcedentes*1000;
            setSaldo(getSaldo() - comision);
        }
        setComisionMens(comision);
        if(getSaldo()>10000){
            activa=true;
        }else{
            activa=false;
        }
        return comision;
    }
    public void mostrarMensajeAhorros(){
        System.out.println("Saldo: "+ getSaldo()+"\n"+"comision mensual: "+getComisionMens()+"\n"+"Número de transacciones realizadas: "+(getNumRetiros()+getNumConsignaciones()));;
    }


}
