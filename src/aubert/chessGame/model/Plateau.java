package aubert.chessGame.model;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private List<Piece> piecesNoires;
    private List<Piece> piecesBlanches;
    private List<Case> cases;
    private List<Position> positionsEchiqiers = new ArrayList<>();

    public List<Case> getCases() {
        return cases;
    }

    public Plateau(List<Piece> piecesNoires, List<Piece> piecesBlanches, List<Case> cases) {
        this.piecesNoires = piecesNoires;
        this.piecesBlanches = piecesBlanches;
        this.cases = cases;
    }

    /**
     * Initialise la plateau pour une nouvelle partie
     * Définition des Positions, Pièces blanches, Pièces noires, Cases de l'échiquier
     */
    public void initPlateau(){

        initPositions();
        initPiecesBlanches();
        initPiecesNoires();
        initCases();
    }

    /**
     * Définit la liste des pièces blanches
     */
    private void initPiecesBlanches() {
        piecesBlanches.add(IndexPieceBlanche.TOUR.getIndexPieceBlanche(),new Tour("Tour",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_rook.png"));
        piecesBlanches.add(IndexPieceBlanche.CAVALIER1.getIndexPieceBlanche(), new Cavalier("Cavalier",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_knight.png"));
        piecesBlanches.add(IndexPieceBlanche.FOU1.getIndexPieceBlanche(), new Fou("Fou",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_bishop.png"));
        piecesBlanches.add(IndexPieceBlanche.DAME.getIndexPieceBlanche(), new Dame("Dame",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_queen.png"));
        piecesBlanches.add(IndexPieceBlanche.ROI.getIndexPieceBlanche(), new Roi("Roi",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_king.png"));
        piecesBlanches.add(IndexPieceBlanche.FOU2.getIndexPieceBlanche(), new Fou("Fou",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_bishop.png"));
        piecesBlanches.add(IndexPieceBlanche.CAVALIER2.getIndexPieceBlanche(), new Cavalier("Cavalier",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_knight.png"));
        piecesBlanches.add(IndexPieceBlanche.TOUR2.getIndexPieceBlanche(), new Tour("Tour",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_rook.png"));

        piecesBlanches.add(IndexPieceBlanche.PION1.getIndexPieceBlanche(), new Pion("Pion",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_pawn.png"));
        piecesBlanches.add(IndexPieceBlanche.PION2.getIndexPieceBlanche(), new Pion("Pion",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_pawn.png"));
        piecesBlanches.add(IndexPieceBlanche.PION3.getIndexPieceBlanche(), new Pion("Pion",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_pawn.png"));
        piecesBlanches.add(IndexPieceBlanche.PION4.getIndexPieceBlanche(), new Pion("Pion",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_pawn.png"));
        piecesBlanches.add(IndexPieceBlanche.PION5.getIndexPieceBlanche(), new Pion("Pion",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_pawn.png"));
        piecesBlanches.add(IndexPieceBlanche.PION6.getIndexPieceBlanche(), new Pion("Pion",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_pawn.png"));
        piecesBlanches.add(IndexPieceBlanche.PION7.getIndexPieceBlanche(), new Pion("Pion",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_pawn.png"));
        piecesBlanches.add(IndexPieceBlanche.PION8.getIndexPieceBlanche(), new Pion("Pion",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_pawn.png"));
    }

    /**
     * Définit la liste des pièces noires
     */
    private void initPiecesNoires() {

        piecesNoires.add(IndexPieceNoire.PION1.getIndexPieceNoire(),new Pion("Pion",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_pawn.png"));
        piecesNoires.add(IndexPieceNoire.PION2.getIndexPieceNoire(),new Pion("Pion",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_pawn.png"));
        piecesNoires.add(IndexPieceNoire.PION3.getIndexPieceNoire(),new Pion("Pion",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_pawn.png"));
        piecesNoires.add(IndexPieceNoire.PION4.getIndexPieceNoire(),new Pion("Pion",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_pawn.png"));
        piecesNoires.add(IndexPieceNoire.PION5.getIndexPieceNoire(),new Pion("Pion",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_pawn.png"));
        piecesNoires.add(IndexPieceNoire.PION6.getIndexPieceNoire(),new Pion("Pion",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_pawn.png"));
        piecesNoires.add(IndexPieceNoire.PION7.getIndexPieceNoire(),new Pion("Pion",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_pawn.png"));
        piecesNoires.add(IndexPieceNoire.PION8.getIndexPieceNoire(),new Pion("Pion",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_pawn.png"));

        piecesNoires.add(IndexPieceNoire.TOUR.getIndexPieceNoire(), new Tour("Tour",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_rook.png"));
        piecesNoires.add(IndexPieceNoire.CAVALIER1.getIndexPieceNoire(), new Cavalier("Cavalier",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_knight.png"));
        piecesNoires.add(IndexPieceNoire.FOU1.getIndexPieceNoire(), new Fou("Fou",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_bishop.png"));
        piecesNoires.add(IndexPieceNoire.DAME.getIndexPieceNoire(), new Dame("Dame",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_queen.png"));
        piecesNoires.add(IndexPieceNoire.ROI.getIndexPieceNoire(), new Roi("Roi",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_king.png"));
        piecesNoires.add(IndexPieceNoire.FOU2.getIndexPieceNoire(), new Fou("Fou",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_bishop.png"));
        piecesNoires.add(IndexPieceNoire.CAVALIER2.getIndexPieceNoire(), new Cavalier("Cavalier",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_knight.png"));
        piecesNoires.add(IndexPieceNoire.TOUR2.getIndexPieceNoire(), new Tour("Tour",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_rook.png"));
    }

    /**
     * Initialise les cases de l'échiquier
     */
    private void initCases() {
        //on place les pièces blanches
        for (int i = 0; i < 16; i++) {
            cases.add(i,new Case(piecesBlanches.get(i), positionsEchiqiers.get(i)));
        }

        //on définit les cases vides
        for (int i = 16; i < 48; i++) {
            cases.add(i,new Case(null, positionsEchiqiers.get(i)));
        }

        //on place les pièces noires
        for (int i = 48; i < 64; i++) {
            cases.add(i,new Case(piecesNoires.get(i-48), positionsEchiqiers.get(i)));
        }
    }

    /**
     * Initialise la position de toutes les cases de l'échiquier
     */
    private void initPositions(){
        //créer une liste de toutes les positions possibles sur le plateau; position (0,0) correspond à la 1ère case en bas à gauche
        for (int posY = 0; posY < 8; posY++) {
            for (int posX = 0; posX < 8; posX++) {
                positionsEchiqiers.add(new Position(posX,posY));
            }
        }
    }

    /**
     * Retourne une liste de déplacements possibles en fonction de la position de la case sélectionnée et la pièce qui se trouve sur la case.
     *
     * @param    positionCliquee      la position de la case cliquée par le joueur
     * @return   positionsPossibles   une liste de positions possibles pour la pièce si elle existe à partir de la case sélectionnée
     */
    public List<Position> deplacementsPossibles (Position positionCliquee){
        List<Position> positionsPossibles = new ArrayList<>();

        for (Case caseEchiquier:cases) {
            if (Position.comparePositions(caseEchiquier.getPositionCase(), positionCliquee)){
                if (caseEchiquier.getPiece()!=null) {
                    positionsPossibles = caseEchiquier.getPiece().deplacementsPossibles(positionCliquee);

                    //on enlève les positions des pièces de même couleur de la liste
                    updatePositionsPossibles(caseEchiquier,positionsPossibles);
                }
            }
        }
        return positionsPossibles;
    }

    private Case trouverCaseParPosition(Position positionARechercher){
        Case caseAretourner = null;

        for (Case caseAREchercher:cases) {
            if (Position.comparePositions(caseAREchercher.getPositionCase(),positionARechercher))
                caseAretourner = caseAREchercher;
        }
        return caseAretourner;
    }
    /**
     * Met à jour la liste des cases du plateau suite au déplacement effectué
     *
     * @param    deplacementEnCours   le déplacement demandé
     */
    public void deplacerPiece(Deplacement deplacementEnCours){
        deplacementEnCours.getNewCase().setPiece(deplacementEnCours.getOldCase().getPiece());
        deplacementEnCours.getOldCase().setPiece(null);
    }

    /**
     * Met à jour la liste des positions possibles en supprimant les positions des cases occupées par une pièce de même couleur
     *
     * @param    positionsPossibles      la liste initiale des positions possibles
     * @param    caseDepart            la couleur de la pièce à bouger
     * @return   positionsPossibles      la liste de positions à jour
     */

    private void updatePositionsPossibles(Case caseDepart, List<Position> positionsPossibles) {
        List<Position> positionsToRemove = new ArrayList<>();
        for (Position posPossible:positionsPossibles) {
            Case casePossible = trouverCaseParPosition(posPossible);
            //enlever les cases où il y a des pièces de même couleur
            if (casePossible!=null && casePossible.getPiece()!=null && casePossible.getPiece().getCouleurPiece()==caseDepart.getPiece().getCouleurPiece())
                positionsToRemove.add(posPossible);

        }
        //enlever les déplacements que le pion n'a pas le droit de faire
        if (caseDepart.getPiece()!=null && caseDepart.getPiece().getNom().equals("Pion"))
            positionsToRemove.addAll(filtrerDeplacementsPions(caseDepart,positionsPossibles));

        positionsPossibles.removeAll(positionsToRemove);
    }

    private List<Position> filtrerDeplacementsPions(Case caseDepart,List<Position> positionsPossibles) {
        List<Position> positionsToRemove = new ArrayList<>();
        Position positionDiagonale=null;
        Position positionOccupee = null;

        //enlever les cases où il n y a pas de pièce à manger en diagonale pour les pions
        if (caseDepart.getPiece()!=null && caseDepart.getPiece().getCouleurPiece()==Couleur.BLANC)
            positionDiagonale = new Position(caseDepart.getPositionCase().getX()+1, caseDepart.getPositionCase().getY()+1);
        else
            positionDiagonale = new Position(caseDepart.getPositionCase().getX()-1, caseDepart.getPositionCase().getY()-1);
        if (trouverCaseParPosition(positionDiagonale).getPiece()==null){
            for (Position positionDiag:positionsPossibles) {
                if (Position.comparePositions(positionDiag,positionDiagonale))
                    positionsToRemove.add(positionDiag);
            }
        }
        if (caseDepart.getPiece()!=null && caseDepart.getPiece().getCouleurPiece()==Couleur.BLANC)
            positionDiagonale = new Position(caseDepart.getPositionCase().getX()-1, caseDepart.getPositionCase().getY()+1);
        else
            positionDiagonale = new Position(caseDepart.getPositionCase().getX()+1, caseDepart.getPositionCase().getY()-1);

        if (trouverCaseParPosition(positionDiagonale).getPiece()==null){
            for (Position positionDiag:positionsPossibles) {
                if (Position.comparePositions(positionDiag,positionDiagonale))
                    positionsToRemove.add(positionDiag);
            }
        }
        //le pion ne peut pas manger une pièce devant lui
        if (caseDepart.getPiece()!=null && caseDepart.getPiece().getCouleurPiece()==Couleur.BLANC)
            positionOccupee = new Position(caseDepart.getPositionCase().getX(), caseDepart.getPositionCase().getY()+1);
        else
            positionOccupee = new Position(caseDepart.getPositionCase().getX(), caseDepart.getPositionCase().getY()-1);
        if (trouverCaseParPosition(positionOccupee).getPiece()!=null){
            for (Position positionDiag:positionsPossibles) {
                if (Position.comparePositions(positionDiag,positionOccupee))
                    positionsToRemove.add(positionDiag);
            }
        }
        return positionsToRemove;
    }
}
