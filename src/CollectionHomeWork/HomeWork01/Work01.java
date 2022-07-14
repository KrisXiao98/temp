package CollectionHomeWork.HomeWork01;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class Work01 {
    public static void main(String[] args) {
        News news1 = new News("新闻一:12346554654654654654465465312312312313123146");
        news1.setContent("新闻1的内容");
        News news2 = new News("新闻二");
        news2.setContent("新闻2的内容");
        ArrayList arrayList = new ArrayList();
        arrayList.add(news1);
        arrayList.add(news2);
        //倒序遍历,遍历时对标题进行处理超过5个字只保留前5个，后面的加...
        for (int i = arrayList.size() - 1; i >= 0 ; i--) {
            Object obj = arrayList.get(i);
            News temp = (News) obj;
            if (temp.getTitleLength() > 15){
                char[] chars = temp.getTitle().toCharArray();
                for (int j = 0; j < 15; j++) {
                    System.out.print(chars[j]);
                }
                System.out.print("...");
                System.out.println();
            }else {
                System.out.println(temp);
            }
        }

    }
}

class News{
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTitleLength() {
        return title.length();
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "title=" + title;
    }
}