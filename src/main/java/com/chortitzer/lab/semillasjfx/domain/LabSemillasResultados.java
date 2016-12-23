/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Industria
 */
@Entity
@Table(name = "lab_semillas_resultados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LabSemillasResultados.findAll", query = "SELECT l FROM LabSemillasResultados l")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByIdMuestra", query = "SELECT l FROM LabSemillasResultados l WHERE l.idMuestra = :idMuestra")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByFechaAnalisis", query = "SELECT l FROM LabSemillasResultados l WHERE l.fechaAnalisis = :fechaAnalisis")
    ,
    @NamedQuery(name = "LabSemillasResultados.findBySemillasPuras", query = "SELECT l FROM LabSemillasResultados l WHERE l.semillasPuras = :semillasPuras")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByMateriaInerteDescripcion1", query = "SELECT l FROM LabSemillasResultados l WHERE l.materiaInerteDescripcion1 = :materiaInerteDescripcion1")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByMateriaInerteValor1", query = "SELECT l FROM LabSemillasResultados l WHERE l.materiaInerteValor1 = :materiaInerteValor1")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByMateriaInerteDescripcion2", query = "SELECT l FROM LabSemillasResultados l WHERE l.materiaInerteDescripcion2 = :materiaInerteDescripcion2")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByMateriaInerteValor2", query = "SELECT l FROM LabSemillasResultados l WHERE l.materiaInerteValor2 = :materiaInerteValor2")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByOtrasSemillasDescripcion", query = "SELECT l FROM LabSemillasResultados l WHERE l.otrasSemillasDescripcion = :otrasSemillasDescripcion")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByOtrasSemillasValor", query = "SELECT l FROM LabSemillasResultados l WHERE l.otrasSemillasValor = :otrasSemillasValor")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByPlantasNormales", query = "SELECT l FROM LabSemillasResultados l WHERE l.plantasNormales = :plantasNormales")
    ,
    @NamedQuery(name = "LabSemillasResultados.findBySemillasDuras", query = "SELECT l FROM LabSemillasResultados l WHERE l.semillasDuras = :semillasDuras")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByPlantasAnormales", query = "SELECT l FROM LabSemillasResultados l WHERE l.plantasAnormales = :plantasAnormales")
    ,
    @NamedQuery(name = "LabSemillasResultados.findBySemillasMuertas", query = "SELECT l FROM LabSemillasResultados l WHERE l.semillasMuertas = :semillasMuertas")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByCantidadDias", query = "SELECT l FROM LabSemillasResultados l WHERE l.cantidadDias = :cantidadDias")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByHumedad", query = "SELECT l FROM LabSemillasResultados l WHERE l.humedad = :humedad")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByTemperatura", query = "SELECT l FROM LabSemillasResultados l WHERE l.temperatura = :temperatura")
    ,
    @NamedQuery(name = "LabSemillasResultados.findByTratamiento", query = "SELECT l FROM LabSemillasResultados l WHERE l.tratamiento = :tratamiento")
    ,
    @NamedQuery(name = "LabSemillasResultados.findBySustrato", query = "SELECT l FROM LabSemillasResultados l WHERE l.sustrato = :sustrato")
    ,
    @NamedQuery(name = "LabSemillasResultados.findBySemillasViables", query = "SELECT l FROM LabSemillasResultados l WHERE l.semillasViables = :semillasViables")})
