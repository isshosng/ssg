package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private List<WiseSaying> wiseSayings;
    private int wiseSayingLastId;


    WiseSayingService() {
        wiseSayings = new ArrayList<>();
        wiseSayingLastId = 0;
    }

    public WiseSaying findByID(int paramId) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == paramId) {
                return wiseSaying;
            }

        } // 하나 찾기
        return null;
    }


    public List<WiseSaying> findAll(){
        return wiseSayings; // 다 찾기
    }

    public WiseSaying write(String content, String author){
        int id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    public void remove(int id){
        WiseSaying foundWiseSaying = findByID(id);
        wiseSayings.remove(foundWiseSaying);
    }
}
