/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Industria
 */
@Entity
@Table(name = "lab_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LabClientes.findAll", query = "SELECT l FROM LabClientes l")
    ,
    @NamedQuery(name = "LabClientes.findById", query = "SELECT l FROM LabClientes l WHERE l.id = :id")
    ,
    @NamedQuery(name = "LabClientes.findByNombre", query = "SELECT l FROM LabClientes l WHERE l.nombre = :nombre")
    ,
    @NamedQuery(name = "LabClientes.findByCtacte", query = "SELECT l FROM LabClientes l WHERE l.ctacte = :ctacte")
    ,
    @NamedQuery(name = "LabClientes.findByDireccion", query = "SELECT l FROM LabClientes l WHERE l.direccion = :direccion")
    ,
    @NamedQuery(name = "LabClientes.findByTelefono", query = "SELECT l FROM LabClientes l WHERE l.telefono = :telefono")
    ,
    @NamedQuery(name = "LabClientes.findByCedula", query = "SELECT l FROM LabClientes l WHERE l.cedula = :cedula")})
public class LabClientes implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String nombre;

    private Integer ctacte;

    private String direccion;

    private Integer telefono;

    private Integer cedula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<LabMuestrasSemillas> labMuestrasSemillasCollection;

    public LabClientes() {
    }

    public LabClientes(Integer id) {
        this.id = id;
    }

    public LabClientes(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic(optional = false)
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "CTACTE")
    public Integer getCtacte() {
        return ctacte;
    }

    public void setCtacte(Integer ctacte) {
        this.ctacte = ctacte;
    }

    @Column(name = "DIRECCION")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "TELEFONO")
    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @Column(name = "CEDULA")
    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    /*
    @XmlTransient
    public Collection<LabMuestrasSemillas> getLabMuestrasSemillasCollection() {
        return labMuestrasSemillasCollection;
    }

    public void setLabMuestrasSemillasCollection(Collection<LabMuestrasSemillas> labMuestrasSemillasCollection) {
        this.labMuestrasSemillasCollection = labMuestrasSemillasCollection;
    }
     */
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
        if (!(object instanceof LabClientes)) {
            return false;
        }
        LabClientes other = (LabClientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
     */
    @Override
    public String toString() {
        return nombre;
    }

}
