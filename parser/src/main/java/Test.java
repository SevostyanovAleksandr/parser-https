import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

   List<Article> articleList= new ArrayList<>();       //коллекци
    Document doc = Jsoup.connect("https://4pda.to/").get();

        Elements h2Elements = doc.getElementsByAttributeValue  ("class", "list-post-title");   //заголовок на сайте
        h2Elements.forEach (h2Element -> {
                    Element aElement = h2Element.child(0);//сыллка у нас находиться на первой позиции
                    String url = aElement.attr("href");// значение ссылки вырезанное из артрибута
                    String title = aElement.child(0).text();//метод text позваляет получить внутритеговое содержимое
                    articleList.add(new Article(url, title));// добавляем в список новую статью конструктор
                });

            articleList.forEach(System.out::println); //выводим на экран то что на парсил
  }
}

class Article {

        private String url;
        private String name;


        public Article(String url, String name) {
            this.url = url;
            this.name = name;
    }

        public String getUrl () {
        return url;
    }

        public void setUrl (String url){

            this.url = url;
    }

        public String getName () {
        return name;
    }

        public void setName (String name){

            this.name = name;
    }


    @Override
    public String toString() {
        return "Article{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
