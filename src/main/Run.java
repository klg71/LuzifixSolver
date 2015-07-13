package main;

import java.util.ArrayList;

import backend.BattleField;
import backend.BattleFieldSolver;
import backend.Move;

public class Run {

	public static void main(String[] args) {
		BattleField battleField=new BattleField(true);
		System.out.println(battleField.toString());
		BattleFieldSolver battleFieldSolver=new BattleFieldSolver();
		battleFieldSolver.solve(battleField,0,new ArrayList<Move>());

	}

}
