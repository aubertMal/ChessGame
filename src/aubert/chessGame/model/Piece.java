package aubert.chessGame.model;

import java.nio.file.Path;
import java.util.List;

public class Piece {

    private String nom;
    private Couleur couleurPiece;
    private String image;

    public Piece(String nom, Couleur couleurPiece, String image) {
        this.nom = nom;
        this.couleurPiece = couleurPiece;
        this.image = image;
    }

    public List<Position> deplacementsPossibles(Position position){
        return null;
    }

    public String getNom() {
        return nom;
    }

    public Couleur getCouleurPiece() {
        return couleurPiece;
    }

    public String getImage() {
        return image;
    }
}
