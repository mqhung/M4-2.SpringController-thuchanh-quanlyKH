package service;

import java.util.List;

public interface IGeneralService<T>{
    List<T> showAll();
    T findById (int id);
    boolean update(T t);
    boolean save(T t, int id);
}
