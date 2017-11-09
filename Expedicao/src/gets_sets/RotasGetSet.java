/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gets_sets;

import java.util.List;

public class RotasGetSet {

    private Integer idCarga, idRota;
    private List<String> cidades;
    private String listaCidadeString;

    public String getListaCidadeString() {
        return listaCidadeString;
    }

    public void setListaCidadeString(String listaCidadeString) {
        this.listaCidadeString = listaCidadeString;
    }
    
    public Integer getIdRota() {
        return idRota;
    }

    public void setIdRota(Integer idRota) {
        this.idRota = idRota;
    }

    public Integer getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(Integer idCarga) {
        this.idCarga = idCarga;
    }

    public List<String> getCidades() {
        return cidades;
    }

    public void setCidades(List<String> cidades) {
        this.cidades = cidades;
    }

}
