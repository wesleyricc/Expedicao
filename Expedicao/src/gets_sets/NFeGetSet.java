package gets_sets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author comp16
 */
public class NFeGetSet {

    private Integer id_Nota_Fiscal, notasExistentes_cargas;
    private String textoCliente;
    private String textoLogradouro;
    private String textoCidade;
    private String textoEstado;
    
    public Integer getNotasExistentes_cargas() {
        return notasExistentes_cargas;
    }

    public void setNotasExistentes_cargas(Integer notasExistentes_cargas) {
        this.notasExistentes_cargas = notasExistentes_cargas;
    }

    public Integer getId_Nota_Fiscal() {
        return id_Nota_Fiscal;
    }

    public void setId_Nota_Fiscal(Integer id_Nota_Fiscal) {
        this.id_Nota_Fiscal = id_Nota_Fiscal;
    }

    public String getTextoCliente() {
        return textoCliente;
    }

    public void setTextoCliente(String textoCliente) {
        this.textoCliente = textoCliente;
    }

    public String getTextoLogradouro() {
        return textoLogradouro;
    }

    public void setTextoLogradouro(String textoEndereco) {
        this.textoLogradouro = textoEndereco;
    }

    public String getTextoCidade() {
        return textoCidade;
    }

    public void setTextoCidade(String textoCidade) {
        this.textoCidade = textoCidade;
    }

    public String getTextoEstado() {
        return textoEstado;
    }

    public void setTextoEstado(String textoEstado) {
        this.textoEstado = textoEstado;
    }

  

    public String toString() {
        return "Cliente:\n\n" + "Nome: " + textoCliente + "\nEndereço: " + textoLogradouro + "\nCidade: " + textoCidade + "\nEstado:  " + textoEstado;
    }

}
