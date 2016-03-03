package ch.amag.webtech.hackathon.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Outputting an ArrayList of Vehicles doesn't work for XML, so we had to create a wrapper class
@XmlRootElement(name = "dealers")
public class DealerList {
  private List<Dealer> dealers;
  
  public DealerList() {
    
  }
  
  public DealerList(List<Dealer> dealers) {
    this.dealers = dealers;
  }

  @XmlElement(name = "dealer")
  public List<Dealer> getDealers(){
      return this.dealers;
  }
  
  public void setDealers(List<Dealer> dealers) {
    this.dealers = dealers;
  }
}
