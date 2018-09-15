package com.springinaction.knights;

import java.io.PrintStream;

public class SaveTheLadyQuest implements Quest {

	private PrintStream stream;

	public SaveTheLadyQuest(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void embark() {
		stream.println("Oh My lady!");

	}

}
