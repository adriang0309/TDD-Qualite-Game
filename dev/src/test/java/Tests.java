import static org.junit.jupiter.api.Assertions.assertFalse;
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
}
