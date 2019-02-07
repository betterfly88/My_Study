package tds.chapter_2;

/**
 * Created by betterfly
 * Date : 2019.02.03
 */
public class SelectionSort {
    public static void main(String[] args) {
        int [] sample = {1,2,3,4,5};
        selectionSort(sample);
        System.out.println(sample);

    }

    /*
        i와 j의 값을 바꿔줌
     */
    public static void swapElements(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /*
        start부터 시작하는 최속값의 위치를 찾고(start 포함)
        배열의 마지막 위치로...
     */
    public static int indexLowest(int[] array, int start){
        int lowIndex = start;
        for(int i= start; i<array.length; i++){
            if (array[i] < array[lowIndex]){
                lowIndex = i;
            }
        }
        return lowIndex;
    }

    /*
        선택 정렬을 사용하여 요소를 정렬
     */
    public static void selectionSort(int[] array){
        for(int i=0; i<array.length; i++){
            int j = indexLowest(array, i);
            swapElements(array, i ,j);
        }
    }
}
