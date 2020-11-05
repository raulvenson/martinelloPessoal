/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.raul.viacep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VRauuul
 */
public abstract class ViaCEPBase {

    protected List<CEP> CEPs;
    protected int index;
    protected String currentCEP;

    public ViaCEPBase() {
        CEPs = new ArrayList<>();
        index = -1;
        currentCEP = "00000-000";
    }

    public abstract void buscar(String cep);

    

    public int getIndex() {
        return index;
    }

    public int getSize() {
        return CEPs.size();
    }
    
    public String getCep() {
        return CEPs.get(index).CEP;
    }
    
    public String getRua() {
        return CEPs.get(index).rua;
    }
    
    public String getBairro() {
        return CEPs.get(index).bairro;
    }
    
    public String getCidade() {
        return CEPs.get(index).cidade;
    }
    
    public String getUF() {
        return CEPs.get(index).UF;
    }

    public final String getHttpGET(String urlToRead) throws MalformedURLException, IOException {
        StringBuilder result = new StringBuilder();

        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }
}
