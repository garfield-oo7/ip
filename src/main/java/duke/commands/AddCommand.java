package duke.commands;

import duke.DukeException;
import duke.storage.Storage;
import duke.tasks.TaskList;
import duke.tasks.Task;
import duke.ui.Ui;

import java.io.IOException;

/**
 * Adds a task to the tasklist.
 */
public class AddCommand extends Command {

    protected Task task;
    private final String MESSAGE = "\tGot it. I just added the " +
            "task: ";

    /**
     * Constructs an add command
     *
     * @param task the task to be added
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.addTask(task);
        storage.saveTaskList(taskList);
        String text = MESSAGE + "\n\t" + task.toString() + "\n" +
                taskList.displayNumTasks();
        ui.displayMessage(text);

    }

    @Override
    public boolean isExit() {
        return false;
    }
}