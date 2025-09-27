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
           float nuevoSobreGiro=getSobregiro()+(monto-getSaldo());
           setSobregiro(nuevoSobreGiro);
           setSaldo(0);
           mensaje="Retiro exitoso, tiene un sobregiro por: "+getSobregiro();
           setNumRetiros(getNumRetiros()+1);
       }
        return mensaje;
    }

    public String consignarDinero(float monto){
        if(monto<=0){return"Monto ingresado incorrecto";}
        if(getSobregiro()>0){
            if(monto>=getSobregiro()) {
                float restante=monto-getSobregiro();
                setSobregiro(0);
                super.consignarDinero(restante);
            }else{
                setSobregiro(getSobregiro()-monto);
            }
        }else{
            super.consignarDinero(monto);
        }
        return "Consignación exitosa";
    }
    public float calcularExtractoMensual(){
        return super.calcularExtractoMensual();
    }

    public void mostrarMensajeCorriente(){
        System.out.println("Saldo: "+ getSaldo()+"\n"+"Comisión mensual"+getComisionMens()+"\n"+"Número de transacciones realizadas: "+(getNumRetiros()+getNumConsignaciones())+"\nSobregiro: "+getSobregiro());;
    }
}

