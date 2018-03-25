package OOP.Fitness;

/**
 * Created by betterFLY on 2018. 3. 1.
 * Github : http://github.com/betterfly88
 */

import fitnesse.responders.run.SuiteResponder;
import fitnesse.wiki.*;


public class FitnessRefactoring {
    public String testTableHtml(PageData pageData, boolean includeSuiteSetup) throws Exception{
        return new TestableHtmlBuilder(pageData, includeSuiteSetup).invoke();
    }

    private class TestableHtmlBuilder {
        private PageData pageData;
        private boolean includeSuiteSetup;
        /*
            filed variable로 변환
         */
        private WikiPage wikiPage;
        private StringBuffer buffer;

        public TestableHtmlBuilder(PageData pageData, boolean includeSuiteSetup) {
            this.pageData = pageData;
            this.includeSuiteSetup = includeSuiteSetup;
            /*
                전역에 사용되므로 생성자에서 초기화
             */
            wikiPage = pageData.getWikiPage();
            buffer = new StringBuffer();
        }

        public String invoke() throws Exception {
            if(isTestPage()){
                // includeInherited 에 전달되는 arguments 들을 inline 함으로써 조금 더 가독성 좋은 코드가 되었다.
                // 추가로 if 문에서 한가지 일만 하므로 {}를 제거해준다.
                // {}가 포함되는 것은 2가지 이상의 일을 할 때만 적용한다.
                includeSetup();
                buffer.append(pageData.getContent());
                includeTeardown();
            }
            pageData.setContent(buffer.toString());
            return pageData.getHtml();
        }

        private boolean isTestPage() throws Exception {
            return pageData.hasAttribute("Test");
        }

        private void includeTeardown() throws Exception {
            includeInherited("TearDown", "teardown");
            if(includeSuiteSetup){
                includeInherited(SuiteResponder.SUITE_TEARDOWN_NAME, "teardown");
            }
        }

        private void includeSetup() throws Exception {
            if(includeSuiteSetup)
                includeInherited(SuiteResponder.SUITE_SETUP_NAME, "setup");
            includeInherited("SetUp", "setup");
        }

        private void includeInherited(String pageName, String mode) throws Exception {
            WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage(pageName, wikiPage);
            if(suiteSetup != null){
                inclduePage(suiteSetup, mode);
            }
        }

        private void inclduePage(WikiPage suiteSetup, String mode) throws Exception {
            WikiPagePath pagePath = wikiPage.getPageCrawler().getFullPath(suiteSetup);
            String pagePathName = PathParser.render(pagePath);
            buffer.append("!include -" + mode + " .").append(pagePathName).append("\n");
        }
    }
}
