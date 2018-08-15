/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author axeLg
 */
public abstract interface IDAO<T> {
    public void insert (T t);
    public void remove (T t);
    public void remove (int id);
    public void update (T t);
    public List<T> getAll();
    public T getById(int id);
    public List<T> orderByName();
    
}
