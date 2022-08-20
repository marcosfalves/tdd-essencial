package com.algaworks.passagem.builders;

import com.algaworks.passagem.model.Voo;

public class VooBuilder {

    private Voo voo;

    public VooBuilder comOrigemDestino(double preco) {
        voo = new Voo("São Paulo", "Rio de Janeiro", preco);
        return this;
    }

    public Voo build(){
        return voo;
    }

}
