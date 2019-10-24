package com.liugs.httplib.entity;

/**
 * Copyright 2019 bejson.com
 */

import java.util.List;

/**
 * Auto-generated: 2019-10-24 22:2:30
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Result {

    private String channel;
    private String count;
    private String ch_name;
    private String artistid;
    private String avatar;
    private List<Songlist> songlist;
    private String channelid;
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public String getChannel() {
        return channel;
    }

    public void setCount(String count) {
        this.count = count;
    }
    public String getCount() {
        return count;
    }

    public void setCh_name(String ch_name) {
        this.ch_name = ch_name;
    }
    public String getCh_name() {
        return ch_name;
    }

    public void setArtistid(String artistid) {
        this.artistid = artistid;
    }
    public String getArtistid() {
        return artistid;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setSonglist(List<Songlist> songlist) {
        this.songlist = songlist;
    }
    public List<Songlist> getSonglist() {
        return songlist;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }
    public String getChannelid() {
        return channelid;
    }

}
