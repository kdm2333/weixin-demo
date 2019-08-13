package com.kdm.message.util.bean;

/**
 * @PackageName:com.kdm.message.util.bean
 * @ClassName:MessageVoice
 * @Description:
 * @author: libj_mios
 * @date: 2019/8/12 15:10
 */
public class MessageVoice extends MessageBase {

    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
