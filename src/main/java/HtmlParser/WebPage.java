package HtmlParser;

public class WebPage {
    private String name;//网页名称
    private String url;// 网页url

    public WebPage(String _url){
        _url = _url.toLowerCase();
        if(!_url.contains("http://")){
            this.url = "http://" + _url;
        } else {
            this.url = _url;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
