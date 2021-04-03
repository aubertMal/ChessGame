package aubert.chessGame.model;

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
            if (comparePositions(caseEchiquier.getPositionCase(), positionCliquee)){
                if (caseEchiquier.getPiece()!=null) {
                    positionsPossibles = caseEchiquier.getPiece().deplacementsPossibles(positionCliquee);
                    //on enlève les positions des pièces de même couleur de la liste
                    updatePositionsPossibles(caseEchiquier.getPiece().getCouleurPiece(),positionsPossibles);
                }
            }
        }
        return positionsPossibles;
    }


    /**
     * Met à jour la liste des cases du plateau suite au déplacement effectué
     *
     * @param    deplacementEnCours   le déplacement demandé
     */
    public void deplacerPiece(Deplacement deplacementEnCours){
        deplacementEnCours.getNewCase().setPiece(deplacementEnCours.getOldCase().getPiece());
        deplacementEnCours.getOldCase().setPiece(null);

        for (Case caseTemp:cases) {
            if (comparePositions(caseTemp.getPositionCase(),deplacementEnCours.getNewCase().getPositionCase()))
                cases.set(cases.indexOf(caseTemp), deplacementEnCours.getNewCase());
            if (comparePositions(caseTemp.getPositionCase(), deplacementEnCours.getOldCase().getPositionCase()))
                cases.set(cases.indexOf(caseTemp), deplacementEnCours.getOldCase());
        }
    }
    /**
     * Met à jour la liste des positions possibles en supprimant les positions des cases occupées par une pièce de même couleur
     *
     * @param    positionsPossibles      la liste initiale des positions possibles
     * @param    couleurPiece            la couleur de la pièce à bouger
     * @return   positionsPossibles      la liste de positions à jour
     */

    private void updatePositionsPossibles(Couleur couleurPiece, List<Position> positionsPossibles) {
        List<Position> positionsToRemove = new ArrayList<>();
        for (Position posPossible:positionsPossibles) {
            for (Case casePossible:cases) {
                if (comparePositions(posPossible,casePossible.getPositionCase()))
                    if (casePossible.getPiece()!=null && casePossible.getPiece().getCouleurPiece()==couleurPiece)
                        positionsToRemove.add(posPossible);
            }
        }
        positionsPossibles.removeAll(positionsToRemove);
    }

    /**
     * vérifie si deux positions sont égales
     *
     * @param    position1      1ère position
     * @param    position2      2ème position
     * @return   true si les positions sont égales, false sinon
     */
    public boolean comparePositions(Position position1, Position position2){
        if (position1.getX() == position2.getX() && position1.getY()== position2.getY())
            return true;
        else
            return false;
    }
}
