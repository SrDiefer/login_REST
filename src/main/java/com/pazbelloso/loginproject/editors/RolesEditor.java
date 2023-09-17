package com.pazbelloso.loginproject.editors;

import com.pazbelloso.loginproject.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.beans.PropertyEditorSupport;

@Component
public class RolesEditor extends PropertyEditorSupport {


//    @Qualifier("roleServiceImpl")
    @Autowired
    private RoleService service;

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        try{
            Integer id = Integer.parseInt(text);
            setValue(service.obtenerPorId(id));
        }catch (NumberFormatException e){
            setValue(null);
        }
    }

}
