/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.List;

/**
 *
 * @author Duoc
 */
public interface MetodosCrud <Generico> {
    public boolean create(Generico objeto); // recibimos un objeto generico
    public boolean update(Generico objeto);// recibimos un objeto generico
    public boolean delete(Object pk);// recibimos una primary key
    
    public Generico read(Object pk); // retornamos un select con la primary  key
    public List<Generico> readAll(); // retornamos una lista generica
}
