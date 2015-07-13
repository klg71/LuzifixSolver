package backend;

import java.util.ArrayList;

public class HorizontalBlock extends Block {

	public HorizontalBlock(int firstX, int firstY) {
		super();
		atomBlocks.add(new AtomBlock(firstX, firstY));
		atomBlocks.add(new AtomBlock(firstX+1, firstY ));
	}

	@Override
	public ArrayList<Move> getMoves(AtomBlock empty1, AtomBlock empty2) {
		ArrayList<Move> moves = new ArrayList<Move>();
		for (Direction dir : Direction.values()) {
			Move tempMove = new Move(this, dir);
			switch (dir) {
			case NORTH:
				if ((tempMove.getPosAfterMove(atomBlocks.get(0)).isEqual(empty1)
						|| tempMove.getPosAfterMove(atomBlocks.get(0)).isEqual(empty2))
						&& (tempMove.getPosAfterMove(atomBlocks.get(1)).isEqual(empty1)
								|| tempMove.getPosAfterMove(atomBlocks.get(1)).isEqual(empty2)))
					moves.add(tempMove);
				break;
			case SOUTH:
				if ((tempMove.getPosAfterMove(atomBlocks.get(0)).isEqual(empty1)
						|| tempMove.getPosAfterMove(atomBlocks.get(0)).isEqual(empty2))
						&& (tempMove.getPosAfterMove(atomBlocks.get(1)).isEqual(empty1)
								|| tempMove.getPosAfterMove(atomBlocks.get(1)).isEqual(empty2)))
					moves.add(tempMove);
				break;
			case EAST:
				if (tempMove.getPosAfterMove(atomBlocks.get(1)).isEqual(empty1)
						|| tempMove.getPosAfterMove(atomBlocks.get(1)).isEqual(empty2))
					moves.add(tempMove);
				break;
			case WEST:
				if (tempMove.getPosAfterMove(atomBlocks.get(0)).isEqual(empty1)
						|| tempMove.getPosAfterMove(atomBlocks.get(0)).isEqual(empty2))
					moves.add(tempMove);
				break;
			}
		}
		return moves;
	}

}
