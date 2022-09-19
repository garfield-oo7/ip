package duke;

import duke.commands.Command;
import duke.parser.Parser;
import duke.tasks.Task;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.tasks.TaskList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Initalises and runs the duke program
 */
public class Duke {

	private Ui ui;
	private Storage storage;
	private TaskList taskList;

	/**
	 * Set up the Ui, Storage and TaskList
	 */
	public Duke() {
		ui = new Ui();
		storage = new Storage();
		taskList = new TaskList(storage.convertToTaskList());
	}

	/**
	 * Runs the program unitl exit is issued
	 */
	public void run() {
		ui.displayWelcomeMessage();
		boolean isExit = false;
		while(!isExit) {
			String userInput = ui.getUserInput();
			Command command = Parser.parse(userInput);
			command.execute(taskList, ui, storage);
			isExit = command.isExit();

		}
	}

	public static void main(String[] args) {

		new Duke().run();
	}


}
