package com.task.springbootasyctask.server;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author XAIOHU
 * @date 2019/9/23 --8:44
 **/
@Service
public class BookService {


@Async
    public List<String> getList() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("DASDA1");
        list.add("DASDA2");
        list.add("DASDA3");
        list.add("DASDA4");
        list.add("DASDA5");
        list.add("DASDA6");
        list.add("DASDA7");
        list.add("DASDA8");
        return list;
    }


}
