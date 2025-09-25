package model;

public class CuentaCorriente extends Cuenta {
    private float sobregiro;
    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.sobregiro=0;
    }

    public float getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
    }

    public String retirarDineroSobre(float monto){
       String mensaje="";
       if(monto<=getSaldo()){
           return super.retirarDinero(monto);
       }else{
           setSaldo(getSaldo()-monto);
           setSobregiro(getSaldo()-monto);
           mensaje="Retiro exitoso, tiene un sobregiro";
       }
        return mensaje;
    }

    public String consignarDinero(float monto){
        String mensaje="Consignación exitosa";
        super.consignarDinero(monto);
        if(getSobregiro()!=0){
            setSobregiro(getSobregiro()-monto);
        }
        return mensaje;
    }
    public float calcularExtractoMensual(){
        return super.calcularExtractoMensual();
    }

    public void mostrarMensajeCorriente(){
        System.out.println("Saldo: "+ getSaldo()+"\n"+"Comisión mensual"+getComisionMens()+"\n"+"Número de transacciones realizadas: "+(getNumRetiros()+getNumConsignaciones())+"\nSobregiro: "+getSobregiro());;
    }
}

