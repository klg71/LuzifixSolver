package backend;

import java.util.ArrayList;

public class BattleField {

	private ArrayList<Block> blocks;
	private AtomBlock empty1, empty2;

	public BattleField(boolean initial) {
		blocks = new ArrayList<Block>();
		blocks.add(new VerticalBlock(0, 0));
		blocks.add(new VerticalBlock(0, 2));
		blocks.add(new VerticalBlock(3, 0));
		blocks.add(new VerticalBlock(3, 2));
		blocks.add(new MainBlock(1, 0));
		blocks.add(new HorizontalBlock(1, 2));
		blocks.add(new SingleBlock(1, 3));
		blocks.add(new SingleBlock(2, 3));
		blocks.add(new SingleBlock(1, 4));
		blocks.add(new SingleBlock(2, 4));
		empty1 = new AtomBlock(0, 4);
		empty2 = new AtomBlock(3, 4);
	}

	public BattleField() {
		blocks = new ArrayList<Block>();
	}

	public void addBlock(Block block) {
		blocks.add(block);
	}
	
	public void findEmptyBlock(){
		int i=0;
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 4; x++) {
				boolean found = false;
				for (Block block : blocks) {
					for (AtomBlock atomBlock : block.getAtomBlocks()) {
						if (atomBlock.getX() == x && atomBlock.getY() == y) {
							found = true;
						}
					}
				}
				if (!found&&i==0){
					empty1=new AtomBlock(x, y);
					i++;
				}
				if (!found&&i==1)
					empty2=new AtomBlock(x, y);
				
					
			}
		}
	}

	public boolean isSolved() {
		for (Block block : blocks) {
			if (block instanceof MainBlock) {
				if (block.getAtomBlocks().get(0).getX() == 1 && block.getAtomBlocks().get(0).getY() == 3) {
					return true;
				} else {
					return false;
				}

			}
		}
		return false;
	}

	public ArrayList<Block> getBlocks() {
		return blocks;
	}

	public String toString() {
		String ret = "";
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 4; x++) {
				boolean found = false;
				for (Block block : blocks) {
					for (AtomBlock atomBlock : block.getAtomBlocks()) {
						if (atomBlock.getX() == x && atomBlock.getY() == y) {
							found = true;
							if (block instanceof SingleBlock)
								ret += "x";
							if (block instanceof MainBlock)
								ret += "o";
							if (block instanceof VerticalBlock)
								ret += "v";
							if (block instanceof HorizontalBlock)
								ret += "h";
						}
					}
				}
				if (!found)
					ret += " ";
			}
			ret += "\n";
		}
		return ret;
	}

	public AtomBlock getEmpty1() {
		// TODO Auto-generated method stub
		return empty1;
	}

	public AtomBlock getEmpty2() {
		// TODO Auto-generated method stub
		return empty2;
	}

	public boolean isEqual(BattleField battleField2) {
		for (Block firstBlock : blocks) {
			boolean found=false;
			for (Block secondBlock : battleField2.getBlocks()) {
				if ((firstBlock.getClass() == secondBlock.getClass())
						&& (firstBlock.getAtomBlocks().get(0).getX() == secondBlock.getAtomBlocks().get(0).getX())
						&& (firstBlock.getAtomBlocks().get(0).getY() == secondBlock.getAtomBlocks().get(0).getY())) {
						found=true;
				}
			}
			if(!found){
				return false;
			}
		}
		return true;
	}

	public BattleField copy() {
		BattleField copyBattleField = new BattleField();
		for (Block block : blocks) {
			if (block instanceof MainBlock)
				copyBattleField.addBlock(
						new MainBlock(block.getAtomBlocks().get(0).getX(), block.getAtomBlocks().get(0).getY()));
			if (block instanceof VerticalBlock)
				copyBattleField.addBlock(
						new VerticalBlock(block.getAtomBlocks().get(0).getX(), block.getAtomBlocks().get(0).getY()));
			if (block instanceof HorizontalBlock)
				copyBattleField.addBlock(
						new HorizontalBlock(block.getAtomBlocks().get(0).getX(), block.getAtomBlocks().get(0).getY()));
			if (block instanceof SingleBlock)
				copyBattleField.addBlock(
						new SingleBlock(block.getAtomBlocks().get(0).getX(), block.getAtomBlocks().get(0).getY()));
		}
		copyBattleField.findEmptyBlock();
		return copyBattleField;
	}
}
