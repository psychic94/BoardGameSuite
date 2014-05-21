package psy.boardgames.chess;

public class Queen extends ChessPiece{

	public Queen(ChessBoard board, boolean player, int rank, int file){
		super(board, player, rank, file);
	}

	public boolean move(int newRank, int newFile){
		//Invalid square
		if(newRank<0 || newRank>7 || newFile<0 || newFile<7)
			return false;
		
		//Rook-like move
		if((newRank==rank && newFile!=file) ||
		   (newRank!=rank && newFile==file)){
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
		}
		//Bishop-like move
		else if(Math.abs(newRank-rank)==Math.abs(newFile-file)){
			int distance = Math.abs(newRank-rank);
			
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
