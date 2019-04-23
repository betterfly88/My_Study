package forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

/**
 * Created by betterfly
 * Date : 2019.04.24
 */
public class CustomRecursiveAction extends RecursiveAction {
    private String workLoad = "";
    private static final int THRESHOLD = 4;

    private static Logger logger = Logger.getAnonymousLogger();

    public CustomRecursiveAction(String workLoad){
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {
        if (workLoad.length() > THRESHOLD){
            ForkJoinTask.invokeAll(createSubTasks());
        }else{
            processing(workLoad);
        }
    }

    private List<CustomRecursiveAction> createSubTasks() {
        List<CustomRecursiveAction> subtasks = new ArrayList<>();

        String partOne = workLoad.substring(0, workLoad.length() / 2);
        String partTwo = workLoad.substring(workLoad.length() / 2, workLoad.length());

        subtasks.add(new CustomRecursiveAction((partOne)));
        subtasks.add(new CustomRecursiveAction((partTwo)));
        return subtasks;
    }

    private void processing(String work){
        String result = work.toUpperCase();
        System.out.println("this result - ( "+ result + " ) - aws processed by"
                + Thread.currentThread().getName()
        );

    }
}
