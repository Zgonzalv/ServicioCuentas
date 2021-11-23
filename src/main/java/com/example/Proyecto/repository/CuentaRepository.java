package com.example.Proyecto.repository;

import com.example.Proyecto.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CuentaRepository{

    @Autowired
    CuentaRepositoryDao cuentaRepositoryDao;

    public void creacionCuenta(Cuenta cuenta) {
        cuentaRepositoryDao.save(cuenta);
    }
    private List<Cuenta> listaCuenta = new ArrayList<>();

    public Optional<Cuenta> getbyCbu(String cbu){
        return cuentaRepositoryDao.findById(cbu);
    }
}
