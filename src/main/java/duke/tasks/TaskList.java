package duke.tasks;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public int getSize() {
        return this.taskList.size();
    }

    public String displayNumTasks() {
        String text = "Now you have " + this.taskList.size() +
                " tasks in the list.";
        return text;
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void markTask(int index) {
        this.taskList.get(index).setDone(true);
    }

    public void unmarkTask(int index) {
        this.taskList.get(index).setDone(false);
    }

    public Task deleteTask(int index) {
        return this.taskList.remove(index);
    }

    public String taskListString() {

        String text = "";

        if (this.taskList.size() == 0) {

            return "You currently have no tasks";
        } else {

            for (int i = 0; i < this.taskList.size(); i++) {

                text +=  (i + 1) + ". " +
                        this.taskList.get(i).toString();
                if (i != this.taskList.size() - 1) {
                    text += "\n";
                }
            }
        }
        return text;
    }

    public String taskListFileString() {

        String text = "";
        for (Task task : this.taskList) {
            text += task.fileString() + "\n";
        }
        return text;
    }

    public String getTaskString(int index) {
        return this.taskList.get(index).toString();
    }

    public ArrayList<Task> findTasks(String word) {
        ArrayList searchMatchList = new ArrayList<Task>();
        for(Task task : taskList) {
            if (task.getDescription().contains(word)) {
                searchMatchList.add(task);
            }
        }
        return searchMatchList;
    }

}