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
public interface MetodosCRUD <Generico>{
    public boolean create(Generico objeto);
    public boolean update(Generico objeto);
    public boolean delete(Object pk);
    
    public Generico read(Object pk);
    public List<Generico>readAll();
}
