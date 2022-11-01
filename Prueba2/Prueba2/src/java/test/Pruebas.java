/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.EquipoDAO;
import dao.JugadorDAO;
import dao.LigaDAO;
import dto.EquipoDTO;
import dto.JugadorDTO;
import dto.LigaDTO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Edd
 */
public class Pruebas {

    public static void main(String[] args) {
        JugadorDAO jug = new JugadorDAO();
        EquipoDAO equip = new EquipoDAO();
        LigaDAO lig = new LigaDAO();
//        System.out.println(lig.create(new LigaDTO(1, "ligitody", 'V', 1)));
//        System.out.println(lig.create(new LigaDTO(2, "ligamoratody", 'A', 1)));
//        System.out.println(lig.update(new LigaDTO(2, "momoratody", 'A', 1)));
//        LigaDTO ldto=lig.read(1);
//        System.out.println("Nombre: "+ldto.getNombre());
//        System.out.println(equip.create(new EquipoDTO(2, "Los tototo Tody", new Date(2010,2,1))));
        //System.out.println(equip.update(new EquipoDTO(2, "Los TOTOTODY", new Date(2011,2,1))));
//        EquipoDTO edto = equip.read(1);
//        System.out.println(edto.getNombre());
//        equip.delete(2);
//        ArrayList<EquipoDTO> equipos = (ArrayList<EquipoDTO>) equip.readAll();
//        for (EquipoDTO e : equipos) {
//            System.out.println("Nombre: " + e.getNombre());
//        }
//        System.out.println(jug.create(new JugadorDTO(4, "tody", "Atacante", 5, new Date(2011), 1)));
        //System.out.println(jug.update(new JugadorDTO(1, "moratody", "Tanque", 3, new Date(2012), 1)));
//        JugadorDTO jdto = jug.read(2);
//       ArrayList<JugadorDTO> jugadores = (ArrayList<JugadorDTO>) jug.readAll(1);
        //jug.delete(2);
//        for (JugadorDTO a : jugadores) {
//            System.out.println("Nombre: "+a.getNombre()+" posicion"+a.getPosicion());
//        }
        //System.out.println(jdto.getNombre());
    }
}
