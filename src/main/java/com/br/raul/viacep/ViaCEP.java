/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.raul.viacep;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author VRauuul
 */
public class ViaCEP extends ViaCEPBase {

    public ViaCEP() {
        super();
    }
    public ViaCEP(String cep) {
        super();
        this.buscar(cep);
    }

    @Override
    public void buscar(String cep) {

        String url = "http://viacep.com.br/ws/" + cep + "/json/";

        JSONObject obj;
        try {
            obj = new JSONObject(getHttpGET(url));
//            CEP novoCEP = new CEP(obj.getString("cep"),
//                    obj.getString("logradouro"),
//                    obj.getString("complemento"),
//                    obj.getString("bairro"),
//                    obj.getString("localidade"),
//                    obj.getString("uf"),
//                    obj.getString("ibge"),
//                    obj.getString("gia"));
           CEP novoCep = new CEP();
           novoCep.setCEP(obj.getString("cep"));
           novoCep.setRua(obj.getString("logradouro"));
           novoCep.setCEP(obj.getString("cep"));



            CEPs.add(novoCep);

            index = CEPs.size() - 1;
        } catch (IOException ex) {
            Logger.getLogger(ViaCEP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
