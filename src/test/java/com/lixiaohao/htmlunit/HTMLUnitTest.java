package com.lixiaohao.htmlunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by lixiaohao on 2016/10/31
 *
 * @Description
 *              使用htmlunit模拟浏览器
 * @Create 2016-10-31 11:31
 * @Company
 */
public class HTMLUnitTest {
    Logger logger  = Logger.getLogger("HtmlUnit");
    WebClient webClient;

    @Before
    public void init(){
        //设置问chrome浏览器
        webClient = new WebClient(BrowserVersion.CHROME);
        logger.info("init 。。。。。。");
    }

    @After
    public void destory(){
        webClient.close();
        logger.info("cloused 。。。。。。");
    }

    @Test
    public void getPageTest(){
        try {
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            final HtmlPage page = webClient.getPage("http://www.cnblogs.com/luotinghao/p/3800054.html");
            logger.info("page:"+page.asText());
//            logger.info("page:"+page.asXml());

            List<HtmlAnchor> urls = page.getAnchors();
            for(HtmlAnchor ach:urls){
                logger.info("url:"+ach.getHrefAttribute());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
