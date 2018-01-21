package uploadingFiles.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import uploadingFiles.model.Image;

@Service
public class ImageService {
	static Image image=new Image();
	List<Integer> imageNumbers;
	public Image returnImage() {
		return image;
	}
	public void incrementCounter() {
		image.incrementImagesCounter();
	}
	public int getImagesCounter() {
		return image.getImagesCounter();
	}
	public List<Integer> generateImagesNumberList(){
		imageNumbers=new ArrayList<Integer>();
		for(Integer i=0;i<getImagesCounter();i++) {
			imageNumbers.add(i,new Integer(i));
		}		
		return imageNumbers;
	}
	

}
