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
@Table(name = "lab_semillas_especies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LabSemillasEspecies.findAll", query = "SELECT l FROM LabSemillasEspecies l"),
    @NamedQuery(name = "LabSemillasEspecies.findById", query = "SELECT l FROM LabSemillasEspecies l WHERE l.id = :id"),
    @NamedQuery(name = "LabSemillasEspecies.findByEspecie", query = "SELECT l FROM LabSemillasEspecies l WHERE l.especie = :especie"),
    @NamedQuery(name = "LabSemillasEspecies.findByVariedad", query = "SELECT l FROM LabSemillasEspecies l WHERE l.variedad = :variedad"),
    @NamedQuery(name = "LabSemillasEspecies.findByNombreComun", query = "SELECT l FROM LabSemillasEspecies l WHERE l.nombreComun = :nombreComun")})
public class LabSemillasEspecies implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "especie")
    private String especie;
    @Basic(optional = false)
    @Column(name = "variedad")
    private String variedad;
    @Basic(optional = false)
    @Column(name = "nombre_comun")
    private String nombreComun;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspecie")
    private Collection<LabMuestrasSemillas> labMuestrasSemillasCollection;

    public LabSemillasEspecies() {
    }

    public LabSemillasEspecies(Integer id) {
        this.id = id;
    }

    public LabSemillasEspecies(Integer id, String especie, String variedad, String nombreComun) {
        this.id = id;
        this.especie = especie;
        this.variedad = variedad;
        this.nombreComun = nombreComun;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    @XmlTransient
    public Collection<LabMuestrasSemillas> getLabMuestrasSemillasCollection() {
        return labMuestrasSemillasCollection;
    }

    public void setLabMuestrasSemillasCollection(Collection<LabMuestrasSemillas> labMuestrasSemillasCollection) {
        this.labMuestrasSemillasCollection = labMuestrasSemillasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LabSemillasEspecies)) {
            return false;
        }
        LabSemillasEspecies other = (LabSemillasEspecies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreComun;
    }
    
}
