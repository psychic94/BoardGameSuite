package psy.boardgames.chess;

import org.bukkit.Location;

public class ChessBoard {
	Location a1, h8;
	ChessPiece[][] pieces;
	boolean whitesTurn;
	
	public ChessBoard(){
		
	}
	
	public void setUp(){
		//Initialize
		pieces = new ChessPiece[8][8];
		
		//White's back rank
		pieces[0][0] = new Rook(this, false, 0, 0);
		pieces[0][1] = new Knight(this, false, 0, 1);
		pieces[0][2] = new Bishop(this, false, 0, 2);
		pieces[0][3] = new Queen(this, false, 0, 3);
		pieces[0][4] = new King(this, false, 0, 4);
		pieces[0][5] = new Bishop(this, false, 0, 5);
		pieces[0][6] = new Knight(this, false, 0, 6);
		pieces[0][7] = new Rook(this, false, 0, 7);
		
		//White's pawns
		for(byte i=0; i<8; i++)
			pieces[1][i] = new Pawn(this, false, 1, i);
		
		//Black's back rank
		pieces[7][0] = new Rook(this, true, 7, 0);
		pieces[7][1] = new Knight(this, true, 7, 1);
		pieces[7][2] = new Bishop(this, true, 7, 2);
		pieces[7][3] = new Queen(this, true, 7, 3);
		pieces[7][4] = new King(this, true, 7, 4);
		pieces[7][5] = new Bishop(this, true, 7, 5);
		pieces[7][6] = new Knight(this, true, 7, 6);
		pieces[7][7] = new Rook(this, true, 7, 7);
		
		//Blacks's pawns
		for(byte i=0; i<8; i++)
			pieces[6][i] = new Pawn(this, true, 6, i);
		
		//Empty squares
		for(int i=2; i<6; i++)
			for(int j=0; j<8; j++)
				pieces[i][j] = null;
		
		whitesTurn = true;
	}
	
	public void setSquare(int rank, int file, ChessPiece piece){
		pieces[rank][file] = piece;
	}
	
	public ChessPiece getSquare(int rank, int file){
		return pieces[rank][file];
	}
}
