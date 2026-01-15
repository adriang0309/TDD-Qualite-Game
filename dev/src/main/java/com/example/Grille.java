package com.example;

public class Grille {
    private Cellule[][] cellules;
    private int width;
    private int height;

    public Grille(int width, int height) {
        this.width = width;
        this.height = height;
        this.cellules = new Cellule[height][width];
        
        // Toutes les cellules sont mortes à la base
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cellules[i][j] = new Cellule(false);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cellule getCellule(int x, int y) {
        if (x >= 0 && x < height && y >= 0 && y < width) {
            return cellules[x][y];
        }
        return null;
    }

    public void setCellule(int x, int y, boolean vivante) {
        if (x >= 0 && x < height && y >= 0 && y < width) {
            cellules[x][y] = new Cellule(vivante);
        }
    }

    // Compter les voisines
    public int compterVoisines(int x, int y) {
        int nombreVoisines = 0;
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // On ne compte pas nous-même
                if (i == 0 && j == 0) continue;
                
                int newX = x + i;
                int newY = y + j;
                
                if (newX >= 0 && newX < height && newY >= 0 && newY < width) {
                    if (cellules[newX][newY].estVivante()) {
                        nombreVoisines++;
                    }
                }
            }
        }
        return nombreVoisines;
    }

    // Met à jour chaque cellule
    public Grille prochaineEtape() {
        Grille nouvelleGrille = new Grille(width, height);
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int voisines = compterVoisines(i, j);
                Cellule prochaineCellule = cellules[i][j].evoluer(voisines);
                nouvelleGrille.cellules[i][j] = prochaineCellule;
            }
        }
        
        return nouvelleGrille;
    }
}
