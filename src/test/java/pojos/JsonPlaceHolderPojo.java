package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)//actualdatayi bu classtan olusturduk ama
// runtimeda bu classta Id  olmadigindan error verdi bizde unknown varsa ignore et dedik bu sekilde
public class JsonPlaceHolderPojo {
//1: private variable 'lar olusturunuz
 private Integer userId;
 private String title;
 private Boolean completed;
//2:Parametreli ve parametresiz constructorlar olusturunuz
//Parametreliler kendi istegimiz icin yaptigimiz constructorlar
    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {//Bu olmasa  response.as(JsonPlaceHolderPojo.Class) yapiamaz ve actual data burdan olusturulamaz
    }
    //3:Public getter ve setterlar olusturunuz

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
//4:toString() methodunu olusturunuz
//Bu sekilde olusturdugum objeyi yazdirmis oldum toString ile
    @Override
    public String toString() {
        return "JsonPlaceHolderPojoClass{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

    /*
  "userId": 55,
            "title": "Tidy your room",
            "completed": false
  */












}
