package com.kdm.message.util.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @PackageName:com.kdm.message.util.bean
 * @ClassName:Image
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/12 15:08
 */
public class Image {

    private String MediaId;

    public Image(String mediaId){
        MediaId = mediaId;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
