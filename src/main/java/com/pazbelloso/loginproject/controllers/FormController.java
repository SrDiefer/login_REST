package com.pazbelloso.loginproject.controllers;

import com.pazbelloso.loginproject.editors.NombreMayuculaEditor;
import com.pazbelloso.loginproject.editors.PaisPropertyEditor;
import com.pazbelloso.loginproject.editors.RolesEditor;
import com.pazbelloso.loginproject.models.domain.Pais;
import com.pazbelloso.loginproject.models.domain.Role;
import com.pazbelloso.loginproject.models.domain.Usuario;
import com.pazbelloso.loginproject.services.PaisService;
import com.pazbelloso.loginproject.services.RoleService;
import com.pazbelloso.loginproject.validation.UsuarioValidador;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @Autowired
    private PaisService paisService;

    @Autowired
    private PaisPropertyEditor paisEditor;

    @Autowired
    private RolesEditor roleEditor;

    @Autowired
    private RoleService roleService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validador);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "fechaNacimiento",
                new CustomDateEditor(dateFormat, true));

        binder.registerCustomEditor(String.class, "nombre", new NombreMayuculaEditor());
        binder.registerCustomEditor(String.class, "apellido", new NombreMayuculaEditor());

        binder.registerCustomEditor(Pais.class, "pais", paisEditor);
        binder.registerCustomEditor(Role.class, "roles", roleEditor);

    }

    @ModelAttribute("genero")
    public List<String> genero(){
        return Arrays.asList("Hombre", "Mujer");}

    @ModelAttribute("listaRoles")
    public List<Role> listaRoles(){
        return this.roleService.listar();
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises(){
        return paisService.listar();
    }

    @ModelAttribute("listaRolesString")
    public List<String> listaRolesString(){
            List<String> roles = new ArrayList<>();
            roles.add("ROLE_ADMIN");
            roles.add("ROLE_USER");
            roles.add("ROLE_MODERATOR");

        return  roles;
    }

    @ModelAttribute("listaRolesMap")
    public Map<String, String> listaRolesMap(){
        Map<String,String> roles =new HashMap<>();
        roles.put("ROLE_ADMIN", "Administrador");
        roles.put("ROLE_USER", "Usuario");
        roles.put("ROLE_MODERATOR", "Moderador");
        return roles;
    }
    @ModelAttribute("paises")
    public List<String> paises(){
        return Arrays.asList("España", "México", "Chile", "Argentina", "Perú", "Colombia", "Venezuela");
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap(){
        Map<String, String> paises =new HashMap<>();
        paises.put("ES", "España");
        paises.put("MX", "México");
        paises.put("CH", "Chile");
        paises.put("AR", "Argentina");
        paises.put("CO", "Colombia");
        paises.put("VE", "Venezuela");
        return paises;
    }

    @GetMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("John");
        usuario.setApellido("Doe");
        usuario.setIdentificador("123.456.789-K");
        usuario.setHabilitar(true);
        usuario.setValorSecreto("Algun Valor Secreto");
        usuario.setPais(new Pais(3, "CL", "Chile"));
        usuario.setRoles(Arrays.asList(new Role(2, "usuario", "ROLE_USER")));
        usuario.setCuenta(2);

        model.addAttribute("titulo", "FORMULARIO DE USUARIOS");
        model.addAttribute("usuario", usuario);

        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model){
        //validador.validate(usuario, result);

        if (result.hasErrors()){
            model.addAttribute("titulo", "RESULTADO FORM");
            model.addAttribute("usuario", usuario);
            return "form";
        }
        return "redirect:/ver";
    }

    @GetMapping("/ver")
    public String ver(@SessionAttribute(name = "usuario", required = false) Usuario usuario, Model model,
                      SessionStatus status){
        if (usuario == null){
            return "redirect:/form";
        }

        model.addAttribute("titulo", "RESULTADO FORM");
        status.setComplete();
        return "resultado";
    }




}