public class LabSemillasResultados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_muestra")
    private Integer idMuestra;
    @Column(name = "fecha_analisis")
    private LocalDate fechaAnalisis;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "semillas_puras")
    private BigDecimal semillasPuras;
    @Column(name = "materia_inerte_descripcion_1")
    private String materiaInerteDescripcion1;
    @Column(name = "materia_inerte_valor_1")
    private BigDecimal materiaInerteValor1;
    @Column(name = "materia_inerte_descripcion_2")
    private String materiaInerteDescripcion2;
    @Column(name = "materia_inerte_valor_2")
    private BigDecimal materiaInerteValor2;
    @Column(name = "materia_inerte_descripcion_3")
    private String materiaInerteDescripcion3;
    @Column(name = "materia_inerte_valor_3")
    private BigDecimal materiaInerteValor3;
    @Column(name = "materia_inerte_descripcion_4")
    private String materiaInerteDescripcion4;
    @Column(name = "materia_inerte_valor_4")
    private BigDecimal materiaInerteValor4;
    @Column(name = "otras_semillas_descripcion")
    private String otrasSemillasDescripcion;
    @Column(name = "otras_semillas_valor")
    private BigDecimal otrasSemillasValor;
    @Column(name = "plantas_normales")
    private BigDecimal plantasNormales;
    @Column(name = "semillas_duras")
    private BigDecimal semillasDuras;
    @Column(name = "plantas_anormales")
    private BigDecimal plantasAnormales;
    @Column(name = "semillas_muertas")
    private BigDecimal semillasMuertas;
    @Column(name = "cantidad_dias")
    private Integer cantidadDias;
    @Column(name = "humedad")
    private BigDecimal humedad;
    @Column(name = "temperatura")
    private String temperatura;
    @Column(name = "tratamiento")
    private String tratamiento;
    @Column(name = "sustrato")
    private String sustrato;
    @Column(name = "semillas_viables")
    private BigDecimal semillasViables;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_muestra", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private LabMuestrasSemillas labMuestrasSemillas;

    public LabSemillasResultados() {
    }

    public LabSemillasResultados(Integer idMuestra) {
        this.idMuestra = idMuestra;
    }

    public Integer getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(Integer idMuestra) {
        this.idMuestra = idMuestra;
    }

    public LocalDate getFechaAnalisis() {
        return fechaAnalisis;
    }

    public void setFechaAnalisis(LocalDate fechaAnalisis) {
        this.fechaAnalisis = fechaAnalisis;
    }

    public BigDecimal getSemillasPuras() {
        return semillasPuras;
    }

    public void setSemillasPuras(BigDecimal semillasPuras) {
        this.semillasPuras = semillasPuras;
    }

    public String getMateriaInerteDescripcion1() {
        return materiaInerteDescripcion1;
    }

    public void setMateriaInerteDescripcion1(String materiaInerteDescripcion1) {
        this.materiaInerteDescripcion1 = materiaInerteDescripcion1;
    }

    public BigDecimal getMateriaInerteValor1() {
        return materiaInerteValor1;
    }

    public void setMateriaInerteValor1(BigDecimal materiaInerteValor1) {
        this.materiaInerteValor1 = materiaInerteValor1;
    }

    public String getMateriaInerteDescripcion2() {
        return materiaInerteDescripcion2;
    }

    public void setMateriaInerteDescripcion2(String materiaInerteDescripcion2) {
        this.materiaInerteDescripcion2 = materiaInerteDescripcion2;
    }

    public BigDecimal getMateriaInerteValor2() {
        return materiaInerteValor2;
    }

    public void setMateriaInerteValor2(BigDecimal materiaInerteValor2) {
        this.materiaInerteValor2 = materiaInerteValor2;
    }

    public String getOtrasSemillasDescripcion() {
        return otrasSemillasDescripcion;
    }

    public void setOtrasSemillasDescripcion(String otrasSemillasDescripcion) {
        this.otrasSemillasDescripcion = otrasSemillasDescripcion;
    }

    public BigDecimal getOtrasSemillasValor() {
        return otrasSemillasValor;
    }

    public void setOtrasSemillasValor(BigDecimal otrasSemillasValor) {
        this.otrasSemillasValor = otrasSemillasValor;
    }

    public BigDecimal getPlantasNormales() {
        return plantasNormales;
    }

    public void setPlantasNormales(BigDecimal plantasNormales) {
        this.plantasNormales = plantasNormales;
    }

    public BigDecimal getSemillasDuras() {
        return semillasDuras;
    }

    public void setSemillasDuras(BigDecimal semillasDuras) {
        this.semillasDuras = semillasDuras;
    }

    public BigDecimal getPlantasAnormales() {
        return plantasAnormales;
    }

    public void setPlantasAnormales(BigDecimal plantasAnormales) {
        this.plantasAnormales = plantasAnormales;
    }

    public BigDecimal getSemillasMuertas() {
        return semillasMuertas;
    }

    public void setSemillasMuertas(BigDecimal semillasMuertas) {
        this.semillasMuertas = semillasMuertas;
    }

    public Integer getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(Integer cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public BigDecimal getHumedad() {
        return humedad;
    }

    public void setHumedad(BigDecimal humedad) {
        this.humedad = humedad;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getSustrato() {
        return sustrato;
    }

    public void setSustrato(String sustrato) {
        this.sustrato = sustrato;
    }

    public BigDecimal getSemillasViables() {
        return semillasViables;
    }

    public void setSemillasViables(BigDecimal semillasViables) {
        this.semillasViables = semillasViables;
    }

    public LabMuestrasSemillas getLabMuestrasSemillas() {
        return labMuestrasSemillas;
    }

    public void setLabMuestrasSemillas(LabMuestrasSemillas labMuestrasSemillas) {
        this.labMuestrasSemillas = labMuestrasSemillas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMuestra != null ? idMuestra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LabSemillasResultados)) {
            return false;
        }
        LabSemillasResultados other = (LabSemillasResultados) object;
        if ((this.idMuestra == null && other.idMuestra != null) || (this.idMuestra != null && !this.idMuestra.equals(other.idMuestra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chortitzer.lab.semillas.LabSemillasResultados[ idMuestra=" + idMuestra + " ]";
    }

    /**
     * @return the materiaInerteDescripcion3
     */
    public String getMateriaInerteDescripcion3() {
        return materiaInerteDescripcion3;
    }

    /**
     * @param materiaInerteDescripcion3 the materiaInerteDescripcion3 to set
     */
    public void setMateriaInerteDescripcion3(String materiaInerteDescripcion3) {
        this.materiaInerteDescripcion3 = materiaInerteDescripcion3;
    }

    /**
     * @return the materiaInerteValor3
     */
    public BigDecimal getMateriaInerteValor3() {
        return materiaInerteValor3;
    }

    /**
     * @param materiaInerteValor3 the materiaInerteValor3 to set
     */
    public void setMateriaInerteValor3(BigDecimal materiaInerteValor3) {
        this.materiaInerteValor3 = materiaInerteValor3;
    }

    /**
     * @return the materiaInerteDescripcion4
     */
    public String getMateriaInerteDescripcion4() {
        return materiaInerteDescripcion4;
    }

    /**
     * @param materiaInerteDescripcion4 the materiaInerteDescripcion4 to set
     */
    public void setMateriaInerteDescripcion4(String materiaInerteDescripcion4) {
        this.materiaInerteDescripcion4 = materiaInerteDescripcion4;
    }

    /**
     * @return the materiaInerteValor4
     */
    public BigDecimal getMateriaInerteValor4() {
        return materiaInerteValor4;
    }

    /**
     * @param materiaInerteValor4 the materiaInerteValor4 to set
     */
    public void setMateriaInerteValor4(BigDecimal materiaInerteValor4) {
        this.materiaInerteValor4 = materiaInerteValor4;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
