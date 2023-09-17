package com.pazbelloso.loginproject.services;

import com.pazbelloso.loginproject.models.domain.Pais;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PaisService {
    public List<Pais> listar();
    public Pais obtenerPorId(Integer id);

}
