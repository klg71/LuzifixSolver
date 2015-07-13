package backend;

public class Move {
	private Block block;
	private Direction direction;
	public Move(Block block, Direction direction) {
		super();
		this.block = block;
		this.direction = direction;
	}
	public Block getBlock() {
		return block;
	}
	public Direction getDirection() {
		return direction;
	}
	public void move(){
		for(AtomBlock atomBlock:block.getAtomBlocks()){
			switch(direction){
			case NORTH:
				atomBlock.setY(atomBlock.getY()-1);
				break;
			case SOUTH:
				atomBlock.setY(atomBlock.getY()+1);
				break;
			case WEST:
				atomBlock.setX(atomBlock.getX()-1);
				break;
			case EAST:
				atomBlock.setX(atomBlock.getX()+1);
				break;
			}
		}
	}
	public AtomBlock getPosAfterMove(AtomBlock inputblock){
		AtomBlock retBlock=new AtomBlock(inputblock.getX(), inputblock.getY());
		switch(direction){
		case NORTH:
			retBlock.setY(retBlock.getY()-1);
			break;
		case SOUTH:
			retBlock.setY(retBlock.getY()+1);
			break;
		case WEST:
			retBlock.setX(retBlock.getX()-1);
			break;
		case EAST:
			retBlock.setX(retBlock.getX()+1);
			break;
		}
		return retBlock;
		
	}
	public void unmove() {
		for(AtomBlock atomBlock:block.getAtomBlocks()){
			switch(direction){
			case NORTH:
				atomBlock.setY(atomBlock.getY()+1);
				break;
			case SOUTH:
				atomBlock.setY(atomBlock.getY()-1);
				break;
			case WEST:
				atomBlock.setX(atomBlock.getX()+1);
				break;
			case EAST:
				atomBlock.setX(atomBlock.getX()-1);
				break;
			}
		}
	}
}
