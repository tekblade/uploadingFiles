package uploadingFiles.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import uploadingFiles.service.ImageService;
import uploadingFiles.model.ImagesManager;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

@Controller
public class PictureUploadController {
		
	@Autowired
	static ImageService service;
	public static File imageDir;
	static String choosenImage="";
    /*____________________________________________________________*/
	@PostConstruct
	public void initData() throws IOException {		
		service=new ImageService();
    	File checkFile;
		checkFile=new File("C:\\Users\\luce\\workspace2\\uploadingFiles\\src\\main\\resources\\static\\images");   	
    	if(checkFile.exists())
    		FileUtils.deleteDirectory(checkFile);
    	imageDir=new File("C:\\Users\\luce\\workspace2\\uploadingFiles\\src\\main\\resources\\static\\images"); 
    	imageDir.mkdirs();
    }
	/*_________________________________________________________*/
	@RequestMapping("/upload")
	public String uploadPage() throws IOException {		
		return "upload";
	}
	/*------------------------------------------------------------------*/
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String onUpload(MultipartFile file) throws IOException {
		String filename = file.getOriginalFilename();
		synchronized(this) {	
			File tempFile=File.createTempFile(imageDir.getPath()+ "\\" +Integer.toString(service.getImagesCounter()), ".jpg", imageDir);
			try(InputStream in =  file.getInputStream();
					OutputStream out=new FileOutputStream(tempFile);){
				IOUtils.copy(in, out);
			}		
			generateFileName(tempFile);
		}
		return "redirect:/upload"; 
		
	}		
	/*--------------------------------------------------------------*/
	@RequestMapping(value="/uploaded")
	public String uploaded(Model model) {	
		List<Integer> imagesList=service.generateImagesNumberList();
		model.addAttribute("images", imagesList);
		return "uploaded";
	}
	/* --------------------------------------------------------*/
	@RequestMapping(value="/showimage", method=RequestMethod.POST)
	public String showimage(Model model, HttpServletRequest request) {
		choosenImage=request.getParameter("choosenimage");
		String imageName=generateExtension(choosenImage);
		model.addAttribute("path", getRelativePath(imageName)); // The issue is here. It reads images from the previous run. Images Counter matches current run
		return "showimage";
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static String getFileExtension(String name) {		
		return name.substring(name.lastIndexOf("."));
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static void generateFileName(File file) {
		String dirPath=imageDir.getPath();
		String newName=dirPath+"\\"+Integer.toString(service.getImagesCounter())+getFileExtension(file.getPath());
		File newFile=new File(newName);
		file.renameTo(newFile);
		service.incrementCounter();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static String generateExtension(String choosenImage) {
		String fileName="C:\\Users\\luce\\workspace2\\uploadingFiles\\src\\main\\resources\\static\\images\\"+choosenImage+".jpg";
		return fileName;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static String getRelativePath(String fullPath) {
		String[] myArray=fullPath.split("\\\\");
		String relativePath="\\images\\"+myArray[myArray.length-1];
		return relativePath;
	}
}







