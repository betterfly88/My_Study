package player;

public class MadedBingoInformation {
	
	BingoDirection bingoDirection;
	int whichLine;
	
	public MadedBingoInformation() {
	}
	
	public MadedBingoInformation(BingoDirection bingoDirection, int whichLine) {
		super();
		this.bingoDirection = bingoDirection;
		this.whichLine = whichLine;
	}
	
	public BingoDirection getBingoDirection() {
		return bingoDirection;
	}
	public void setBingoDirection(BingoDirection bingoDirection) {
		this.bingoDirection = bingoDirection;
	}
	public int getWhichLine() {
		return whichLine;
	}
	public void setWhichLine(int whichLine) {
		this.whichLine = whichLine;
	}
	
	@Override
	public String toString() {
		return "MadedBIngoInfomation [bingoDirection=" + bingoDirection + ", whichLine=" + whichLine + "]";
	}
	
}
