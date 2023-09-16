package com.pazbelloso.loginproject.services;

import com.pazbelloso.loginproject.models.domain.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoleServiceImpl implements RoleService{

    private List<Role> roles;

    public RoleServiceImpl() {
        this.roles = new ArrayList<>();
            this.roles.add(new Role(1, "Administrador", "ROLE_ADMIN"));
            this.roles.add(new Role(1, "Administrador", "ROLE_USER"));
            this.roles.add(new Role(1, "Administrador", "ROLE_MODERATOR"));
    }

    @Override
    public List<Role> listar() {
        return roles;
    }

    @Override
    public Role obtenerPorId(Integer id) {
        Role rolEncontrado =null;
        for(Role role: roles){
            if (id == role.getId());
            break;
        }
        return rolEncontrado;
    }
}
