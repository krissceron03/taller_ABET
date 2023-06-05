import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaz_empleado extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtSueldo;
    private JButton btnRegistrar;
    private JTextField txtBuscaCedula;
    private JButton btnBuscarPorCedula;
    private JTextField txtCambioNombre;
    private JTextField txtCambioCedula;
    private JTextField txtCambioSueldo;
    private JButton btnModificar;
    private JTextArea taEmpleadosRegistrados;
    private JButton btnEliminar;
    private JButton limpiarButton;
    private JTextField txtApellido;
    private JTextField txtCorreo;
    private JTextField txtCambioCorreo;
    private JTextField txtCambioApellido;
    private JButton btnGuardarCambios;
    private JTextField txtCedulaSueldo;
    private JButton btnOkay;
    private JTextField txtSueldoActual;
    private JLabel textoSueldo;
    private JTextField txtBonos;
    private JTextField txtDescuentos;
    private JButton btnActualizarSueldo;
    private JTextField txtSueldoAct;
    private JButton cargarDatosPredeterminadosButton;
    private JButton visualizarButton;
    private mecanismo_empleado me ;
    private empleado emp;
    public interfaz_empleado(String titulo) {
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        txtCambioNombre.setEnabled(false);
        txtCambioApellido.setEnabled(false);
        txtCambioCedula.setEnabled(false);
        txtCambioCorreo.setEnabled(false);
        txtCambioSueldo.setEnabled(false);
        btnGuardarCambios.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);




        me= new mecanismo_empleado();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                me.registrarEmpleados(new empleado(txtNombre.getText(), txtApellido.getText(),Integer.parseInt(txtCedula.getText()), txtCorreo.getText(),Double.parseDouble(txtSueldo.getText())));
                JOptionPane.showMessageDialog(null,"Empleado registrado correctamente");
                taEmpleadosRegistrados.setText(me.toString());

            }

        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
        btnBuscarPorCedula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
                BuscaPorCedula(Integer.parseInt(txtBuscaCedula.getText()));


            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGuardarCambios.setEnabled(true);
                btnModificar.setEnabled(false);
                txtCambioNombre.setEnabled(true);
                txtCambioApellido.setEnabled(true);
                //txtCambioCedula.setEnabled(true);
                txtCambioCorreo.setEnabled(true);
                txtCambioSueldo.setEnabled(true);

            }
        });
        btnGuardarCambios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            me.ModificarDatos(txtCambioNombre.getText(), txtCambioApellido.getText(), Integer.parseInt(txtCambioCedula.getText()),
                    txtCambioCorreo.getText(),Double.parseDouble(txtCambioSueldo.getText()));
            JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
            limpiar();
                txtCambioNombre.setEnabled(false);
                txtCambioApellido.setEnabled(false);
                txtCambioCorreo.setEnabled(false);
                txtCambioSueldo.setEnabled(false);
                btnGuardarCambios.setEnabled(false);
                btnEliminar.setEnabled(false);


            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empleado ep=me.EliminarEmpleado(Integer.parseInt(txtBuscaCedula.getText()));
                if (ep!=null){
                    JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente");
                }
                limpiar();
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
            }
        });
        cargarDatosPredeterminadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                me.QuemarDatos();
                JOptionPane.showMessageDialog(null, "Datos cargados correctamente");

            }
        });
        btnOkay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscaPorCedula2(Integer.parseInt(txtCedulaSueldo.getText()));

            }
        });
        btnActualizarSueldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               double sueldoActualizado= me.ActualizarSueldos(Double.parseDouble(txtSueldoActual.getText()),Double.parseDouble(txtBonos.getText()),Double.parseDouble(txtDescuentos.getText()));
                System.out.println(sueldoActualizado);
                txtSueldoAct.setText(String.valueOf(sueldoActualizado));
                //taEmpleadosRegistrados.setText(emp.toString()+" Sueldo Actualizado: " + sueldoActualizado);
            }
        });
        visualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taEmpleadosRegistrados.setText(me.toString());

            }
        });
    }
private void BuscaPorCedula(int cedula){
        empleado empleadoEncontrado= me.BuscarPorCedula(cedula);
        if (empleadoEncontrado!=null){
            txtCambioNombre.setText(empleadoEncontrado.getNombre());
            txtCambioCedula.setText(String.valueOf(empleadoEncontrado.getCedula()));
            txtCambioSueldo.setText(String.valueOf(empleadoEncontrado.getSueldo()));
            txtCambioApellido.setText(empleadoEncontrado.getApellido());
            txtCambioCorreo.setText(empleadoEncontrado.getCorreo());
        }else {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado");
        }
}
private void BuscaPorCedula2(int cedula){
    empleado empleadoEncontrado= me.BuscarPorCedula(cedula);
    if (empleadoEncontrado!=null){
        txtSueldoActual.setText(String.valueOf(empleadoEncontrado.getSueldoTotal()));
    }else {
        JOptionPane.showMessageDialog(null, "Empleado no encontrado");
    }
}
    private void BuscaPorCedulaParaSueldo(int cedula){
        empleado empleadoEncontrado= me.BuscarPorCedula(cedula);
        if (empleadoEncontrado!=null){
            String sueldoFinal=String.valueOf(me.ActualizarSueldos(emp.getSueldoTotal(),Double.parseDouble(txtBonos.getText()),Double.parseDouble(txtDescuentos.getText())));
            taEmpleadosRegistrados.setText(emp.toString()+ " Sueldo Final (Bonos y/o Descuentos): " +sueldoFinal);
        }else {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado");
        }
    }
private void limpiar(){
    txtNombre.setText(null);
    txtCedula.setText(null);
    txtSueldo.setText(null);
    txtApellido.setText(null);
    txtCorreo.setText(null);
    //ventana modificar datos
    txtCambioNombre.setText(null);
    txtCambioApellido.setText(null);
    txtCambioCedula.setText(null);
    txtCambioCorreo.setText(null);
    txtCambioSueldo.setText(null);
    txtBuscaCedula.setText(null);

}

}
