/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chortitzer.lab.semillasjfx.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "lab_semillas_muestreadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LabSemillasMuestreadores.findAll", query = "SELECT l FROM LabSemillasMuestreadores l"),
    @NamedQuery(name = "LabSemillasMuestreadores.findById", query = "SELECT l FROM LabSemillasMuestreadores l WHERE l.id = :id"),
    @NamedQuery(name = "LabSemillasMuestreadores.findByNombre", query = "SELECT l FROM LabSemillasMuestreadores l WHERE l.nombre = :nombre")})
public class LabSemillasMuestreadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idMuestreador")
    private Collection<LabMuestrasSemillas> labMuestrasSemillasCollection;

    public LabSemillasMuestreadores() {
    }

    public LabSemillasMuestreadores(Integer id) {
        this.id = id;
    }

    public LabSemillasMuestreadores(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof LabSemillasMuestreadores)) {
            return false;
        }
        LabSemillasMuestreadores other = (LabSemillasMuestreadores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
