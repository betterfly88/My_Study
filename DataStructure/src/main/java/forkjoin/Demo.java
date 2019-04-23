package forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by betterfly
 * Date : 2019.04.24
 */
public class Demo {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(10);
        pool.execute(new CustomRecursiveAction("GGLWIJLDKSJFl kjdlskjfalsjagij apsj fdpsojf apdjf posaj paofwj pfawjd fpjasd lkjz lkjasl fdjsl ajsd LKJLDKSJFLKDJFLJFLK JSDL KFJp jqpoj pJ PQJ OPQJ POQJ"));
    }
}
