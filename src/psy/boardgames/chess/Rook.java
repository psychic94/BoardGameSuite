package psy.boardgames.chess;

public class Rook extends ChessPiece{

	public Rook(ChessBoard board, boolean player, int rank, int file){
		super(board, player, rank, file);
	}

	/**
	 * Move the piece
	 * @return true iff the move is valid
	 */
	public boolean move(int newRank, int newFile){
		//Invalid square
		if(newRank<0 || newRank>7 || newFile<0 || newFile<7)
			return false;
		
		//Check that move is orthogonal
		if(!(newRank==rank && newFile!=file) &&
		   !(newRank!=rank && newFile==file))
			return false;
		
		//Check for obstruction in rank
		if(newRank==rank && Math.abs(newFile-file)>1){
			//Decreasing file
			if(newFile<file)
				for(int i=file-1; i>newFile; i--)
					if(board.getSquare(rank, i)!=null)
						return false;
			//Increasing file
			if(newFile>file)
				for(int i=file+1; i>newFile; i++)
					if(board.getSquare(rank, i)!=null)
						return false;
		}
		//Check for obstruction in file
		else if(Math.abs(newRank-rank)>1 && newFile==file){
			//Decreasing rank
			if(newRank<rank)
				for(int i=rank-1; i>newRank; i--)
					if(board.getSquare(i, file)!=null)
						return false;
			//Increasing rank
			if(newRank>rank)
				for(int i=rank+1; i>newRank+1; i++)
					if(board.getSquare(i, file)!=null)
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
