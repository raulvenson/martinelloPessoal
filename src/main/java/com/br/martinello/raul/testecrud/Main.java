/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.martinello.raul.testecrud;

/**
 *
 * @author raul.venson
 */
public class Main {
    public static void main(String[] args) {
        
        //Esse main não serve pra mais nada, tudo pelo jform
        
        TestDAO testeDao = new TestDAO();
        
        Teste teste = new Teste();
        teste.setNomeEstado("Mato Grosso");
        teste.setRegiaoEstado("Centro-Oeste");
        
//        testeDao.save(teste);
        
    }
    
}
