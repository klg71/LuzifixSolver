package main;

import backend.BattleField;
import backend.BattleFieldSolver;

public class Run {

	public static void main(String[] args) {
		BattleField battleField=new BattleField(true);
		System.out.println(battleField.toString());
		BattleFieldSolver battleFieldSolver=new BattleFieldSolver();
		battleFieldSolver.solve(battleField,0);

	}

}
