package com.example.characterstore.model;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RICKANDMORTY")
public class PersonajeRickYMorty extends Producto{
	
    @Column(name = "estado", length = 40)
    private String estado;
    
    @Column(name = "especie", length = 40)
    private String especie;
    
    @Column(name = "tipo",length = 40)
    private String tipo;

    @Column(name = "genero",length = 40)
    private String genero;
    
    @Column(name = "origen",length = 60)
    private String origen;
    
    @Column(name = "locacion",length = 60)
   private String locacion;


    public PersonajeRickYMorty() {}

    @Override
    public String getDescripcionVenta() {
        String texto = (especie == null || especie.isBlank())
                ? "Sepa judas"
                : especie;
        return getNombre() + " - " + texto;
    }



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getLocacion() {
		return locacion;
	}

	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}

	@Override
    public String getAtributoPrincipal() {
        return (especie == null || especie.isBlank())
                ? "Por lo menos existe"
                : especie;
    }


}
