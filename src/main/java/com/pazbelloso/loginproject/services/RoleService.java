package com.pazbelloso.loginproject.services;

import com.pazbelloso.loginproject.models.domain.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


//@Service
public interface RoleService {
    public List<Role> listar();
    public Role obtenerPorId(Integer id);
}
