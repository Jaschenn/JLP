package Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "data_bk", schema = "JLP", catalog = "")
public class DataEntity {
    @Id
    private  int uuid;
    private String pian;
    private String zhang;
    private String title;
    private String content;
    private String keyword;
    private String similar;
    private String summarg;
    private String baidu_comp;
    @Basic
    @Column(name = "baidu_comp" , nullable = true,length = 99999)
    public String getBaidu_comp() {
        return baidu_comp;
    }

    public void setBaidu_comp(String baidu_comp) {
        this.baidu_comp = baidu_comp;
    }
    @Basic
    @Column(name = "summarg" , nullable = true,length = 255)
    public String getSummarg() {
        return summarg;
    }

    public void setSummarg(String summarg) {
        this.summarg = summarg;
    }

    @Basic
    @Column(name = "pian", nullable = true, length = 255)
    public String getPian() {
        return pian;
    }

    public void setPian(String pian) {
        this.pian = pian;
    }

    @Basic
    @Column(name = "zhang", nullable = true, length = 255)
    public String getZhang() {
        return zhang;
    }

    public void setZhang(String zhang) {
        this.zhang = zhang;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "keyword", nullable = true, length = 255)
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "Similar", nullable = true, length = 255)
    public String getSimilar() {
        return similar;
    }

    public void setSimilar(String similar) {
        this.similar = similar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataEntity that = (DataEntity) o;

        if (pian != null ? !pian.equals(that.pian) : that.pian != null) return false;
        if (zhang != null ? !zhang.equals(that.zhang) : that.zhang != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (keyword != null ? !keyword.equals(that.keyword) : that.keyword != null) return false;
        if (similar != null ? !similar.equals(that.similar) : that.similar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pian != null ? pian.hashCode() : 0;
        result = 31 * result + (zhang != null ? zhang.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (similar != null ? similar.hashCode() : 0);
        return result;
    }

}
