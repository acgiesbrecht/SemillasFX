/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "lab_muestras_semillas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LabMuestrasSemillas.findAll", query = "SELECT l FROM LabMuestrasSemillas l")
    ,
    @NamedQuery(name = "LabMuestrasSemillas.findById", query = "SELECT l FROM LabMuestrasSemillas l WHERE l.id = :id")
    ,
    @NamedQuery(name = "LabMuestrasSemillas.findByIdentificacionOriginal", query = "SELECT l FROM LabMuestrasSemillas l WHERE l.identificacionOriginal = :identificacionOriginal")
    ,
    @NamedQuery(name = "LabMuestrasSemillas.findByFechaEntrada", query = "SELECT l FROM LabMuestrasSemillas l WHERE l.fechaEntrada = :fechaEntrada")
    ,
    @NamedQuery(name = "LabMuestrasSemillas.findByZafra", query = "SELECT l FROM LabMuestrasSemillas l WHERE l.zafra = :zafra")
    ,
    @NamedQuery(name = "LabMuestrasSemillas.findByProcedencia", query = "SELECT l FROM LabMuestrasSemillas l WHERE l.procedencia = :procedencia")
    ,
    @NamedQuery(name = "LabMuestrasSemillas.findByMuestraOLote", query = "SELECT l FROM LabMuestrasSemillas l WHERE l.muestraOLote = :muestraOLote")
    ,
    @NamedQuery(name = "LabMuestrasSemillas.findByLotePeso", query = "SELECT l FROM LabMuestrasSemillas l WHERE l.lotePeso = :lotePeso")
    ,
    @NamedQuery(name = "LabMuestrasSemillas.findByLoteCantidadBolsas", query = "SELECT l FROM LabMuestrasSemillas l WHERE l.loteCantidadBolsas = :loteCantidadBolsas")
    ,
    @NamedQuery(name = "LabMuestrasSemillas.findByFechaMuestreo", query = "SELECT l FROM LabMuestrasSemillas l WHERE l.fechaMuestreo = :fechaMuestreo")})
public class LabMuestrasSemillas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "identificacion_original")
    private String identificacionOriginal;
    @Basic(optional = false)
    @Column(name = "fecha_entrada")
    private LocalDate fechaEntrada;
    @Column(name = "zafra")
    private String zafra;
    @Column(name = "procedencia")
    private String procedencia;
    @Basic(optional = false)
    @Column(name = "muestra_o_lote")
    private int muestraOLote;
    @Column(name = "lote_peso")
    private Integer lotePeso;
    @Column(name = "lote_cantidad_bolsas")
    private String loteCantidadBolsas;
    @Column(name = "fecha_muestreo")
    private LocalDate fechaMuestreo;
    @JoinColumn(name = "id_muestreador", referencedColumnName = "id")
    @ManyToOne
    private LabSemillasMuestreadores idMuestreador;
    @JoinColumn(name = "id_especie", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LabSemillasEspecies idEspecie;
    @JoinColumn(name = "id_cliente", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private LabClientes idCliente;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LabSemillasCategorias idCategoria;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "labMuestrasSemillas")
    private LabSemillasResultados labSemillasResultados;

    public LabMuestrasSemillas() {
    }

    public LabMuestrasSemillas(Integer id) {
        this.id = id;
    }

    public LabMuestrasSemillas(Integer id, LocalDate fechaEntrada, int muestraOLote) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.muestraOLote = muestraOLote;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacionOriginal() {
        return identificacionOriginal;
    }

    public void setIdentificacionOriginal(String identificacionOriginal) {
        this.identificacionOriginal = identificacionOriginal;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getZafra() {
        return zafra;
    }

    public void setZafra(String zafra) {
        this.zafra = zafra;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public int getMuestraOLote() {
        return muestraOLote;
    }

    public void setMuestraOLote(int muestraOLote) {
        this.muestraOLote = muestraOLote;
    }

    public Integer getLotePeso() {
        return lotePeso;
    }

    public void setLotePeso(Integer lotePeso) {
        this.lotePeso = lotePeso;
    }

    public String getLoteCantidadBolsas() {
        return loteCantidadBolsas;
    }

    public void setLoteCantidadBolsas(String loteCantidadBolsas) {
        this.loteCantidadBolsas = loteCantidadBolsas;
    }

    public LocalDate getFechaMuestreo() {
        return fechaMuestreo;
    }

    public void setFechaMuestreo(LocalDate fechaMuestreo) {
        this.fechaMuestreo = fechaMuestreo;
    }

    public LabSemillasMuestreadores getIdMuestreador() {
        return idMuestreador;
    }

    public void setIdMuestreador(LabSemillasMuestreadores idMuestreador) {
        this.idMuestreador = idMuestreador;
    }

    public LabSemillasEspecies getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(LabSemillasEspecies idEspecie) {
        this.idEspecie = idEspecie;
    }

    public LabClientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(LabClientes idCliente) {
        this.idCliente = idCliente;
    }

    public LabSemillasCategorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(LabSemillasCategorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    public LabSemillasResultados getLabSemillasResultados() {
        return labSemillasResultados;
    }

    public void setLabSemillasResultados(LabSemillasResultados labSemillasResultados) {
        this.labSemillasResultados = labSemillasResultados;
    }

    /*
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LabMuestrasSemillas)) {
            return false;
        }
        LabMuestrasSemillas other = (LabMuestrasSemillas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }*/
    @Override
    public String toString() {
        return "com.chortitzer.lab.semillas.LabMuestrasSemillas[ id=" + id + " ]";
    }

}
