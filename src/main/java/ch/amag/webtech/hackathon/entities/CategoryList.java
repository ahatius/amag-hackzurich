package ch.amag.webtech.hackathon.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Outputting an ArrayList of Vehicles doesn't work for XML, so we had to create a wrapper class
@XmlRootElement(name = "categories")
public class CategoryList {
  private List<Category> categories;
  
  public CategoryList() {
    
  }
  
  public CategoryList(List<Category> categories) {
    this.categories = categories;
  }

  @XmlElement(name = "category")
  public List<Category> getCategories(){
      return this.categories;
  }
  
  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }
}
