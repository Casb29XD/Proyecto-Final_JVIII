package co.edu.uniquindio.proyecto_final.proyecto_final.utils;

import co.edu.uniquindio.proyecto_final.proyecto_final.model.Empleado;
import co.edu.uniquindio.proyecto_final.proyecto_final.model.Sgre;

import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {
    public static final String RUTA_ARCHIVO_CLIENTES = "src/main/resources/persistencia/archivoClientes.txt";
    public static final String RUTA_ARCHIVO_EMPLEADOS = "src/main/resources/persistencia/archivoEmpleados.txt";
    public static final String RUTA_ARCHIVO_USUARIOS = "/src/main/resources/persistencia/archivoUsuarios.txt";
    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/persistencia/log/BancoLog.txt";
    public static final String RUTA_ARCHIVO_OBJETOS = "co.edu.uniquindio.programacion3/src/main/resources/persistencia/archivoObjetos.txt";
    public static final String RUTA_ARCHIVO_MODELO_BANCO_BINARIO = "src/main/resources/persistencia/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_BANCO_XML = "src/main/resources/persistencia/model.xml";


    public static void cargarDatosArchivos(Sgre sgre) throws FileNotFoundException, IOException {
        //cargar archivo de clientes
       /* ArrayList<Cliente> clientesCargados = cargarClientes();
        if(clientesCargados.size() > 0)
            banco.getListaClientes().addAll(clientesCargados);
*/
        //cargar archivos empleados
        List<Empleado> empleadosCargados = cargarEmpleados();
        if(empleadosCargados.size() > 0)
            sgre.getEmpleados().addAll(empleadosCargados);

        //cargar archivo transcciones

        //cargar archivo empleados

        //cargar archivo prestamo

    }


    ////crud Empleados
    public static void guardarEmpleados(List<Empleado> listaEmpleados) throws IOException {
        FileWriter fw = new FileWriter(RUTA_ARCHIVO_EMPLEADOS);
        BufferedWriter bfw = new BufferedWriter(fw);
        for (Empleado empleado : listaEmpleados) {
            bfw.write(empleado.getId() + "@@" + empleado.getNombre() + "@@" + empleado.getCorreo() + "\n");
        }
        bfw.close();
        fw.close();
    }

    public static List<Empleado> cargarEmpleados() throws IOException {
        List<Empleado> empleados = new ArrayList<>();
        FileReader fr = new FileReader(RUTA_ARCHIVO_EMPLEADOS);
        BufferedReader bfr = new BufferedReader(fr);
        String linea;
        while ((linea = bfr.readLine()) != null) {
            String[] partes = linea.split("@@");
            if (partes.length == 3) {
                Empleado empleado = new Empleado();
                empleado.setId(partes[0]);
                empleado.setNombre(partes[1]);
                empleado.setCorreo(partes[2]);
                empleados.add(empleado);
            }
        }
        bfr.close();
        fr.close();
        return empleados;
    }
    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }


    //------------------------------------SERIALIZACIÓN  y XML

    public static Sgre cargarRecursoSgreBinario() {
        Sgre sgre = null;
        try {
            sgre = (Sgre) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sgre;
    }

    public static void guardarRecursoSgreBinario(Sgre sgre) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO_MODELO_BANCO_BINARIO));
            oos.writeObject(sgre);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Sgre cargarRecursosSgreXML() {
        Sgre sgre = null;
        try {
            sgre = (Sgre) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sgre;
    }

    public static void guardarRecursoSgreXML(Sgre sgre) {
        try {
            XMLEncoder codificadorXML = new XMLEncoder(new FileOutputStream(RUTA_ARCHIVO_MODELO_BANCO_XML));
            codificadorXML.writeObject(sgre);
            codificadorXML.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
