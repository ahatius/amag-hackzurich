package ch.amag.webtech.hackathon.entities;

public interface Color {
  public String getId();
  public String getDescriptionGerman();
//  public String getDescriptionFrench();
//  public String getDescriptionItalian();
  public String getCategory();
  public void setId(String id);
  public void setDescriptionGerman(String descriptionGerman);
//  public void setDescriptionFrench(String descriptionFrench);
//  public void setDescriptionItalian(String descriptionItalian);
  public void setCategory(String category);
}
