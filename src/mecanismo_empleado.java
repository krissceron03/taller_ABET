import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class mecanismo_empleado {
private List<empleado> listaEmpleados=new ArrayList<>();
private empleado emp;

public boolean registrarEmpleados(empleado e){
    if (BuscarPorCedula(e.getCedula())==null){
        listaEmpleados.add(e);
        return true;
    }else {
        return false;
    }
}
public empleado BuscarPorCedula(int cedula){
    for (empleado em: listaEmpleados) {
        if(em.getCedula()==cedula){
            return em;
        }
    }
    return null;
}
    public boolean ModificarDatos(String nombre, String apellido,int cedula, String correo, double sueldo) {
        empleado ep=BuscarPorCedula(cedula);
        if (ep!=null){
            ep.setApellido(apellido);
            ep.setNombre(nombre);
            ep.setCorreo(correo);
            ep.setSueldo(sueldo);
            return true;
        }
        return false;
    }
    public empleado EliminarEmpleado(int cedula){
        empleado ep;
        for (int i=0;i<listaEmpleados.size();i++){
            ep=listaEmpleados.get(i);
            if (ep.getCedula()==cedula){
                listaEmpleados.remove(i);
                return ep;
            }
        }
        return null;
    }
    public void QuemarDatos(){
    listaEmpleados.add(new empleado("Kristiany", "Cerón",1726349580,"krissceron@outlook.com",700));
        listaEmpleados.add(new empleado("Camila", "Vega",1721436507,"camivega@outlook.com",1000));
        listaEmpleados.add(new empleado("Juliana", "Vargas",1725397597,"julianavargas@outlook.com",800));
        listaEmpleados.add(new empleado("Mateo", "Encalada",1823459260,"mateoencalada@outlook.com",500));
        listaEmpleados.add(new empleado("Dylan", "Clerque",1745672345,"dylanclerque@outlook.com",600));
    }
public double ActualizarSueldos(int cedula, double sueldoTotal, double bonos, double descuentos){

    double sueldoFinal= sueldoTotal+bonos-descuentos;
    ActSueldos(cedula, sueldoFinal);
    //emp.setSueldoActualizado(sueldoFinal);
    return sueldoFinal;
}
    public boolean ActSueldos(int cedula, double sueldo) {
        empleado ep=BuscarPorCedula(cedula);
        if (ep!=null){
            ep.setSueldoActualizado(sueldo);
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Lista Empleados\n" + listaEmpleados;
    }
}
