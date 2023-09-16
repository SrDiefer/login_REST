package com.pazbelloso.loginproject.editors;

import java.beans.PropertyEditorSupport;

public class NombreMayuculaEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(text.toUpperCase().trim());
    }
}
