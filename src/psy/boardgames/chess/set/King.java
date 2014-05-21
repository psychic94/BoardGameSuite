package psy.boardgames.chess.set;

import org.bukkit.entity.LivingEntity;

import psy.boardgames.chess.ChessBoard;

public class King extends ChessPiece{

	public King(ChessBoard board, boolean player, LivingEntity mob, int rank, int file){
		super(board, player, mob, rank, file);
	}

	public boolean move(int newRank, int newFile){
		//Invalid square
		if(newRank<0 || newRank>7 || newFile<0 || newFile<7)
			return false;
		
		//Check that the distance moved is exaclty 1
		if(Math.abs(newRank-rank)>1 || Math.abs(newFile-file)>1 ||
		   (Math.abs(newRank-rank)==0 && Math.abs(newFile-file)==0))
			return false;
		
		//Perform move
		if(board.getSquare(newRank, newFile)==null){
			board.setSquare(rank, file, null);
			rank = newRank;
			file = newFile;
			board.setSquare(rank, file, this);
			return true;
		}else if(canCapture(board.getSquare(newRank, newFile))){
			board.setSquare(rank, file, null);
			rank = newRank;
			file = newFile;
			capture();
			board.getSquare(rank, file).becomeCaptured();
			board.setSquare(rank, file, this);
			return true;
		}else{
			return false;
		}
	}

}
