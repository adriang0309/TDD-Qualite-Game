import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.Cellule;
import com.example.Grille;

public class Tests {
    
    @Test // Pas assez de voisines : morte
    public void cellShouldDieIfNotEnoughNeighbors() {
        Grille grille = new Grille(3,3);

        // Grille test
        grille.setCellule(0,0, false);
        grille.setCellule(1,0, false);
        grille.setCellule(2,0, false);

        grille.setCellule(0,1, false);
        grille.setCellule(1,1, true);
        grille.setCellule(2,1, false);

        grille.setCellule(0,2, false);
        grille.setCellule(1,2, false);
        grille.setCellule(2,2, false);

        grille = grille.prochaineEtape();

        Cellule celluleTest = grille.getCellule(1, 1);
        assertFalse(celluleTest.estVivante(), "Une cellule vivante avec moins de 2 voisins devrait mourir");
    }

    @Test // Trop de voisines : mortes
    public void cellShouldDieIfTooMuchNeighbors() {
        Grille grille = new Grille(3,3);

        // Grille test, 4 voisins
        grille.setCellule(0,0, true);
        grille.setCellule(1,0, true);
        grille.setCellule(2,0, true);

        grille.setCellule(0,1, true);
        grille.setCellule(1,1, true);
        grille.setCellule(2,1, false);

        grille.setCellule(0,2, false);
        grille.setCellule(1,2, false);
        grille.setCellule(2,2, false);

        grille = grille.prochaineEtape();

        Cellule celluleTest = grille.getCellule(1, 1);
        
        assertFalse(celluleTest.estVivante(), "Une cellule vivante avec plus de 3 voisins devrait mourir");
    }

    @Test // Morte et exactement 3 voisines : naissance
    public void cellShouldBornIfThreeNeighbors() {
        Grille grille = new Grille(3,3);

        // Grille test
        grille.setCellule(0,0, true);
        grille.setCellule(1,0, true);
        grille.setCellule(2,0, true);

        grille.setCellule(0,1, false);
        grille.setCellule(1,1, false);
        grille.setCellule(2,1, false);

        grille.setCellule(0,2, false);
        grille.setCellule(1,2, false);
        grille.setCellule(2,2, false);

        grille = grille.prochaineEtape();

        Cellule celluleTest = grille.getCellule(1, 1);

        assertTrue(celluleTest.estVivante(), "Une cellule morte avec 3 voisins devrait naître");
    }

    @Test // Vivante avec 2 voisines : survie
    public void cellShouldStayAliveIfTwoNeighbors() {
        Grille grille = new Grille(3,3);

        // Grille test, 2 voisins
        grille.setCellule(0,0, true);
        grille.setCellule(1,0, true);
        grille.setCellule(2,0, false);

        grille.setCellule(0,1, false);
        grille.setCellule(1,1, true);
        grille.setCellule(2,1, false);

        grille.setCellule(0,2, false);
        grille.setCellule(1,2, false);
        grille.setCellule(2,2, false);

        grille = grille.prochaineEtape();

        Cellule celluleTest = grille.getCellule(1, 1);

        assertTrue(celluleTest.estVivante(), "Une cellule vivante avec 2 voisins devrait survivre");
    }

    @Test // Vivante avec 3 voisines : survie
    public void cellShouldStayAliveIfThreeNeighbors() {
        Grille grille = new Grille(3,3);

        // Grille test, 3 voisins
        grille.setCellule(0,0, true);
        grille.setCellule(1,0, true);
        grille.setCellule(2,0, true);

        grille.setCellule(0,1, false);
        grille.setCellule(1,1, true);
        grille.setCellule(2,1, false);

        grille.setCellule(0,2, false);
        grille.setCellule(1,2, false);
        grille.setCellule(2,2, false);

        grille = grille.prochaineEtape();

        Cellule celluleTest = grille.getCellule(1, 1);

        assertTrue(celluleTest.estVivante(), "Une cellule vivante avec 3 voisins devrait survivre");
    }
}
