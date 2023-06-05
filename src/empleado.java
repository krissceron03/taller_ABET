public class empleado {
    private String nombre;
    private String apellido;
    private int cedula;
    private String correo;
    private double sueldo;
    private double aporte;
    private double impuesto;
    private double sueldoTotal;
    private double bonos;
    private double descuentos;


    public empleado(String nombre, String apellido, int cedula, String correo, double sueldo) {
        this.nombre = nombre;
        this.apellido=apellido;
        this.cedula = cedula;
        this.correo=correo;
        this.sueldo = sueldo;
        this.aporte = aporteAlSeguroSocial();
        this.impuesto = impuesto();
        this.sueldoTotal=sueldo-impuesto()-aporteAlSeguroSocial();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getAporte() {
        return aporte;
    }

    public void setAporte(double aporte) {
        this.aporte = aporte;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(double sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }

    public double getBonos() {
        return bonos;
    }

    public void setBonos(double bonos) {
        this.bonos = bonos;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public double aporteAlSeguroSocial(){
        double aporte= sueldo*(9.35/100);
        return aporte;
    }
    public double impuesto(){
        if (sueldo<=5000){
            impuesto=0;
        } else if (sueldo> 5000 && sueldo <=10000) {
            impuesto= (sueldo-5000)*(10/100);
        } else if (sueldo> 10000 && sueldo<=18000) {
            impuesto= (sueldo-10000)*(20/100);
        } else {
            impuesto=(sueldo-18000)*(30/100);
        }
        return impuesto;

    }

    @Override
    public String toString() {
        return "\nEmpleado:\n" +
                "Nombre: '" + nombre + ", Apellido: '" + apellido + ", Cedula: " + cedula + ", Correo: '" + correo  +
                "\nSueldo: " + sueldo + ", Aporte: " + aporte + ", Impuesto: " + impuesto + ", SueldoTotal: " + sueldoTotal;
    }
}
