/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.raul.viacep;

/**
 *
 * @author VRauuul
 */
public class CEP {
    public String CEP;
    public String rua;
    public String bairro;
    public String cidade;
    public String UF;
    
    public CEP(){
        this.CEP = null;
        this.rua = null;
        this.bairro = null;
        this.cidade = null;
        this.UF = null;
    }
    
    public CEP(String CEP, String rua, String bairro, String cidade, String UF){
        this.CEP = CEP;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
    }

//    CEP(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
    
    

    
}
