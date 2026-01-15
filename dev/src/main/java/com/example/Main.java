package com.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
    private static final int GRID_WIDTH = 30;
    private static final int GRID_HEIGHT = 30;
    private static final int CELL_SIZE = 15;
    private static Grille grille;

    public Main() {
        setPreferredSize(new Dimension(GRID_WIDTH * CELL_SIZE, GRID_HEIGHT * CELL_SIZE));
        setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        grille = new Grille(GRID_WIDTH, GRID_HEIGHT);
        
        // Planeur
        grille.setCellule(5, 5, true);
        grille.setCellule(5, 6, true);
        grille.setCellule(5, 7, true);
        grille.setCellule(4, 7, true);
        grille.setCellule(3, 6, true);

        JFrame frame = new JFrame("Jeu de la Vie");
        Main panel = new Main();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {
            try {
                Thread.sleep(250);
                grille = grille.prochaineEtape();
                panel.repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (int i = 0; i < GRID_HEIGHT; i++) {
            for (int j = 0; j < GRID_WIDTH; j++) {
                if (grille.getCellule(i, j).estVivante()) {
                    g.setColor(Color.BLACK);
                    g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }
}