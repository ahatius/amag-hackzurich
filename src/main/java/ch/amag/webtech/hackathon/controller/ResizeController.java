package ch.amag.webtech.hackathon.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.amag.webtech.hackathon.entities.VehicleImageId;
import ch.amag.webtech.hackathon.entities.VehicleThumbnailRaw;
import ch.amag.webtech.hackathon.repository.VehicleImageIdRepository;
import ch.amag.webtech.hackathon.repository.VehicleImageRawRepository;
import ch.amag.webtech.hackathon.repository.VehicleThumbnailRawRepository;

@RestController
@RequestMapping("/resize")
@ComponentScan(basePackages = { "ch.amag.webtech.hackathon" })
public class ResizeController {
  @Autowired
  VehicleImageRawRepository imageRepository;
  
  @Autowired
  VehicleImageIdRepository imageIdRepository;
  
  @Autowired
  VehicleThumbnailRawRepository thumbnailRepository;
  
  @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
  public void resize() throws IOException {
    for(VehicleImageId id : imageIdRepository.findAll()) {
      if(thumbnailRepository.findOne(id.getId()).getThumbnailData() != null) {
        continue;
      }
      
      byte[] imageData = imageRepository.findOne(id.getId()).getImageData();
      
      ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
      BufferedImage bufferedImage = ImageIO.read(bais);
      
      BufferedImage bufferedResizedImage = Scalr.resize(bufferedImage, Scalr.Method.BALANCED, Scalr.Mode.AUTOMATIC, 400); //400,300 was the size we expected
      
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ImageIO.write(bufferedResizedImage, "jpg", baos);
      baos.flush();
      byte[] resizedImageData = baos.toByteArray();
      
      VehicleThumbnailRaw thumbnail = new VehicleThumbnailRaw();
      thumbnail.setId(id.getId());
      thumbnail.setThumbnailData(resizedImageData);
      
      thumbnailRepository.save(thumbnail);
    }
  }
  
  @RequestMapping(value = "/original", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
  public byte[] original() throws IOException {
    for(VehicleImageId id : imageIdRepository.findAll()) {
      byte[] imageData = imageRepository.findOne(id.getId()).getImageData();
      return imageData;
      
    }
    
    return null;
  }
}
