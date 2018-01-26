package com.DentApp.objects;

public class Clinica {
    private String id_clinica;
    private String nombre_clinica;
    private String nombre_propietario;
    private String direccion_clinica;
    private String telefono_clinica;
    private String email_clinica;
    private String habilitacion_clinica;

    public Clinica() {
    }

    public Clinica(String id_clinica, String nombre_clinica, String nombre_propietario, String direccion_clinica, String telefono_clinica, String email_clinica, String habilitacion_clinica) {
        this.id_clinica = id_clinica;
        this.nombre_clinica = nombre_clinica;
        this.nombre_propietario = nombre_propietario;
        this.direccion_clinica = direccion_clinica;
        this.telefono_clinica = telefono_clinica;
        this.email_clinica = email_clinica;
        this.habilitacion_clinica = habilitacion_clinica;
    }

    public String getId_clinica() {
        return id_clinica;
    }

    public void setId_clinica(String id_clinica) {
        this.id_clinica = id_clinica;
    }

    public String getNombre_clinica() {
        return nombre_clinica;
    }

    public void setNombre_clinica(String nombre_clinica) {
        this.nombre_clinica = nombre_clinica;
    }

    public String getNombre_propietario() {
        return nombre_propietario;
    }

    public void setNombre_propietario(String nombre_propietario) {
        this.nombre_propietario = nombre_propietario;
    }

    public String getDireccion_clinica() {
        return direccion_clinica;
    }

    public void setDireccion_clinica(String direccion_clinica) {
        this.direccion_clinica = direccion_clinica;
    }

    public String getTelefono_clinica() {
        return telefono_clinica;
    }

    public void setTelefono_clinica(String telefono_clinica) {
        this.telefono_clinica = telefono_clinica;
    }

    public String getEmail_clinica() {
        return email_clinica;
    }

    public void setEmail_clinica(String email_clinica) {
        this.email_clinica = email_clinica;
    }

    public String getHabilitacion_clinica() {
        return habilitacion_clinica;
    }

    public void setHabilitacion_clinica(String habilitacion_clinica) {
        this.habilitacion_clinica = habilitacion_clinica;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Clinica{");
        sb.append("id_clinica='").append(id_clinica).append('\'');
        sb.append(", nombre_clinica='").append(nombre_clinica).append('\'');
        sb.append(", nombre_propietario='").append(nombre_propietario).append('\'');
        sb.append(", direccion_clinica='").append(direccion_clinica).append('\'');
        sb.append(", telefono_clinica='").append(telefono_clinica).append('\'');
        sb.append(", email_clinica='").append(email_clinica).append('\'');
        sb.append(", habilitacion_clinica='").append(habilitacion_clinica).append('\'');
        sb.append('}').append(System.getProperty("line.separator"));
        return sb.toString();
    }
}
