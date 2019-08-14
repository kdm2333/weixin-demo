package com.kdm.message.util.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @PackageName:com.kdm.message.util.bean
 * @ClassName:Voice
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/12 15:08
 */
public class Voice {

    private String MediaId;

    public Voice(String mediaId){
        MediaId = mediaId;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
