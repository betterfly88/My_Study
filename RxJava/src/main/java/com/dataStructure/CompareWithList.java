package com.dataStructure;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class CompareWithList {

    //TODO 이 내용을 <Observable> 로 구현해보기. 성능 측텅 테스트임
    private List<String> list;

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        CompareWithList arrList = new CompareWithList(new ArrayList<>());
        List<String> list = arrList.setList();
        System.out.println(list.get(999));
        System.out.println(System.currentTimeMillis() - now);


        now = System.currentTimeMillis();
        CompareWithList linkedList = new CompareWithList(new LinkedList<>());
        List<String> list2 = linkedList.setList();
        System.out.println(list2.get(999));
        System.out.println(System.currentTimeMillis() - now);
    }

    public CompareWithList(List<String> list){
        this.list = list;
    }

    public List<String> setList(){
        IntStream.range(0, 10_000_000).forEach(idx -> {
            list.add("String_"+idx);
        });

        return list;
    }

    public void byObservable(){
        CompareWithList arrList = new CompareWithList(new ArrayList<>());
        List<String> list = arrList.setList();
        Observable.fromArray(list)
                .subscribe(v ->{
                    v.get(999);
                });
    }

    public void generate(){

    }
}
