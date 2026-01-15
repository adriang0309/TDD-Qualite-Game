package com.example;

public class Cellule {
    private boolean vivante;

    public Cellule(boolean vivante) {
        this.vivante = vivante;
    }

    public boolean estVivante() {
        return vivante;
    }

    public void setVivante(boolean vivante) {
        this.vivante = vivante;
    }

    public Cellule evoluer(int voisines) {
        if (vivante) {
            // 2 ou 3 voisines : survit
            if (voisines == 2 || voisines == 3) {
                return new Cellule(true);
            // Sinon, morte
            } else {
                return new Cellule(false);
            }
        } else {
            // 3 voisines : naissance
            if (voisines == 3) {
                return new Cellule(true);
            // Sinon, reste morte
            } else {
                return new Cellule(false);
            }
        }
    }
}
