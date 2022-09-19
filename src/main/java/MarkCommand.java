import java.io.IOException;

public class MarkCommand extends Command {

    protected int index;
    private final String MESSAGE = "\tExcellent! I have marked " +
            "the task as done: ";

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.markTask(index);
        try {
            storage.saveTaskList(taskList);
        } catch (IOException e) {
            System.out.println("Error while saving the text");
        }
        String text = MESSAGE + "\n " + taskList.getTaskString(index);
        ui.displayMessage(text);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}