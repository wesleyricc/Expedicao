package telas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author comp16
 */
public class gets_sets_cliente {
    
    private String textoCliente;
    private String textoEndereco;
    private String textoNumero;
    private String textoCidade;
    private String textoEstado;
    private String textoPais;

    public String getTextoCliente() {
        return textoCliente;
    }

    public void setTextoCliente(String textoCliente) {
        this.textoCliente = textoCliente;
    }

    public String getTextoEndereco() {
        return textoEndereco;
    }

    public void setTextoEndereco(String textoEndereco) {
        this.textoEndereco = textoEndereco;
    }

    public String getTextoNumero() {
        return textoNumero;
    }

    public void setTextoNumero(String textoNumero) {
        this.textoNumero = textoNumero;
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

    public String getTextoPais() {
        return textoPais;
    }

    public void setTextoPais(String textoPais) {
        this.textoPais = textoPais;
    }
    
     public String toString() {
        return "Cliente:\n\n" + "Nome: " + textoCliente + "\nEndereço: " + textoEndereco + "\nNumero: " + textoNumero + "\nCidade: " + textoCidade + "\nEstado:  " + textoEstado + "\nPaís: " + textoPais;
    }
    
    
}
