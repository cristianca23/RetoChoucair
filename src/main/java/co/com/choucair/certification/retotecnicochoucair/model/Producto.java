package co.com.choucair.certification.retotecnicochoucair.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Producto(@JsonProperty("nombreProducto") String nombreProducto, @JsonProperty("cantidadProducto") String cantidadProducto, @JsonProperty("valorProducto") String valorProducto) {

}
