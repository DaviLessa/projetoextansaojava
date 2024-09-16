package com.extensaojava;

import java.util.List;

public class Professor{
    private String nome, cpf, rg, pis, localnasc, endereco, datanasc, valor, datapgto;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getPis() {
        return pis;
    }
    public void setPis(String pis) {
        this.pis = pis;
    }
    public String getLocalnasc() {
        return localnasc;
    }
    public void setLocalnasc(String localnasc) {
        this.localnasc = localnasc;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getDatanasc() {
        return datanasc;
    }
    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public String getDatapgto() {
        return datapgto;
    }
    public void setDatapgto(String datapgto) {
        this.datapgto = datapgto;
    }
    public Professor( String nome, String cpf, String rg, String pis, String localnasc, String datanasc, String endereco, String valor, String datapgto ) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.pis = pis;
        this.localnasc = localnasc;
        this.datanasc = datanasc;
        this.endereco = endereco;
        this.valor = valor;
        this.datapgto = datapgto;
    }

    public Professor buscaProfessor(String inputNomeCpf, List<Professor> professores){
        for (Professor professor : professores){
            if (professor.getNome().equalsIgnoreCase(inputNomeCpf) || professor.cpf.equals(inputNomeCpf))
            return professor;
        }
        return null;
    }
    
}