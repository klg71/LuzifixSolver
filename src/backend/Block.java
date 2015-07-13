package backend;

import java.util.ArrayList;

public abstract class Block {
	protected ArrayList<AtomBlock> atomBlocks;
	public abstract ArrayList<Move> getMoves(AtomBlock empty1,AtomBlock empty2);
	
	public Block(){
		atomBlocks=new ArrayList<AtomBlock>();
	}
	
	public ArrayList<AtomBlock> getAtomBlocks() {
		return atomBlocks;
	}
}
