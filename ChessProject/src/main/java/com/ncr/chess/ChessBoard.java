package com.ncr.chess;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH + 1][MAX_BOARD_HEIGHT + 1];
    }
    
    /**
     * @param pawn
     * @param xCoordinate
     * @param yCoordinate
     * @param pieceColor
     * This method is used to add the pawn piece to the ChessBoard. If there are any duplicates entries, it updates the coordinates to (-1,-1). 
     */
    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
    	
    	if(checkForPiecePresent(xCoordinate, yCoordinate)) {
    		pawn= neg(pawn);
    	} else {
    		if((pieceColor==PieceColor.BLACK && xCoordinate==6) || (pieceColor==PieceColor.WHITE && xCoordinate==1)) {
    			pawn.setXCoordinate(xCoordinate);
            	pawn.setYCoordinate(yCoordinate);
            	pieces[xCoordinate][yCoordinate] = pawn;
    		}
    		else {
    			pawn= neg(pawn);
    		}
    	}
    }
    
    
    /**
     * @param xCoordinate
     * @param yCoordinate
     * @return boolean
     * This method returns true if the coordinates are within the proper range.
     */
    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
    	if(xCoordinate>=0 && xCoordinate<MAX_BOARD_WIDTH &&  yCoordinate>=0 && yCoordinate<MAX_BOARD_HEIGHT) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * @param pawn
     * @return
     * This method is used to set the coordinates to (-1,-1) in case of duplicate entry.
     */
    private Pawn neg(Pawn pawn) {
    	pawn.setXCoordinate(-1);
    	pawn.setYCoordinate(-1);
    	return pawn;
    }
    
    /**
     * @param xCoordinate
     * @param yCoordinate
     * @return boolean
     * This method returns true if the piece is present for given coordinates.
     */
    private boolean checkForPiecePresent(int xCoordinate, int yCoordinate) {
    	if(pieces[xCoordinate][yCoordinate]!= null) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
