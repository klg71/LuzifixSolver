package backend;

import java.util.ArrayList;

public class SingleBlock extends Block {

	public SingleBlock(int firstX, int firstY) {
		super();
		atomBlocks.add(new AtomBlock(firstX, firstY));
	}

	@Override
	public ArrayList<Move> getMoves(AtomBlock empty1, AtomBlock empty2) {
		ArrayList<Move> moves = new ArrayList<Move>();
		for (Direction dir : Direction.values()) {
			Move tempMove = new Move(this, dir);
			if (tempMove.getPosAfterMove(atomBlocks.get(0)).isEqual(empty1)
						|| tempMove.getPosAfterMove(atomBlocks.get(0)).isEqual(empty2))
					moves.add(tempMove);
		}
		return moves;
	}
}
