package com.example.yls.newsclient.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yls on 2017/6/28.
 */

public class NewsEntity{

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> T1348647909107) {
        this.result = T1348647909107;
    }

    public static class ResultBean implements Serializable {
        /**
         * postid : PHOT24VTH000100A
         * hasCover : false
         * hasHead : 1
         * replyCount : 9018
         * hasImg : 1
         * digest :
         * hasIcon : false
         * docid : 9IG74V5H00963VRO_CMVD4AUObjxunjianguoupdateDoc
         * title : 老人驼背90度 手术台为他垫1米高凳子
         * order : 1
         * priority : 354
         * lmodify : 2017-06-15 14:42:54
         * boardid : photoview_bbs
         * ads : [{"title":"河南少林寺众僧手工收麦 现场秀功夫","skipID":"00AP0001|2260970","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/5b586db5b70e487db2651eb52440add020170615155720.jpeg","subtitle":"","skipType":"photoset","url":"00AP0001|2260970"},{"title":"法总统到访摩洛哥 高冷小王子帅气抢眼","skipID":"00AO0001|2260899","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/6333d7bf12f74899b428edd45703730920170615095953.jpeg","subtitle":"","skipType":"photoset","url":"00AO0001|2260899"},{"title":"城中村\"夹缝天空\"被居民戏称\"楼亲亲\"","skipID":"00AP0001|2260875","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/e840d8703796489ea3f15f01534048f120170615080922.jpeg","subtitle":"","skipType":"photoset","url":"00AP0001|2260875"},{"title":"600斤女子减肥 曾漏斗喂食欲胖霸世界","skipID":"00AO0001|2260950","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/bfeffba7d8594250bb4629b33111357320170615144320.jpeg","subtitle":"","skipType":"photoset","url":"00AO0001|2260950"},{"title":"朴槿惠与崔顺实再次出庭受审 神情各异","skipID":"00AO0001|2260922","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/e7ed9609eec64ef9ae9415ac9659d6a220170615112323.jpeg","subtitle":"","skipType":"photoset","url":"00AO0001|2260922"}]
         * photosetID : 00AP0001|2260913
         * imgsum : 9
         * topic_background : http://img2.cache.netease.com/m/newsapp/reading/cover1/C1348646712614.jpg
         * template : normal1
         * votecount : 8246
         * skipID : 00AP0001|2260913
         * alias : Top NewsEntity
         * skipType : photoset
         * cid : C1348646712614
         * hasAD : 1
         * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/f14a11d9f538401b9448a8380cacbee120170615101817.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/406910d7c6dd45fbbec0dbb585c8b51f20170615101818.jpeg"}]
         * source : 网易综合
         * ename : androidnews
         * tname : 头条
         * imgsrc : http://cms-bucket.nosdn.127.net/10343654f849464bac94fa73f25308c120170615101817.jpeg
         * ptime : 2017-06-15 10:19:01
         * url_3w : http://news.163.com/17/0614/20/CMTSG7NV000189FH.html
         * ltitle : 习近平会见卢森堡首相贝泰尔
         * url : http://3g.163.com/news/17/0614/20/CMTSG7NV000189FH.html
         * subtitle :
         * specialID : S1497403767137
         */

        private String postid;
        private boolean hasCover;
        private int hasHead;
        private int replyCount;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String docid;
        private String title;
        private int order;
        private int priority;
        private String lmodify;
        private String boardid;
        private String photosetID;
        private int imgsum;
        private String topic_background;
        private String template;
        private int votecount;
        private String skipID;
        private String alias;
        private String skipType;
        private String cid;
        private int hasAD;
        private String source;
        private String ename;
        private String tname;
        private String imgsrc;
        private String ptime;
        private String url_3w;
        private String ltitle;
        private String url;
        private String subtitle;
        private String specialID;
        private List<AdsBean> ads;
        private List<ImgextraBean> imgextra;

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public int getImgsum() {
            return imgsum;
        }

        public void setImgsum(int imgsum) {
            this.imgsum = imgsum;
        }

        public String getTopic_background() {
            return topic_background;
        }

        public void setTopic_background(String topic_background) {
            this.topic_background = topic_background;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getUrl_3w() {
            return url_3w;
        }

        public void setUrl_3w(String url_3w) {
            this.url_3w = url_3w;
        }

        public String getLtitle() {
            return ltitle;
        }

        public void setLtitle(String ltitle) {
            this.ltitle = ltitle;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getSpecialID() {
            return specialID;
        }

        public void setSpecialID(String specialID) {
            this.specialID = specialID;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

        public static class AdsBean implements Serializable {
            /**
             * title : 河南少林寺众僧手工收麦 现场秀功夫
             * skipID : 00AP0001|2260970
             * tag : photoset
             * imgsrc : http://cms-bucket.nosdn.127.net/5b586db5b70e487db2651eb52440add020170615155720.jpeg
             * subtitle :
             * skipType : photoset
             * url : 00AP0001|2260970
             */

            private String title;
            private String skipID;
            private String tag;
            private String imgsrc;
            private String subtitle;
            private String skipType;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSkipID() {
                return skipID;
            }

            public void setSkipID(String skipID) {
                this.skipID = skipID;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getSkipType() {
                return skipType;
            }

            public void setSkipType(String skipType) {
                this.skipType = skipType;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ImgextraBean implements Serializable {
            /**
             * imgsrc : http://cms-bucket.nosdn.127.net/f14a11d9f538401b9448a8380cacbee120170615101817.jpeg
             */

            private String imgsrc;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }
        }
    }
}
