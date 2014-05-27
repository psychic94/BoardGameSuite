package psy.boardgames.chess;

import org.bukkit.Location;
import org.bukkit.World;

import psy.boardgames.chess.set.Bishop;
import psy.boardgames.chess.set.ChessPiece;
import psy.boardgames.chess.set.King;
import psy.boardgames.chess.set.Knight;
import psy.boardgames.chess.set.Pawn;
import psy.boardgames.chess.set.Queen;
import psy.boardgames.chess.set.Rook;
import psy.boardgames.core.GameBoard;

public class ChessBoard extends GameBoard{
	ChessPiece[][] pieces;

	public ChessBoard(String name, Location loc1, Location loc2){
		this(name, loc1.getWorld(), loc1, loc2);
	}
	
	public ChessBoard(String name, World world, Location loc1, Location loc2){
		super(name, world, loc1, loc2);
		// TODO game specific size check (8, 16, or 24 blocks wide)
	}
	
	public void setUp(){
		//Initialize
		pieces = new ChessPiece[8][8];
		
		//White's back rank
		pieces[0][0] = new Rook(this, false, null, 0, 0);
		pieces[0][1] = new Knight(this, false, null, 0, 1);
		pieces[0][2] = new Bishop(this, false, null, 0, 2);
		pieces[0][3] = new Queen(this, false, null, 0, 3);
		pieces[0][4] = new King(this, false, null, 0, 4);
		pieces[0][5] = new Bishop(this, false, null, 0, 5);
		pieces[0][6] = new Knight(this, false, null, 0, 6);
		pieces[0][7] = new Rook(this, false, null, 0, 7);
		
		//White's pawns
		for(byte i=0; i<8; i++)
			pieces[1][i] = new Pawn(this, false, null, 1, i);
		
		//Black's back rank
		pieces[7][0] = new Rook(this, true, null, 7, 0);
		pieces[7][1] = new Knight(this, true, null, 7, 1);
		pieces[7][2] = new Bishop(this, true, null, 7, 2);
		pieces[7][3] = new Queen(this, true, null, 7, 3);
		pieces[7][4] = new King(this, true, null, 7, 4);
		pieces[7][5] = new Bishop(this, true, null, 7, 5);
		pieces[7][6] = new Knight(this, true, null, 7, 6);
		pieces[7][7] = new Rook(this, true, null, 7, 7);
		
		//Blacks's pawns
		for(byte i=0; i<8; i++)
			pieces[6][i] = new Pawn(this, true, null, 6, i);
		
		//Empty squares
		for(int i=2; i<6; i++)
			for(int j=0; j<8; j++)
				pieces[i][j] = null;
		
	}
	
	public void putAway(){
		// TODO despawn all entity pieces
	}
	
	public void setSquare(int rank, int file, ChessPiece piece){
		pieces[rank][file] = piece;
	}
	
	public ChessPiece getSquare(int rank, int file){
		return pieces[rank][file];
	}
}