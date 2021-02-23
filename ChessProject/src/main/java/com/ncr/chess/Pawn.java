package com.ncr.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;
	

	public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }
    
    /**
     * @param movementType
     * @param newX
     * @param newY
     * This method is used to define the movement for the pawn with both movement type MOVE and CAPTURE.
     */
    public void move(MovementType movementType, int newX, int newY) {
    	if(movementType == MovementType.MOVE) {
    		if(checkForValidForwardMove(newX, newY)) {
				this.setYCoordinate(newY);
			}	
    	} else if(movementType == MovementType.CAPTURE) {
    		if(checkForValidCaptureMove(newX, newY)) {
    			this.setXCoordinate(newX);
				this.setYCoordinate(newY);
    		} 
    	}
    }

    @Override
    public String toString() {
        return getCurrentPositionAsString();
    }

    protected String getCurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
    
    /**
     * @param newX
     * @param newY
     * @return boolean
     * This method returns true if coordinates are valid to move FORWARD.
     */
    private boolean checkForValidForwardMove(int newX, int newY) {
    	if(this.pieceColor == PieceColor.BLACK) {
    		if( newY == this.yCoordinate - 1) {
    			return true;
    		}
    	} else {
    		if(newY == this.yCoordinate + 1) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * @param newX
     * @param newY
     * @return boolean
     * This method returns true if coordinates are valid to Capture move for pawn. 
     */
    private boolean checkForValidCaptureMove(int newX, int newY) {
    	if(this.pieceColor == PieceColor.BLACK) {
    		if(newY == this.yCoordinate - 1 && (newX==this.xCoordinate - 1 || newX==this.xCoordinate + 1)) {
    			return true;
    		}
    	} else if(this.pieceColor == PieceColor.WHITE) {
    		if(newY == this.yCoordinate + 1 && (newX==this.xCoordinate - 1 || newX==this.xCoordinate + 1)) {
    			return true;
    		}
    	}
    	return false;
    }
}
