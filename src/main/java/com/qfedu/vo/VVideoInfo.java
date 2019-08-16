package com.qfedu.vo;

import com.qfedu.utils.StringUtils;

/**
 * @program: QFVideos
 * @ClassName: VVideoInfo
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-02 16:05
 **/
public class VVideoInfo {
    private int id;
    private String title;
    private String detail;
    private String speakerName;
    private int time;
    private int playNum;
    private String showTime;

    public String getShowTime() {
        showTime = StringUtils.getTimeByInt(time);
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public int getPlayNum() {
        return playNum;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }
}
