/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1guia4universidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;

public class Eje1Guia4Universidad {

public static void main(String[] args) throws SQLException {
   try {
            // TODO code application logic here
            //Cargar driver de conexion
            Class.forName("org.mariadb.jdbc.Driver");
            
            //Conexion a la base de datos
            Connection conn=DriverManager.getConnection("jdbc:mariadb://localhost/eje1","root","");
            
//             String sql="insert into alumno(dni,apellido,nombre,fechaNacimiento,estado) "
//                     + "values (52745628,'Lopez','Juan','"+LocalDate.of(2000,Month.AUGUST,29)+"',true);";
//             String sql="insert into alumno(dni,apellido,nombre,fechaNacimiento,estado) "
//                     + "values (50789741,'Pastel','Sofia','"+LocalDate.of(2001,Month.JUNE,13)+"',true);";
//             String sql="insert into alumno(dni,apellido,nombre,fechaNacimiento,estado) "
//                     + "values (40789741,'Bal','Victoria','"+LocalDate.of(2000,Month.MAY,20)+"',true);";
//             PreparedStatement ps=conn.prepareStatement(sql);
//             int filas=ps.executeUpdate();
//             if(filas>0){
//               JOptionPane.showMessageDialog(null,"Alumna/o agregada/o Exitosamente");
//             }
//             String sql="insert into materia(nombre,año,estado) values ('Laboratorio 2', 2, true)";
//             String sql="insert into materia(nombre,año,estado) values ('Epis', 1, true)";
 //            String sql="insert into materia(nombre,año,estado) values ('Laboratorio', 1, true)";
//             String sql="insert into materia(nombre,año,estado) values ('Proyecto', 3, true)";
//            PreparedStatement ps=conn.prepareStatement(sql);
//            int filas=ps.executeUpdate();
//            if(filas>0){
//               JOptionPane.showMessageDialog(null,"Materia agregada Exitosamente");
//            }
//              String sql="insert into inscripcion(nota,id_alumno,id_materia) values(10,6,8)";
//              String sql="insert into inscripcion(nota,id_alumno,id_materia) values(8,6,5)";
//               String sql="insert into inscripcion(nota,id_alumno,id_materia) values(6,7,5)";
//              String sql="insert into inscripcion(nota,id_alumno,id_materia) values(10,7,6)";
//              String sql="insert into inscripcion(nota,id_alumno,id_materia) values(7,8,7)";
//               String sql="insert into inscripcion(nota,id_alumno,id_materia) values(7,8,8)";
//             PreparedStatement ps=conn.prepareStatement(sql);
//             int filas=ps.executeUpdate();
//             if(filas>0){
//               JOptionPane.showMessageDialog(null, "Inscripcion Exitosa");
//             }
      String sql="select * from alumno join inscripcion on alumno.id_alumno=inscripcion.id_alumno where nota>=8";
      PreparedStatement ps=conn.prepareStatement(sql);
      ResultSet resultado=ps.executeQuery();
      
      while(resultado.next()){
       System.out.println("Id "+resultado.getInt("id_alumno"));
       System.out.println("DNI "+resultado.getInt("dni"));
       System.out.println("Apellido "+resultado.getString("apellido"));
       System.out.println("Nombre "+resultado.getString("nombre"));
       System.out.println("Fecha de nacimiento "+resultado.getDate("fechaNacimiento"));
       System.out.println("Estado "+resultado.getBoolean("estado"));
   }
//         String sql="delete from inscripcion where id_alumno=6 and id_materia=5 limit 1";
//         PreparedStatement ps=conn.prepareStatement(sql);
//         int resultado=ps.executeUpdate();
//         int filas=ps.executeUpdate();
//             if(filas>0){
//             JOptionPane.showMessageDialog(null, "Desinscripcion Exitosa");   
//         }
              
            
    } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Debe agregar los driver al proyecto!!!");
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion");
    }
        
    }
    
}
