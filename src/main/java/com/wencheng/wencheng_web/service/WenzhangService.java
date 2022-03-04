package com.wencheng.wencheng_web.service;

import com.wencheng.wencheng_web.pojo.Wenzhang;

import java.util.List;

public interface WenzhangService {

    int  AddWenZhang(Wenzhang wenzhang);
    List<Wenzhang> selectwenzhang () ;
    int updateWenzhang(Wenzhang wenzhang);
    int delwenzhang(Wenzhang wenzhang);
    int updateWenzhangs(Wenzhang wenzhang);
    String  getStatus(String username);
}
