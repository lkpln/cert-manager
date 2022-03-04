package com.wencheng.wencheng_web.service;


import com.wencheng.wencheng_web.Mapper.WenzhangMapper;
import com.wencheng.wencheng_web.pojo.Wenzhang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class WenzhangServiceimpl implements WenzhangService {
    @Autowired
    private WenzhangMapper wenzhangmapper;


    @Override
    public int AddWenZhang(Wenzhang wenzhang) {
        return wenzhangmapper.AddWenZhang ( wenzhang );
    }

    @Override
    public List<Wenzhang> selectwenzhang() {
        return wenzhangmapper.selectwenzhang();
    }

    @Override
    public int updateWenzhang(Wenzhang wenzhang) {
        return wenzhangmapper.updateWenzhang(wenzhang);
    }

    @Override
    public int delwenzhang(Wenzhang wenzhang) {
        return wenzhangmapper.delwenzhang(wenzhang);
    }

    @Override
    public int updateWenzhangs(Wenzhang wenzhang) {
        return wenzhangmapper.updateWenzhangs(wenzhang);
    }

    @Override
    public String getStatus(String username) {
        return wenzhangmapper.getStatus(username);
    }


}
