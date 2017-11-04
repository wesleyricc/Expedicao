/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gets_sets;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author comp16
 */
public class CargasGetSet {
    
    String Cliente, Rua, Cidade, Estado;
    Integer NFe, idCarga, Numero, idRota;
    List<Integer> itensCarga;
    List<CargasGetSet> itensNFe;
    List<String> formaTransporte;
    List<String> cidades_entrega = new ArrayList<>();
    
    
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

    public Integer getNumero() {
        return Numero;
    }

    public void setNumero(Integer Numero) {
        this.Numero = Numero;
    }

    public List<String> getCidades_entrega() {
        return cidades_entrega;
    }

    public void setCidades_entrega(List<String> cidades_entrega) {
        this.cidades_entrega = cidades_entrega;
    }

    public Integer getNFe() {
        return NFe;
    }

    public void setNFe(Integer NFe) {
        this.NFe = NFe;
    }


    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }


    public List<String> getFormaTransporte() {
        return formaTransporte;
    }

    public void setFormaTransporte(List<String> formaTransporte) {
        this.formaTransporte = formaTransporte;
    }


    public void setCidade(List<String> cidade) {
        this.cidades_entrega = cidade;
    }
    

    public List<CargasGetSet> getItensNFe() {
        return itensNFe;
    }

    public void setItensNFe(List<CargasGetSet> itensNFe) {
        this.itensNFe = itensNFe;
    }
    
    public List<Integer> getItensCarga() {
        return itensCarga;
    }

    public void setItensCarga(List<Integer> itensCarga) {
        this.itensCarga = itensCarga;
    }
    
    
    
    
    
    
}
