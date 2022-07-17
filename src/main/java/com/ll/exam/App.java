package com.ll.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    private BufferedReader br;
    private WiseSayingController wiseSayingController;

    public App(BufferedReader br) {
        this.br = br; // 여기서 br는 이거만!
        wiseSayingController = new WiseSayingController(br);
    }

    public void run() throws IOException {
        System.out.println("== 명언 SSG =="); // 초기 출력 화면

        outer:
        while (true) {
            System.out.print("명령) ");
            String cmd = br.readLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    wiseSayingController.write(rq);
                    break;
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
                case "수정":
                    wiseSayingController.modify(rq);
                    break;
                case "목록":
                    wiseSayingController.list(rq);
                    break;
                case "종료":
                    break outer;
            }
        }
        br.close();
    }
}

