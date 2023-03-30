package com.jaimecorg.taller.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Reparacion {

    @Id
    @GeneratedValue
    private int codigo;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId("vehiculo_codigo")
    private Vehiculo vehiculo;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId("mecanico_codigo")
    private Mecanico mecanico;

    private Date fechaEntrada;
    private Date fechaSalida;
    private Float kilometrosSalida;
    private String descripcion;//Lo que le pasa al coche y lo que necesita (lo que dice el cliente que le pasa cuando lo trae)
    private String estado;
    private String observaciones;//Obervaciones del mecánico
    private Float precio;
    private boolean mecanicaGeneral;
    private boolean diagnostico;
    private boolean inyeccion;
    private boolean preItv;
    private boolean frenos;
    private boolean suspension;
    private boolean aceite;
    private boolean filtros;
    private boolean neumaticos;
    private boolean revisionOficial;
    private boolean matriculas;
    private boolean bateria;
    private boolean correas;
    private boolean chapaPintura;
    private boolean equilibradoAlineacion;
    private boolean sistemaEscape;
    private boolean climaticacion;
    private boolean electricidadElectronica;
    private boolean ventaRecambios;
 
    public Reparacion() {
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Float getKilometrosSalida() {
        return kilometrosSalida;
    }

    public void setKilometrosSalida(Float kilometrosSalida) {
        this.kilometrosSalida = kilometrosSalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isMecanicaGeneral() {
        return mecanicaGeneral;
    }

    public void setMecanicaGeneral(boolean mecanicaGeneral) {
        this.mecanicaGeneral = mecanicaGeneral;
    }

    public boolean isDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(boolean diagnostico) {
        this.diagnostico = diagnostico;
    }

    public boolean isInyeccion() {
        return inyeccion;
    }

    public void setInyeccion(boolean inyeccion) {
        this.inyeccion = inyeccion;
    }

    public boolean isPreItv() {
        return preItv;
    }

    public void setPreItv(boolean preItv) {
        this.preItv = preItv;
    }

    public boolean isFrenos() {
        return frenos;
    }

    public void setFrenos(boolean frenos) {
        this.frenos = frenos;
    }

    public boolean isSuspension() {
        return suspension;
    }

    public void setSuspension(boolean suspension) {
        this.suspension = suspension;
    }

    public boolean isAceite() {
        return aceite;
    }

    public void setAceite(boolean aceite) {
        this.aceite = aceite;
    }

    public boolean isFiltros() {
        return filtros;
    }

    public void setFiltros(boolean filtros) {
        this.filtros = filtros;
    }

    public boolean isNeumaticos() {
        return neumaticos;
    }

    public void setNeumaticos(boolean neumaticos) {
        this.neumaticos = neumaticos;
    }

    public boolean isRevisionOficial() {
        return revisionOficial;
    }

    public void setRevisionOficial(boolean revisionOficial) {
        this.revisionOficial = revisionOficial;
    }

    public boolean isMatriculas() {
        return matriculas;
    }

    public void setMatriculas(boolean matriculas) {
        this.matriculas = matriculas;
    }

    public boolean isBateria() {
        return bateria;
    }

    public void setBateria(boolean bateria) {
        this.bateria = bateria;
    }

    public boolean isCorreas() {
        return correas;
    }

    public void setCorreas(boolean correas) {
        this.correas = correas;
    }

    public boolean isChapaPintura() {
        return chapaPintura;
    }

    public void setChapaPintura(boolean chapaPintura) {
        this.chapaPintura = chapaPintura;
    }

    public boolean isEquilibradoAlineacion() {
        return equilibradoAlineacion;
    }

    public void setEquilibradoAlineacion(boolean equilibradoAlineacion) {
        this.equilibradoAlineacion = equilibradoAlineacion;
    }

    public boolean isSistemaEscape() {
        return sistemaEscape;
    }

    public void setSistemaEscape(boolean sistemaEscape) {
        this.sistemaEscape = sistemaEscape;
    }

    public boolean isClimaticacion() {
        return climaticacion;
    }

    public void setClimaticacion(boolean climaticacion) {
        this.climaticacion = climaticacion;
    }

    public boolean isElectricidadElectronica() {
        return electricidadElectronica;
    }

    public void setElectricidadElectronica(boolean electricidadElectronica) {
        this.electricidadElectronica = electricidadElectronica;
    }

    public boolean isVentaRecambios() {
        return ventaRecambios;
    }

    public void setVentaRecambios(boolean ventaRecambios) {
        this.ventaRecambios = ventaRecambios;
    }
    
}
