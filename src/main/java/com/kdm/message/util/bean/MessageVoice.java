package com.kdm.message.util.bean;

/**
 * @PackageName:com.kdm.message.util.bean
 * @ClassName:MessageVoice
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/12 15:10
 */
public class MessageVoice extends MessageBase {

    private Voice voice;

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }
}
