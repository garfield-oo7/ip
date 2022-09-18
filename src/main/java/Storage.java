import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Storage {

    private final String DATA_FILEPATH = "data/duke.txt";


    public void createDataFile() throws IOException {

        String[] dataPathList = DATA_FILEPATH.split("/");
        String currentDirectory = "";

        for(int i = 0; i < dataPathList.length - 1; i++) {

            currentDirectory += dataPathList[i];
            File directory = new File(currentDirectory);

            if (!directory.exists()) {
                directory.mkdir();
            }

            currentDirectory += "/";

        }

        File newFile = new File(DATA_FILEPATH);
        newFile.createNewFile();
    }

    public ArrayList<Task> convertToTaskList() throws FileNotFoundException {

        ArrayList<Task> taskList = new ArrayList<Task>();
        File file = new File(DATA_FILEPATH);
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()) {

            String task = sc.nextLine();
            String[] description = task.split(" \\| ");

            boolean isDone = description[1].equals("1");

            switch(description[0]){

                case "T":
                    taskList.add(new ToDo(description[2], isDone));
                    break;
                case "D":
                    taskList.add(new Deadline(description[2], isDone, description[3]));
                    break;
                case "E":
                    taskList.add(new Event(description[2], isDone, description[3]));
                    break;
                default:
                    break;
            }

        }

        return taskList;

    }

    public void saveTaskList(ArrayList<Task> taskList) throws IOException {

        FileWriter fw = new FileWriter(DATA_FILEPATH);


        for(Task t : taskList) {

            fw.write(t.toFileString() + System.lineSeparator());

        }



        fw.close();

    }




}
