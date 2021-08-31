package com.canteko.helloworld;
import java.util.Objects;

public class Averia {
    private String titulo;
    private String modeloCoche;
    private String urlFoto;
    private int numeroPresupuestos;

    public Averia() {
    }

    public Averia(String titulo, String modeloCoche, String urlFoto, int numeroPresupuestos) {
        this.titulo = titulo;
        this.modeloCoche = modeloCoche;
        this.urlFoto = urlFoto;
        this.numeroPresupuestos = numeroPresupuestos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getModeloCoche() {
        return modeloCoche;
    }

    public void setModeloCoche(String modeloCoche) {
        this.modeloCoche = modeloCoche;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getNumeroPresupuestos() {
        return numeroPresupuestos;
    }

    public void setNumeroPresupuestos(int numeroPresupuestos) {
        this.numeroPresupuestos = numeroPresupuestos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Averia averia = (Averia) o;
        return numeroPresupuestos == averia.numeroPresupuestos && Objects.equals(titulo, averia.titulo) && Objects.equals(modeloCoche, averia.modeloCoche) && Objects.equals(urlFoto, averia.urlFoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, modeloCoche, urlFoto, numeroPresupuestos);
    }

    @Override
    public String toString() {
        return "Averia{" +
                "titulo='" + titulo + '\'' +
                ", modeloCoche='" + modeloCoche + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                ", numeroPresupuestos=" + numeroPresupuestos +
                '}';
    }
}
