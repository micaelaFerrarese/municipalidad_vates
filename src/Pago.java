public class Pago {

    private  int demora;
    private float importe;
    private float interesesAdicionales;

    public Pago(int demora, float importe) {
        this.demora = demora;
        this.importe = importe;
        if (demora == 0){
            this.interesesAdicionales = 0f;
        } else {
            this.interesesAdicionales = importe * (0.5f * demora);
        }
    }

    public int getDemora() {
        return demora;
    }

    public void setDemora(int demora) {
        this.demora = demora;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public float getInteresesAdicionales() {
        return interesesAdicionales;
    }

    public void setInteresesAdicionales(float interesesAdicionales) {
        this.interesesAdicionales = interesesAdicionales;
    }

    //Metodos

    
    @Override
    public String toString() {
        return "Pago{" +
                ", demora=" + demora +
                ", importe=" + importe +
                ", interesesAdicionales=" + interesesAdicionales +
                '}';
    }
}
