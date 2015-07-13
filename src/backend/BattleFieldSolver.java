package backend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BattleFieldSolver {
	private ArrayList<BattleField> battleFieldsVisited;

	public BattleFieldSolver() {
		battleFieldsVisited = new ArrayList<BattleField>();
	}

	public void solve(BattleField battleField,int steps,ArrayList<Move> moves) {
		if (battleField.isSolved()) {
			System.out.println(battleField.toString()+"Steps: "+Integer.toString(steps)+"\n");
			FileWriter fileWriter=null;
			try {
				fileWriter=new FileWriter(new File(Integer.toHexString(System.identityHashCode(battleField))));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Move move:moves){
				try {
					fileWriter.write(move.toString()+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
						ArrayList<Move> tempList=(ArrayList<Move>) moves.clone();
						tempList.add(move);
						solve(battleFieldTemp,steps+1,tempList);
					} else {
						move.unmove();
					}

				}
			}
		}
	}

}
