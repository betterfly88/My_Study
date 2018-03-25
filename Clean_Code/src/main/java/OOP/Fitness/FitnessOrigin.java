package OOP.Fitness;

/**
 * Created by betterFLY on 2018. 3. 1.
 * Github : http://github.com/betterfly88
 */

import fitnesse.responders.run.SuiteResponder;
import fitnesse.wiki.*;


public class FitnessOrigin {
    public String testTableHtml(PageData pageData, boolean includeSuiteSetup) throws Exception{
        WikiPage wikiPage  = pageData.getWikiPage();
        StringBuffer buffer = new StringBuffer();

        if(pageData.hasAttribute("Test")){
            if(includeSuiteSetup){
                WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage(SuiteResponder.SUITE_SETUP_NAME, wikiPage);
                if(suiteSetup != null){
                    WikiPagePath pagePath = wikiPage.getPageCrawler().getFullPath(suiteSetup);
                    String pagePathName = PathParser.render(pagePath);
                    buffer.append("!include - setup , ").append(pagePathName).append("\n");
                }
            }
            WikiPage setup= PageCrawlerImpl.getInheritedPage("SetUp",wikiPage);
            if(setup != null){
                WikiPagePath setupPath = wikiPage.getPageCrawler().getFullPath(setup);
                String setupPathName = PathParser.render(setupPath);
                buffer.append("!include - setup ,").append(setupPathName).append("\n");
            }
        }

        buffer.append(pageData.getContent());
        if(pageData.hasAttribute("Test")){
            WikiPage tearDown = PageCrawlerImpl.getInheritedPage("TearDown", wikiPage);
            if(tearDown != null){
                WikiPagePath tearDownPath = wikiPage.getPageCrawler().getFullPath(tearDown);
                String setupPathName = PathParser.render(tearDownPath);
                buffer.append("!include - teardown ,").append(setupPathName).append("\n");
            }

            if(includeSuiteSetup){
                WikiPage suiteTearDown = PageCrawlerImpl.getInheritedPage(SuiteResponder.SUITE_TEARDOWN_NAME, wikiPage);
                if(suiteTearDown != null){
                    WikiPagePath pagePath = wikiPage.getPageCrawler().getFullPath(suiteTearDown);
                    String setupPathName = PathParser.render(pagePath);
                    buffer.append("!include - teardown ,").append(setupPathName).append("\n");
                }
            }
        }

        pageData.setContent(buffer.toString());
        return pageData.getHtml();
    }
}
