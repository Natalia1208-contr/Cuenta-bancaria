package model;

public class Cuenta {
    private float saldo;
    private int numConsignaciones;
    private int numRetiros;
    private float tasaAnual;
    private float comisionMens;

    public Cuenta(float saldo, float tasaAnual){
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
        this.comisionMens = 0;
        this.numConsignaciones = 0;
        this.numRetiros = 0;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumConsignaciones() {
        return numConsignaciones;
    }

    public void setNumConsignaciones(int numConsignaciones) {
        this.numConsignaciones = numConsignaciones;
    }

    public int getNumRetiros() {
        return numRetiros;
    }

    public void setNumRetiros(int numRetiros) {
        this.numRetiros = numRetiros;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }

    public void setTasaAnual(float tasaAnual) {
        this.tasaAnual = tasaAnual;
    }

    public float getComisionMens() {
        return comisionMens;
    }

    public void setComisionMens(float comisionMens) {
        this.comisionMens = comisionMens;
    }

    public String consignarDinero(float monto){
        String mensaje="Monto ingresado incorrecto";
        if(monto>0) {
            saldo += monto;
            numConsignaciones++;
            mensaje="Consignación exitosa";
        }
        return mensaje;
    }

    public String retirarDinero(float monto){
        String mensaje="No es posible hacer el retiro";
        if(monto<=saldo&&monto>0){
            saldo=saldo-monto;
            numRetiros++;
            mensaje="Retiro exitoso";
        }
        return mensaje;
    }

    public float calcularIntMensual(){
        float interesMensual=(tasaAnual/12)/100;
        saldo+=saldo*interesMensual;
        return saldo;
    }
    public float calcularExtractoMensual(){
        float saldox=calcularIntMensual();
        saldo=saldox-comisionMens;
        return saldo;
    }

    public void mostrarInfo(){
        System.out.println("Saldo: "+saldo+"\n"+"Numero consignaciones: "+numConsignaciones+"\n"+"numero de retiros: "+numRetiros+"\n"+"Tasa anual "+tasaAnual+"\n"+"comision mensual: "+comisionMens);
    }
}
