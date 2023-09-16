package com.pazbelloso.loginproject.services;

import com.pazbelloso.loginproject.models.domain.Pais;

import java.util.Arrays;
import java.util.List;

public class PaisServiceImpl implements PaisService{

    private List<Pais> lista;

    public PaisServiceImpl() {
        this.lista = Arrays.asList(
                new Pais(1,"ES","España"),
                new Pais(2,"MX","Mexico"),
                new Pais(3,"CL","Chile"),
                new Pais(4,"AR","Argentina"),
                new Pais(5,"PE","Perú"),
                new Pais(6,"CO","Colombia"),
                new Pais(7,"VE","Venezuela")

        );
    }

    @Override
    public List<Pais> listar() {
        return lista;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais paisEncontrado = null;
        for(Pais p: this.lista){
            if(id == p.getId()){
                paisEncontrado = p;
                break;
            }
        }
        return paisEncontrado;

    }
}