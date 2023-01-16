package co.com.choucair.certification.retotecnicochoucair.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Producto {
    private String nombreProducto;
    private String cantidadProducto;
    private String valorProducto;

    public Producto(@JsonProperty("nombreProducto") String nombreProducto,
                    @JsonProperty("cantidadProducto") String cantidadProducto,
                    @JsonProperty("valorProducto") String valorProducto) {
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.valorProducto = valorProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(String valorProducto) {
        this.valorProducto = valorProducto;
    }
}

