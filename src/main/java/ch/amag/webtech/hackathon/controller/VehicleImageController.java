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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.amag.webtech.hackathon.entities.VehicleImageRaw;
import ch.amag.webtech.hackathon.entities.VehicleThumbnailRaw;
import ch.amag.webtech.hackathon.repository.VehicleImageRawRepository;
import ch.amag.webtech.hackathon.repository.VehicleThumbnailRawRepository;

@RestController
@RequestMapping("/image")
@ComponentScan(basePackages = { "ch.amag.webtech.hackathon" })
public class VehicleImageController {
  @Autowired
  VehicleImageRawRepository imageRepository;
  
  @Autowired
  VehicleThumbnailRawRepository thumbnailRepository;
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
  public byte[] getVehicle(@PathVariable int id) throws IOException {
    VehicleImageRaw image = imageRepository.findOne(id);
    
    return image.getImageData();
  }
  
  @RequestMapping(value = "/{id}/thumbnail", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
  public byte[] getThumbnail(@PathVariable int id) throws IOException {
    VehicleThumbnailRaw image = thumbnailRepository.findOne(id);
    
    return image.getThumbnailData();
  }
  
  @RequestMapping(value = "/{id}/width/{width}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
  public byte[] getImageWithWidth(@PathVariable int id, @PathVariable int width) throws IOException {
    VehicleImageRaw image = imageRepository.findOne(id);
    
    byte[] imageData = image.getImageData();
    
    ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
    BufferedImage bufferedImage = ImageIO.read(bais);
    
    BufferedImage bufferedResizedImage = Scalr.resize(bufferedImage, Scalr.Method.BALANCED, Scalr.Mode.AUTOMATIC, width); //400,300 was the size we expected
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    
    ImageIO.write(bufferedResizedImage, "jpg", baos);
    baos.flush();
    
    return baos.toByteArray();
  }
  
  @RequestMapping(value = "/{id}/height/{height}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
  public byte[] getImageWithHeight(@PathVariable int id, @PathVariable int height) throws IOException {
    VehicleImageRaw image = imageRepository.findOne(id);
    
    byte[] imageData = image.getImageData();
    
    ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
    BufferedImage bufferedImage = ImageIO.read(bais);
    
    //int width = bufferedImage.getHeight() / bufferedImage.getWidth() * height;
    
    double ratio = 1.0 * bufferedImage.getWidth() / bufferedImage.getHeight();
    Double width = height * ratio;
    
    BufferedImage bufferedResizedImage = Scalr.resize(bufferedImage, Scalr.Method.BALANCED, Scalr.Mode.AUTOMATIC, width.intValue(), height); //400,300 was the size we expected
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    
    ImageIO.write(bufferedResizedImage, "jpg", baos);
    baos.flush();
    
    return baos.toByteArray();
  }
}
