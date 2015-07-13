package backend;

import java.util.ArrayList;

public class BattleFieldSolver {
	private ArrayList<BattleField> battleFieldsVisited;

	public BattleFieldSolver() {
		battleFieldsVisited = new ArrayList<BattleField>();
	}

	public void solve(BattleField battleField,int steps) {
		if (battleField.isSolved()) {
			System.out.println(battleField.toString()+"Steps: "+Integer.toString(steps)+"\n");
			
		} else {
			AtomBlock empty1 = battleField.getEmpty1();
			AtomBlock empty2 = battleField.getEmpty2();
			for (Block block : battleField.getBlocks()) {
				for (Move move : block.getMoves(empty1, empty2)) {
					move.move();
					boolean isEqual = false;
					for (BattleField field : battleFieldsVisited) {
						if (field.isEqual(battleField)) {
							isEqual = true;
						}
					}
					if (!isEqual) {
						//System.out.println(battleField.toString());
						battleFieldsVisited.add(battleField.copy());
						BattleField battleFieldTemp=battleField.copy();
						move.unmove();
						solve(battleFieldTemp,steps+1);
					} else {
						move.unmove();
					}

				}
			}
		}
	}

}
