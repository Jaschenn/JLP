package gecco;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl = "https://baike.baidu.com/item/{title}",pipelines = "Gpipeline")
public class BaiduComp implements HtmlBean {
    private static final long serialVersionUID = -7127412585200687225L;
    @RequestParameter("title")
    private String title;
    @Text
    @HtmlField(cssPath = "body > div.body-wrapper > div.content-wrapper > div > div.main-content > div.lemma-summary > div")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
