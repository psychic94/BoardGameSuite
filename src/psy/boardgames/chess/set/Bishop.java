package psy.boardgames.chess.set;

import org.bukkit.entity.LivingEntity;

import psy.boardgames.chess.ChessBoard;

public class Bishop extends ChessPiece{
	
	public Bishop(ChessBoard board, boolean player, LivingEntity mob, int rank, int file){
		super(board, player, mob, rank, file);
	}

	/**
	 * Move the piece
	 * @return true iff the move is valid
	 */
	public boolean move(int newRank, int newFile){
		//Invalid square
		if(newRank<0 || newRank>7 || newFile<0 || newFile<7)
			return false;
		
		int distance;
		
		//Check if the rank and file change ratio is 1:1
		//If it is, remember the distance
		if(Math.abs(newRank-rank)==Math.abs(newFile-file))
			distance = Math.abs(newRank-rank);
		else
			return false;

		//Check that distance is nonzero
		if(distance<1)
			return false;
		//Check for obstructions...
		else if(distance>1){
			//in increasing rank and increasing file
			if(newRank>rank && newFile>file)
				for(int i=1; i<distance; i++)
					if(board.getSquare(rank+i, file+i)!=null)
						return false;
			//in increasing rank and Decreasing file
			if(newRank>rank && newFile<file)
				for(int i=1; i<distance; i++)
					if(board.getSquare(rank+i, file-i)!=null)
						return false;
			//in decreasing rank and increasing file
			if(newRank<rank && newFile>file)
				for(int i=1; i<distance; i++)
					if(board.getSquare(rank-i, file+i)!=null)
						return false;
			//in decreasing rank and decreasing file
			if(newRank<rank && newFile<file)
				for(int i=1; i<distance; i++)
					if(board.getSquare(rank-i, file-i)!=null)
						return false;
		}
		
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
