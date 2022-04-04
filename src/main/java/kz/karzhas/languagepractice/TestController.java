package kz.karzhas.languagepractice;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import kz.karzhas.languagepractice.vocabulary.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {
    @Autowired
    WordRepository repository;

    @GetMapping(value = "del")
    void del(){
//        try {
//            Document docCustomConn = Jsoup.connect("https://translate.yandex.kz/?lang=en-ru&text=how")
//                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
//                    .timeout(5000)
//                    .referrer("http://google.com")
//                    .get();
//            Elements d1 = docCustomConn.getElementsByClass("example_source");
//            Elements d2 = docCustomConn.getElementsByClass(".example_source");
//            Elements d3 = docCustomConn.select(".example_source");
//
//            System.out.println(d1.size());
//
//            //
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);
        try {
            HtmlPage page = webClient.getPage("https://translate.yandex.kz/?lang=en-ru&text=how");

            webClient.getCurrentWindow().getJobManager().removeAllJobs();
            webClient.close();

            String title = page.getTitleText();
            System.out.println("Page Title: " + title);

//            recipesFile.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }

//        WordDto w = new WordDto();
//        w.setSpelling("!!!!@!!");
//        return repository.findBySpelling("!!!!");
//        repository.save(w);
//        return repository.findAll();
//        repository.deleteAll();
    }

    @PostMapping(value = "/test")
    String test(@RequestBody String addingInfo){
        String[] lines = addingInfo.split(System.lineSeparator());
        for(int i = 0; i < lines.length; i++){
            System.out.println(lines[i] + " | ");
        }
        return addingInfo;
    }
}
